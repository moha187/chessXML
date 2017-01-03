package chessxml;

import chessxml.Board;
import chessxml.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Moha
 */
public class Player {

    private Color color;
    private String name;
    private Board board;

    public Player(Color color, String name) {
        this.color = color;
        this.name = name;

    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    /**
     * public Board getBoard() { return board; }
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
