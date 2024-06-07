package ticketandersencourse;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Ticket {
    private String ID;
    private String concertHall;
    private int eventCode;
    private long time;
    private boolean isPromo;
    private StadiumSector stadiumSector;
    private double backpackWeight;
    private BigDecimal price;

    public Ticket() {
        this.ID = null;
        this.concertHall = null;
        this.eventCode = 0;
        this.time = Instant.now().getEpochSecond();
        this.isPromo = false;
        this.stadiumSector = null;
    }
    public Ticket(String concertHall, int eventCode, long time) {
        this.concertHall = new Validator().getValidatedConcertHall(concertHall);
        this.eventCode = new Validator().getValidatedEventCode(eventCode);
        this.time = time;
    }

    public Ticket(String ID, String concertHall, int eventCode, long time, boolean
            isPromo, StadiumSector stadiumSector, double backpackWeight, BigDecimal price) {
        this.ID = new Validator().getValidatedId(ID);
        this.concertHall = new Validator().getValidatedConcertHall(concertHall);
        this.eventCode = new Validator().getValidatedEventCode(eventCode);
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.backpackWeight = backpackWeight;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public long getTime() {
        return time;
    }

    public boolean isPromo() {
        return isPromo;
    }
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return eventCode == ticket.eventCode
                && time == ticket.time
                && isPromo == ticket.isPromo
                && Double.compare(backpackWeight, ticket.backpackWeight) == 0
                && Objects.equals(ID, ticket.ID)
                && Objects.equals(concertHall, ticket.concertHall)
                && stadiumSector == ticket.stadiumSector
                && Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, concertHall, eventCode, time, isPromo, stadiumSector, backpackWeight, price);
    }

    @Override
    public String toString() {
        String promo = isPromo() ? "promo" : "not promo";
        return "Ticket{" +
                "ID='" + ID + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + promo +
                ", stadiumSector=" + stadiumSector +
                ", backpackWeight=" + backpackWeight +
                ", price=" + price +
                '}';
    }
}