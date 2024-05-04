import java.util.Date;

public class Rental {
    private final Date date;
    private final String name;
    private final int numberOfPeople;

    public Rental(Date date, String name, int numberOfPeople) throws IllegalArgumentException {
        if (date.before(getCurrentDate())) {
            throw new IllegalArgumentException("Rental date cannot be in the past");
        } else {
            this.date = date;
            this.name = name;
            this.numberOfPeople = numberOfPeople;
        }
    }

    public Date getDate() {
        return date;
    }

    private Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
}
