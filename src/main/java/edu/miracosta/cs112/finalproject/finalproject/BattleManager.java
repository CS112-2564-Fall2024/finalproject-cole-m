package edu.miracosta.cs112.finalproject.finalproject;

public class BattleManager {
    UserPlayer userPlayer;
    BotPlayer botPlayer;
    boolean userTurn;

    public BattleManager(UserPlayer userPlayer, BotPlayer botPlayer, boolean userTurn) {
        this.setAll(userPlayer, botPlayer, userTurn);
    }

//    public BattleManager() {
//        this.setAll(userPlayer, botPlayer, userTurn);
//    }

    public BattleManager(BattleManager copy) {
        this.setAll(copy.userPlayer, copy.botPlayer, copy.userTurn);
    }

    public void setUserPlayer(UserPlayer userPlayer) {
        this.userPlayer = userPlayer;
    }

    public void setBotPlayer(BotPlayer botPlayer) {
        this.botPlayer = botPlayer;
    }

    public void setUserTurn(boolean userTurn) {
        this.userTurn = userTurn;
    }

    public void setAll(UserPlayer userPlayer, BotPlayer botPlayer, boolean userTurn) {
        this.setUserPlayer(userPlayer);
        this.setBotPlayer(botPlayer);
        this.setUserTurn(userTurn);
    }

    public UserPlayer getUserPlayer() {
        return this.userPlayer;
    }

    public BotPlayer getBotPlayer() {
        return this.botPlayer;
    }

    public boolean getUserTurn() {
        return this.userTurn;
    }

    @Override
    public String toString() {
        return "BattleManager: " +
                "userPlayer=" + userPlayer +
                ", botPlayer=" + botPlayer +
                ", userTurn=" + userTurn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BattleManager other = (BattleManager) obj;

        return userTurn == other.userTurn &&
                (userPlayer != null && userPlayer.equals(other.userPlayer)) &&
                (botPlayer != null && botPlayer.equals(other.botPlayer));
    }
}
