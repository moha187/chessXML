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
public class Figure {

    private FigureType type;
    private boolean dead;
    private Color color;
    private Position pos;

    public Figure(FigureType type, boolean dead, Color color, Position startPos) {
        this.type = type;
        this.dead = dead;
        this.color = color;
        this.pos = startPos;
    }

    public Figure(String figureType, Color color, Position position) {

        switch (figureType) {
            case "pawn":
                this.type = FigureType.PAWN;
                break;
            case "bishop":
                this.type = FigureType.BISHOP;
                break;
            case "knight":
                this.type = FigureType.KNIGHT;
                break;
            case "rook":
                this.type = FigureType.ROOK;
                break;
            case "queen":
                this.type = FigureType.QUEEN;
                break;
            case "king":
                this.type = FigureType.KING;
                break;
        }

        this.color = color;
        this.pos = position;
        this.dead = false;
    }

    public FigureType getType() {
        return type;
    }

    public boolean isDead() {
        return dead;
    }

    public void bringToLife(Position newPos) {
        this.dead = false;
        setPosition(newPos);
    }

    public void setDead() {
        this.dead = true;
        this.pos.setDead();
    }

    public Color getColor() {
        return color;
    }

    public Position getPos() {
        return pos;
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }

}
