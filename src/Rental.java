import java.util.Date;

public class Rental {
    private Date date;
    private String name;

    public Date getDate() {
        return date;
    }

    private int numberOfPeople;

    private Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public Rental(Date date, String name, int numberOfPeople) throws IllegalArgumentException {
        if (date.before(getCurrentDate())) {
            throw new IllegalArgumentException("Rental date cannot be in the past");
        } else {
            this.date = date;
            this.name = name;
            this.numberOfPeople = numberOfPeople;
        }
    }
}
