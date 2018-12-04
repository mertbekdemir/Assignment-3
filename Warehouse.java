
/**
 * Write a description of class Warehouse here.
 *
 * @author Mert Bekdemir
 * @version 1409
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Warehouse
{

    private ArrayList<Package> packages;

    private int numPackages;
    private double valuePackage;

    /**
     * Constructor for objects of class Warehouse
     */
    public Warehouse(Package[] pack)
    {
        packages = new ArrayList<Package>();

        if(pack == null){
            throw new IllegalArgumentException("List of Packages cannot be null.");
        }

        for(Package eachPackage : pack)
        {
            if(eachPackage == null){
                throw new IllegalArgumentException("List of packages cannot be null.");
            }

            for(Package eachPack : packages) {
                if(eachPackage.getTrackingCode() == eachPack.getTrackingCode())
                {
                    throw new IllegalArgumentException("Duplicate Tracking Code found: " + eachPackage.getTrackingCode());
                }
            }
            packages.add(eachPackage);
        }
    }

    /**
     * 
     * @returns number of packages
     */
    public int getNumPackages()
    {

        int numberOfPackages;

        if(packages == null ) { 
            numberOfPackages = 0;
        }else{
            numberOfPackages = packages.size();
        }
        return numberOfPackages;
    }

    /** 
     *  Gets the total shipping price 
     *  
     *  @return total shipping price 
     */
    public double getTotalPackageValue()
    {

        double totalShippingPrice = 0;

        for(Package eachPackage : packages)
        {
            if(eachPackage.getShippingPrice() > 0.0) {
                totalShippingPrice += eachPackage.getShippingPrice();

            }
        }
        return totalShippingPrice;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package[] findPackagesByPriority(int priorityOfPackage)
    {
        if(priorityOfPackage < 1){
            throw new IllegalArgumentException("Priority must be either 1, 2 or 3.");
        }else if(priorityOfPackage > 3) {
            throw new IllegalArgumentException("Priority must be either 1, 2 or 3.");   
        }

        int index = 0;
        int numberPriority = 0;

        Package[] packageOfPriority;

        for(Package eachPackage : packages)
        {
            if(eachPackage != null && eachPackage.getPriority() == priorityOfPackage){
                numberPriority++;
            }
        }

        if(numberPriority > 0){

            packageOfPriority = new Package[numberPriority];
        }else{
            return null;
        }

        for(Package eachPackage : packages)
        {
            if(eachPackage != null && eachPackage.getPriority() == priorityOfPackage){
                packageOfPriority[index] = eachPackage;
                index++;
            }

        }
        return packageOfPriority;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package[] findPackagesAboveWeight(double packageGreaterThanWeight)
    {
        if(packageGreaterThanWeight < 0.0 || packageGreaterThanWeight > 100.0){
            throw new IllegalArgumentException("Weight must be between 0.0 and 100.0lbs.");
        }

        int index = 0;
        int numberPackageGreaterWeight = 0;

        Package[] packageOfPriority;
        Package[] packy = new Package[0];

        for(Package eachPackage : packages)
        {
            if(eachPackage != null && eachPackage.getWeight() > packageGreaterThanWeight){
                numberPackageGreaterWeight++;
            }
        }

        if(numberPackageGreaterWeight > 0){

            packageOfPriority = new Package[numberPackageGreaterWeight];
        }else{
            return packy;
        }

        for(Package eachPackage : packages)
        {
            if(eachPackage != null && eachPackage.getWeight() > packageGreaterThanWeight ){
                packageOfPriority[index] = eachPackage;
                index++;
            }

        }
        return packageOfPriority;

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package[] findPackagesBelowWeight(double packageLessThenWeight)
    {
        if(packageLessThenWeight < 0.0 || packageLessThenWeight > 100.0){
            throw new IllegalArgumentException("Weight must be between 0.0 and 100.0lbs.");
        }

        int index = 0;
        int numberPackageLessThanWeight = 0;

        Package[] packageOfPriority;

        for(Package eachPackage : packages)
        {
            if(eachPackage != null && eachPackage.getWeight() < packageLessThenWeight){
                numberPackageLessThanWeight++;
            }
        }

        if(numberPackageLessThanWeight > 0){

            packageOfPriority = new Package[numberPackageLessThanWeight];
        }else{
            return null;
        }

        for(Package eachPackage : packages)
        {
            if(eachPackage != null && eachPackage.getWeight() < packageLessThenWeight ){
                packageOfPriority[index] = eachPackage;
                index++;
            }

        }
        return packageOfPriority;

    }

    public Package shipPackageByTrackingCode(int trackingNumber)
    {
        if(trackingNumber >=1000000000){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingNumber + " is too large.");
        }
        else if(trackingNumber <= 0){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingNumber + " cannot be negative.");
        }

        Iterator<Package> it = packages.iterator();

        while(it.hasNext()) {
            Package sendingPackage = it.next();

            if(trackingNumber == sendingPackage.getTrackingCode())
            {
                it.remove();
                return sendingPackage;

            }
        }
        return null;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Package[] shipPackagesByDestinationCity(String destinationCity)

    {
        if(destinationCity == null){
            throw new IllegalArgumentException("The Destination City is not valid.");
        }else if(destinationCity.equals("")){
            throw new IllegalArgumentException("The Destination City is not set.");
        }

        if(packages == null)
        {
            throw new IllegalArgumentException("The dpackages cannot be null"); 
        }

        ArrayList<Package> shippedPackages = new ArrayList<Package>();
        Iterator<Package> it = packages.iterator();

        while(it.hasNext()){
            Package sendablePackage = it.next();

            if(sendablePackage.getDestCity().equals(destinationCity))
            {
                shippedPackages.add(sendablePackage);
                it.remove();
            }
        }
        Package [] sent = shippedPackages.toArray(new Package[shippedPackages.size()]);

        return sent;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addPackage(Package packy)
    {
        if(packy == null) {
            throw new IllegalArgumentException("cannot be null");
        }else{
            for(Package eachPackage : packages)
            {
                if(packy.getTrackingCode() == eachPackage.getTrackingCode())
                {
                    throw new IllegalArgumentException("Tracking Code is not unique.");
                }
            }

        }
        packages.add(packy);
        return;
    }
}
