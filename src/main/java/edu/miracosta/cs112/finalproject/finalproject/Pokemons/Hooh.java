package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.FirePokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Hooh extends FirePokemon {
    public Hooh() {
        super("Ho-oh", "Fire", "/PokemonImages/Ho-oh.png", 350,
                new AttackMove[]{
                        new Inferno(),
                        new Ember(),
                        new FireBlast(),
                        new Overheat()});
    }
}
