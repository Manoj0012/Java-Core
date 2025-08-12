package Repository;

import Model.TeacherModel;

import java.sql.*;

public class AdminRepo {
    private final DB_Connectivity connectivity;
    private final Connection dbconnection;
    public AdminRepo(){
         this.connectivity=DB_Connectivity.getDatabase();
         this.dbconnection=connectivity.getConnection();
    }

    public ResultSet AllTeachers() {
        // need to apply view.......soon
        String sql="SELECT * FROM teacherView";
        ResultSet resData=null;
        try {
            Statement st=dbconnection.createStatement();
            resData=st.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  resData;
    }

    public int addTeacher(TeacherModel t){
        String sql="INSERT INTO teacher(t_name,t_place,username,password,dep_id) VALUES (?, ?, ?, ?, ?);";
        int row_affected=0;
        try{

            PreparedStatement pt= dbconnection.prepareStatement(sql);
            pt.setString(1, t.getName());
            pt.setString(2, t.getPlace());
            pt.setString(3, t.getUsername());
            pt.setString(4, t.getPassword());
            pt.setInt(5, t.getDep_id());
            row_affected= pt.executeUpdate();
            pt.close();
        }
        catch (SQLException e){
            System.out.println("Failed! to Insert the Data "+e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return row_affected;
    }

    public ResultSet ViewOneTeacher(int id){
        String sql="SELECT * FROM teacherView WHERE t_id=?";
        ResultSet resData=null;
        try{
            PreparedStatement pt=dbconnection.prepareStatement(sql);
            pt.setInt(1,id);
            resData=pt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed! to get the Data "+e.getMessage());
        }
        return  resData;
    }

    public int updateTeacher(TeacherModel t,int id){
        String sql="UPDATE  teacher set t_name=?,t_place=?,username=?,password=?,dep_id=? where t_id=?;";
        int row_affected=0;
        try{
            PreparedStatement pt= dbconnection.prepareStatement(sql);
            pt.setString(1, t.getName());
            pt.setString(2, t.getPlace());
            pt.setString(3, t.getUsername());
            pt.setString(4, t.getPassword());
            pt.setInt(5, t.getDep_id());
            pt.setInt(6, id);
            row_affected=pt.executeUpdate();
            pt.close();
        }
        catch (SQLException e){
            System.out.println("Failed! to Insert the Data "+e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return row_affected;
    }

    public int deleteTeacher(int id){
        String sql="DELETE FROM teacher where t_id=?;";
        int row_affected=0;
        try{
            PreparedStatement  pt=dbconnection.prepareStatement(sql);
            pt.setInt(1, id);
            row_affected=pt.executeUpdate();
            pt.close();
        } catch (SQLException e) {
            System.out.println("Failed! to Delete the Data "+e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return row_affected;
    }
}
