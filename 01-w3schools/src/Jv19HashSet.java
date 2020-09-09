/*
Java HashSet :
    is a collection of items where every item is unique,
    and it is found in the java.util package
    Items in an HashSet are actually objects
*/
import java.util.HashSet; // Import the HashSet class

class Jv19HashSet {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<String>();
        // Add Items
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);

        // Check If an Item Exists
        System.out.println(cars.contains("Mazda"));

        // Remove an Item
        cars.remove("Volvo");
        System.out.println(cars);

        // To remove all items, use the clear() method:
        // cars.clear();
        // System.out.println(cars);

        // HashSet Size
        System.out.println(cars.size());

        // Loop Through a HashSet
        for (String i : cars) {
            System.out.println(i);
        }

        // Create a HashSet object called numbers
        HashSet<Integer> numbers = new HashSet<Integer>();

        // Add values to the set
        numbers.add(4);
        numbers.add(7);
        numbers.add(8);

        // Show which numbers between 1 and 10 are in the set
        for(int i = 1; i <= 10; i++) {
            if(numbers.contains(i)) {
                System.out.println(i + " was found in the set.");
            } else {
                System.out.println(i + " was not found in the set.");
            }
        }
    }
}
