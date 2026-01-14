package fa.training.main;


import fa.training.entities.*;
import fa.training.utils.Validator;

import java.util.Scanner;

public class PersonManage {

    private static Person[] persons = new Person[10];
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Input data");
            System.out.println("2. Update student by ID");
            System.out.println("3. Display teachers salary > 1000");
            System.out.println("4. Report students pass course (final mark >=6)");
            System.out.println("0. Exit");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputData(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    displayHighSalaryTeacher();
                    break;
                case 4:
                    reportPassedStudents();
                    break;
            }
        } while (choice != 0);
    }

    private static void inputData(Scanner scanner) {
        if (count >= persons.length) {
            System.out.println("Array is full");
            return;
        }

        System.out.println("1. Student | 2. Teacher");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Full name: ");
        String name = scanner.nextLine();

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (!Validator.isValidEmail(email)) {
            System.out.println("Invalid email");
            return;
        }

        if (type == 1) {
            System.out.print("Student ID: ");
            String id = scanner.nextLine();

            System.out.print("Theory: ");
            double theory = Double.parseDouble(scanner.nextLine());

            System.out.print("Practice: ");
            double practice = Double.parseDouble(scanner.nextLine());

            if (!Validator.isValidMark(theory) || !Validator.isValidMark(practice)) {
                System.out.println("Invalid mark");
                return;
            }

            persons[count++] = new Student(name, gender, phone, email, id, theory, practice);

        } else if (type == 2) {
            System.out.print("Basic salary: ");
            double basic = Double.parseDouble(scanner.nextLine());

            System.out.print("Subsidy: ");
            double subsidy = Double.parseDouble(scanner.nextLine());

            persons[count++] = new Teacher(name, gender, phone, email, basic, subsidy);
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (persons[i] instanceof Student) {
                Student s = (Student) persons[i];
                if (s.getStudentId().equals(id)) {
                    System.out.print("New theory: ");
                    double theory = Double.parseDouble(scanner.nextLine());

                    System.out.print("New practice: ");
                    double practice = Double.parseDouble(scanner.nextLine());

                    if (Validator.isValidMark(theory) && Validator.isValidMark(practice)) {
                        s.setTheory(theory);
                        s.setPractice(practice);
                        System.out.println("Update success");
                    } else {
                        System.out.println("Invalid mark");
                    }
                    return;
                }
            }
        }
        System.out.println("Student not found");
    }

    private static void displayHighSalaryTeacher() {
        for (int i = 0; i < count; i++) {
            if (persons[i] instanceof Teacher) {
                Teacher t = (Teacher) persons[i];
                if (t.calculateSalary() > 1000) {
                    t.display();
                }
            }
        }
    }

    private static void reportPassedStudents() {
        for (int i = 0; i < count; i++) {
            if (persons[i] instanceof Student) {
                Student s = (Student) persons[i];
                if (s.calculateFinalMark() >= 6) {
                    s.display();
                }
            }
        }
    }
}
