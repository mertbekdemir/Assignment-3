
import java.lang.reflect.Constructor;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.AfterClass;

public abstract class SpecificationTest
{
    protected void testField(final Class<?> clazz,
                             final String fieldName,
                             final Class expectedType,
                             final String[] expectedModifiers,
                             final String[] forbiddenModifiers)
    {
        if (clazz == null)
        {
            throw new IllegalArgumentException("clazz cannot be null");
        }

        if (fieldName == null)
        {
            throw new IllegalArgumentException("fieldName cannot be null");
        }

        try
        {
            final Field field;
            final int modifiers;
            final Class<?> type;

            field = clazz.getDeclaredField(fieldName);
            type = field.getType();

            if (!(type.equals(expectedType)))
            {
                fail(clazz.getName() + "." + fieldName + " must be declared as \"" + expectedType.getName() + "\"");
            }

            modifiers = field.getModifiers();
            checkRequiredModifiers(clazz, fieldName, expectedModifiers, modifiers);
            checkForbiddenModifiers(clazz, fieldName, forbiddenModifiers, modifiers);
        }
        catch (final NoSuchFieldException ex)
        {
            fail(clazz.getName() + " must have a field named: \"" + fieldName + "\"");
        }
    }

    protected void testMethod(final Class<?> clazz,
                              final String methodName,
                              final Class expectedReturnType,
                              final String[] expectedModifiers,
                              final String[] forbiddenModifiers,
                              final Class<?>... expectedParameters)
    {
        if (clazz == null)
        {
            throw new IllegalArgumentException("clazz cannot be null");
        }

        if (methodName == null)
        {
            throw new IllegalArgumentException("methodName cannot be null");
        }

        try
        {
            final Method method;
            final int modifiers;
            final Class<?> returnType;

            method = clazz.getDeclaredMethod(methodName, expectedParameters);
            returnType = method.getReturnType();

            if (!(returnType.equals(expectedReturnType)))
            {
                fail(clazz.getName() + "." + methodName + " must return \"" + expectedReturnType.getName() + "\"");
            }

            modifiers = method.getModifiers();
            checkRequiredModifiers(clazz, methodName, expectedModifiers, modifiers);
            checkForbiddenModifiers(clazz, methodName, forbiddenModifiers, modifiers);
        }
        catch (final NoSuchMethodException ex)
        {
            if(expectedParameters == null || expectedParameters.length == 0)
            {
                fail(clazz.getName() + " must have a method named: \"" + methodName + "\" that takes no parameters");
            }
            else
            {
                fail(clazz.getName() + " must have a method named: \"" + methodName + "\" with parameters " + Arrays.toString(expectedParameters));
            }
        }
    }
    
    protected void testNumberOfConstructors(final Class<?> clazz,
                                            final int expected)
    {
        if (clazz == null)
        {
            throw new IllegalArgumentException("clazz cannot be null");
        }

        final Constructor[] constructors;

        constructors = clazz.getConstructors();

        assertEquals("Expected: " + expected + " construcructors for " + clazz + " found: " + constructors.length, expected, constructors.length);
    }
    protected void testConstructor(final Class<?> clazz,
                                   final String[] expectedModifiers,
                                   final Class<?>... expectedParameters)
    {
        if (clazz == null)
        {
            throw new IllegalArgumentException("clazz cannot be null");
        }

        try
        {
            final Constructor constructor;
            final int         modifiers;

            constructor = clazz.getConstructor(expectedParameters);

            modifiers = constructor.getModifiers();
            checkRequiredModifiers(clazz, constructor.getName(), expectedModifiers, modifiers);
        }
        catch (final NoSuchMethodException ex)
        {
            fail(clazz.getName() + " must have a Constructor with parameters: " + Arrays.toString(expectedParameters));
        }
    }

    private void checkRequiredModifiers(final Class<?> clazz,
                                        final String name,
                                        final String[] expectedModifiers,
                                        final int actualModifiers)
    {
        for (final String expected : expectedModifiers)
        {
            switch (expected)
            {
                case "public":
                {
                    if (!(Modifier.isPublic(actualModifiers)))
                    {
                        fail(clazz.getName() + "." + name + " must be declared \"public\"");
                    }
                    break;
                }
                case "private":
                {
                    if (!(Modifier.isPrivate(actualModifiers)))
                    {
                        fail(clazz.getName() + "." + name + " must be declared \"private\"");
                    }
                    break;
                }
                case "protected":
                {
                    if (!(Modifier.isProtected(actualModifiers)))
                    {
                        fail(clazz.getName() + "." + name + " must be declared \"protected\"");
                    }
                    break;
                }
                case "final":
                {
                    if (!(Modifier.isFinal(actualModifiers)))
                    {
                        fail(clazz.getName() + "." + name + " must be declared \"final\"");
                    }
                    break;
                }
                case "static":
                {
                    if (!(Modifier.isStatic(actualModifiers)))
                    {
                        fail(clazz.getName() + "." + name + " must be declared \"static\"");
                    }
                    break;
                }
            }
        }
    }

    private void checkForbiddenModifiers(final Class<?> clazz,
                                         final String name,
                                         final String[] unexpectedModifiers,
                                         final int actualModifiers)
    {
        for (final String unexpected : unexpectedModifiers)
        {
            switch (unexpected)
            {
                case "public":
                {
                    if (Modifier.isPublic(actualModifiers))
                    {
                        fail(clazz.getName() + "." + name + " must not be declared \"public\"");
                    }
                    break;
                }
                case "private":
                {
                    if (Modifier.isPrivate(actualModifiers))
                    {
                        fail(clazz.getName() + "." + name + " must not be declared \"private\"");
                    }
                    break;
                }
                case "protected":
                {
                    if (Modifier.isProtected(actualModifiers))
                    {
                        fail(clazz.getName() + "." + name + " must not be declared \"protected\"");
                    }
                    break;
                }
                case "final":
                {
                    if (Modifier.isFinal(actualModifiers))
                    {
                        fail(clazz.getName() + "." + name + " must not be declared \"final\"");
                    }
                    break;
                }
                case "static":
                {
                    if (Modifier.isStatic(actualModifiers))
                    {
                        fail(clazz.getName() + "." + name + " must not be declared \"static\"");
                    }
                    break;
                }
            }
        }
    }
}
