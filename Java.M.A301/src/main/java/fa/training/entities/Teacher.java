package fa.training.entities;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Person {

    private double basicSalary;
    private double subsidy;

    public Teacher(String fullName, String gender, String phone, String email,
                   double basicSalary, double subsidy) {
        super(fullName, gender, phone, email);
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    public double calculateSalary() {
        return basicSalary + subsidy;
    }

    @Override
    public void display() {
        System.out.println("Teacher: " + fullName
                + ", Salary: " + calculateSalary());
    }
}

