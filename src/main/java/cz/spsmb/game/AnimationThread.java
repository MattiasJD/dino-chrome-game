package cz.spsmb.game;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AnimationThread extends Thread{
    private volatile Image image;
    private static FileInputStream source;

    @Override
    public void run() {
        while (true) {
            try {
                image = new Image(new FileInputStream("src/main/resources/trex/trex1.png"));
                Thread.sleep(500);
                image = new Image(new FileInputStream("src/main/resources/trex/trex2.png"));
                Thread.sleep(500);
            } catch (FileNotFoundException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Image getImage() {
        return image;
    }
}
