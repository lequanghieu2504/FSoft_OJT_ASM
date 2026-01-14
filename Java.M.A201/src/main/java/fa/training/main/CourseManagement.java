package fa.training.main;

import java.util.Scanner;

import fa.training.entities.Course;
import fa.training.utils.Validator;

public class CourseManagement {

    public static void main(String[] args) {
        Course[] courses = new Course[10];

        inputCourses(courses);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Search courses by attribute");
            System.out.println("2. Display all mandatory courses");
            System.out.println("3. Display all courses");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    handleSearch(courses, sc);
                    break;
                case "2":
                    displayMandatory(courses);
                    break;
                case "3":
                    displayAll(courses);
                    break;
                case "0":
                    System.out.println("Bye.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void inputCourses(Course[] courses) {
        System.out.println("Input 10 courses:");
        for (int i = 0; i < courses.length; i++) {
            System.out.println("\n--- Course " + (i + 1) + " ---");
            Course c = new Course();
            c.input();
            courses[i] = c;
        }
    }

    private static void handleSearch(Course[] courses, Scanner sc) {
        System.out.println("\nSearch by attribute type:");
        System.out.println("- courseCode");
        System.out.println("- courseName");
        System.out.println("- duration");
        System.out.println("- status");
        System.out.println("- flag");
        System.out.print("Enter type: ");
        String type = sc.nextLine().trim();

        Object data = null;
        if ("duration".equalsIgnoreCase(type)) {
            while (true) {
                System.out.print("Enter duration (double): ");
                String raw = sc.nextLine().trim();
                try {
                    data = Double.parseDouble(raw);
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid double, try again.");
                }
            }
        } else {
            System.out.print("Enter value: ");
            data = sc.nextLine();
        }

        Course[] result = find(courses, type, data);
        if (result.length == 0) {
            System.out.println("No course found.");
            return;
        }

        System.out.println("Found " + result.length + " course(s):");
        for (Course c : result) {
            System.out.println(c);
        }
    }

    public static Course[] find(Course[] courses, String type, Object data) {
        if (courses == null || type == null) return new Course[0];

        int count = 0;
        for (Course c : courses) {
            if (c != null && matches(c, type, data)) {
                count++;
            }
        }

        Course[] result = new Course[count];
        int idx = 0;
        for (Course c : courses) {
            if (c != null && matches(c, type, data)) {
                result[idx++] = c;
            }
        }
        return result;
    }

    private static boolean matches(Course c, String type, Object data) {
        String t = type.trim();

        if ("courseCode".equalsIgnoreCase(t)) {
            String v = String.valueOf(data).trim();
            return c.getCourseCode() != null && c.getCourseCode().equalsIgnoreCase(v);
        }

        if ("courseName".equalsIgnoreCase(t)) {
            String v = String.valueOf(data).trim();
            return c.getCourseName() != null && c.getCourseName().equalsIgnoreCase(v);
        }

        if ("duration".equalsIgnoreCase(t)) {
            if (!(data instanceof Double)) return false;
            double v = (Double) data;
            return Double.compare(c.getDuration(), v) == 0;
        }

        if ("status".equalsIgnoreCase(t)) {
            String v = Validator.normalize(String.valueOf(data));
            return c.getStatus() != null && Validator.normalize(c.getStatus()).equals(v);
        }

        if ("flag".equalsIgnoreCase(t)) {
            String v = Validator.normalizeFlagForStorage(String.valueOf(data));
            return c.getFlag() != null && c.getFlag().equalsIgnoreCase(v);
        }

        return false;
    }

    private static void displayMandatory(Course[] courses) {
        System.out.println("\nMandatory courses:");
        boolean found = false;
        for (Course c : courses) {
            if (c == null) continue;
            if ("mandatory".equalsIgnoreCase(c.getFlag())) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No mandatory courses.");
        }
    }

    private static void displayAll(Course[] courses) {
        System.out.println("\nAll courses:");
        for (Course c : courses) {
            if (c != null) System.out.println(c);
        }
    }
}
