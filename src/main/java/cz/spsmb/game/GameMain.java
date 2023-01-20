package cz.spsmb.game;

import javafx.application.Application;
import javafx.stage.Stage;
import views.SimpleViewManager;

public class GameMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DinoGame dinoGame = new DinoGame(new SimpleViewManager());
        Menu menu = new Menu(new SimpleViewManager());
        //stage.setScene(menu);
        stage.setScene(dinoGame);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
