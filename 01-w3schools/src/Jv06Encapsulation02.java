public class Jv06Encapsulation02 {
    public static void main(String[] args) {
        Jv06Encapsulation01 myObj = new Jv06Encapsulation01();
        // myObj.name = "John";  // error
        // System.out.println(myObj.name); // error
        myObj.setName("John"); // Set the value of the name variable to "John"
        System.out.println(myObj.getName());
    }
}
