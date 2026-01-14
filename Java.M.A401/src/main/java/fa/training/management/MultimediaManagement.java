package fa.training.management;

import fa.training.entities.Multimedia;

import java.util.ArrayList;
import java.util.List;

public class MultimediaManagement {

    private List<Multimedia> listOfMultimedia;

    public MultimediaManagement(List<Multimedia> listOfMultimedia) {
        this.listOfMultimedia = listOfMultimedia;
    }

    public void addMultiMedia(Multimedia multimedia) {
        listOfMultimedia.add(multimedia);
    }

    public void displayMultiMedia() {
        System.out.println("-----LIST OF MULTIMEDIA-----");
        for (Multimedia m : listOfMultimedia) {
            System.out.println(m);
        }
    }
}
