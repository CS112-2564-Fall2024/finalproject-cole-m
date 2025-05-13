package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Objects;

public class GrassPokemon extends Pokemon{

    public GrassPokemon(String name, String type, String imagePath, int maxHP, int hp, AttackMove[] moveSet) {
        super(name, type, imagePath, maxHP, hp, moveSet);
    }

    public GrassPokemon() {
        this.setType("Grass");
    }

    @Override
    public void attack(AttackMove attackMove, Pokemon opponentPokemon) {
        int currentOppHP = opponentPokemon.getHp();
        int damage = attackMove.getDamageAmount(); // default damage

        if (Objects.equals(attackMove.getType(), "Grass")) {
            if (Objects.equals(opponentPokemon.getType(), "Fire")) {
                damage *= 0.2;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Grass is not so effective against Fire\n");
            } else if (Objects.equals(opponentPokemon.getType(), "Water")) {
                damage *= 1.5;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Grass is very effective against Water\n");
            } else {
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".\n");
            }
        } else {
            opponentPokemon.setHp(currentOppHP - (int) damage);
            System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".\n");
        }
    }
}
