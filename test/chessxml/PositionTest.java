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
public class PositionTest {

    Position pos11;

    public PositionTest() {
        pos11 = new Position(1, 1);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        pos11 = null;
    }

    @Test
    public void testSetPos() {
        pos11.setPosition(9,3);
        assertEquals(1, pos11.getHorizontal());
        pos11.setPosition(4, 4);
        assertEquals(4, pos11.getVertical());

    }

}
