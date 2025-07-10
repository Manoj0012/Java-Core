public class Ticket_Factory {
   private static  int Upper=1;
   private static  int Middle=2;
   private static int Lower=3;
   private static int id=1;
    public static Ticket create_ticket(String name,int age,char perf){
        Ticket ticket=null;
        if( Train.get_ConfirmTicket()>=Lower && (age<18||age>=60) ){
            ticket=new Ticket(id++,name,age,'L',Lower);
            Lower=Lower+3;
            return ticket;
        }
        Seat seat=allocate_seat(perf);
        if(seat.seat_no!=0){
            ticket=new Ticket(id++,name,age,seat.berth,seat.seat_no);
        }
        else {
            ticket=new Ticket(id++,name,age,perf,0);
        }
        return ticket;
    }
    private static Seat allocate_seat(char pref){
       switch (pref){
           case 'U':
               if (Train.get_ConfirmTicket()>=Upper) return getseat('U');
               if (Train.get_ConfirmTicket()>=Middle) return getseat('M');
               if (Train.get_ConfirmTicket()>=Lower) return getseat('L');
               break;
           case 'M':
               if (Train.get_ConfirmTicket()>=Middle) return getseat('M');
               if (Train.get_ConfirmTicket()>=Lower) return getseat('L');
               if (Train.get_ConfirmTicket()>=Upper) return getseat('U');
               break;
           case 'L':
               if (Train.get_ConfirmTicket()>=Lower) return getseat('L');
               if (Train.get_ConfirmTicket()>=Middle) return getseat('M');
               if (Train.get_ConfirmTicket()>=Upper) return getseat('U');
               break;
       }
       return new Seat(0,pref);
    }
    private static Seat getseat(char pref){
        Seat seat=null;
        switch (pref){
        case 'U':
            seat=new Seat(Upper,'U');
             Upper=Upper+3;
             break;
             case 'M':
                 seat=new Seat(Middle,'M');
                 Middle=Middle+3;
                 break;
            case 'L':
                seat=new Seat(Lower,'L');
                Lower=Lower+3;
                break;
        }
        return seat;
    }
}
