public class Vehicle{
    public String vehicleType;
    public String modeofTransport;
    public Vehicle()
    {
        this("Unknown","Unknown");
        System.out.println("Constructor with no arguments");
        // this.vehicleType = "Unknown";
        // this.modeofTransport = "Unknown";
    }
    public Vehicle(String vehicleType,String modeofTransport)
    {
        System.out.println("Constructor with two arguments");
        this.vehicleType = vehicleType;
        this.modeofTransport = modeofTransport;
    }
}