/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import chessxml.Board;
import chessxml.Figure;
import chessxml.Player;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author root
 */
public class GameSaver {

    private final String pathname;
    private final Player[] players;
    private final Board board;

    public GameSaver(String pathname, Board board, Player[] players) {
        this.pathname = pathname;
        this.board = board;
        this.players = players;
    }

    public void saveGame() {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("game");
            doc.appendChild(rootElement);

            // staff elements
            for (Player players : this.players) {
                Element player = doc.createElement("player");
                rootElement.appendChild(player);

                Element playerName = doc.createElement("name");
                playerName.appendChild(doc.createTextNode(players.getName()));
                player.appendChild(playerName);

                Element playerColor = doc.createElement("color");
                playerColor.appendChild(doc.createTextNode(players.getColor().toString()));
                player.appendChild(playerColor);

                Element playerTurn = doc.createElement("turn");
                if (board.getTurn() == players.getColor()) {
                    playerTurn.appendChild(doc.createTextNode("true"));
                } else {
                    playerTurn.appendChild(doc.createTextNode("false"));
                }
                player.appendChild(playerTurn);

                Element playerFigures = doc.createElement("figures");
                player.appendChild(playerFigures);

                int[] figureCounts = {1, 1, 1, 1};
                Figure[] figuresOfPlayer = board.getFiguresOfColor(players.getColor());
                for (Figure figure : figuresOfPlayer) {
                    switch (figure.getType()) {

                        case PAWN:
                            Element pawn = doc.createElement("pawn" );
                            figureCounts[0]++;
                            playerFigures.appendChild(pawn);

                            this.setPositionOfFigure(doc, figure, pawn);
                            break;

                        case ROOK:
                            Element rook = doc.createElement("rook" );
                            figureCounts[1]++;
                            playerFigures.appendChild(rook);

                            this.setPositionOfFigure(doc, figure, rook);
                            break;

                        case KNIGHT:
                            Element knight = doc.createElement("knight" );
                            figureCounts[2]++;
                            playerFigures.appendChild(knight);

                            this.setPositionOfFigure(doc, figure, knight);
                            break;

                        case BISHOP:
                            Element bishop = doc.createElement("bishop");
                            figureCounts[3]++;
                            playerFigures.appendChild(bishop);

                            this.setPositionOfFigure(doc, figure, bishop);
                            break;

                        case QUEEN:
                            Element queen = doc.createElement("queen");
                            playerFigures.appendChild(queen);

                            this.setPositionOfFigure(doc, figure, queen);
                            break;

                        case KING:
                            Element king = doc.createElement("king");
                            playerFigures.appendChild(king);

                            this.setPositionOfFigure(doc, figure, king);
                            break;
                    }

                }

            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(this.pathname));

            // Output to console for testing
            //StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }

        System.out.println("Saved the Game");
    }

    private void setPositionOfFigure(Document doc, Figure figure, Element elementToAppendTo) {

        Element xposition = doc.createElement("xposition");
        xposition.appendChild(doc.createTextNode(String.valueOf(figure.getPos().getHorizontal())));

        Element yposition = doc.createElement("yposition");
        yposition.appendChild(doc.createTextNode(String.valueOf(figure.getPos().getVertical())));

        elementToAppendTo.appendChild(xposition);
        elementToAppendTo.appendChild(yposition);
    }
}
