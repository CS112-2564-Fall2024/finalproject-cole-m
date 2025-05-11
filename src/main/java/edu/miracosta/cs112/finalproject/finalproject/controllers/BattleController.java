package edu.miracosta.cs112.finalproject.finalproject.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BattleController {

    @FXML
    Button fightButton, healButton, pokemonButton, runButton;

    @FXML
    private void handleFight() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/attack-scene.fxml"));

        Stage window = (Stage) fightButton.getScene().getWindow();
        window.setScene(new Scene(root));
        System.out.println("Fight button clicked!");
    }

    @FXML
    private void handleHeal() {
        System.out.println("Heal button clicked!");
    }

    @FXML
    private void handlePokemon() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/pokemon-scene.fxml"));

        Stage window = (Stage) fightButton.getScene().getWindow();
        window.setScene(new Scene(root));
        System.out.println("Fight button clicked!");
        System.out.println("Pokemon button clicked!");
    }

    @FXML
    private void handleRun() {
        System.out.println("Run button clicked!");
    }
}
