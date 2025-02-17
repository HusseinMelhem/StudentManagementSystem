import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private static final String FILE_NAME = "students.txt";
    private static List<student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        loadStudentsFromFile(); // Load existing students
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📚 Student Management System 📚");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    saveStudentsToFile();
                    System.out.println("Exiting... 🚀");
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
            
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        studentList.add(new student(id, name, age, grade));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n Student List:");
            studentList.forEach(System.out::println);
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (student student : studentList) {
            if (student.getId() == id) {
                System.out.println(" Student Found: " + student);
                return;
            }
        }
        System.out.println(" Student not found!");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        studentList.removeIf(student -> student.getId() == id);
        System.out.println(" Student deleted successfully!");
    }

    private static void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList);
            System.out.println(" Students saved successfully.");
        } catch (IOException e) {
            System.out.println(" Error saving students.");
        }
    }

    private static void loadStudentsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentList = (List<student>) ois.readObject();
            System.out.println(" Students loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" No existing students found.");
        }
    }
}
