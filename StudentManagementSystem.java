import java.util.*;
class student{
    private int ID;
    private String name;
    private double marks;

    public student(int ID, String name, double marks){
        this.ID =ID;
        this.name = name;
        this.marks=marks;
    }

    //getter setter
    public int getID(){
        return ID;
    }
    public String getName(String name){
        return name;
    }
    public double getMarks(double marks){
        return marks;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setMarks(double marks){
        this.marks = marks;
    }
    void display(){
        System.out.println("ID:"+ID+"name"+name+"Marks:"+marks);
    }
}

public class StudentManagementSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<student> students = new ArrayList<>();

    public static void main(String args[]){
        int choice;

        do{
            System.out.println("=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Students");
            System.out.println("5. View All Student");
            System.out.println("6. Exit");
            System.out.println("Enter your Choice");
            choice = sc.nextInt();

            switch(choice){
                case 1: addStudent(); break;
                case 2: viewStudent(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: viewallStudent(); break;
                case 6: System.out.println("Exiting...Danyawad :)"); break;
                default: System.out.println("Invalid Choice! try again");
            }
        }while(choice !=6);
    }

    private static void addStudent(){
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        student s = new student(id, name, marks);
        students.add(s);
        System.out.println("Student added successfully!");
    }
    private static void viewStudent(){
        System.out.print("Enter Student ID to View: ");
        int ID = sc.nextInt();
        boolean found = false;

        for(student s : students){
            if(s.getID()==ID){
                s.display();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Student With ID:"+ID+"not found");
        }
    }
    private static void updateStudent(){
        System.out.print("Enter Student ID to Update: ");
        int ID = sc.nextInt();
        boolean found = false;

        for (student s : students) {
            if (s.getID() == ID) {
                sc.nextLine();  // consume newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated Successfully");
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Student With ID:"+ID+"not found");
        }
    }
    private static void deleteStudent(){
        System.out.print("Enter Student ID to Delete: ");
        int ID = sc.nextInt();
        boolean removed = students.removeIf(s -> s.getID() == ID);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with ID " + ID + " not found.");
        }
    }
    private static void viewallStudent(){
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- All Student Records ---");
            for (student s : students) {
                s.display();
            }
        }
    }
}
