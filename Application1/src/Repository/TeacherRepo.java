package Repository;

import Model.StudentModel;

import java.sql.*;

public class TeacherRepo {
    private final DB_Connectivity connectivity;
    private final Connection db_conn;

    public TeacherRepo() {
        this.connectivity=DB_Connectivity.getDatabase();
        this.db_conn=connectivity.getConnection();
    }

    public ResultSet getAllStudents() throws SQLException{
        String sql="SELECT * FROM StudentView;";
        Statement stmt = db_conn.createStatement();
        ResultSet  resdata = stmt.executeQuery(sql);
        return resdata;
    }

    public ResultSet getStudent(int id) throws SQLException{
        String sql="SELECT * FROM StudentView  WHERE s_id=?;";
        PreparedStatement stmt = db_conn.prepareStatement(sql);
        stmt.setInt(1,id);
        ResultSet resdata = stmt.executeQuery();
        return resdata;
    }

    public int AddStudent(StudentModel s,int total,String status) throws SQLException{
        String sql="INSERT INTO student" +
                "(s_name, s_place, s_age, phys, math, chem, eng, total, status, username, password, dep_id, t_id)"+
                "VALUES"+"(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = db_conn.prepareStatement(sql);
        stmt.setString(1,s.getName());
        stmt.setString(2,s.getPlace());
        stmt.setInt(3,s.getAge());
        stmt.setInt(4,s.getPhy());
        stmt.setInt(5,s.getMath());
        stmt.setInt(6,s.getChem());
        stmt.setInt(7,s.getEng());
        stmt.setInt(8,total);
        stmt.setString(9,status);
        stmt.setString(10,s.getUsername());
        stmt.setString(11,s.getPassword());
        stmt.setInt(12,s.getDepartment_id());
        stmt.setInt(13,s.getTeacher_id());
        int row=stmt.executeUpdate();
        return row;
    }
}
