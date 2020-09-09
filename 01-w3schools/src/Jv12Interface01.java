// Interface
// Interface methods are by default abstract and public
// Interface attributes are by default public, static and final
// An interface cannot contain a constructor (as it cannot be used to create objects)
interface Animal1 {
    public void animalSound(); // interface method (does not have a body)
    public void sleep(); // interface method (does not have a body)
}

// Pig2 "implements" the Animal1 interface
class Pig2 implements Animal1 {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
    public void sleep() {
        // The body of sleep() is provided here
        System.out.println("The sleeping Pig2 says: Zzz");
    }
}

class Jv12Interface01 {
    public static void main(String[] args) {
        Pig2 myPig2 = new Pig2();  // Create a Pig2 object
        myPig2.animalSound();
        myPig2.sleep();
    }
}
