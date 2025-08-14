package Model;

public class TeacherModel {
   private String name;
   private String place;
   private String username;
   private String password;
   private int dep_id;


    public TeacherModel(String name, String place, String username, String password, int depId) {
        this.name = name;
        this.place = place;
        this.username = username;
        this.password = password;
        dep_id = depId;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getDep_id() {
        return dep_id;
    }

}
