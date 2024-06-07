package ticketandersencourse;

import java.math.BigDecimal;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        service.createTicket();
        service.createTicket("Filadelfia", 455, Instant.now().getEpochSecond());
        service.createTicket("8965", "Elphi",
                120, Instant.now().getEpochSecond(), true,
                StadiumSector.B, 12.0, new BigDecimal("45"));

        Ticket ticket = new Ticket();
        ticket.setID("1234");
        ticket.setStadiumSector(StadiumSector.C);

        service.createTicket(ticket);

        System.out.println(service.getById("8965"));
        System.out.println(service.getBySector(StadiumSector.C));
        System.out.println(service.getStorageInfo());
    }
}
