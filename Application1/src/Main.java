import Model.TeacherModel;
import Repository.DB_Connectivity;
import Repository.AdminRepo;
import Service.AdminService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DB_Connectivity connectivity=DB_Connectivity.getDatabase();
        AdminService adminService=new AdminService();
//        adminService.UpdateTeacher(new TeacherModel("manoj upadte","tamilnode","m000","0000",2),4);
//        adminService.DeleteTeacher(4);
        adminService.ViewTeacherByID(3);
//        adminService.ViewAllTeachers();
    }
}