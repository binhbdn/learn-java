/*
1. Access Modifiers
1.1 For classes
    1.1.1 public :          is accessible by any other class
    1.1.2 default :         is only accessible by classes in the same package,
                            is used when do not specify a modifier
1.2 For attributes, methods and constructors
    1.2.1 public :          is accessible by any other class
    1.2.2 private :         is only accessible within the declared class
    1.2.3 default :         is only accessible by classes in the same package,
                            is used when do not specify a modifier
    1.2.4 protected :       is accessible in the same package and subclasses

2. Non-Access Modifiers
2.1 For classes
    2.1.1 final :           cannot be inherited by other classes

    2.1.2 abstract :        cannot be used to create objects,
                            to access an abstract class, it must be inherited from another class


2.2 For attributes and methods
    2.2.1 final :           cannot be overridden/modified

    2.2.2 static :          belongs to the class, rather than an object

    2.2.3 abstract :        can only be used in an abstract class
                            and can only be used on methods
                            method does not have a body,
                            body is provided by the subclass (inherited from)

    2.2.4 transient :       are skipped when serializing the object containing them
                            được bỏ qua khi tuần tự hóa đối tượng chứa chúng

    2.2.5 synchronized :	Methods can only be accessed by one thread at a time

    2.2.6 volatile :        value of an attribute is not cached thread-locally,
                            and is always read from the "main memory"
*/

// abstract class
abstract class Jv04Constructor01 {
  public String fname = "John";
  public int age = 24;
  public abstract void study(); // abstract method
}

// Subclass (inherit from Jv04Constructor01)
class Student extends Jv04Constructor01 {
  public int graduationYear = 2018;
  public void study() { // the body of the abstract method is provided here
    System.out.println("Studying all day long");
  }
}