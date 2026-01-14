package fa.training.entities;

import java.util.Scanner;

import fa.training.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String courseCode;  // course id
    private String courseName;
    private double duration;
    private String status;      // active / in-active
    private String flag;        // optional / mandatory / N/A

    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter course code (FWxxx): ");
            String code = sc.nextLine().trim();
            if (Validator.isValidCourseCode(code)) {
                this.courseCode = code;
                break;
            }
            System.out.println("Invalid course code. Must be 5 chars, start with FW and follow by 3 digits (e.g., FW123).");
        }

        while (true) {
            System.out.print("Enter course name: ");
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                this.courseName = name;
                break;
            }
            System.out.println("Course name cannot be empty.");
        }

        while (true) {
            System.out.print("Enter duration (double >= 0): ");
            String raw = sc.nextLine().trim();
            try {
                double d = Double.parseDouble(raw);
                if (d >= 0.0) {
                    this.duration = d;
                    break;
                }
                System.out.println("Duration must be >= 0.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number format. Please input a double value.");
            }
        }

        while (true) {
            System.out.print("Enter status (active / in-active): ");
            String st = sc.nextLine().trim();
            if (Validator.isValidStatus(st)) {
                this.status = Validator.normalize(st);
                break;
            }
            System.out.println("Invalid status. Only accept 'active' or 'in-active'.");
        }

        while (true) {
            System.out.print("Enter flag (optional / mandatory / N/A): ");
            String fl = sc.nextLine().trim();
            if (Validator.isValidFlag(fl)) {
                this.flag = Validator.normalizeFlagForStorage(fl);
                break;
            }
            System.out.println("Invalid flag. Only accept 'optional', 'mandatory', 'N/A'.");
        }
    }
}
