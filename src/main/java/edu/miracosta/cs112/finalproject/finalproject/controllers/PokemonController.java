package edu.miracosta.cs112.finalproject.finalproject.controllers;
import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.BotPlayer;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.UserPlayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class PokemonController {
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
    private Button pokemon1Button, pokemon2Button, pokemon3Button, pokemon4Button, pokemon5Button, pokemon6Button;

    @FXML
    private ImageView pokemonImage1, pokemonImage2, pokemonImage3, pokemonImage4, pokemonImage5, pokemonImage6;

    @FXML
    private void handlePokemon1() {
        System.out.println("Clicked Pokemon1!");
        Pokemon pokemon = userPlayer.getPokemons()[0];
        userPlayer.setCurrentPokemon(pokemon);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handlePokemon2() {
        System.out.println("Clicked Pokemon2!");
        Pokemon pokemon = userPlayer.getPokemons()[1];
        userPlayer.setCurrentPokemon(pokemon);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handlePokemon3() {
        System.out.println("Clicked Pokemon3!");
        Pokemon pokemon = userPlayer.getPokemons()[2];
        userPlayer.setCurrentPokemon(pokemon);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handlePokemon4() {
        System.out.println("Clicked Pokemon4!");
        Pokemon pokemon = userPlayer.getPokemons()[3];
        userPlayer.setCurrentPokemon(pokemon);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handlePokemon5() {
        System.out.println("Clicked Pokemon5!");
        Pokemon pokemon = userPlayer.getPokemons()[4];
        userPlayer.setCurrentPokemon(pokemon);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handlePokemon6() {
        System.out.println("Clicked Pokemon6!");
        Pokemon pokemon = userPlayer.getPokemons()[5];
        userPlayer.setCurrentPokemon(pokemon);
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

    public void loadBattleScene () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/battle-scene.fxml"));
        Parent newRoot = loader.load();

        BattleController battleController = loader.getController();
        battleController.initBattleScene(userPlayer, botPlayer);

        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(newRoot));
    }

    public void updatePokemonButtons() {
        System.out.println("In update!");
        if (userPlayer != null && userPlayer.getPokemons() != null) {
            Pokemon[] pokemons = userPlayer.getPokemons(); // Assume this returns 4 strings

            pokemon1Button.setText(pokemons[0].getName());
            pokemonImage1.setImage(new Image(getClass().getResourceAsStream(pokemons[0].getImagePath())));
            pokemon2Button.setText(pokemons[1].getName());
            pokemonImage2.setImage(new Image(getClass().getResourceAsStream(pokemons[1].getImagePath())));
            pokemon3Button.setText(pokemons[2].getName());
            pokemonImage3.setImage(new Image(getClass().getResourceAsStream(pokemons[2].getImagePath())));
            pokemon4Button.setText(pokemons[3].getName());
            pokemonImage4.setImage(new Image(getClass().getResourceAsStream(pokemons[3].getImagePath())));
            pokemon5Button.setText(pokemons[4].getName());
            pokemonImage5.setImage(new Image(getClass().getResourceAsStream(pokemons[4].getImagePath())));
            pokemon6Button.setText(pokemons[5].getName());
            pokemonImage6.setImage(new Image(getClass().getResourceAsStream(pokemons[5].getImagePath())));
        }
    }

    public void initPokemonScene(UserPlayer userPlayer, BotPlayer botPlayer) {
        this.setUserPlayer(userPlayer);
        this.setBotPlayer(botPlayer);
        this.updatePokemonButtons();
    }
}
