// Java Iterator
// An Iterator is an object that can be used to loop through collections,
// like ArrayList and HashSet.

// Import the ArrayList class and the Iterator class
import java.util.ArrayList;
import java.util.Iterator;

class Jv20Iterator {
    public static void main(String[] args) {
        // Make a collection
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
    
        // Get the iterator
        Iterator<String> it = cars.iterator();
    
        // Print the first item
        System.out.println(it.next());
        System.out.println("----------");
        // Print the next item
        // System.out.println(it.next());

        // Loop through a collection
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Removing Items from a Collection
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        System.out.println(numbers);

        Iterator<Integer> it1 = numbers.iterator();
        while(it1.hasNext()) {
            Integer i = it1.next();
            if(i < 10) {
                it1.remove();
            }
        }
        System.out.println(numbers);


    }
}
