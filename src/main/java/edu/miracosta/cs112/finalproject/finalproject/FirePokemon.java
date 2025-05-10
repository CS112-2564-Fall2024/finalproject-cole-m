package edu.miracosta.cs112.finalproject.finalproject;

public class FirePokemon extends Pokemon{

    public FirePokemon(String name, String type, String imagePath, int maxHP, int hp, AttackMove[] moveSet) {
        super(name, type, imagePath, maxHP, hp, moveSet);
    }

    public FirePokemon() {
        this.setType("Fire");
    }

    @Override
    public void attack(Pokemon other) {
        //TODO: create conditions based on the opponents type
    }
}
