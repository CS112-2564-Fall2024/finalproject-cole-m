package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.controllers.AttackController;
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

    public BattleManager() {
    }

    public static BattleManager getInstance() {
        return instance;
    }

    public void init(Player userPlayer, BotPlayer botPlayer) {
        this.userPlayer = userPlayer;
        this.botPlayer = botPlayer;
    }

    public Player getUserPlayer() {
        return this.userPlayer;
    }

    public BotPlayer getBotPlayer() {
        return this.botPlayer;
    }

    public void playerAttack(int index) {
        Pokemon userPokemon = this.userPlayer.getCurrentPokemon();
        AttackMove move = userPokemon.getMoveSet()[index];
        Pokemon botPokemon = this.botPlayer.getCurrentPokemon();

        userPokemon.attack(move, botPokemon);
        if (!checkAlive(botPokemon)) {
            try {
                botPlayer.switchPokemon();
                botTurn();
            } catch (Exception e) {
                System.out.println("Bot ran out of pokemons!");
                System.out.println("Game Over");
                //TODO Game Over
            }
        }

    }

    public void botTurn() {
        Pokemon userPokemon = this.userPlayer.getCurrentPokemon();
        Pokemon botPokemon = this.botPlayer.getCurrentPokemon();

        float percentHealth = botPokemon.getHp() / botPokemon.getMaxHP();
        if(percentHealth < 0.5) {
            botPlayer.healPokemon();
        } else {
            botPlayer.commandAttack(userPokemon);
            if(!checkAlive(userPokemon)) {
                try {
                    showPokemonSwitchScene();
                } catch (Exception e) {
                    System.out.println("Hi");
                }
            }

        }
    }

    public boolean checkAlive(Pokemon pokemon) {
        if(pokemon.getHp() > 0) {
            return true;
        } return false;
    }

    private void showPokemonSwitchScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/pokemon-scene.fxml"));
        Parent root = loader.load();

        PokemonController controller = loader.getController();
        controller.initPokemonScene();

        // You need access to the current stage
        Stage stage = (Stage) javafx.stage.Window.getWindows().filtered(Window::isShowing).get(0);
        stage.setScene(new Scene(root));
        stage.show();
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
