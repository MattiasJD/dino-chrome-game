package objects;

import cz.spsmb.game.AnimationThread;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import views.SceneManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Trex extends ImageView {
    private SceneManager sceneManager;
    AnimationThread thread = new AnimationThread();
    public Trex(SceneManager sceneManager) {
        thread.start();
        this.sceneManager = sceneManager;
        init();
    }

    private void init() {
        System.out.println(thread.getImage().getWidth());
        Image image = thread.getImage();
        super.setImage(image);


        sceneManager.showOnlySceneCollection(this);
    }


}
