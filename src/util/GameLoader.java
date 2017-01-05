/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import chessxml.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author root
 */
public class GameLoader {

    private String filename;
    private Game game;

    private int playerNameIndex = 0;
    private int playerColorIndex = 1;
    private int playerTurnIndex = 2;
    private int playerFigureIndex = 3;

    public GameLoader(String filename) {
        this.filename = filename;
    }

    public Game loadGame() {
        System.out.println("Loading game...");
        this.game = new Game();
        Player[] players = new Player[2];
        Color turnOfPlayer = null;
        ArrayList<Figure> allFigures = new ArrayList<>();

        try {
            File xmlFile = new File(this.filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList playersNodes = doc.getElementsByTagName("player");
            for (int i = 0; i < playersNodes.getLength(); i++) {
                Node playerNode = playersNodes.item(i);
                NodeList playerNodes = playerNode.getChildNodes();

                Player player = new Player();

                player.setName(playerNodes.item(playerNameIndex).getTextContent());
                player.setColorWithString(playerNodes.item(playerColorIndex).getTextContent());

  

                if (playerNodes.item(playerTurnIndex).getTextContent() == "true") {
                    turnOfPlayer = player.getColor();
                }

                NodeList playerFigures = playerNodes.item(playerFigureIndex).getChildNodes();

                Figure[] figuresOfPlayer = new Figure[playerFigures.getLength()];

                for (int n = 0; n < playerFigures.getLength(); n++) {
 

                    String figureName = playerFigures.item(n).getNodeName();

                    NodeList figureCoordinates = playerFigures.item(n).getChildNodes();

                    int xposition = Integer.valueOf(figureCoordinates.item(0).getTextContent());
                    int yposition = Integer.valueOf(figureCoordinates.item(1).getTextContent());

                    Position pos = new Position(xposition, yposition);

                    Figure figure = new Figure(figureName, player.getColor(), pos);
                    figuresOfPlayer[n] = figure;
                }
                players[i] = player;

                for (Figure figure : figuresOfPlayer) {
                    allFigures.add(figure);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GameLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GameLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        game.setPlayers(players);

        Figure[] gameFigures = new Figure[allFigures.size()];

        for (int i = 0; i < gameFigures.length; i++) {
            gameFigures[i] = allFigures.get(i);
        }

        game.setBoard(new Board(gameFigures, turnOfPlayer));
        System.out.println("Game loaded");
        return game;
    }

}
