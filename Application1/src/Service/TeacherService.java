package Service;

import Model.StudentModel;
import Repository.TeacherRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherService {
    private final TeacherRepo teacherRepo ;
    public TeacherService(){
       this.teacherRepo = new TeacherRepo();
    }
    public void ViewAllStudent(){
        try {
            ResultSet res = teacherRepo.getAllStudents();
            PrintStudent(res);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void ViewOneStudent(int id){
            try{
                ResultSet res = teacherRepo.getStudent(id);
               PrintStudent(res);
            } catch (NullPointerException e) {
                System.out.println("No Such Student Exists");
            }
            catch (SQLException e){
                System.out.println("Failed to fetch data "+e.getMessage());
            }
    }
    public void AddStudent(StudentModel s){
        try{
            int total=s.getTotal();
            int row=teacherRepo.AddStudent(s,total,status(total));
            if(row>0){
                System.out.println("Student Added Successfully");
            }
        }
        catch (SQLException e){
            System.out.println("Failed to Add Student data "+e.getMessage());
        }
    }

    public void Average(){
        try {
            ResultSet rs=teacherRepo.getAllStudents();
            int total=0;
            int index=0;
            while(rs.next()){
                total+=rs.getInt(8);
                index++;
            }
            System.out.println("Average Student is "+(total/index));
        }
        catch (SQLException e){
            System.out.println("Failed to Calculate Average Student data "+e.getMessage());
        }
        catch (NullPointerException e){
            System.out.println("No Data Available");
        }
    }

    private String status(int total){
        if(total>=(400*0.4)) return "PASS";
        return "FAIL";
    }

    private void PrintStudent(ResultSet res) throws SQLException {
        while (res.next()) {
            System.out.println(
                    "Id :"+res.getInt(1)+" | "+
                            "Name :"+res.getString(2)+" | "+
                            "Place :"+res.getString(3)+" | "+
                            "Physics "+res.getInt(4)+" | "+
                            "Math "+res.getInt(5)+" | "+
                            "Chemistry :"+res.getInt(6)+" | "+
                            "English :"+res.getInt(7)+" | "+
                            "Total :"+res.getInt(8)+" | "+
                            "Status :"+res.getString(9)+" | "+
                            "Department id :"+res.getInt(10)+" | "+
                            "Department Name :"+res.getString(11)
            );
        }
    }
}
