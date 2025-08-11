import Repository.DB_Connectivity;
import Service.AdminService;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /// fro testing only
        DB_Connectivity connectivity=DB_Connectivity.getDatabase();
        AdminService adminService=new AdminService();

//        adminService.updateTeacher("JAN Adrean","usa","jan1243","0000",2,3);
//        adminService.deleteTeacher(2);
        adminService.viewTeachers();
        connectivity.closeConnection();

    }
}