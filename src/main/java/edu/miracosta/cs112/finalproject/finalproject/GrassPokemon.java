package edu.miracosta.cs112.finalproject.finalproject;

public class GrassPokemon extends Pokemon{

    public GrassPokemon(String name, String type, String imagePath, int maxHP, int hp, AttackMove[] moveSet) {
        super(name, type, imagePath, maxHP, hp, moveSet);
    }

    public GrassPokemon() {
        this.setType("Grass");
    }

    @Override
    public void attack(Pokemon other) {
        //TODO: create conditions based on the opponents type
    }
}
