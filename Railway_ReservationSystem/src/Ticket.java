public class Ticket {
    int Ticket_id;
    String name;
    int age;
    char perf;
    int seat_no;

    public Ticket(int ticket_id, String name, int age, Character perf, int seat_no) {
        Ticket_id = ticket_id;
        this.name = name;
        this.age = age;
        this.perf = perf;
        this.seat_no = seat_no;
    }
}
