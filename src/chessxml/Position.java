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
public class Position {

    private int horizontal;
    private int vertical;

    public Position(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public void setDead() {
        this.horizontal = 0;
        this.vertical = 0;
    }

    public void setPosition(int horizontal, int vertical) {
        if (!(horizontal > 8 || vertical > 8
                || horizontal < 1 || vertical < 1)) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    @Override
    public String toString() {
        return "Position{" + horizontal + ", " + vertical + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        return this.horizontal == other.horizontal
                && this.vertical == other.vertical;
    }

}
