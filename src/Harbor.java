import java.util.ArrayList;
import java.util.Date;

public class Harbor {
    private static final int maxCapacity = 20;

    private final String name;
    private final ArrayList<Sailboat> sailboats = new ArrayList<>();
    private final ArrayList<Rental> rentals = new ArrayList<>();
    private final String address;

    public Harbor(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addShip(Sailboat sailboat) throws IllegalStateException {
        if (this.sailboats.size() >= maxCapacity) {
            throw new IllegalStateException(String.format("Number of assigned sailboats cannot exceed %d", maxCapacity));
        } else {
            this.sailboats.add(sailboat);
        }
    }

    private boolean isBoatAvailable(Sailboat sailboat, Date date) {
        for (Rental rental : this.rentals) {
            if (rental.getSailboat().equals(sailboat) && rental.getDate().equals(date)) {
                return false;
            }
        }
        return true;
    }

    public Sailboat rentSailboat(Date date, String name, int numberOfPeople) throws IllegalArgumentException {
        for (Sailboat s : this.sailboats) {
            if (s.getCapacity() >= numberOfPeople) {
                if (isBoatAvailable(s, date)) {
                    this.rentals.add(new Rental(date, name, numberOfPeople, s));
                    return s;
                }
            }
        }
        throw new IllegalArgumentException("No sailboats available at the time");
    }

    public double calculateIncome() {
        return this.rentals.stream().mapToDouble(r -> r.getSailboat().getDailyRate()).sum();
    }
}
