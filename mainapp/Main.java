package mainapp;

import java.util.Scanner;
import models.Student;
import services.EnrollmentManager;

public class Main {
    public static void main(String[] args) {
        EnrollmentManager manager = new EnrollmentManager();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("1. Add Student");
                System.out.println("2. List Students");
                System.out.println("3. Search by Student ID");
                System.out.println("4. Sort Students by Name");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        Student student = new Student(id, name);
                        manager.addStudent(student);
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        Student[] all = manager.getStudents();
                        if (manager.getCount() == 0) {
                            System.out.println("No students available.");
                        }
                        for (int i = 0; i < manager.getCount(); i++) {
                            System.out.println(all[i]);
                        }
                        break;

                    case 3:
                        System.out.println("Enter Student ID: ");
                        String searchId = scanner.nextLine();
                        Student found = manager.searchStudentById(searchId);
                        if (found == null) {
                            System.out.println("Student not found.");
                        } else {
                            System.out.println("Found: " + found);
                        }
                        break;

                    case 4:
                        manager.sortStudentsByName();
                        System.out.println("Students sorted by name.");
                        break;

                    case 5:
                        System.out.println("Exiting.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }
    }
}