// Keys and values in a HashMap are actually objects
import java.util.HashMap; // import the HashMap class

class Jv18HashMap {
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<String, String>();
    
        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);

        // Access an Item
        System.out.println(capitalCities.get("England"));

        // Remove an Item
        capitalCities.remove("England");
        System.out.println(capitalCities);

        // Remove all items
        // capitalCities.clear();
        // System.out.println(capitalCities);

        // HashMap Size
        System.out.println(capitalCities.size());

        // Loop Through a HashMap
        // Print keys
        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }
        // Print values
        for (String i : capitalCities.values()) {
            System.out.println(i);
        }
        // Print keys and values
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }


        // Create a HashMap object called people
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        // Add keys and values (Name, Age)
        people.put("John", 32);
        people.put("Steve", 30);
        people.put("Angie", 33);

        for (String i : people.keySet()) {
        System.out.println("key: " + i + " value: " + people.get(i));
        }
    }
}
