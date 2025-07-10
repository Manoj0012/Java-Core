public class Toyato_factory implements Vehicle_Factory{
    @Override
    public Vehicle getCar() {
        return new Toyato_car();
    }
}
