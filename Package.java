/**
 * Write a description of class Package here.
 *
 * @author Mert Bekdemir
 * @version 1409
 */
public class Package
{
    // instance variables - replace the example below with your own
    public static final int MAX_PRIORITY = 1;
    public static final int MID_PRIORITY = 2;
    public static final int MIN_PRIORITY = 3;

    public static final int MAX_TRACKING_CODE = 1000000000;
    public static final int MIN_TRACKING_CODE = 0;
    public static final double MAX_WEIGHT = 100.0;
    public static final double MIN_WEIGHT = 0.0;
    public static final double MIN_SHIPPING_PRICE = 0.0;

    private final int trackingCode;
    private int priority = MID_PRIORITY;
    private double shippingPrice;
    private double weight = 0.25;
    private String originCity;
    private String destCity;
    private String trackingPage = "http://www.trackpackage.com";

    /**
     * Constructor for objects of class Package
     * @param trackingCode the tracking code for the package
     * @param shippingPrice the shipping price for the package
     * @param originCity the origin city for the package
     * @param destinationCity the destination city for the package
     */
    public Package(int trackingCode, double shippingPrice, String originCity, String destinationCity)
    {

        if(trackingCode >= MIN_TRACKING_CODE && trackingCode <= MAX_TRACKING_CODE) {
            this.trackingCode = trackingCode; 

        }else if(trackingCode > MAX_TRACKING_CODE){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingCode + " is too large.");
        }else{
            throw new IllegalArgumentException("Sorry, tracking code cannot be negative.");
        }

        setShippingPrice(shippingPrice);
        setOriginCity(originCity);
        setDestinationCity(destinationCity);
    }

    /**
     * Second constructor for objects of class Package
     * 
     * @param trackingCode the tracking code for the package
     * @param priority integer priority degree can be 1,2, or 3
     * @param shippingPrice the shipping price for he package
     * @param weightInPounds the weight in pounds for the package
     * @param originCity the origin city for the package
     * @param destinationCity the destination city for the package
     * @param trackingWebpage the tracking webpage for the package
     */
    public Package(int trackingCode, int priority, double shippingPrice, double weightInPounds, String originCity, String destinationCity, String trackingWebpage)
    {
        if(trackingCode >= MIN_TRACKING_CODE && trackingCode <= MAX_TRACKING_CODE) {
            this.trackingCode = trackingCode; 

        }else if(trackingCode > MAX_TRACKING_CODE){
            throw new IllegalArgumentException("Sorry, tracking code " + trackingCode + " is too large.");
        }else{
            throw new IllegalArgumentException("Sorry, tracking code cannot be negative.");
        }
        setPriority(priority);
        setShippingPrice(shippingPrice);
        setWeightInPounds(weightInPounds);
        setOriginCity(originCity);
        setDestinationCity(destinationCity);
        setTrackingWebpage(trackingWebpage);
    }

    // Mutator Methods

    /**
     * @param numberOfPriority degree of priority can be 1,2, or 3
     * @return setPriority sets the priority
     */
    public void setPriority(int numberOfPriority)
    {
        if(numberOfPriority == MIN_PRIORITY || numberOfPriority == MID_PRIORITY || numberOfPriority == MAX_PRIORITY ) {
            this.priority = numberOfPriority;
        }else{
            throw new IllegalArgumentException("Priority must be either 1, 2 or 3.");
        }    

    }

    /**
     * @param shippingPrice is the shipping price for the package
     * @return setShippingPrice sets the shipping price 
     */
    public void setShippingPrice(double shippingPrice)
    {
        if(shippingPrice >= MIN_SHIPPING_PRICE) {
            this.shippingPrice = shippingPrice;   
        }else{
            throw new IllegalArgumentException("Shipping Price cannot be negative.");
        }
    }

    /**
     * @param weightInPounds the weight in pounds for the package
     * @return setWeightInPounds sets the weight in pounds
     */
    public void setWeightInPounds(double weightInPounds)
    {
        if(weightInPounds >= MIN_WEIGHT && weightInPounds <= MAX_WEIGHT) {
            this.weight = weightInPounds;
        }else{
            throw new IllegalArgumentException("Weight must be between 0.0 and 100.0lbs.");   
        }
    }

    /**
     * @param origin city name of the origin city
     * @return setOriginCity sets the origin city
     */
    public void setOriginCity(String originCity)
    {
        if(originCity != null && !originCity.equals("")) {
            this.originCity = originCity;   

        }else if(originCity == null){
            throw new IllegalArgumentException("The Origin City is not valid.");
        }else{
            throw new IllegalArgumentException("The Origin City is not set.");
        }
    }

    /**
     * @param destinationCity name of the destination city
     * @return setDestinationCity sets the destination city
     */
    public void setDestinationCity(String destinationCity)
    {
        if(destinationCity != null && !destinationCity.equals("")) {
            this.destCity = destinationCity;
        }else if(destinationCity == null){
            throw new IllegalArgumentException("The Destination City is not valid.");
        }else{
            throw new IllegalArgumentException("The Destination City is not set.");
        }
    }

    /**
     * @param trackingWebpage address of the tracking webpage
     * @return setTrackingWebpage sets the tracking webpage
     */
    public void setTrackingWebpage(String trackingWebpage)
    {
        if(trackingWebpage != null && !trackingWebpage.equals("")) {
            this.trackingPage = trackingWebpage;
        }else if(trackingWebpage == null){
            throw new IllegalArgumentException("The Tracking Page is not valid.");
        }else{
            throw new IllegalArgumentException("The Tracking Page is not set.");
        }
    }

    //Accessor Methods

    /**
     * @return getTrackingCode returns the tracking code 
     */
    public int getTrackingCode () {
        return trackingCode;
    }

    /**
     * @return getPriority return the priority number
     */
    public int getPriority() {
        return priority;   
    }

    /**
     * @return getShippingPrice returns the price of shipping
     */
    public double getShippingPrice() {
        return shippingPrice;
    }

    /**
     * @return getWeightInPounds returns the weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return getOriginCity returns the origin city
     */
    public String getOriginCity() {
        return originCity;   
    }

    /**
     * @return getDestinationCity returns the destination city
     */
    public String getDestCity() {
        return destCity;
    }

    /**
     * @return getTrackingWebpage returns the tracking webpage
     */
    public String getTrackingPage() {
        return trackingPage;   
    }

    /**
     * return getPackageDetails returns a string with package details
     */
    public String getPackageDetails() {
        return "Package " + getTrackingCode() + " ships from " + getOriginCity() + " to " + getDestCity() + " for $" + getShippingPrice() + " with priority "
        + getPriority() + " and weight of " + getWeight() + "lbs. Tracking details at " + getTrackingPage() + ".";
    }
}
