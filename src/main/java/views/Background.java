package views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Background extends ImageView {
    private final SceneManager sceneManager;
    private int height = 600;
    private int width = 600;

    public Background(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        init();
    }
    private void init() {
        Image bck = null;
        try {
            bck = new Image(new FileInputStream("src/main/resources/trex/trex1.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        super.setImage(bck);
        sceneManager.showOnlySceneCollection(this);

    }
}
