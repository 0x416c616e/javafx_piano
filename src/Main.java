import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.Set;


public class Main extends Application {
    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Piano");

        stage.setWidth(400);
        stage.setHeight(190);
        stage.setResizable(false);
        VBox root = new VBox();
        HBox piano = new HBox();


        Button[] button = new Button[9];
        Button[] flatAndSharpKeys = new Button[9];
        //after 1, 2, 4, 5, 6, there's a flat or sharp key
        //though I won't really support them
        for (int i = 1; i < button.length; i++) {
            final Set<Integer> AFTER = Set.of(
                    1, 2, 4, 5, 6
            ); // flat and sharp keys for an octave
            String[] keyNames = {"", "C", "D", "E", "F", "G", "A", "B", "C"};
            button[i] = new Button(keyNames[i]);
            button[i].setPrefHeight(150);
            button[i].setPrefWidth(50);
            final int forLambda = i;
            final String forLambda2 = keyNames[i];
            button[i].setOnAction( e -> {
                System.out.println("Button " + forLambda + " was clicked (" + forLambda2 + ")");
            });
            piano.getChildren().add(button[i]);
            if (AFTER.contains(i)) {
                flatAndSharpKeys[i] = new Button();
                flatAndSharpKeys[i].setPrefHeight(80);
                flatAndSharpKeys[i].setPrefWidth(5);
                flatAndSharpKeys[i].setStyle("-fx-color: black; -fx-background-color: black;");
                piano.getChildren().add(flatAndSharpKeys[i]);
            }
        }
        root.getChildren().addAll(piano);

        //root.getChildren().add(button[1]);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> {
            boolean pianoKeyPressed = false;
            switch (e.getCode()) {
                case DIGIT1:
                    System.out.println("Key 1 pressed (low C)");
                    pianoKeyPressed = true;
                    break;
                case DIGIT2:
                    System.out.println("Key 2 pressed (D)");
                    pianoKeyPressed = true;
                    break;
                case DIGIT3:
                    System.out.println("Key 3 pressed (E)");
                    pianoKeyPressed = true;
                    break;
                case DIGIT4:
                    System.out.println("Key 4 pressed (F)");
                    pianoKeyPressed = true;
                    break;
                case DIGIT5:
                    System.out.println("Key 5 pressed (G)");
                    pianoKeyPressed = true;
                    break;
                case DIGIT6:
                    System.out.println("Key 6 pressed (A)");
                    pianoKeyPressed = true;
                    break;
                case DIGIT7:
                    System.out.println("Key 7 pressed (B)");
                    pianoKeyPressed = true;
                    break;
                case DIGIT8:
                    System.out.println("Key 8 pressed (high C)");
                    pianoKeyPressed = true;
                    break;
                default:
                    System.out.println("Not supposed to get here");
                    break;
            }

        });
        root.requestFocus();
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
