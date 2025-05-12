package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.BotPlayer;
import edu.miracosta.cs112.finalproject.finalproject.UserPlayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class BattleController {
    private UserPlayer userPlayer;
    private BotPlayer botPlayer;

    public void setUserPlayer(UserPlayer player) {
        this.userPlayer = player;
    }

    public void setBotPlayer(BotPlayer player) {
        this.botPlayer = player;
    }

    @FXML
    private Button fightButton, healButton, pokemonButton, runButton;

    @FXML
    ImageView userPokemonImage, botPokemonImage;

    @FXML
    private void handleFight() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/attack-scene.fxml"));
        Parent root = loader.load();

        AttackController controller = loader.getController();
        controller.initAttackScene(userPlayer, botPlayer);

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

        PokemonController controller = loader.getController();
        controller.initPokemonScene(userPlayer, botPlayer);

        Stage window = (Stage) pokemonButton.getScene().getWindow();
        window.setScene(new Scene(root));

        System.out.println("Pokemon button clicked!");
    }

    @FXML
    private void handleRun() {
        System.out.println("Run button clicked!");
        System.exit(0);
    }

    @FXML
    public void setUserPokemonImage() {
        userPokemonImage.setImage(new Image(getClass().getResourceAsStream(userPlayer.getCurrentPokemon().getImagePath())));
    }

    @FXML
    public void setBotPokemonImage() {
        botPokemonImage.setImage(new Image(getClass().getResourceAsStream(botPlayer.getCurrentPokemon().getImagePath())));
    }

    public void initBattleScene(UserPlayer userPlayer, BotPlayer botPlayer) {
        this.setUserPlayer(userPlayer);
        this.setBotPlayer(botPlayer);
        this.setUserPokemonImage();
        this.setBotPokemonImage();
    }
}
