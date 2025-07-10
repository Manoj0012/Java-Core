public class Built_Vahicle_Factory {
    public static Vehicle_Factory get_vehicle_factory(String brand){
        if(brand.equals("toyato")){
            return new Toyato_factory();
        } else if (brand.equals("benz")) {
            return new Benz_factory();
        }
        return null;
    }
}
