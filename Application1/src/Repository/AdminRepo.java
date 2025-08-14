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

    public ResultSet AllTeachers() throws SQLException {
        String sql="SELECT * FROM teacherView";
        Statement st=dbconnection.createStatement();
        ResultSet resData=st.executeQuery(sql);
        return  resData;
    }

    public int addTeacher(TeacherModel t) throws SQLException {
        String sql="INSERT INTO teacher(t_name,t_place,username,password,dep_id) VALUES (?, ?, ?, ?, ?);";
        int row_affected=0;
        PreparedStatement pt= dbconnection.prepareStatement(sql);
        pt.setString(1, t.getName());
        pt.setString(2, t.getPlace());
        pt.setString(3, t.getUsername());
        pt.setString(4, t.getPassword());
        pt.setInt(5, t.getDep_id());
        row_affected= pt.executeUpdate();
        pt.close();
        return row_affected;
    }

    public ResultSet ViewOneTeacher(int id) throws SQLException {
        String sql="SELECT * FROM teacherView WHERE t_id=?";
        PreparedStatement pt=dbconnection.prepareStatement(sql);
        pt.setInt(1,id);
        ResultSet resData=pt.executeQuery();
        return  resData;
    }

    public int updateTeacher(TeacherModel t,int id) throws SQLException {
        String sql="UPDATE  teacher set t_name=?,t_place=?,username=?,password=?,dep_id=? where t_id=?;";
        int row_affected=0;
        PreparedStatement pt= dbconnection.prepareStatement(sql);
        pt.setString(1, t.getName());
        pt.setString(2, t.getPlace());
        pt.setString(3, t.getUsername());
        pt.setString(4, t.getPassword());
        pt.setInt(5, t.getDep_id());
        pt.setInt(6, id);
        row_affected=pt.executeUpdate();
        pt.close();
        return row_affected;
    }

    public int deleteTeacher(int id) throws SQLException {
        String sql="DELETE FROM teacher where t_id=?;";
        int row_affected=0;
         PreparedStatement  pt=dbconnection.prepareStatement(sql);
         pt.setInt(1, id);
         row_affected=pt.executeUpdate();
         pt.close();
        return row_affected;
    }
}
