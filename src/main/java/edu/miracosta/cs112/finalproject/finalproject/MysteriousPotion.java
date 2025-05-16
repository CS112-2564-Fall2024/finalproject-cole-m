package edu.miracosta.cs112.finalproject.finalproject;

public class MysteriousPotion extends Potion{
    public MysteriousPotion(int potionsLeft, int potionsMax) {
        super(potionsLeft, potionsMax);
    }

    public void heal(Pokemon pokemon){
        double randomValue = 0.5 + (Math.random() * 0.5);
        int potionsLeft = this.getPotionsLeft();
        int addHP = (int) randomValue * 100;
        if (potionsLeft > 0) {
            int currentHp = pokemon.getHp();
            int maxHp = pokemon.getMaxHP();

            if (currentHp > 0) {
                System.out.println(pokemon.getName() + " HP was originally " + currentHp);

                if (currentHp + addHP > maxHp) {
                    pokemon.setHp(maxHp);
                    System.out.println("And was healed to max HP of " + maxHp);
                } else {
                    pokemon.setHp(currentHp + addHP);
                    System.out.println(pokemon.getName() + " was healed to a HP of " + pokemon.getHp());
                }

                this.setPotionsLeft(potionsLeft - 1);
            } else {
                System.out.println(pokemon.getName() + " is knocked out");
            }
        } else {
            System.out.println("You are out of potion!");
        }
    }
}
