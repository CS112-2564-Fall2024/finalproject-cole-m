package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.UserPlayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class BattleController {

    private UserPlayer userPlayer;

    public void setUserPlayer(UserPlayer player) {
        this.userPlayer = player;
    }

    @FXML
    private Button fightButton, healButton, pokemonButton, runButton;

    @FXML
    private void handleFight() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/attack-scene.fxml"));
        Parent root = loader.load();

        // Pass the user player to the attack controller
        AttackController controller = loader.getController();
        controller.setUserPlayer(userPlayer);
        controller.updateAttackButtons();

        // Switch to the attack scene
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/pokemon-scene.fxml"));
        Parent root = loader.load();

        // Pass the user player to the attack controller
        PokemonController controller = loader.getController();
        controller.setUserPlayer(userPlayer);
        controller.updatePokemonButtons();

        // Switch to the attack scene
        Stage window = (Stage) pokemonButton.getScene().getWindow();
        window.setScene(new Scene(root));

        System.out.println("Pokemon button clicked!");
    }

    @FXML
    private void handleRun() {
        System.out.println("Run button clicked!");
    }
}
