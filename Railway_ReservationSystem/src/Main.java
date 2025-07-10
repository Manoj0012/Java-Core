import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Reservation_manager reservationManager=new Reservation_manager();
        while(true){
            int i=0;
            Scanner s=new Scanner(System.in);
            System.out.println("________________________________");
            System.out.println("1) Book Tickets   ");
            System.out.println("2) Ticket Details ");
            System.out.println("3) All Tickets    ");
            System.out.println("4) Cancel Ticket  ");
            System.out.println("5) Available Tickets   ");
            System.out.println("0) Exit           ");
            System.out.println("________________________________");
            i=s.nextInt();
            switch (i){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("________________________________");
                    System.out.println("Enter name");
                    String name=s.next();
                    System.out.println("Enter age");
                    int age= s.nextInt();
                    System.out.println("Enter Berth Preference");
                    char pref=s.next().charAt(0);
                    reservationManager.Book_Ticket(name,age,pref);
                    break;
                case 2:
                    System.out.println("________________________________");
                    System.out.println("Enter your Ticket Id:");
                    int id=s.nextInt();
                    reservationManager.getTicket_details(id);
                    break;
                case 3:
                    System.out.println("________________________________");
                    reservationManager.display_AllTickets();
                    break;
                case 4:
                    System.out.println("________________________________");
                    System.out.println("Enter your Ticket Id:");
                    int Ticket_id=s.nextInt();
                    reservationManager.Cancel_Ticket(Ticket_id);
                    break;
                case 5:
                    System.out.println("________________________________");
                    reservationManager.Available_tickets();
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}