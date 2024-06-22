package ticketandersencourse.service;

import ticketandersencourse.interfaces.Printable;
import ticketandersencourse.interfaces.RolePrint;
import ticketandersencourse.interfaces.Shareable;
import ticketandersencourse.model.Ticket;
import ticketandersencourse.user.Admin;
import ticketandersencourse.user.Client;
import ticketandersencourse.user.Entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private static List<Ticket> ticketList;

    public TicketService() {
        ticketList = new ArrayList<>();
    }

    public static void getTicketList() {
        System.out.println(ticketList);
    }

    public static void setTicketList(List<Ticket> ticketList) {
        TicketService.ticketList = ticketList;
    }

    public static String getTicketById(String ID) {
        for (Ticket ticket : ticketList) {
            if (ticket.getID().equals(ID)) {
                return ticket.getID();
            }
        }
        return null;
    }

    public static void main(String[] args)  {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("4893", "hall #1", 489, Instant.now().getEpochSecond(), true, 'A', 3.5, new BigDecimal("120"), 4852));
        tickets.add(new Ticket("8624", "hall #2", 239, Instant.now().getEpochSecond(), true,'B', 4.0, new BigDecimal("150"), 3585));
        tickets.add(new Ticket("9247", "hall #3", 769, Instant.now().getEpochSecond(), true, 'C', 5.0, new BigDecimal("145"), 1285));
        tickets.add(new Ticket("3581", "hall #4", 196, Instant.now().getEpochSecond(), true,  'C', 4.5, new BigDecimal("110"), 8632));
        tickets.add(new Ticket("6384", "hall #5", 374, Instant.now().getEpochSecond(), true,'A', 3.0, new BigDecimal("125"), 4485));
        tickets.add(new Ticket("4925", "hall #6", 815, Instant.now().getEpochSecond(), true, 'B', 2.5, new BigDecimal("180"), 7963));
        tickets.add(new Ticket("3702", "hall #7", 684, Instant.now().getEpochSecond(), true, 'B', 2.0, new BigDecimal("85"), 5896));
        tickets.add(new Ticket("4305", "hall #8", 106, Instant.now().getEpochSecond(), true, 'C', 3.5, new BigDecimal("95"), 4586));
        tickets.add(new Ticket("7900", "hall #9", 674, Instant.now().getEpochSecond(), true, 'A', 5.5, new BigDecimal("165"), 3658));
        tickets.add(new Ticket("1385", "hall #10", 285, Instant.now().getEpochSecond(), true, 'A', 6.0, new BigDecimal("175"), 1486));
        setTicketList(tickets);
        //getTicketList();


        //empty
        Ticket empty = new Ticket();
        System.out.println(empty);
        //full
        Ticket full = new Ticket("4575", "Elphi",
                    120, Instant.now().getEpochSecond(), true,
                'B', 12.0, new BigDecimal("45"), 8524);
        System.out.println(full);

        //limited
        Ticket limited = new Ticket("Filadelfia", 455, Instant.now().getEpochSecond());
        System.out.println(limited);

        //calling method by id
        System.out.println(getTicketById("4893"));


        //hw 4

        // method to get values of ticket fields
        full.getTicketValues(tickets);



        Entity entity = new Ticket();
        entity.setId(1256);
        System.out.println(entity.getId()); //getting id from its parent abstract class

        RolePrint rolePrint1 = new Client();  // runtime polymorphism
        System.out.println(rolePrint1.printRole());
        RolePrint rolePrint2 = new Admin();   // runtime polymorphism
        System.out.println(rolePrint2.printRole());


        Printable printable1 = new Client();      // runtime polymorphism
        printable1.print();
        Printable printable2 = new Admin();        // runtime polymorphism
        printable2.print();

        Shareable shareable = new Ticket();             // runtime polymorphism
        shareable.sharedByEmail("JohnDoe@gmail.com");
        shareable.sharedByPhone("+112458962487");







    }
}
