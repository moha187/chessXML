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

    public FigureType getType() {
        return type;
    }

    public boolean isDead() {
        return dead;
    }

    public Color getColor() {
        return color;
    }

    public Position getPos() {
        return pos;
    }

}
