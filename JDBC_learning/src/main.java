import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Amazon";
        String username = "root";
        String password = "";
        ConnectionProvider db = new ConnectionProvider(url, username, password);
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter the Operation:");
            System.out.println("Enter No 1 for Readone");
            System.out.println("Enter No 2 for ReadAll");
            System.out.println("Enter No 3 for Create");
            System.out.println("Enter No 4 for Update");
            System.out.println("Enter No 5 for Delete");
            System.out.println("Enter No 0 for exit");
            int choice=sc.nextInt();
            int id=0;
            switch (choice){
                case 1:
                    System.out.println("------------------------");
                    System.out.println("Enter the id to read:");
                    id=sc.nextInt();
                    db.read(id);
                    System.out.println("------------------------");
                    break;
                case 2:
                    System.out.println("------------------------");
                    System.out.println("All Records");
                    db.read();
                    System.out.println("------------------------");
                    break;
                case 3:
                    System.out.println("------------------------");
                    System.out.println("Create record");
                    System.out.println("Enter Product Name:");
                    String productName=sc.next();
                    System.out.println("Enter category Name:");
                    String category=sc.next();
                    System.out.println("Enter Price:");
                    int price=sc.nextInt();
                    db.createProduct(productName,category,price);
                    System.out.println("------------------------");
                    break;
                case 4:
                    System.out.println("------------------------");
                    System.out.println("Update record");
                    System.out.println("Enter id");
                    id=sc.nextInt();
                    System.out.println("Enter New Price :");
                    int update_price=sc.nextInt();
                    db.updateProduct(id,update_price);
                    System.out.println("------------------------");
                    break;
                case 5:
                    System.out.println("------------------------");
                    System.out.println("Delete record");
                    System.out.println("Enter id");
                    id=sc.nextInt();
                    db.deleteProduct(id);
                    System.out.println("------------------------");
                    break;
                case 0:
                    System.out.println("Thank you");
                    System.exit(1);
                default:
                    System.out.println("No Operation Present!");
            }
        }
    }
}
