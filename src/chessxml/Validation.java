/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessxml;

import java.util.Arrays;

/**
 *
 * @author Moha
 */
public class Validation {

    private Position[] getPossiblePositionsPawn(Position pos) {
        Position[] result = new Position[32];
        int horizontal = pos.getHorizontal();
        int vertical = pos.getVertical();
        if (vertical - 1 >= 1) {
            result[0] = new Position(horizontal, --vertical);
        }
        vertical = pos.getVertical();
        if (vertical + 1 <= 8) {
            result[1] = new Position(horizontal, ++vertical);
        }
        vertical = pos.getVertical();
        if (horizontal - 1 >= 1) {
            result[2] = new Position(--horizontal, vertical);
        }
        horizontal = pos.getHorizontal();
        if (horizontal + 1 >= 1) {
            result[3] = new Position(++horizontal, vertical);
        }
        return result;

    }

    private Position[] getPossiblePositionsBishop(Position pos) {
        Position[] result = new Position[32];
        int horizontal = pos.getHorizontal();
        int vertical = pos.getVertical();
        int i = 0;
        while (horizontal > 1 && vertical < 8) {
            result[i] = new Position(--horizontal, ++vertical);
            i++;
        }
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (horizontal < 8 && vertical < 8) {
            result[i] = new Position(++horizontal, ++vertical);
            i++;
        }
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (horizontal < 8 && vertical > 1) {
            result[i] = new Position(++horizontal, --vertical);
            i++;
        }
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (horizontal > 1 && vertical > 1) {
            result[i] = new Position(--horizontal, --vertical);
            i++;
        }
        return result;
    }

    private Position[] getPossiblePositionsRook(Position pos) {
        Position[] result = new Position[32];
        int horizontal = 0;
        int vertical = pos.getVertical();
        int i = 0;
        while (horizontal < 8) {
            result[i] = new Position(++horizontal, vertical);
            i++;
        }
        horizontal = pos.getHorizontal();
        vertical = 0;
        while (vertical < 8) {
            result[i] = new Position(horizontal, ++vertical);
            i++;
        }
        return result;
    }

    public Position[] getPossibleMove(Player player, Figure fig, Position pos) {
        Position[] possiblePos = getPossiblePositions(fig.getType(), pos);
        Position[] result = new Position[possiblePos.length];
        int resultIndex = 0;
        for (int i = 0; i < possiblePos.length; i++) {
            if (player.getBoard().getFigure(possiblePos[i]).getColor() != player.getColor()) {

                resultIndex++;
            }
        }

        return null;
    }

    public Position[] getPossiblePositions(FigureType figType, Position pos) {
        Position[] result = new Position[32];
        int horizontal;
        int vertical;
        int i;
        switch (figType) {

            case ROOK:
                return getPossiblePositionsRook(pos);

            case PAWN:
                return getPossiblePositionsPawn(pos);

            case BISHOP:
                return getPossiblePositionsBishop(pos);
            case QUEEN:
                Position[] possiblePosRook = getPossiblePositionsRook(pos);
                Position[] possiblePosBishop = getPossiblePositionsBishop(pos);
                result = Arrays.copyOf(possiblePosRook, possiblePosRook.length + possiblePosBishop.length);
                System.arraycopy(possiblePosBishop, 0, result, possiblePosRook.length, possiblePosBishop.length);
                return result;
            case KING:

                Position[] possiblePositionPawn = getPossiblePositionsPawn(pos);

                Position[] possiblePositionDiagonal = new Position[32];
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                i = 0;
                if (horizontal - 1 >= 1 && vertical + 1 <= 8) {
                    possiblePositionDiagonal[i] = new Position(--horizontal, ++vertical);
                    i++;
                }
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal + 1 <= 8 && vertical + 1 <= 8) {
                    possiblePositionDiagonal[i] = new Position(++horizontal, ++vertical);
                    i++;
                }
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal + 1 < 8 && vertical - 1 > 1) {
                    possiblePositionDiagonal[i] = new Position(++horizontal, --vertical);
                    i++;
                }
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal - 1 > 1 && vertical - 1 >= 1) {
                    possiblePositionDiagonal[i] = new Position(--horizontal, --vertical);
                    i++;
                }
                result = Arrays.copyOf(possiblePositionPawn, possiblePositionPawn.length + possiblePositionDiagonal.length);
                System.arraycopy(possiblePositionDiagonal, 0, result, possiblePositionPawn.length, possiblePositionDiagonal.length);
                return result;

            case KNIGHT:
                i = 0;
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal + 1 <= 8 && vertical + 2 <= 8) {
                    result[i] = new Position(++horizontal, vertical + 2);
                    i++;
                }

                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal - 1 >= 1 && vertical + 2 <= 8) {
                    result[i] = new Position(--horizontal, vertical + 2);
                    i++;
                }
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal + 2 <= 8 && vertical + 1 <= 8) {
                    result[i] = new Position(horizontal + 2, ++vertical);
                    i++;
                }

                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal - 2 >= 1 && vertical + 1 <= 8) {
                    result[i] = new Position(horizontal - 2, ++vertical);
                    i++;
                }
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal + 1 <= 8 && vertical - 2 >= 1) {
                    result[i] = new Position(++horizontal, vertical - 2);
                    i++;
                }

                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal - 1 >= 1 && vertical - 2 >= 1) {
                    result[i] = new Position(--horizontal, vertical - 2);
                    i++;
                }
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal + 2 <= 8 && vertical - 1 >= 1) {
                    result[i] = new Position(horizontal + 2, --vertical);
                    i++;
                }
                horizontal = pos.getHorizontal();
                vertical = pos.getVertical();
                if (horizontal - 2 >= 1 && vertical - 1 >= 1) {
                    result[i] = new Position(horizontal - 2, --vertical);
                    i++;
                }
                return result;

        }

        return null;
    }
}
