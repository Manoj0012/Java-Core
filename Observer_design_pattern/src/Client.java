//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client {
    public static void main(String[] args) {
        Observer observer=new Observer();
        User user1=new User(1);
        User user2=new User(3);
        User user3=new User(3);
        observer.add_subscriber(user1);
        observer.add_subscriber(user2);
        observer.add_subscriber(user3);
        observer.remove_subscriber(user2);
        observer.subscriber_details();
        observer.sent_update("hi");
    }
}