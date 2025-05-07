package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.FirePokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.AquaTail;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.Dive;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.HydroCannon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.Whirlpool;

public class Kyogre extends FirePokemon {
    public Kyogre() {
        super("Kyogre", "Water", "/PokemonImages/Kyogre.png", 350,
                new AttackMove[]{
                        new HydroCannon(),
                        new Whirlpool(),
                        new AquaTail(),
                        new Dive()});
    }
}
