package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.Pokemons.*;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.Absorb;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.AquaTail;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.DizzyPunch;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.Inferno;

public class Main {
    public static void main(String[] args) {
        BotPlayer user = new BotPlayer(new Pokemon[]{
                new Chimchar(),
                new Blastoise(),
                new Treecko(),
                new Floatzel(),
                new Hooh(),
                new Kyogre()},
                6, 10, 10);

        BotPlayer p2 = new BotPlayer(new Pokemon[]{
                new Kyogre(),
                new Blastoise(),
                new Treecko(),
                new Floatzel(),
                new Hooh(),
                new Chimchar()},
                6, 10, 10);

        for(int i=0; i<5; i++) {
            System.out.println(user.getCurrentPokemon().getName());
            user.commandAttack(p2.getCurrentPokemon());
            p2.healPokemon();
            user.switchPokemon();
            System.out.println();
        }
    }
}