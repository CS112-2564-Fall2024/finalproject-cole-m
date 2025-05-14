package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.Pokemons.*;
import edu.miracosta.cs112.finalproject.finalproject.controllers.BattleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("battle-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Get controller and set the UserPlayer
        BattleController controller = fxmlLoader.getController();
        UserPlayer userPlayer = new UserPlayer(new Pokemon[]{
                new Chimchar(),
                new Blastoise(),
                new Treecko(),
                new Floatzel(),
                new Hooh(),
                new Kyogre()},
                6, 10);
        BotPlayer botPlayer = new BotPlayer(new Pokemon[]{
                new Kyogre(),
                new Blastoise(),
                new Treecko(),
                new Floatzel(),
                new Hooh(),
                new Chimchar()},
                6, 10);
        controller.setUserPlayer(userPlayer);
        controller.setBotPlayer(botPlayer);
        controller.setUserPokemonImage();
        controller.setBotPokemonImage();

        stage.setTitle("Pokemon Battle!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}