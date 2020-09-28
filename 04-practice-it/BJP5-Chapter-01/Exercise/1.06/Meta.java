/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e6-Meta
BJP5 Exercise 1.6: Meta

Write a complete Java program called Meta whose output is the text that would be the source code of a Java program named Hello that prints "Hello, world!" as its output:
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
*/
public class Meta{
    public static void main(String[] args){
        System.out.println("public class Hello {");
        System.out.println("    public static void main(String[] args) {");
        System.out.println("        System.out.println(\"Hello, world!\");");
        System.out.println("    }");
        System.out.println("}");
    }
}