import java.util.ArrayList;
import java.util.Date;

public class Harbor {
    private static final int maxCapacity = 20;

    private final String name;
    private final ArrayList<Sailboat> sailboats = new ArrayList<>();

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

    public Sailboat rentSailboat(Date date, String name, int numberOfPeople) throws IllegalArgumentException {
        for (Sailboat sailboat : sailboats) {
            if (sailboat.getCapacity() >= numberOfPeople && sailboat.isAvailable(date)) {
                sailboat.rent(new Rental(date, name, numberOfPeople));
                return sailboat;
            }
        }
        throw new IllegalArgumentException("No boats available at this time");
    }

    public double calculateIncome() {
        return this.sailboats.stream().mapToDouble(obj -> obj.getRentalsTotal()).sum();
    }
}
