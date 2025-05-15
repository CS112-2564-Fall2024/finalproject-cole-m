package edu.miracosta.cs112.finalproject.finalproject;
import java.util.Random;

public class BotPlayer extends Player {

    public BotPlayer(Pokemon[] pokemons, int pokemonCount, int maxPotionsCount, int potionsCount) {
        super(pokemons, pokemonCount, maxPotionsCount, potionsCount);
    }

    public void switchPokemon() {
        int pokemonLeft = this.getPokemonCount();

        this.setPokemonCount(pokemonLeft - 1);
        int nextPokemonIndex = this.getPokemons().length - pokemonLeft + 1;
        this.setCurrentPokemon(this.getPokemons()[nextPokemonIndex]);
    }

    public void commandAttack(Pokemon opponentPokemon) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(4); //random int form 0-3
        Pokemon currentPokemon = this.getCurrentPokemon();
        AttackMove move = currentPokemon.getMoveSet()[randomIndex];
        currentPokemon.attack(move, opponentPokemon);
    }
}
