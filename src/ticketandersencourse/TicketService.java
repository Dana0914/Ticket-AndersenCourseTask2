package ticketandersencourse;

import java.math.BigDecimal;
import java.time.*;

public class TicketService {
    public static void main(String[] args) {
        Ticket empty = new Ticket();
        System.out.println(empty);
        Ticket full = new Ticket("8965", "Elphi",
                120, Instant.now().getEpochSecond(), true,
                StadiumSector.B, 12.0, new BigDecimal("45"));
        System.out.println(full);
        Ticket limited = new Ticket("Filadelfia", 455, Instant.now().getEpochSecond());
        System.out.println(limited);


    }
}
