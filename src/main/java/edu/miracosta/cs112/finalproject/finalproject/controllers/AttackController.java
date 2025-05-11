package edu.miracosta.cs112.finalproject.finalproject.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class AttackController {

    @FXML
    private Pane root;

    @FXML
    Button attack1Button, attack2Button, attack3Button, attack4Button;

    @FXML
    private void handleAttack1 () {
        System.out.println("Clicked Attack1!");
    }

    @FXML
    private void handleAttack2 () {
        System.out.println("Clicked Attack2!");
    }

    @FXML
    private void handleAttack3 () {
        System.out.println("Clicked Attack3!");
    }

    @FXML
    private void handleAttack4 () {
        System.out.println("Clicked Attack4!");
    }

    @FXML
    public void initialize() {
        // Wait until scene is available to set key listener
        root.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.ESCAPE) {
                        System.out.println("Escape key was pressed!");
                        try {
                            loadBattleScene();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        });
    }

    public void loadBattleScene () throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/battle-scene.fxml"));
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(newRoot));
    }

}
