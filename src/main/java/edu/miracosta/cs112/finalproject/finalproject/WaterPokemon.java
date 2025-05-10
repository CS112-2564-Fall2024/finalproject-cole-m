package edu.miracosta.cs112.finalproject.finalproject;

public class WaterPokemon extends Pokemon{

    public WaterPokemon(String name, String type, String imagePath, int maxHP, int hp, AttackMove[] moveSet) {
        super(name, type, imagePath, maxHP, hp, moveSet);
    }

    public WaterPokemon() {
        this.setType("Water");
    }

    @Override
    public void attack(Pokemon other) {
        //TODO: create conditions based on the opponents type
    }
}
