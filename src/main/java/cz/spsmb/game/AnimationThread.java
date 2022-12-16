package cz.spsmb.game;

import javafx.scene.image.Image;
import objects.Trex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AnimationThread extends Thread{
    private Image image1;
    private Image image2;

    private Trex trex;

    public AnimationThread(Trex trex) {
        init();
        this.trex = trex;
        this.trex.setImage(image1);
    }

    private void init() {
        try {
            image1 = new Image(new FileInputStream("src/main/resources/trex/trex1.png"));
            image2 = new Image(new FileInputStream("src/main/resources/trex/trex2.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                trex.setImage(image2);
                Thread.sleep(200);
                trex.setImage(image1);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
