/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessxml;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Moha
 */
public class ValidationTest {

    Board board;
    Validation validation;

    public ValidationTest() {
        validation = new Validation();
        board = new Board();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        validation = null;
        board = null;
    }

    @Test
    public void testGetPossiblePositionPawnBlack() {
        assertEquals(FigureType.PAWN, board.getFigure(new Position(3, 7)).getType());
        board.getFigure(new Position(3, 2)).setPosition(new Position(4, 6));
        assertEquals(FigureType.PAWN, board.getFigure(new Position(4, 6)).getType());
        assertEquals(Color.WHITE, board.getFigure(new Position(4, 6)).getColor());
        Position[] result = validation.getPossiblePositions(board.getFigure(new Position(3, 7)), board);
        ArrayList<Position> resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }
        }
        assertTrue(resultList.contains(new Position(4, 6)));
        assertTrue(resultList.contains(new Position(3, 6)));
        assertEquals(2, resultList.size());
    }

    @Test
    public void testGetPossiblePositionPawnWhite() {
        assertEquals(FigureType.PAWN, board.getFigure(new Position(4, 2)).getType());
        board.getFigure(new Position(5, 7)).setPosition(new Position(5, 3));
        assertEquals(FigureType.PAWN, board.getFigure(new Position(5, 3)).getType());
        assertEquals(Color.BLACK, board.getFigure(new Position(5, 3)).getColor());
        Position[] result = validation.getPossiblePositions(board.getFigure(new Position(4, 2)), board);
        ArrayList<Position> resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }
        }
        assertEquals(2, resultList.size());
        assertTrue(resultList.contains(new Position(5, 3)));
        assertTrue(resultList.contains(new Position(4, 3)));

        board.getFigure(new Position(5, 3)).setPosition(new Position(5, 7));
        assertEquals(FigureType.PAWN, board.getFigure(new Position(5, 7)).getType());
        result = validation.getPossiblePositions(board.getFigure(new Position(4, 2)), board);
        resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }
        }
        assertEquals(1, resultList.size());
        assertTrue(resultList.contains(new Position(4, 3)));
    }

    @Test
    public void testGetPossiblePositionBishop() {
        Position[] result = validation.getPossiblePositions(board.getFigure(new Position(6, 1)), board);
        ArrayList<Position> resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }

        }
        assertEquals(0, resultList.size());
        board.getFigure(new Position(3, 8)).setPosition(new Position(3, 5));
        board.getFigure(new Position(6, 1)).setPosition(new Position(5, 3));

        assertEquals(FigureType.BISHOP, board.getFigure(new Position(5, 3)).getType());
        assertEquals(Color.WHITE, board.getFigure(new Position(5, 3)).getColor());
        assertEquals(FigureType.BISHOP, board.getFigure(new Position(3, 5)).getType());
        assertEquals(Color.BLACK, board.getFigure(new Position(3, 5)).getColor());

        result = validation.getPossiblePositions(board.getFigure(new Position(5, 3)), board);
        resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }
        }
        assertTrue(resultList.contains(new Position(4, 4)));
        assertTrue(resultList.contains(new Position(3, 5)));
        assertTrue(resultList.contains(new Position(6, 4)));
        assertTrue(resultList.contains(new Position(7, 5)));
        assertTrue(resultList.contains(new Position(8, 6)));
        assertEquals(5, resultList.size());

    }

    @Test
    public void testGetPossiblePositionsKing() {
        Position[] result = validation.getPossiblePositions(board.getFigure(new Position(5, 1)), board);
        ArrayList<Position> resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }
        }
        assertEquals(0, resultList.size());
        board.getFigure(new Position(5, 1)).setPosition(new Position(8, 3));
        board.getFigure(new Position(4, 7)).setPosition(new Position(8, 4));
        assertEquals(FigureType.KING, board.getFigure(new Position(8, 3)).getType());
        assertEquals(FigureType.PAWN, board.getFigure(new Position(8, 4)).getType());

        result = validation.getPossiblePositions(board.getFigure(new Position(8, 3)), board);
        resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }
        }
        assertTrue(resultList.contains(new Position(8, 4)));
        assertTrue(resultList.contains(new Position(7, 4)));
        assertTrue(resultList.contains(new Position(7, 3)));
        assertEquals(3, resultList.size());

    }

    @Test
    public void testGetPossiblePositionsKnight() {
        board.getFigure(new Position(3, 2)).setPosition(new Position(3, 3));
        assertEquals(FigureType.PAWN, board.getFigure(new Position(3, 3)).getType());

        Position[] result = validation.getPossiblePositions(board.getFigure(new Position(2, 1)), board);
        ArrayList<Position> resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }
        }
        assertEquals(1, resultList.size());
        assertTrue(resultList.contains(new Position(1, 3)));
    }

    /**
     * Test of getPossiblePositions method, of class Validation.
     */
    @Test
    public void testGetPossiblePositionsRook() {
        Position[] result = validation.getPossiblePositions(board.getFigure(new Position(1, 1)), board);
        ArrayList<Position> resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {

                resultList.add(position);
            }
        }
        assertEquals(0, resultList.size());

        board.getFigure(new Position(1, 1)).setPosition(new Position(4, 4));
        board.getFigure(new Position(1, 8)).setPosition(new Position(4, 6));

        assertEquals(FigureType.ROOK, board.getFigure(new Position(4, 4)).getType());
        assertEquals(FigureType.ROOK, board.getFigure(new Position(4, 6)).getType());

        result = validation.getPossiblePositions(board.getFigure(new Position(4, 4)), board);
        resultList = new ArrayList<>();
        for (Position position : result) {
            if (position != null) {
                resultList.add(position);
            }
        }
        assertEquals(10, resultList.size());
        assertTrue(resultList.contains(new Position(4, 5)));
        assertTrue(resultList.contains(new Position(4, 3)));
        assertTrue(resultList.contains(new Position(6, 4)));
        assertTrue(resultList.contains(new Position(7, 4)));
        assertTrue(resultList.contains(new Position(8, 4)));
        assertTrue(resultList.contains(new Position(2, 4)));
        assertTrue(resultList.contains(new Position(3, 4)));
        assertTrue(resultList.contains(new Position(4, 6)));

    }

    @Test
    public void testValidTarget() {
        board.getFigure(new Position(1, 1)).setPosition(new Position(4, 4));
        board.getFigure(new Position(1, 8)).setPosition(new Position(4, 6));
        assertTrue(validation.validTarget(board.getFigure(new Position(4, 4)), board, new Position(3, 4)));
        assertFalse(validation.validTarget(board.getFigure(new Position(4, 4)), board, new Position(7, 8)));
    }

}
