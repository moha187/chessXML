/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessxml;

import util.GameLoader;
import util.GameSaver;
import util.rss.RSSController;

/**
 *
 * @author Moha, Marvin
 */
public class ChessXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String saveGames = "src/saveGames/safegame01.xml";
        /**
         * Initializes RSSFeed
         */
        RSSController rssController = new RSSController("src/rss/feed.xml");
        rssController.setUpFeed();

        /**
         * DEMO RSS ITEMS
         */
        rssController.addFeedItem("WHITE", "PAWN", "2", "1", "3", "1");
        rssController.addFeedItem("BLACK", "PAWN", "7", "2", "8", "2");

        /**
         * DEMO OF GAME AND GAMESAVER + LOADER
         */
        Game newGame = new Game();
        newGame.startGame("Marvin", "Moha");
        

        /**
         * INIT OF FIGURES
         */
        System.out.println("============================PRINTING ALL POSITIONS============================");
        
        printAllPositios(newGame);
        
        /**
         * MOVING A FIGURE
         */
        System.out.println("============================MOVING FIGURE============================");

        newGame.selectFigure(new Position(1, 2));
        newGame.selectTarget(new Position(1, 3));
        printAllPositios(newGame);

        /**
         * SAVING A GAME - LOOK INTO saveGames/safegame01.xml
         */
        System.out.println("============================SAVING GAME============================");

        GameSaver gameSaver = new GameSaver(saveGames, newGame.getBoard(), newGame.getPlayers());
        gameSaver.saveGame();

        
        System.out.println("============================LOADING GAME============================");
        GameLoader loader = new GameLoader(saveGames);
        Game loadedGame = loader.loadGame();

        printAllPositios(loadedGame);

    }

    public static void printAllPositios(Game game) {
        for (Figure figure : game.getAllPositions()) {
            System.out.println("Figure: " + figure.getType().toString());
            System.out.println("        on: " + figure.getPos().getHorizontal() + "|" + figure.getPos().getVertical());
        }
    }

}
