package fa.training.main;

import fa.training.entities.Song;
import fa.training.entities.Video;
import fa.training.management.MultimediaManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MultimediaManagement management =
                new MultimediaManagement(new ArrayList<>());

        while (true) {
            System.out.println("Choose function:");
            System.out.println("1. Add a new Video");
            System.out.println("2. Add a new Song");
            System.out.println("3. Show all multimedia");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Video video = new Video();
                    System.out.println("-----Enter video information-----");
                    video.createVideo();
                    management.addMultiMedia(video);
                    break;

                case 2:
                    Song song = new Song();
                    System.out.println("-----Enter song information-----");
                    song.createSong();
                    management.addMultiMedia(song);
                    break;

                case 3:
                    management.displayMultiMedia();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
