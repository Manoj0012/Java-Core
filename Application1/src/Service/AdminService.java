package Service;

import Model.TeacherModel;
import Repository.AdminRepo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService {
    private AdminRepo adminRepo =null;
    public AdminService(){
        adminRepo = new AdminRepo();
    }

    public void ViewAllTeachers(){
        ResultSet rs;
       try {
            rs= adminRepo.AllTeachers();
           while (rs.next()) {
               System.out.println("==================================================");
               System.out.println(
                       "ID: " + rs.getInt(1) + " | "
                               + "Name: " + rs.getString(2) + " | "
                               + "Place: " + rs.getString(3) + " | "
                               + "Department Id: " + rs.getString(4) + " | "
                               + "Department Name: " + rs.getString(5) + " | "

               );
               System.out.println("==================================================");
           }
           if(rs!=null){
               rs.close();
           }
       }
       catch (SQLException e){
           System.out.println(e.getMessage());
       }
       catch (Exception e) {
           System.out.println("Data is null"+e.getMessage());
       }
    }

    public  void  ViewTeacherByID(int id){
        try {
            ResultSet rs= adminRepo.ViewOneTeacher(id);
            while(rs.next()) {
                System.out.println("==================================================");
                System.out.println(
                        "ID: " + rs.getInt(1) + " | "
                                + "Name: " + rs.getString(2) + " | "
                                + "Place: " + rs.getString(3) + " | "
                                + "Department Id: " + rs.getString(4) + " | "
                                + "Department Name: " + rs.getString(5) + " | "

                );
                System.out.println("==================================================");
            }
            if(rs!=null){
                rs.close();
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Data is null"+e.getMessage());
        }
    }


    public void AddTeacher(TeacherModel t){
        int row=adminRepo.addTeacher(t);
        if(row<=0){
            System.out.println("Teacher Failed to Add");
            return;
        }
        System.out.println(row+" Teacher Added");
    }


    public void UpdateTeacher(TeacherModel t,int id){
        int row=adminRepo.updateTeacher(t,id);
        if(row<=0){
            System.out.println("Teacher Failed to Update");
            return;
        }
        System.out.println(row+" Teacher Updated");
    }
    public void DeleteTeacher(int id){
        int row=adminRepo.deleteTeacher(id);
        if(row<=0){
            System.out.println("Teacher Failed to delete");
            return;
        }
        System.out.println(row+" Teacher deleted");
    }
}
