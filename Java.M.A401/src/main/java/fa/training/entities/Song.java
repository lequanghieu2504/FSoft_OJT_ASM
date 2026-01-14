package fa.training.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@NoArgsConstructor
public class Song extends Multimedia {

    private String singer;

    public Song(String name, double duration, String singer) {
        super(name, duration);
        this.singer = singer;
    }

    public void createSong() {
        super.createMultimedia();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter singer: ");
        this.singer = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Song: " + name + "  " + duration + "  " + singer;
    }
}
