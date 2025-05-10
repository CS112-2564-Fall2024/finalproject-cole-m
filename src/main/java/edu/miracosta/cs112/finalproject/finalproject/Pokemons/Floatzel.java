package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.FirePokemon;
import edu.miracosta.cs112.finalproject.finalproject.WaterPokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Floatzel extends WaterPokemon {
    public Floatzel() {
        super("Floatzel", "Water", "/PokemonImages/Floatzel.png", 180, 180,
                new AttackMove[]{
                        new Cut(),
                        new Whirlpool(),
                        new AquaTail(),
                        new Dive()});
    }
}
