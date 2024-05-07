import java.util.Date;

public class Rental {
    private final Date date;
    private final String name;
    private final int numberOfPeople;
    private final Sailboat sailboat;

    public Rental(Date date, String name, int numberOfPeople, Sailboat sailboat) throws IllegalArgumentException {
        if (date.before(getCurrentDate())) {
            throw new IllegalArgumentException("Rental date cannot be in the past");
        } else {
            this.date = date;
            this.name = name;
            this.numberOfPeople = numberOfPeople;
            this.sailboat = sailboat;
        }
    }

    private Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public Date getDate() {
        return date;
    }

    public Sailboat getSailboat() {
        return sailboat;
    }
}
