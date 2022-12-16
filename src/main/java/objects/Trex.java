package objects;

import cz.spsmb.game.AnimationThread;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import views.SceneManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Trex extends ImageView {
    private SceneManager sceneManager;
    private AnimationThread thread;
    public Trex(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.thread = new AnimationThread(this);
        init();
    }

    private void init() {
        thread.start();
        sceneManager.showOnlySceneCollection(this);
    }


}
