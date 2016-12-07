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
public final class Board {

    Figure[] figures;

    public Board() {
        this.figures = initFigures();
    }

    public Figure[] initFigures() {
        figures = new Figure[32];
        figures[0] = new Figure(FigureType.KING, false, Color.WHITE, new Position(5, 1));
        figures[1] = new Figure(FigureType.QUEEN, false, Color.WHITE, new Position(4, 1));
        figures[2] = new Figure(FigureType.BISHOP, false, Color.WHITE, new Position(6, 1));
        figures[3] = new Figure(FigureType.BISHOP, false, Color.WHITE, new Position(3, 1));
        figures[4] = new Figure(FigureType.KNIGHT, false, Color.WHITE, new Position(2, 1));
        figures[5] = new Figure(FigureType.KNIGHT, false, Color.WHITE, new Position(7, 1));
        figures[6] = new Figure(FigureType.ROOK, false, Color.WHITE, new Position(1, 1));
        figures[7] = new Figure(FigureType.ROOK, false, Color.WHITE, new Position(8, 1));
        figures[8] = new Figure(FigureType.PAWN, false, Color.WHITE, new Position(1, 2));
        figures[9] = new Figure(FigureType.PAWN, false, Color.WHITE, new Position(2, 2));
        figures[10] = new Figure(FigureType.PAWN, false, Color.WHITE, new Position(3, 2));
        figures[11] = new Figure(FigureType.PAWN, false, Color.WHITE, new Position(4, 2));
        figures[12] = new Figure(FigureType.PAWN, false, Color.WHITE, new Position(5, 2));
        figures[13] = new Figure(FigureType.PAWN, false, Color.WHITE, new Position(6, 2));
        figures[14] = new Figure(FigureType.PAWN, false, Color.WHITE, new Position(7, 2));
        figures[15] = new Figure(FigureType.PAWN, false, Color.WHITE, new Position(8, 2));
        figures[16] = new Figure(FigureType.KING, false, Color.BLACK, new Position(5, 8));
        figures[17] = new Figure(FigureType.QUEEN, false, Color.BLACK, new Position(4, 8));
        figures[18] = new Figure(FigureType.BISHOP, false, Color.BLACK, new Position(6, 8));
        figures[19] = new Figure(FigureType.BISHOP, false, Color.BLACK, new Position(3, 8));
        figures[20] = new Figure(FigureType.KNIGHT, false, Color.BLACK, new Position(2, 8));
        figures[21] = new Figure(FigureType.KNIGHT, false, Color.BLACK, new Position(7, 8));
        figures[22] = new Figure(FigureType.ROOK, false, Color.BLACK, new Position(1, 8));
        figures[23] = new Figure(FigureType.ROOK, false, Color.BLACK, new Position(8, 8));
        figures[24] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(1, 8));
        figures[25] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(2, 8));
        figures[26] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(3, 8));
        figures[27] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(4, 8));
        figures[28] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(5, 8));
        figures[29] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(6, 8));
        figures[30] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(7, 8));
        figures[31] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(8, 8));

        return figures;
    }

    public Figure getFigure(Position pos) {
        for (Figure figure : figures) {
            if (pos.equals(figure.getPos())) {
                return figure;
            }
        }
        return null;
    }

    public void moveFigure(Player player, Figure figure, Position target) {
        if (player.getColor().equals(figure.getColor())) {
            
        }

    }
}
