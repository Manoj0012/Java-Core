public class Car implements Vehicle{
    @Override
    public void start() {
        System.out.println("An car Starts");
    }

    @Override
    public void stop() {
        System.out.println("An a car Stops");
    }
}
