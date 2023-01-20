package cz.spsmb.game;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Scene;
import objects.Trex;
import views.SceneManager;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class Menu extends Scene {
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 600;
    private final SceneManager sceneManager;
    private Button startButton;
    private ActionListener actionListener;

    public Menu(SceneManager sceneManager) {
        super(sceneManager.getParentScene(), SCENE_WIDTH, SCENE_HEIGHT);
        this.sceneManager = sceneManager;
        draw();
    }
    public void draw (){
        //startButton.setBounds(SCENE_WIDTH/2, SCENE_HEIGHT/2, 50, 50);
        //startButton.setLabel("Start game");
        //sceneManager.showOnlySceneCollection((List<Node>) startButton);
    }
}
