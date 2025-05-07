package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.FirePokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Charizard extends FirePokemon {
    public Charizard() {
        super("Charizard", "Fire", "/PokemonImages/Charizard.png", 250,
                new AttackMove[]{
                        new Inferno(),
                        new Ember(),
                        new FireBlast(),
                        new DizzyPunch()});
    }
}
