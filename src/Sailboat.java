public class Sailboat {
    private final String name;
    private final int capacity;
    private final double dailyRate;

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

    public double getDailyRate() {
        return dailyRate;
    }
}
