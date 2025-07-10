public class Benz_factory implements Vehicle_Factory{
    @Override
    public Vehicle getCar() {
        return new Benz_car();
    }
}
