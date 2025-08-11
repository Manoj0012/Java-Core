package Service;

import Repository.DB_Connectivity;

import java.sql.*;

public class AdminService {
    private final DB_Connectivity connectivity;
    private final Connection dbconnection;
    public AdminService(){
         this.connectivity=DB_Connectivity.getDatabase();
         this.dbconnection=connectivity.getConnection();
    }

    public void viewTeachers() {
        // need to apply view.......soon
        String sql="SELECT * FROM teacher";
        try {
            Statement st=dbconnection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            System.out.println("==============================");
            while(rs.next()){
                System.out.println(
                        "ID: "+rs.getInt(1)+" | "
                        +"Name: "+ rs.getString(2)+" | "
                        +"Place: "+rs.getString(3));
            }
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTeacher(String name,String place,String username,String password,int dep_id){
        String sql="INSERT INTO teacher(t_name,t_place,username,password,dep_id) VALUES (?, ?, ?, ?, ?);";
        try{

            PreparedStatement pt= dbconnection.prepareStatement(sql);
            pt.setString(1, name);
            pt.setString(2, place);
            pt.setString(3, username);
            pt.setString(4, password);
            pt.setInt(5, dep_id);
            pt.executeUpdate();
            pt.close();
        }
        catch (SQLException e){
            System.out.println("Failed! to Insert the Data "+e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateTeacher(String name,String place,String username,String password,int dep_id,int id){
        String sql="UPDATE  teacher set t_name=?,t_place=?,username=?,password=?,dep_id=? where t_id=?;";
        System.out.println(sql);
        try{

            PreparedStatement pt= dbconnection.prepareStatement(sql);
            pt.setString(1, name);
            pt.setString(2, place);
            pt.setString(3, username);
            pt.setString(4, password);
            pt.setInt(5, dep_id);
            pt.setInt(6, id);
            pt.executeUpdate();
            pt.close();
        }
        catch (SQLException e){
            System.out.println("Failed! to Insert the Data "+e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteTeacher(int id){
        String sql="DELETE FROM teacher where t_id=?;";
        try{
            PreparedStatement  pt=dbconnection.prepareStatement(sql);
            pt.setInt(1, id);
            pt.executeUpdate();
            System.out.println("Teacher data deleted!");
            pt.close();

        } catch (SQLException e) {
            System.out.println("Failed! to Delete the Data "+e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
