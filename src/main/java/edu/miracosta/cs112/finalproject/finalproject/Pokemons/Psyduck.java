package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.FirePokemon;
import edu.miracosta.cs112.finalproject.finalproject.WaterPokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.AquaTail;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.Cut;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.Dive;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.DizzyPunch;

public class Psyduck extends WaterPokemon {
    public Psyduck() {
        super("Psyduck", "Water", "/PokemonImages/Psyduck.png", 100, 100,
                new AttackMove[]{
                        new Cut(),
                        new DizzyPunch(),
                        new AquaTail(),
                        new Dive()});
    }
}
