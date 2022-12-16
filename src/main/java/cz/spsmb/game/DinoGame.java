package cz.spsmb.game;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import objects.Clouds;
import objects.Trex;
import views.SceneManager;


public class DinoGame extends Scene {

    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 600;
    private static final int GROUND_HEIGHT = 400;
    private static int SCORE = 0;
    private final SceneManager sceneManager;
    private Boolean isRunning = true;
    private Trex trex;
    private Text end = new Text();

    private Text score = new Text();

    public DinoGame(SceneManager sceneManager) {
        super(sceneManager.getParentScene(), SCENE_WIDTH, SCENE_HEIGHT);
        this.sceneManager = sceneManager;
        this.trex = new Trex(sceneManager);
        gameStart();
    }

    public void isHit(double dinoPos, double recPos) {
        System.out.println(dinoPos);
        System.out.println(recPos);
        if ((int) dinoPos == (int) recPos) {
            gameOver();
        } else {
            SCORE = SCORE+1;
        }
    }

    public void gameStart() {
        trex.setY(300);
        Line ground = new Line(0, 400, 600, GROUND_HEIGHT);
        Rectangle rec = new Rectangle(30, 30, Color.RED);
        rec.setY(GROUND_HEIGHT - rec.getHeight());
        rec.setX(500);
        score.setX(300);
        score.setY(250);
        score.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        initHandlers();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning == true) {
                    score.setText("Score "+ SCORE);
                    rec.setX(rec.getX() - 1);
                    if(trex.getX()+150 == rec.getX()){
                        isHit(trex.getY() + 100, rec.getY() + rec.getHeight());
                    }

                    if (trex.getY() < GROUND_HEIGHT - 100) {
                        trex.setY(trex.getY() + 0.8);
                    }

                    if(rec.getX()+rec.getWidth() == 0){
                        rec.setX(600);
                    }

                    try {
                        Thread.sleep(6);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        sceneManager.showOnlySceneCollection(trex,rec, ground, score, end);

    }

    private void initHandlers() {
        super.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getText().equals("w")){
                    trex.setY(trex.getY()-70);
                }
            }
        });
    }

    public void gameOver() {
        isRunning = false;
        end.setText("GAME OVER");
        end.setX(200);
        end.setY(200);
        end.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    }
}
