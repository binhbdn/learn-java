class OuterClass4 {
    int x = 10;

    class InnerClass {
        public int myInnerMethod() {
            return x;
        }
    }
}

public class Jv10InnerClass04 {
    public static void main(String[] args) {
        OuterClass4 myOuter = new OuterClass4();
        OuterClass4.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.myInnerMethod());
      }
}
