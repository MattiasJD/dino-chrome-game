package cz.spsmb.game;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import objects.Trex;
import views.SceneManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.EventListener;

public class DinoGame extends Scene {

    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 600;
    private final SceneManager sceneManager;
    private Trex trex;

    public DinoGame(SceneManager sceneManager) {
        super(sceneManager.getParentScene(), SCENE_WIDTH, SCENE_HEIGHT);
        this.sceneManager = sceneManager;
        this.trex = new Trex(sceneManager);
        gameStart();
    }
    public void gameStart (){

        trex.setY(300);
        Line ground = new Line(0,400,600,400);
        Rectangle rectangle = new Rectangle(50,50);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    rectangle.setX(rectangle.getX() + 1);
                    try {
                        Thread.sleep(6);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
                sceneManager.showOnlySceneCollection(rectangle, ground, trex);
    }
}
