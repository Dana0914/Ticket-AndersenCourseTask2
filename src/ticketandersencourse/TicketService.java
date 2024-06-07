package ticketandersencourse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TicketService {

    List<Ticket> tickets;

    public TicketService() {
        tickets = new ArrayList<>();
    }

    public void createTicket() {
        capacityChecker();
        Ticket ticket = new Ticket();
        tickets.add(ticket);
    }

    public void createTicket(String concertHall, int eventCode, long time) {
        capacityChecker();
        Ticket ticket = new Ticket(concertHall, eventCode, time);
        tickets.add(ticket);
    }

    public void createTicket(String id, String concertHall, int eventCode, long time, boolean isPromo,
                             StadiumSector stadiumSector, double backpackWeight, BigDecimal price) {
        capacityChecker();
        Ticket ticket = new Ticket(id, concertHall, eventCode, time, isPromo,
                stadiumSector, backpackWeight, price);
        tickets.add(ticket);
    }

    public String getStorageInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("There are ")
                .append(tickets.size())
                .append(" tickets in the storage:\n");

        for (Ticket ticket : tickets) {
            stringBuilder.append(ticket)
                    .append("\n");
        }

        return stringBuilder.toString();
    }

    public Ticket getById(String id) {
        for (Ticket ticket : tickets) {
            if (ticket.getID().equals(id)) return ticket;
        }
        System.out.println("There is no ticket with such ID in the storage");
        return null;
    }

    public Ticket getBySector(StadiumSector stadiumSector) {
        for (Ticket ticket : tickets) {
            if(ticket.getStadiumSector() == stadiumSector) return ticket;
        }
        System.out.println("There is no ticket with such stadium sector");
        return null;
    }

    private void capacityChecker() {
        if (tickets.size() >= 10) throw new RuntimeException("Ticket limit reached");
    }
}
