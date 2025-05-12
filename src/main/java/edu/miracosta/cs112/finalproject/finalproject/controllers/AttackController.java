package edu.miracosta.cs112.finalproject.finalproject.controllers;
import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.BotPlayer;
import edu.miracosta.cs112.finalproject.finalproject.UserPlayer;
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
    private UserPlayer userPlayer;
    private BotPlayer botPlayer;

    public void setUserPlayer(UserPlayer player) {
        this.userPlayer = player;
    }

    public void setBotPlayer(BotPlayer player) {
        this.botPlayer = player;
    }

    @FXML
    private Pane root;

    @FXML
    Button attack1Button, attack2Button, attack3Button, attack4Button;

    @FXML
    private void handleAttack1 () {
        System.out.println("Clicked Attack1!");
        AttackMove move = userPlayer.getCurrentPokemon().getMoveSet()[0];
        userPlayer.getCurrentPokemon().attack(move, botPlayer.getCurrentPokemon());
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleAttack2 () {
        System.out.println("Clicked Attack2!");
        AttackMove move = userPlayer.getCurrentPokemon().getMoveSet()[1];
        userPlayer.getCurrentPokemon().attack(move, botPlayer.getCurrentPokemon());
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleAttack3 () {
        System.out.println("Clicked Attack3!");
        AttackMove move = userPlayer.getCurrentPokemon().getMoveSet()[2];
        userPlayer.getCurrentPokemon().attack(move, botPlayer.getCurrentPokemon());
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleAttack4 () {
        System.out.println("Clicked Attack4!");
        AttackMove move = userPlayer.getCurrentPokemon().getMoveSet()[3];
        userPlayer.getCurrentPokemon().attack(move, botPlayer.getCurrentPokemon());
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void loadBattleScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/battle-scene.fxml"));
        Parent newRoot = loader.load();

        BattleController battleController = loader.getController();
        battleController.initBattleScene(userPlayer, botPlayer);

        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(newRoot));
    }

    public void updateAttackButtons() {
        System.out.println("In update!");
        if (userPlayer != null && userPlayer.getCurrentPokemon() != null) {
            AttackMove[] moves = userPlayer.getCurrentPokemon().getMoveSet(); // Assume this returns 4 strings
            attack1Button.setText(moves[0].getAttackName());
            attack2Button.setText(moves[1].getAttackName());
            attack3Button.setText(moves[2].getAttackName());
            attack4Button.setText(moves[3].getAttackName());
        }
    }
}
