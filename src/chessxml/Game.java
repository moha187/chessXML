/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessxml;

/**
 *
 * @author Moha
 */
public class Game {

    private Player playerWhite;
    private Player playerBlack;
    private Board board;
    private Figure selectedFigure;

    public void startGame(String nameWhitePlayer, String nameBlackPlayer) {
        playerWhite = new Player(Color.WHITE, nameWhitePlayer);
        playerBlack = new Player(Color.BLACK, nameBlackPlayer);
        board = new Board();
        System.out.println("Start Game!!!!");
    }

    public Figure[] getAllPositions() {

        return board.getAllFigures();
    }

    public Color getTurn() {
        return board.getTurn();
    }

    public void selectFigure(Position pos) {
        if (pos != null) {
            this.selectedFigure = board.getFigure(pos);
        }
    }

    public void selectTarget(Position pos) {
        if (pos != null) {
            if (getTurn() == playerWhite.getColor()) {
                board.moveFigure(playerWhite, selectedFigure, pos);
            } else if (getTurn() == playerBlack.getColor()) {
                board.moveFigure(playerBlack, selectedFigure, pos);
            }
        }
    }

    public Position[] getPossibleTargets() {
        if (this.selectedFigure != null) {
            return board.getPossibleTargets(this.selectedFigure);
        } else {
            return new Position[0];
        }
    }

    public boolean gameIsRunning() {
        return board.kingsAreAlive();
    }

    public Player[] getPlayers() {
        Player[] players = new Player[2];
        players[0] = this.playerWhite;
        players[1] = this.playerBlack;
        return players;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(Player[] players) {
        for (Player player : players) {
            if (player.getColor() == Color.WHITE) {
                this.playerWhite = player;
            } else if (player.getColor() == Color.BLACK) {
                this.playerBlack = player;
            }
        }
    }
}
