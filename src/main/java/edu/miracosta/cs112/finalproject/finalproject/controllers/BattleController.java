package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.BattleManager;
import edu.miracosta.cs112.finalproject.finalproject.BotPlayer;
import edu.miracosta.cs112.finalproject.finalproject.UserPlayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class BattleController {
    private final BattleManager manager = BattleManager.getInstance();
    private UserPlayer userPlayer = manager.getUserPlayer();
    private BotPlayer botPlayer = manager.getBotPlayer();

    @FXML
    private Button fightButton, healButton, pokemonButton, runButton;

    @FXML
    ImageView userPokemonImage, botPokemonImage;

    @FXML
    TextField healCountText;

    @FXML
    private void handleFight() throws IOException {
        loadAttackScene();

        System.out.println("Fight button clicked!");
    }

    @FXML
    private void handleHeal() {
        userPlayer.setPotionsCount(userPlayer.getPotionsCount() - 1);
        this.setHealText();
        System.out.println("Heal button clicked!");
    }

    @FXML
    private void handlePokemon() throws IOException{
        loadPokemonScene();

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

    public void setHealText() {
        healCountText.setText(userPlayer.getPotionsCount() + " / " + userPlayer.getMaxPotionsCount());
    }

    public void loadAttackScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/attack-scene.fxml"));
        Parent root = loader.load();

        AttackController controller = loader.getController();
        controller.initAttackScene();

        Stage window = (Stage) fightButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void loadPokemonScene() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/pokemon-scene.fxml"));
        Parent root = loader.load();

        PokemonController controller = loader.getController();
        controller.initPokemonScene();

        Stage window = (Stage) pokemonButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void initBattleScene() {
        this.userPlayer = manager.getUserPlayer();
        this.botPlayer = manager.getBotPlayer();
        this.setUserPokemonImage();
        this.setBotPokemonImage();
        this.setHealText();
    }
}
