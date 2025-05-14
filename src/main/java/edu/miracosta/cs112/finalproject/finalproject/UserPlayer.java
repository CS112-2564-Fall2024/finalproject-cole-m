package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.controllers.AttackController;

import java.util.Random;

public class UserPlayer extends Player{

    public UserPlayer(Pokemon[] pokemons, int pokemonCount, int potionsCount) {
        super(pokemons, pokemonCount, potionsCount);
    }

    public Pokemon switchPokemon() {
        int pokemonLeft = this.getPokemonCount();

        if (pokemonLeft > 1) {


        }

        System.out.println("You have no more Pokémons.");
        return null;
    }

    public void healPokemon() {
        int potionsLeft = this.getPotionsCount();
        if (potionsLeft > 0) {
            int currentHp = this.getCurrentPokemon().getHp();
            int maxHp = this.getCurrentPokemon().getMaxHP();

            if (currentHp > 0) {
                System.out.println(this.getCurrentPokemon().getName() + " HP was originally " + currentHp);

                if (currentHp + 50 > maxHp) {
                    this.getCurrentPokemon().setHp(maxHp);
                    System.out.println("And was healed to max HP of " + maxHp);
                } else {
                    this.getCurrentPokemon().setHp(currentHp + 50);
                    System.out.println(this.getCurrentPokemon().getName() + " was healed to a HP of " + this.getCurrentPokemon().getHp());
                }

                potionsLeft--;
            } else {
                System.out.println(this.getCurrentPokemon().getName() + " is knocked out");
            }
        } else {
            System.out.println("You are out of potion!");
        }
    }
}
