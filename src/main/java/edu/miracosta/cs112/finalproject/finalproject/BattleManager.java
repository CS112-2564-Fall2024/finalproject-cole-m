package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.controllers.AttackController;
import edu.miracosta.cs112.finalproject.finalproject.controllers.BattleController;
import edu.miracosta.cs112.finalproject.finalproject.controllers.PokemonController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class BattleManager {
    private static final BattleManager instance = new BattleManager();
    private Player userPlayer;
    private BotPlayer botPlayer;
    private Stage primaryStage;

    public BattleManager() {
    }

    public static BattleManager getInstance() {
        return instance;
    }

    public void init(Player userPlayer, BotPlayer botPlayer, Stage stage) {
        this.userPlayer = userPlayer;
        this.botPlayer = botPlayer;
        this.primaryStage = stage;
    }

    public Player getUserPlayer() {
        return this.userPlayer;
    }

    public BotPlayer getBotPlayer() {
        return this.botPlayer;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void playerAttack(int index) {
        Pokemon userPokemon = this.userPlayer.getCurrentPokemon();
        AttackMove move = userPokemon.getMoveSet()[index];
        Pokemon botPokemon = this.botPlayer.getCurrentPokemon();

        userPokemon.attack(move, botPokemon);
        try {
            this.updateBotHPBar();
        } catch (Exception e) {
            System.out.println();
        }
        if (!checkAlive(botPokemon)) {
            try {
                botPlayer.switchPokemon();
            } catch (OutOfPokemons oop) {
                System.out.println(oop.getMessage());
                System.exit(0);
            }
        } else {
            botTurn();
        }


    }

    public void botTurn() {
        Pokemon userPokemon = this.userPlayer.getCurrentPokemon();
        Pokemon botPokemon = this.botPlayer.getCurrentPokemon();

        float percentHealth = (float)botPokemon.getHp() / botPokemon.getMaxHP();
        if(percentHealth < 0.2) {
            botPlayer.healPokemon();
            try {
                this.updateBotHPBar();
            } catch (Exception e) {
                System.out.println();
            }
        } else {
            botPlayer.commandAttack(userPokemon);
            try {

            if(!checkAlive(userPokemon)) {
                if(this.userPlayer.getPokemonCount() > 1) {
                    this.userPlayer.setPokemonCount(this.userPlayer.getPokemonCount() - 1);
                    try {
                        showPokemonSwitchScene();
                    } catch (Exception e) {
                        System.out.println();
                    }
                } else {
                    throw new OutOfPokemons("Player has no more Pokemons!");
                }
            }
            } catch (OutOfPokemons oop) {
                System.out.println(oop.getMessage());
                System.exit(0);
            }

        }
    }

    public boolean checkAlive(Pokemon pokemon) {
        if(pokemon.getHp() > 0) {
            return true;
        } return false;
    }

    public void updateBotHPBar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/battle-scene.fxml"));
        Parent root = loader.load();

        BattleController controller = loader.getController();
        controller.updateBotHPBar();
    }

    private void showPokemonSwitchScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/pokemon-scene.fxml"));
        Parent root = loader.load();

        PokemonController controller = loader.getController();
        controller.initPokemonScene();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public String toString() {
        return "BattleManager: " +
                "userPlayer=" + userPlayer +
                ", botPlayer=" + botPlayer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BattleManager other = (BattleManager) obj;

        return
                (userPlayer != null && userPlayer.equals(other.userPlayer)) &&
                (botPlayer != null && botPlayer.equals(other.botPlayer));
    }
}
