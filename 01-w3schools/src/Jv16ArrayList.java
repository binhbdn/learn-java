/*
    Elements in an ArrayList are actually objects
    To use other types, must specify an equivalent wrapper class:
        int         Integer
        boolean     Boolean
        char        Character
        double      Double
*/

import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;  // Import the Collections class

class Jv16ArrayList {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        // Add Items
        cars.add("Volvo");cars.add("Mazda");cars.add("Ford");cars.add("BMW");
        
        System.out.println(cars);

        // Access an Item
        System.out.println(cars.get(0));

        // Change an Item
        cars.set(0, "Opel");
        System.out.println(cars);

        // Remove an Item
        cars.remove(0);
        System.out.println(cars);

        // Remove all Items
        // cars.clear();
        // System.out.println(cars);

        // ArrayList Size
        System.out.println(cars.size());

        // Loop Through an ArrayList with a for loop
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }

        // Loop Through an ArrayList with the for-each loop
        for (String i : cars) {
            System.out.println(i);
        }

        // Create an ArrayList to store numbers (add elements of type Integer):
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);
        for (int i : myNumbers) {
            System.out.println(i);
        }

        // Sort an ArrayList
        Collections.sort(cars);  // Sort cars
        for (String i : cars) {
            System.out.println(i);
        }

        Collections.sort(myNumbers);  // Sort myNumbers
        for (int i : myNumbers) {
            System.out.println(i);
        }
    }
}
