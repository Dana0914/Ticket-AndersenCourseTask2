package ticketandersencourse;

import java.math.BigDecimal;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private static List<Ticket> ticketList;

    public TicketService() {
        ticketList = new ArrayList<>();
    }

    public static List<Ticket> getTicketList() {
        return ticketList;
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

    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("4893", "hall #1", 489, Instant.now().getEpochSecond(), true, StadiumSector.A, 3.5, new BigDecimal("120")));
        tickets.add(new Ticket("8624", "hall #2", 239, Instant.now().getEpochSecond(), true, StadiumSector.B, 4.0, new BigDecimal("150")));
        tickets.add(new Ticket("9247", "hall #3", 769, Instant.now().getEpochSecond(), true, StadiumSector.C, 5.0, new BigDecimal("145")));
        tickets.add(new Ticket("3581", "hall #4", 196, Instant.now().getEpochSecond(), true,  StadiumSector.B, 4.5, new BigDecimal("110")));
        tickets.add(new Ticket("6384", "hall #5", 374, Instant.now().getEpochSecond(), true, StadiumSector.A, 3.0, new BigDecimal("125")));
        tickets.add(new Ticket("4925", "hall #6", 815, Instant.now().getEpochSecond(), true, StadiumSector.A, 2.5, new BigDecimal("180")));
        tickets.add(new Ticket("3702", "hall #7", 684, Instant.now().getEpochSecond(), true, StadiumSector.B, 2.0, new BigDecimal("85")));
        tickets.add(new Ticket("4305", "hall #8", 106, Instant.now().getEpochSecond(), true, StadiumSector.C, 3.5, new BigDecimal("95")));
        tickets.add(new Ticket("7900", "hall #9", 674, Instant.now().getEpochSecond(), true, StadiumSector.B, 5.5, new BigDecimal("165")));
        tickets.add(new Ticket("1385", "hall #10", 285, Instant.now().getEpochSecond(), true, StadiumSector.A, 6.0, new BigDecimal("175")));
        setTicketList(tickets);

        Ticket empty = new Ticket();
        System.out.println(empty);
        Ticket full = new Ticket("8965", "Elphi",
                120, Instant.now().getEpochSecond(), true,
                StadiumSector.B, 12.0, new BigDecimal("45"));
        System.out.println(full);
        Ticket limited = new Ticket("Filadelfia", 455, Instant.now().getEpochSecond());
        System.out.println(limited);

        System.out.println(getTicketById("4893"));


    }
}
