import java.util.ArrayList;
import java.util.List;

public class Reservation_manager {
    private List<Ticket> confirm_ticket_data=new ArrayList<>();
    private List<Ticket> rac_ticket=new ArrayList<>();
    private List<Ticket> waiting_list=new ArrayList<>();
 public void Available_tickets(){
     System.out.println("("+(Train.get_ConfirmTicket()-confirm_ticket_data.size())+") Tickets Available");
 }
 public void  Book_Ticket(String name,int age ,char perf){
    Ticket ticket= Ticket_Factory.create_ticket(name,age ,perf);
     System.out.println(ticket.seat_no);
     if(confirm_ticket_data.size()<3){
         confirm_ticket_data.add(ticket);
         System.out.println("________________________________");
         System.out.println("Ticket Confirmed ");
         getTicket_details(ticket.Ticket_id);

     } else if (rac_ticket.size()<Train.get_RacTicket()) {
         rac_ticket.add(ticket);
         System.out.println("________________________________");
         System.out.println("Ticket in Rac");
         getTicket_details(ticket.Ticket_id);

     }
     else if(waiting_list.size()<Train.get_WatingTicket()){
         waiting_list.add(ticket);
         System.out.println("________________________________");
         System.out.println("Ticket in Waiting List");
         getTicket_details(ticket.Ticket_id);

     }
     else{
         System.out.println("________________________________");
         System.out.println("No Ticket Available Currently");

     }
 }
 private  Ticket getTicket(int id){
     for(Ticket i:confirm_ticket_data){
         if(i.Ticket_id==id){
             return i;
         }
     }
     for(Ticket i:rac_ticket){
         if(i.Ticket_id==id){
             return i;
         }
     }
     for(Ticket i:waiting_list){
         if(i.Ticket_id==id){
             return i;
         }
     }
     return null;
 }
 public void getTicket_details(int id){
     Ticket i=getTicket(id);
     if(i!=null){
         System.out.println("________________________________");
         System.out.println(
                 "Ticket Id: "+i.Ticket_id+"\n"+
                         "Name: "+i.name+"\n"+
                         "Age: "+i.age+"\n"+
                         "Berth preference: "+i.perf+"\n"+
                         "Seat No: "+i.seat_no);
         System.out.println("________________________________");
     }
     else{
         System.out.println("________________________________");
         System.out.println("No Ticket Found");
         System.out.println("________________________________");
     }
 }
 public void Cancel_Ticket(int id){
     Ticket ticket=getTicket(id);
    if(ticket!=null){
        confirm_ticket_data.remove(ticket);
        if(!rac_ticket.isEmpty()){
            Ticket racTicket=rac_ticket.remove(0);
            racTicket.perf=ticket.perf;
            racTicket.seat_no=ticket.seat_no;
            confirm_ticket_data.add(racTicket);
            if(!waiting_list.isEmpty()){
                rac_ticket.add(waiting_list.remove(0));
            }
        }
        System.out.println("________________________________");
        System.out.println("Ticket id:"+ticket.Ticket_id+"Cancelled Succesfully");
        System.out.println("________________________________");
    }

 }
 public void display_AllTickets(){
     for(Ticket i:confirm_ticket_data){
         System.out.println("________________________________");
         System.out.println(
                 "Ticket Id: "+i.Ticket_id+"\n"+
                 "Name: "+i.name+"\n"+
                 "Age: "+i.age+"\n"+
                 "Berth preference: "+i.perf+"\n"+
                 "Seat No: "+i.seat_no);
         System.out.println("________________________________");
     }
     for(Ticket i:rac_ticket){
         System.out.println("________________________________");
         System.out.println(
                 "Ticket Id: "+i.Ticket_id+"\n"+
                         "Name: "+i.name+"\n"+
                         "Age: "+i.age+"\n"+
                         "Berth preference: "+i.perf+"\n"+
                         "Seat No: "+i.seat_no);
         System.out.println("________________________________");
     }
     for(Ticket i:waiting_list){
         System.out.println("________________________________");
         System.out.println(
                 "Ticket Id: "+i.Ticket_id+"\n"+
                         "Name: "+i.name+"\n"+
                         "Age: "+i.age+"\n"+
                         "Berth preference: "+i.perf+"\n"+
                         "Seat No: "+i.seat_no);
         System.out.println("________________________________");
     }
 }

}
