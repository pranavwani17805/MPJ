import java.util.Scanner;

class Student {
    int rollNo;
    String studentName;
    int studentAge;

    Student(int rollNo, String studentName, int studentAge) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    void showDetails() {
        System.out.println("\nStudent Information");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + studentName);
        System.out.println("Age     : " + studentAge);
    }
}

public class StudentDemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int rollNo = input.nextInt();

        input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Age: ");
        int age = input.nextInt();

        Student s = new Student(rollNo, name, age);
        s.showDetails();

        input.close();
    }
}
