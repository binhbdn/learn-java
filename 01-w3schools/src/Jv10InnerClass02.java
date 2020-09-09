// Private Inner Class
class OuterClass2 {
    int x = 10;

    // private class InnerClass {
    //     int y = 5;
    // }
}

public class Jv10InnerClass02 {
    public static void main(String[] args) {
        OuterClass2 myOuter = new OuterClass2();
        System.out.println(myOuter.x);

        // Error: The type OuterClass2.InnerClass is not visible
        // OuterClass2.InnerClass myInner = myOuter.new InnerClass();
        // System.out.println(myInner.y + myOuter.x);
      }
}
