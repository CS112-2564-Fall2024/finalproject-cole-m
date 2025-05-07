package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.FirePokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Chimchar extends FirePokemon {
    public Chimchar() {
        super("Chimchar", "Fire", "/PokemonImages/Chimchar.png", 100,
                new AttackMove[]{
                        new Cut(),
                        new Ember(),
                        new FireBlast(),
                        new DizzyPunch()});
    }
}
