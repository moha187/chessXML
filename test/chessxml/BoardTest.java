/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessxml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Moha
 */
public class BoardTest {

    Board board;

    public BoardTest() {
        board = new Board();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        board = null;
    }

    @Test
    public void testInitBoard() {
        int pawnWhite = 0;
        int pawnBlack = 0;
        int kingWhite = 0;
        int kingBlack = 0;
        int queenWhite = 0;
        int queenBlack = 0;
        int rookWhite = 0;
        int rookBlack = 0;
        int bishopWhite = 0;
        int bishopBlack = 0;
        int knightWhite = 0;
        int knightBlack = 0;

        Figure[] figures = board.initFigures();
        for (Figure fig : figures) {
            if (fig.getType() == FigureType.PAWN) {
                if (fig.getColor() == Color.BLACK) {
                    pawnBlack++;
                } else {
                    pawnWhite++;
                }
            }

            if (fig.getType() == FigureType.QUEEN) {
                if (fig.getColor() == Color.BLACK) {
                    queenBlack++;
                } else {
                    queenWhite++;
                }
            }
            if (fig.getType() == FigureType.ROOK) {
                if (fig.getColor() == Color.BLACK) {
                    rookBlack++;
                } else {
                    rookWhite++;
                }
            }
            if (fig.getType() == FigureType.BISHOP) {
                if (fig.getColor() == Color.BLACK) {
                    bishopBlack++;
                } else {
                    bishopWhite++;
                }
            }
            if (fig.getType() == FigureType.KING) {
                if (fig.getColor() == Color.BLACK) {
                    kingBlack++;
                } else {
                    kingWhite++;
                }
            }
            if (fig.getType() == FigureType.KNIGHT) {
                if (fig.getColor() == Color.BLACK) {
                    knightBlack++;
                } else {
                    knightWhite++;
                }
            }
        }
        assertEquals(1, kingBlack);
        assertEquals(1, kingWhite);
        assertEquals(1, queenBlack);
        assertEquals(1, queenWhite);
        assertEquals(2, rookBlack);
        assertEquals(2, rookWhite);
        assertEquals(2, bishopBlack);
        assertEquals(2, bishopWhite);
        assertEquals(2, knightBlack);
        assertEquals(2, knightWhite);
        assertEquals(8, pawnBlack);
        assertEquals(8, pawnWhite);
        assertEquals(32, figures.length);
    }

    @Test
    public void testGetFigure() {
        Figure whiteBishop = board.getFigure(new Position(3, 1));
        assertEquals(Color.WHITE, whiteBishop.getColor());
        assertEquals(FigureType.BISHOP, whiteBishop.getType());

        Figure blackKnight = board.getFigure(new Position(7, 8));
        assertEquals(Color.BLACK, blackKnight.getColor());
        assertEquals(FigureType.KNIGHT, blackKnight.getType());

        assertEquals(null, board.getFigure(new Position(4, 4)));
    }

}
