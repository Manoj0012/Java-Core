import java.sql.*;

public class ConnectionProvider {
    private final Connection con;
    private PreparedStatement pst=null;

    public ConnectionProvider(String url,String username,String password) throws SQLException {
        con= DriverManager.getConnection(url,username,password);
    }

    public void createProduct(String product_name,String category,int price) throws SQLException {
        String command="INSERT INTO product(product_name,category,price)VALUES(?,?,?)";
       try{
           pst=con.prepareStatement(command);
           pst.setString(1,product_name);
           pst.setString(2,category);
           pst.setInt(3,price);
           int row= pst.executeUpdate();
           System.out.println("Successfully Stored: "+row+" "+"data");
       } catch (SQLException e) {
           System.out.println("Error:"+e.getMessage());
       }
       finally {
          if(pst!=null) pst.close();
       }
    }

    public void read(int id) {
        try{
            ResultSet data=readOne(id);
            if(!data.isBeforeFirst()) throw  new NullPointerException();
            while(data.next()){
                System.out.println(
                                "Product id: "+ data.getInt(1)+"\n"+
                               "Product name: "+ data.getString(2)+"\n"+
                               "Product category: "+ data.getString(3)+"\n"+
                               "Product price: "+ data.getInt(4));
            }
        }
        catch (NullPointerException e){
            System.out.println("data dosen't present in database");
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }


    public void read() {
        try{
            ResultSet data=readAll();
            if(data==null) throw  new NullPointerException();
            while(data.next()){
                System.out.println(
                        "Product id: "+ data.getInt(1)+"\n"+
                                "Product name: "+ data.getString(2)+"\n"+
                                "Product category: "+ data.getString(3)+"\n"+
                                "Product price: "+ data.getInt(4));
            }
        }
        catch (NullPointerException e){
            System.out.println("No data present");
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }


    private ResultSet readOne(int id) throws SQLException {
         ResultSet data=null;
        try{
            String command="SELECT * FROM product WHERE id=?";
            pst=con.prepareStatement(command);
            pst.setInt(1,id);
            data=pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return data;
    }


    private ResultSet readAll() throws SQLException {
        ResultSet data=null;
        try{
            String command="SELECT * FROM product";
            pst=con.prepareStatement(command);
            data=pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return data;
    }


    public void updateProduct(int id,int price) throws SQLException {
        String command="UPDATE  product SET price=? WHERE id=?";
        try{
            pst=con.prepareStatement(command);
            pst.setInt(1,price);
            pst.setInt(2,id);
            int row= pst.executeUpdate();
            System.out.println("Successfully Updated: "+row+"data");
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
        }
        finally {
            if(pst!=null) pst.close();
        }
    }
    public void deleteProduct(int id) throws SQLException {
        String command="DELETE FROM product  WHERE id=?";
        try{
            pst=con.prepareStatement(command);
            pst.setInt(1,id);
            int row= pst.executeUpdate();
            System.out.println("Successfully Deleted: "+" "+row+"data");
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
        }
        finally {
            if(pst!=null) pst.close();
        }
    }
    public void CloseConnection()  {
        try{
            if(con!=null&& !con.isClosed()){
                System.out.println("Connection Successfully Closed");
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error in Closing Connection:"+e.getMessage());
        }
    }
}
