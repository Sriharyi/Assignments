class Car extends Vehicle{
    public static void main(String args[]){
        Vehicle car1 = new Vehicle();
        Vehicle bmw = new Vehicle("Car","ThroughLand");
        System.out.println(car1.vehicleType+" "+car1.modeofTransport);
        System.out.println(bmw.vehicleType+" "+bmw.modeofTransport);
    }
}