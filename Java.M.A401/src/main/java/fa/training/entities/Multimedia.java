package fa.training.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Multimedia {

    protected String name;
    protected double duration;

    public void createMultimedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter duration: ");
        this.duration = Double.parseDouble(scanner.nextLine());
    }
}
