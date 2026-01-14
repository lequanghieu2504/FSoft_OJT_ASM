package fa.training.entities;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    protected String fullName;
    protected String gender;
    protected String phone;
    protected String email;


    public abstract void display();
}
