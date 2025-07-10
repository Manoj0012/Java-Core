public class Client {
    public static void main(String[] args) {
       Vehicle_Factory Toyato=Built_Vahicle_Factory.get_vehicle_factory("toyato");
       Vehicle car=Toyato.getCar();
       car.assemble();
    }
}
