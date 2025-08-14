import Model.StudentModel;
import Model.TeacherModel;
import Repository.DB_Connectivity;
import Repository.AdminRepo;
import Service.AdminService;
import Service.TeacherService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DB_Connectivity connectivity=DB_Connectivity.getDatabase();
        TeacherService teacherService=new TeacherService();
//        teacherService.AddStudent(new StudentModel("abc","kk",12,90,90,90,90,"uccc","000",1,1));
        teacherService.Average();
        teacherService.ViewAllStudent();
    }
}