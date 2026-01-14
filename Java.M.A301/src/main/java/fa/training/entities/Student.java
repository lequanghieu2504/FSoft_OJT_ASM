package fa.training.entities;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends Person {

    private String studentId;
    private double theory;
    private double practice;

    public Student(String fullName, String gender, String phone, String email,
                   String studentId, double theory, double practice) {
        super(fullName, gender, phone, email);
        this.studentId = studentId;
        this.theory = theory;
        this.practice = practice;
    }

    public double calculateFinalMark() {
        return (theory + practice) / 2;
    }

    @Override
    public void display() {
        System.out.println("Student ID: " + studentId
                + ", Name: " + fullName
                + ", Final Mark: " + calculateFinalMark());
    }
}
