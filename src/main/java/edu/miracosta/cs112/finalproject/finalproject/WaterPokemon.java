package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Objects;

public class WaterPokemon extends Pokemon{

    public WaterPokemon(String name, String type, String imagePath, int maxHP, int hp, AttackMove[] moveSet) {
        super(name, type, imagePath, maxHP, hp, moveSet);
    }

    public WaterPokemon() {
        this.setType("Water");
    }

    @Override
    public void attack(AttackMove attackMove, Pokemon opponentPokemon) {
        int currentOppHP = opponentPokemon.getHp();
        int damage = attackMove.getDamageAmount(); // default damage

        if (Objects.equals(attackMove.getType(), "Water")) {
            if (Objects.equals(opponentPokemon.getType(), "Grass")) {
                damage *= 0.2;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Water is not so effective against Grass\n");
            } else if (Objects.equals(opponentPokemon.getType(), "Fire")) {
                damage *= 1.5;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Water is very effective against Fire\n");
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
