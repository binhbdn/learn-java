// https://www.hackerrank.com/challenges/java-priority-queue

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

//Create the Student and Priorities classes here.
class Student {
  private int id;
  private String name;
  private double cgpa;

  public Student(int id, String name, double cgpa){
    super();
    this.id=id;
    this.name=name;
    this.cgpa=cgpa;
  };

  public int getID(){
    return id;
  };

  public String getName(){
    return name;
  };

  public double getCGPA(){
    return cgpa;
  };
}

class Priorities {
	public List<Student> getStudents(List<String> events){
    PriorityQueue<Student> studentsQueue = new PriorityQueue<Student>(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID));
		List<Student> students = new ArrayList<Student> ();
		for (String e: events) {
			Scanner in = new Scanner(e);
      String event = in.next();
      
			if (event.equals("ENTER")) {
				String name = in.next();
				double cgpa = in.nextDouble();
				int id = in.nextInt();

				Student student = new Student(id, name, cgpa);
				studentsQueue.add(student);
			}else if(event.equals("SERVED")) {
				studentsQueue.poll();
      }else{
        System.out.println("Wrong input!");
      };
      in .close();
    };
    
    while (! studentsQueue.isEmpty()){
      students.add(studentsQueue.poll());
    };
    
    return students;
	}
}

class Solution415 {
  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();
  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());    
    List<String> events = new ArrayList<>();
    
    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }
    
    List<Student> students = priorities.getStudents(events);
    
    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st: students) {
        System.out.println(st.getName());
      }
    }
  }
}