package ticketandersencourse.model;

import annotation.NullableWarning;
import ticketandersencourse.interfaces.Printable;
import ticketandersencourse.interfaces.Shareable;
import ticketandersencourse.user.Entity;
import ticketandersencourse.validation.EmailValidator;
import ticketandersencourse.validation.PhoneNumberValidator;
import ticketandersencourse.validation.Validator;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
public class Ticket extends Entity implements Shareable, Printable {
    @NullableWarning()
    private String ID;
    private final String concertHall;
    private final int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double backpackWeight;
    private BigDecimal price;

    public Ticket() {
        this.ID = null;
        this.concertHall = null;
        this.eventCode = 0;
        this.time = Instant.now().getEpochSecond();
        this.isPromo = false;
        this.stadiumSector = 0;
        processNullableWarningAnnotation();


    }

    public Ticket(String concertHall, int eventCode, long time) {
        this.concertHall = new Validator().getValidatedConcertHall(concertHall);
        this.eventCode = new Validator().getValidatedEventCode(eventCode);
        this.time = time;
        processNullableWarningAnnotation();
    }

    public Ticket(String ID, String concertHall, int eventCode, long time, boolean
            isPromo, char stadiumSector, double backpackWeight, BigDecimal price, int id)  {
        super(id);
        this.ID = new Validator().getValidatedId(ID);
        this.concertHall = new Validator().getValidatedConcertHall(concertHall);
        this.eventCode = new Validator().getValidatedEventCode(eventCode);
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = new Validator().getValidatedSector(stadiumSector);
        this.backpackWeight = backpackWeight;
        this.price = price;
        processNullableWarningAnnotation();

    }

    public String getID() {
        return ID;
    }

    public char getStadiumSector() {
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

    public void setTime(long time) {
        this.time = time;
    }

    public void setStadiumSector(char stadiumSector) {
        this.stadiumSector = new Validator().getValidatedSector(stadiumSector);
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
        System.out.println(new PhoneNumberValidator().getValidPhoneNumber(phone));
    }

    @Override
    public void sharedByEmail(String email) {
        System.out.println(new EmailValidator().getValid(email));
    }

    @Override
    public void print() {
        System.out.println("Overrided implementation of print() method for Ticket class");
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
                && Objects.equals(price, ticket.price)
                && Objects.equals(super.getId(), ticket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, concertHall, eventCode, time, isPromo, stadiumSector, backpackWeight, price, super.getId());
    }

    @Override
    public String toString() {
        String promo = isPromo() ? "promo" : "not promo";
        return "Ticket{" +
                "ID='" + ID + '\'' +
                "id='" + super.getId() + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + promo +
                ", stadiumSector=" + stadiumSector +
                ", backpackWeight=" + backpackWeight +
                ", price=" + price +
                '}';
    }

    public void processNullableWarningAnnotation() {
        try {
            Class<Ticket> clazz = Ticket.class;
            Field field = clazz.getDeclaredField("ID");
            if (field.isAnnotationPresent(NullableWarning.class) && field.get(this) == null) {
                System.out.println("Variable " + field.getName() + " is null in " + this.getClass());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Could not access the field " + e.getMessage());
        }
    }
}