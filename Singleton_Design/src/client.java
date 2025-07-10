//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class client {
    public static void main(String[] args) {
        Vehicle car=Singleton.getInstance();
        car.start();
        car.stop();
    }
}