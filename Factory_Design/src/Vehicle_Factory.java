public class Vehicle_Factory {
    private static  Vehicle vehicle;
    public static  Vehicle createvehicle(String Type){
        switch(Type){
            case "car":
                vehicle= new Car();
                break;
            case "bike":
                vehicle= new Bike();
                break;
            default:
                System.out.println("Invalid creation");
                break;
        }
        return vehicle;
    }
}
