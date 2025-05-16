package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.BattleManager;
import edu.miracosta.cs112.finalproject.finalproject.BotPlayer;
import edu.miracosta.cs112.finalproject.finalproject.Player;

public class BagController {
    private final BattleManager manager = BattleManager.getInstance();
    private Player userPlayer = manager.getUserPlayer();
    private BotPlayer botPlayer = manager.getBotPlayer();
}
