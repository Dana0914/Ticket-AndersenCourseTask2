package ticketandersencourse.validation;

public class Validator {

    public String getValidatedId(String ID) {
        String regex = "[a-z0-9]{4}";
        if (!ID.toLowerCase().matches(regex)) {
            throw new IllegalArgumentException("No more than 4 digits or chars");
        }
        return ID;
    }
    public int getValidatedId(int id) {
        if (id < 1000 || id > 9999) {
            throw new IllegalArgumentException("No more than 4 digits");
        }
        return id;
    }
    public String getValidatedConcertHall(String concertHall) {
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("No more than 10 characters");
        }
        return concertHall;
    }

    public int getValidatedEventCode(int eventCode) {
        if (eventCode < 100 || eventCode > 999) {
            throw new IllegalArgumentException("No more than 3 digits");
        }
        return eventCode;
    }

}
