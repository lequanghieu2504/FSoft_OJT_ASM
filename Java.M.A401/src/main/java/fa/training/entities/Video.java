package fa.training.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

public class Video extends Multimedia {

    public Video() {
        super();
    }

    public Video(String name, double duration) {
        super(name, duration);
    }

    public void createVideo() {
        super.createMultimedia();
    }

    @Override
    public String toString() {
        return "Video: " + name + "  " + duration;
    }
}
