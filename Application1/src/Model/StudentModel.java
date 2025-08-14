package Model;

public class StudentModel {
    private String name;
    private String place;
    private int age;
    private int phy;
    private int math;
    private int chem;
    private int eng;
    private String username;
    private String password;
    private int department_id;
    private int teacher_id;


    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public int getAge() {
        return age;
    }

    public int getPhy() {
        return phy;
    }

    public int getMath() {
        return math;
    }

    public int getChem() {
        return chem;
    }

    public int getEng() {
        return eng;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public StudentModel( String name, String place, int age,
                         int phy, int math, int chem, int eng,
                         String username, String password,
                         int department_id, int teacher_id) {

        this.name = name;
        this.place = place;
        this.age = age;
        this.phy = phy;
        this.math = math;
        this.chem = chem;
        this.eng = eng;
        this.username = username;
        this.password = password;
        this.department_id = department_id;
        this.teacher_id = teacher_id;
    }

    public int getTotal(){
        int total=phy+math+chem+eng;
        return total;
    }

}
