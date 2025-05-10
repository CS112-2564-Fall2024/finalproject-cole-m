package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Objects;

public class FirePokemon extends Pokemon{

    public FirePokemon(String name, String type, String imagePath, int maxHP, int hp, AttackMove[] moveSet) {
        super(name, type, imagePath, maxHP, hp, moveSet);
    }

    public FirePokemon() {
        this.setType("Fire");
    }

    @Override
    public void attack(AttackMove attackMove, Pokemon opponentPokemon) {
        int currentOppHP = opponentPokemon.getHp();
        int damage = attackMove.getDamageAmount(); // default damage

        if (Objects.equals(attackMove.getType(), "Fire")) {
            if (Objects.equals(opponentPokemon.getType(), "Water")) {
                damage *= 0.2;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");

                System.out.println("Fire is not so effective against Water\n");
            } else if (Objects.equals(opponentPokemon.getType(), "Grass")) {
                damage *= 1.5;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Fire is very effective against Grass\n");
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
