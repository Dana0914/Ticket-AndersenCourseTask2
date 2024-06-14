package ticketandersencourse.model;

import ticketandersencourse.enums.StadiumSector;
import ticketandersencourse.interfaces.Printable;
import ticketandersencourse.interfaces.Shareable;
import ticketandersencourse.validation.Validator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Ticket implements Shareable, Printable {
    private String ID;
    private String concertHall;
    private int eventCode;
    public long time;
    private boolean isPromo;
    public StadiumSector stadiumSector;
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

    public int getEventCode() {
        return eventCode;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public double getBackpackWeight() {
        return backpackWeight;
    }

    public void getTicketValues(List<Ticket> ticket) {
        for (Ticket t : ticket) {
            System.out.println(t.getID() + " " +
                    t.getConcertHall() + " " +
                    t.getEventCode() + " " +
                    t.getTime() + " " +
                    t.getStadiumSector() + " " +
                    t.isPromo() + " " +
                    t.getBackpackWeight() + " " +
                    t.getPrice());
        }
    }

    @Override
    public void sharedByPhone(String phone) {
        System.out.println(phone);
    }

    @Override
    public void sharedByEmail(String email) {
        System.out.println(email);
    }

    @Override
    public void print() {
        System.out.println(this);
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