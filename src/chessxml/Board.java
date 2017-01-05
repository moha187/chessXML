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

    private Figure[] figures;
    private Validation validation;
    private Color turn;

    public Board() {
        this.figures = initFigures();
        this.validation = new Validation();
        this.turn = Color.WHITE;
    }

    public Board(Figure[] figures, Color color) {
        this.figures = figures;
        this.validation = new Validation();
        this.turn = color;
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
        figures[24] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(1, 7));
        figures[25] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(2, 7));
        figures[26] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(3, 7));
        figures[27] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(4, 7));
        figures[28] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(5, 7));
        figures[29] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(6, 7));
        figures[30] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(7, 7));
        figures[31] = new Figure(FigureType.PAWN, false, Color.BLACK, new Position(8, 7));
        return figures;
    }

    public Figure getFigure(Position pos) {
        for (Figure figure : figures) {
            if (pos.equals(figure.getPos())
                    && !(figure.isDead())) {
                return figure;
            }
        }
        return null;
    }

    public Figure[] getFiguresOfColor(Color color) {
        Figure[] figuresOfColor = new Figure[16];
        int i = 0;
        for (Figure figure : this.getAllFigures()) {
            if (figure.getColor() == color && !figure.isDead()) {
                figuresOfColor[i] = figure;
                i++;
            }
        }
        return figuresOfColor;
    }

    public Position[] getPossibleTargets(Figure fig) {
        return validation.getPossiblePositions(fig, this);
    }

    private void setDead(Position pos) {
        this.getFigure(pos).setDead();
    }

    public void moveFigure(Player player, Figure figure, Position target) {
        if (player.getColor().equals(getTurn()) && player.getColor().equals(figure.getColor())
                && validation.validTarget(figure, this, target)) {
            if (this.getFigure(target) != null
                    && player.getColor() != this.getFigure(target).getColor()) {
                this.setDead(target);
                this.getFigure(figure.getPos()).setPosition(target);
                this.switchTurn();
            } else {
                this.getFigure(figure.getPos()).setPosition(target);
                this.switchTurn();
            }

        }
    }

    public Figure[] getAllFigures() {
        return this.figures;
    }

    private void switchTurn() {
        if (turn.equals(Color.BLACK)) {
            turn = Color.WHITE;
        } else {
            turn = Color.BLACK;
        }
    }

    public Color getTurn() {
        return turn;
    }

    public boolean kingsAreAlive() {
        int kingCounter = 0;
        for (Figure figure : figures) {
            if (figure.getType() == FigureType.KING) {
                kingCounter++;
            }
            if (kingCounter == 2) {
                return true;
            }
        }
        return false;
    }

}
