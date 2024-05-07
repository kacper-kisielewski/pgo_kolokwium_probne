import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //1. We create harbor which contains sailboats
        Harbor h1 = new Harbor("Sailor's Cove", "22 Marina Drive, Gdansk, Poland");

        //2. Creating sailboats
        Sailboat s1 = new Sailboat("Seabreeze", 4, 150.00);
        Sailboat s2 = new Sailboat("Wind Whisperer", 6, 200.00);
        Sailboat s3 = new Sailboat("Oceanic", 8, 250.00);
        Sailboat s4 = new Sailboat("Nautical Dream", 10, 300.00);

        //3. Adding ships to harbor
        h1.addShip(s1);
        h1.addShip(s2);
        h1.addShip(s3);
        h1.addShip(s4);

        //4. Renting ships
        Sailboat boat1 = h1.rentSailboat(new Date(2020, 1, 1), "John Smith", 5);
        Sailboat boat2 = h1.rentSailboat(new Date(2020, 1, 1), "Andrew Malewski", 3);
        Sailboat boat3 = h1.rentSailboat(new Date(2020, 1, 1), "John Doe", 4);
        Sailboat boat4 = h1.rentSailboat(new Date(2020, 1, 1), "Anne Smith", 3);

        //This line will cause an exception - because there are no free boats at this date
        try {
            Sailboat boat5 = h1.rentSailboat(new Date(2020, 1, 1), "M", 4);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        //5. Get the total income based on all the rentals in the system
        double income = h1.calculateIncome();
        System.out.println("Total rental income is: " + income);
    }
}