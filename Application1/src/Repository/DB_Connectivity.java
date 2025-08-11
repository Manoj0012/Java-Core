package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connectivity {
    private  Connection con = null;
    private static DB_Connectivity database=null;
    private DB_Connectivity(){
        connect();
    }
    private void connect()  {
        try{
            this.con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Application1","root","");
            System.out.println("Connected to database successfully");
        }
        catch (SQLException e){
            System.out.println("Connection Failed! Check output console "+e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static DB_Connectivity getDatabase(){
        if(database==null){
            database=new DB_Connectivity();
        }
        return database;
    }

    public Connection getConnection(){
        return this.con;
    }

    public void closeConnection()  {
        try {
            this.con.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console "+e.getMessage());
        }

    }

}
