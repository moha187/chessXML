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

    public Player(Color color, String name, Board board) {
        this.color = color;
        this.name = name;
        this.board = board;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

}
