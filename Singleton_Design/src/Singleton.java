public class Singleton {
    private static  Vehicle vehicle;
    private Singleton(){}
    public static Vehicle getInstance(){
        if(vehicle==null){
            return vehicle=new Car();
        }
        return vehicle;
    }
}
