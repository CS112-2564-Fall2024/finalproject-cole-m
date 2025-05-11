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

public class PokemonController {

    @FXML
    private Pane root;

    @FXML
    Button pokemon1Button, pokemon2Button, pokemon3Button, pokemon4Button, pokemon5Button, pokemon6Button;

    @FXML
    private void handlePokemon1() {
        System.out.println("Clicked Pokemon1!");
    }

    @FXML
    private void handlePokemon2() {
        System.out.println("Clicked Pokemon2!");
    }

    @FXML
    private void handlePokemon3() {
        System.out.println("Clicked Pokemon3!");
    }

    @FXML
    private void handlePokemon4() {
        System.out.println("Clicked Pokemon4!");
    }

    @FXML
    private void handlePokemon5() {
        System.out.println("Clicked Pokemon5!");
    }

    @FXML
    private void handlePokemon6() {
        System.out.println("Clicked Pokemon6!");
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
