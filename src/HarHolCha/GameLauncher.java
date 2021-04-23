package HarHolCha;

import elevengame.GameInterface;

public class GameLauncher {
    public static void main(String[] args) {
        GameInterface game = new GameCore();
        game.getCardDescriptionAt(5);
    }
}
