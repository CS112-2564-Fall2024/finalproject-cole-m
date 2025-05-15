package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.controllers.AttackController;

public class BattleManager {
    private static final BattleManager instance = new BattleManager();
    UserPlayer userPlayer;
    BotPlayer botPlayer;

    public BattleManager() {
    }

    public static BattleManager getInstance() {
        return instance;
    }

    public void init(UserPlayer userPlayer, BotPlayer botPlayer) {
        this.userPlayer = userPlayer;
        this.botPlayer = botPlayer;
    }

    public UserPlayer getUserPlayer() {
        return this.userPlayer;
    }

    public BotPlayer getBotPlayer() {
        return this.botPlayer;
    }

    public void playerAttack(AttackMove move) {
    }

    public void botTurn() {

    }

    public boolean checkAlive(Pokemon pokemon) {
        if(pokemon.getHp() > 0) {
            return true;
        } return false;
    }
    @Override
    public String toString() {
        return "BattleManager: " +
                "userPlayer=" + userPlayer +
                ", botPlayer=" + botPlayer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BattleManager other = (BattleManager) obj;

        return
                (userPlayer != null && userPlayer.equals(other.userPlayer)) &&
                (botPlayer != null && botPlayer.equals(other.botPlayer));
    }
}
