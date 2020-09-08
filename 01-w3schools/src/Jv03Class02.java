class Jv03Class02 {
    public static void main(String[] args) {
        Jv03Class01 myObj1 = new Jv03Class01(); // Object 1
        Jv03Class01 myObj2 = new Jv03Class01(); // Object 2
        // cannot assign a value to a final variable :
        // myObj1.x = 7;
        System.out.println(myObj1.x);

        System.out.println(myObj2.y);
        myObj2.y = 9;
        System.out.println(myObj2.y);

        // Static methods can be called without creating objects
        Jv03Class01.myStaticMethod(); // Call the static method
        myObj2.myStaticMethod(); // Call the static method on the object !!!

        // Public methods must be called by creating objects
        // Jv03Class01.myPublicMethod(); // Call the public method -> This would compile an error
        myObj1.myPublicMethod(); // Call the public method on the object
    }
}
