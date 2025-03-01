package Student_Management_System;
import java.io.*;
import java.util.*;

class Student {
    private String id;
    private String name;
    private int age;
    private String course;

    public Student(String id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getId() {
    	return id; 
    	}
    public String getName() {
    	return name; 
    	}
    public int getAge() { 
    	return age; 
    	}
    public String getCourse() {
    	return course; 
    	}

    public void setName(String name) { 
    	this.name = name; 
    	}
    public void setAge(int age) { 
    	this.age = age; 
    	}
    public void setCourse(String course) { 
    	this.course = course; 
    	}

    public String toString() {
        return id + "," + name + "," + age + "," + course;
    }

}

public class StudentManagementSystem {
    private static final String FILE_NAME = "students.txt";
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudents();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== This is Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    editStudent(scanner);
                    break;
                case 3:
                    searchStudent(scanner);
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    deleteStudent(scanner);
                    break;
                case 6:
                    saveStudents();
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    private static void editStudent(Scanner scanner) {
        System.out.print("Enter Student ID to Edit: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.print("Enter New Name (leave blank to keep current): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) s.setName(name);

                System.out.print("Enter New Age (or 0 to keep current): ");
                int age = scanner.nextInt();
                scanner.nextLine();
                if (age > 0) s.setAge(age);

                System.out.print("Enter New Course (leave blank to keep current): ");
                String course = scanner.nextLine();
                if (!course.isEmpty()) s.setCourse(course);

                System.out.println("Student details updated!");
                return;
            }
        }
        System.out.println("Student ID not found!");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter Student ID to Search: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student ID not found!");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("\n=== Student List ===");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to Delete: ");
        String id = scanner.nextLine();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student ID not found!");
    }

    private static void loadStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while ((reader.readLine()) != null) {
                
            }
        } catch (IOException e) {
            System.out.println("No existing student records found.");
        }
    }

    private static void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving student data!");
        }
    }
}
