public class User implements Subscriber {
    private int id;

    public User(int id) {
        this.id = id;
    }
    public void details(){
        System.out.println(getClass().getName()+""+this.id);
    }
    @Override
    public void notify(String msg) {
        System.out.println("Hey you got Message:"+" "+msg);
    }

}
