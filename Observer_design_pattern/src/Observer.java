import java.util.ArrayList;
import java.util.List;

public class Observer {
    private List<User> subscibers=new ArrayList<>();

    public void add_subscriber(User user){
      if(subscibers.contains(user)){
          System.out.println("User already there");
      }
      else{
          subscibers.add(user);
          System.out.println("Subscriber Added");
      }
    }
    public void remove_subscriber(User user){
        if(!subscibers.contains(user)){
            System.out.println("User not found");
        }
        else{
            subscibers.remove(user);
            System.out.println("User Removed");
        }
    }
    public void subscriber_details( ){
        for(User user:subscibers){
            user.details();
        }
    }
    public void sent_update(String msg){
        for(User user:subscibers){
            user.notify(msg);
        }
    }

}
