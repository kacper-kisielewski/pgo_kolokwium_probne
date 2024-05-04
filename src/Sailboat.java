import java.util.ArrayList;
import java.util.Date;

public class Sailboat {
    private String name;
    private int capacity;
    private double dailyRate;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Sailboat(String name, int capacity, double dailyRate) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity has to be higher than zero");
        } else if (dailyRate < 0) {
            throw new IllegalArgumentException("Daily rate cannot be negative");
        } else {
            this.name = name;
            this.capacity = capacity;
            this.dailyRate = dailyRate;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable(Date date) {
        for (Rental rental : rentals) {
            if (rental.getDate().equals(date)) return false;
        }
        return true;
    }

    public void rent(Rental rental) {
        this.rentals.add(rental);
    }

    public double getRentalsTotal() {
        return this.rentals.size() * this.dailyRate;
    }
}
