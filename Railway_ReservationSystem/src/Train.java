public class Train {
    private static int  Confirm_Ticket=3;
    private static int  Rac_Ticket=1;
    private static  int  Wating_Ticket=1;
    public static void setTrain_tickets(int confirm_Ticket,int rac_Ticket,int wating_Ticket) {
        Confirm_Ticket = confirm_Ticket;
        Rac_Ticket=rac_Ticket;
        Wating_Ticket=wating_Ticket;
    }
    public static  int  get_ConfirmTicket(){
        return Confirm_Ticket;
    }
    public static int  get_RacTicket(){
        return Rac_Ticket;
    }
    public static int  get_WatingTicket(){
        return Wating_Ticket;
    }
}
