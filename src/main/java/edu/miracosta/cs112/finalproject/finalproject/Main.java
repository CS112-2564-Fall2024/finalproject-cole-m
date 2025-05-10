package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.Pokemons.*;

public class Main {
    public static void main(String[] args) {
        Player user = new Player(new Pokemon[]{
                new Chimchar(),
                new Blastoise(),
                new Treecko(),
                new Floatzel(),
                new Hooh(),
                new Kyogre()},
                6, 10);

         Player opponent = new Player(new Pokemon[]{
                 new Venusar(),
                 new Treecko(),
                 new Serperior(),
                 new Oshawott(),
                 new Psyduck(),
                 new Magikarp()},
                 6, 10);

        user.getPokemons()[2].setHp(80);
        user.healPokemon(user.getPokemons()[2]);
    }
}