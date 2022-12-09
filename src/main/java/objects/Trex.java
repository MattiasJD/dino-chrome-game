package objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import views.SceneManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Trex extends ImageView {
    private SceneManager sceneManager;
    public Trex(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        init();
    }

    private void init() {
        Image image = null;
        Image image1 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/trex/trex1.png"));
            image1 = new Image(new FileInputStream("src/main/resources/trex/trex2.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        super.setImage(image);

        sceneManager.showOnlySceneCollection(this);
    }

}
