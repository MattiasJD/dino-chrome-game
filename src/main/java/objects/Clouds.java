package objects;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import views.SceneManager;

public class Clouds extends ImageView {
    private SceneManager sceneManager;


    private void init() {
        Node node = new Node() {
            private Image image = new Image("src/main/resources/background/yoink.png");
        };
        sceneManager.showOnlySceneCollection(this);
    }

}
