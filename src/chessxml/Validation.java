/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessxml;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Moha
 */
public class Validation {
    
    private Position[] getPossiblePositionsBlackPawn(Position pos, Board board) {
        Position[] result = new Position[32];
        int horizontal = pos.getHorizontal();
        int vertical = pos.getVertical();
        Color selectedFigureColor = board.getFigure(pos).getColor();
        
        if (vertical - 1 >= 1
                && board.getFigure(new Position(horizontal, vertical - 1)) == null) {
            result[0] = new Position(horizontal, --vertical);
        }
        
        vertical = pos.getVertical();
        horizontal = pos.getHorizontal();
        if (vertical - 1 >= 1
                && horizontal + 1 <= 8
                && board.getFigure(new Position(horizontal + 1, vertical - 1)) != null
                && board.getFigure(new Position(horizontal + 1, vertical - 1)).getColor() != selectedFigureColor) {
            result[1] = new Position(horizontal + 1, vertical - 1);
        }
        if (vertical - 1 >= 1
                && horizontal - 1 >= 1
                && board.getFigure(new Position(horizontal - 1, vertical - 1)) != null
                && board.getFigure(new Position(horizontal - 1, vertical - 1)).getColor() != selectedFigureColor) {
            result[2] = new Position(horizontal - 1, vertical - 1);
        }
        return result;
    }
    
    private Position[] getPossiblePositionsWhitePawn(Position pos, Board board) {
        Position[] result = new Position[32];
        int horizontal = pos.getHorizontal();
        int vertical = pos.getVertical();
        Color selectedFigureColor = board.getFigure(pos).getColor();
        
        if (vertical + 1 <= 8
                && board.getFigure(new Position(horizontal, vertical + 1)) == null) {
            result[0] = new Position(horizontal, ++vertical);
        }
        
        vertical = pos.getVertical();
        horizontal = pos.getHorizontal();
        if (vertical + 1 <= 8
                && horizontal + 1 <= 8
                && board.getFigure(new Position(horizontal + 1, vertical + 1)) != null
                && board.getFigure(new Position(horizontal + 1, vertical + 1)).getColor() != selectedFigureColor) {
            result[1] = new Position(horizontal + 1, vertical + 1);
        }
        if (vertical + 1 <= 8
                && horizontal - 1 >= 1
                && board.getFigure(new Position(horizontal - 1, vertical + 1)) != null
                && board.getFigure(new Position(horizontal - 1, vertical + 1)).getColor() != selectedFigureColor) {
            result[2] = new Position(horizontal - 1, vertical + 1);
        }
        return result;
    }
    
    private Position[] getPossiblePositionsBishop(Position pos, Board board) {
        Position[] result = new Position[32];
        int horizontal = pos.getHorizontal();
        int vertical = pos.getVertical();
        int i = 0;
        Color selectedFigureColor = board.getFigure(pos).getColor();
        while (horizontal > 1 && vertical < 8) {
            if (board.getFigure(new Position(horizontal - 1, vertical + 1)) == null) {
                result[i] = new Position(--horizontal, ++vertical);
                i++;
            } else if (board.getFigure(new Position(horizontal - 1, vertical + 1)).getColor() != selectedFigureColor) {
                result[i] = new Position(--horizontal, ++vertical);
                i++;
                break;
            } else if (board.getFigure(new Position(horizontal - 1, vertical + 1)).getColor() == selectedFigureColor) {
                break;
            } else {
                horizontal--;
                vertical++;
            }
        }
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (horizontal < 8 && vertical < 8) {
            if (board.getFigure(new Position(horizontal + 1, vertical + 1)) == null) {
                result[i] = new Position(++horizontal, ++vertical);
                i++;
            } else if (board.getFigure(new Position(horizontal + 1, vertical + 1)).getColor() != selectedFigureColor) {
                result[i] = new Position(++horizontal, ++vertical);
                i++;
                break;
            } else if (board.getFigure(new Position(horizontal + 1, vertical + 1)).getColor() == selectedFigureColor) {
                break;
            } else {
                horizontal++;
                vertical++;
            }
        }
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (horizontal < 8 && vertical > 1) {
            if (board.getFigure(new Position(horizontal + 1, vertical - 1)) == null) {
                result[i] = new Position(++horizontal, --vertical);
                i++;
            } else if (board.getFigure(new Position(horizontal + 1, vertical - 1)).getColor() != selectedFigureColor) {
                result[i] = new Position(++horizontal, --vertical);
                i++;
                break;
            } else if (board.getFigure(new Position(horizontal + 1, vertical - 1)).getColor() == selectedFigureColor) {
                break;
            } else {
                horizontal++;
                vertical--;
            }
        }
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (horizontal > 1 && vertical > 1) {
            if (board.getFigure(new Position(horizontal - 1, vertical - 1)) == null) {
                result[i] = new Position(--horizontal, --vertical);
                i++;
            } else if (board.getFigure(new Position(horizontal - 1, vertical - 1)).getColor() != selectedFigureColor) {
                
                result[i] = new Position(--horizontal, --vertical);
                i++;
                break;
            } else if (board.getFigure(new Position(horizontal - 1, vertical - 1)).getColor() == selectedFigureColor) {
                break;
            } else {
                horizontal--;
                vertical--;
            }
        }
        return result;
    }
    
    private Position[] getPossiblePositionsRook(Position pos, Board board) {
        Position[] result = new Position[32];
        int horizontal = pos.getHorizontal();
        int vertical = pos.getVertical();
        int i = 0;
        Color selectedFigureColor = board.getFigure(pos).getColor();
        while (horizontal < 8) {
            if (board.getFigure(new Position(horizontal + 1, vertical)) == null) {
                result[i] = new Position(++horizontal, vertical);
                i++;
            } else if (board.getFigure(new Position(horizontal + 1, vertical)).getColor() != selectedFigureColor) {
                result[i] = new Position(++horizontal, vertical);
                i++;
                break;
            } else if (board.getFigure(new Position(horizontal + 1, vertical)).getColor() == selectedFigureColor) {
                break;
            } else {
                horizontal++;
            }
        }
        
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (horizontal > 1) {
            if (board.getFigure(new Position(horizontal - 1, vertical)) == null) {
                result[i] = new Position(--horizontal, vertical);
                i++;
            } else if (board.getFigure(new Position(horizontal - 1, vertical)).getColor() != selectedFigureColor) {
                result[i] = new Position(--horizontal, vertical);
                i++;
                break;
            } else if (board.getFigure(new Position(horizontal - 1, vertical)).getColor() == selectedFigureColor) {
                break;
            } else {
                horizontal--;
            }
        }
        
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (vertical < 8) {
            if (board.getFigure(new Position(horizontal, vertical + 1)) == null) {
                
                result[i] = new Position(horizontal, ++vertical);
                i++;
            } else if (board.getFigure(new Position(horizontal, vertical + 1)).getColor() != selectedFigureColor) {
                result[i] = new Position(horizontal, ++vertical);
                i++;
                break;
            } else if (board.getFigure(new Position(horizontal, vertical + 1)).getColor() == selectedFigureColor) {
                break;
            } else {
                vertical++;
            }
        }
        horizontal = pos.getHorizontal();
        vertical = pos.getVertical();
        while (vertical > 1) {
            if (board.getFigure(new Position(horizontal, vertical - 1)) == null) {
                result[i] = new Position(horizontal, --vertical);
                i++;
            } else if (board.getFigure(new Position(horizontal, vertical - 1)).getColor() != selectedFigureColor) {
                result[i] = new Position(horizontal, --vertical);
                i++;
                break;
            } else if (board.getFigure(new Position(horizontal, vertical - 1)).getColor() == selectedFigureColor) {
                break;
            } else {
                vertical--;
            }
            
        }
        return result;
    }
    
    public Position[] getPossiblePositions(Figure fig, Board board) {
        Position[] result = new Position[32];
        int horizontal;
        int vertical;
        int i;
        switch (fig.getType()) {
            
            case ROOK:
                return sorter(getPossiblePositionsRook(fig.getPos(), board));
            
            case PAWN:
                if (fig.getColor() == (Color.WHITE)) {
                    return sorter(getPossiblePositionsWhitePawn(fig.getPos(), board));
                } else {
                    return sorter(getPossiblePositionsBlackPawn(fig.getPos(), board));
                }
            
            case BISHOP:
                return sorter(getPossiblePositionsBishop(fig.getPos(), board));
            case QUEEN:
                Position[] possiblePosRook = getPossiblePositionsRook(fig.getPos(), board);
                Position[] possiblePosBishop = getPossiblePositionsBishop(fig.getPos(), board);
                result = Arrays.copyOf(possiblePosRook, possiblePosRook.length + possiblePosBishop.length);
                System.arraycopy(possiblePosBishop, 0, result, possiblePosRook.length, possiblePosBishop.length);
                return sorter(result);
            case KING:
                
                result = new Position[32];
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                i = 0;
                Color selectedFigureColor = board.getFigure(fig.getPos()).getColor();
                
                if (horizontal + 1 <= 8) {
                    if (board.getFigure(new Position(horizontal + 1, vertical)) == null) {
                        result[i] = new Position(horizontal + 1, vertical);
                    } else if (board.getFigure(new Position(horizontal + 1, vertical)) != null
                            && board.getFigure(new Position(horizontal + 1, vertical)).getColor() != selectedFigureColor) {
                        result[i] = new Position(++horizontal, vertical);
                        i++;
                    }
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal - 1 >= 1) {
                    if (board.getFigure(new Position(horizontal - 1, vertical)) == null) {
                        result[i] = new Position(horizontal - 1, vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal - 1, vertical)) != null
                            && board.getFigure(new Position(horizontal - 1, vertical)).getColor() != selectedFigureColor) {
                        result[i] = new Position(horizontal - 1, vertical);
                        i++;
                    }
                    
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (vertical + 1 <= 8) {
                    if (board.getFigure(new Position(horizontal, vertical + 1)) == null) {
                        result[i] = new Position(horizontal, vertical + 1);
                        i++;
                    } else if (board.getFigure(new Position(horizontal, vertical + 1)) != null
                            && board.getFigure(new Position(horizontal, vertical + 1)).getColor() != selectedFigureColor) {
                        
                        result[i] = new Position(horizontal, vertical + 1);
                        i++;
                    }
                    
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (vertical - 1 >= 1) {
                    if (board.getFigure(new Position(horizontal, vertical - 1)) == null) {
                        result[i] = new Position(horizontal, vertical - 1);
                        i++;
                    } else if (board.getFigure(new Position(horizontal, vertical - 1)) != null
                            && board.getFigure(new Position(horizontal, vertical - 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(horizontal, vertical - 1);
                        i++;
                    }
                    
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                
                if (horizontal - 1 >= 1 && vertical + 1 <= 8) {
                    if (board.getFigure(new Position(horizontal - 1, vertical + 1)) == null) {
                        result[i] = new Position(--horizontal, ++vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal - 1, vertical + 1)) != null
                            && board.getFigure(new Position(horizontal - 1, vertical + 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(--horizontal, ++vertical);
                        i++;
                    }
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal + 1 <= 8 && vertical + 1 <= 8) {
                    if (board.getFigure(new Position(horizontal + 1, vertical + 1)) == null) {
                        result[i] = new Position(++horizontal, ++vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal + 1, vertical + 1)) != null
                            && board.getFigure(new Position(horizontal + 1, vertical + 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(++horizontal, ++vertical);
                        i++;
                    }
                }
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal + 1 <= 8 && vertical - 1 >= 1) {
                    if (board.getFigure(new Position(horizontal + 1, vertical - 1)) == null) {
                        result[i] = new Position(++horizontal, --vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal + 1, vertical - 1)) != null
                            && board.getFigure(new Position(horizontal + 1, vertical - 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(++horizontal, --vertical);
                        i++;
                    }
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal - 1 >= 1 && vertical - 1 >= 1) {
                    if (board.getFigure(new Position(horizontal - 1, vertical - 1)) == null) {
                        result[i] = new Position(--horizontal, --vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal - 1, vertical - 1)) == null
                            && board.getFigure(new Position(horizontal - 1, vertical - 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(--horizontal, --vertical);
                        i++;
                    }
                }
                
                return sorter(result);
            
            case KNIGHT:
                i = 0;
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                selectedFigureColor = fig.getColor();
                if (horizontal + 1 <= 8 && vertical + 2 <= 8) {
                    if (board.getFigure(new Position(horizontal + 1, vertical + 2)) == null) {
                        result[i] = new Position(++horizontal, vertical + 2);
                        i++;
                    } else if (board.getFigure(new Position(horizontal + 1, vertical + 2)) != null
                            && board.getFigure(new Position(horizontal + 1, vertical + 2)).getColor() != selectedFigureColor) {
                        result[i] = new Position(++horizontal, vertical + 2);
                        i++;
                    }
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal - 1 >= 1 && vertical + 2 <= 8) {
                    if (board.getFigure(new Position(horizontal - 1, vertical + 2)) == null) {
                        result[i] = new Position(--horizontal, vertical + 2);
                        i++;
                    } else if (board.getFigure(new Position(horizontal - 1, vertical + 2)) != null
                            && board.getFigure(new Position(horizontal - 1, vertical + 2)).getColor() != selectedFigureColor) {
                        result[i] = new Position(--horizontal, vertical + 2);
                        i++;
                    }
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal + 2 <= 8 && vertical + 1 <= 8) {
                    if (board.getFigure(new Position(horizontal + 2, vertical + 1)) == null) {
                        
                        result[i] = new Position(horizontal + 2, ++vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal + 2, vertical + 1)) != null
                            && board.getFigure(new Position(horizontal + 2, vertical + 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(horizontal + 2, ++vertical);
                        i++;
                    }
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal - 2 >= 1 && vertical + 1 <= 8) {
                    if (board.getFigure(new Position(horizontal - 2, vertical + 1)) == null) {
                        result[i] = new Position(horizontal - 2, ++vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal - 2, vertical + 1)) != null
                            && board.getFigure(new Position(horizontal - 2, vertical + 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(horizontal - 2, ++vertical);
                        i++;
                    }
                }
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal + 1 <= 8 && vertical - 2 >= 1) {
                    if (board.getFigure(new Position(horizontal + 1, vertical - 2)) == null) {
                        result[i] = new Position(++horizontal, vertical - 2);
                        i++;
                    } else if (board.getFigure(new Position(horizontal + 1, vertical - 2)) != null
                            && board.getFigure(new Position(horizontal + 1, vertical - 2)).getColor() != selectedFigureColor) {
                        result[i] = new Position(++horizontal, vertical - 2);
                        i++;
                    }
                }
                
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal - 1 >= 1 && vertical - 2 >= 1) {
                    if (board.getFigure(new Position(horizontal - 1, vertical - 2)) == null) {
                        result[i] = new Position(--horizontal, vertical - 2);
                        i++;
                    } else if (board.getFigure(new Position(horizontal - 1, vertical - 2)) != null
                            && board.getFigure(new Position(horizontal - 1, vertical - 2)).getColor() != selectedFigureColor) {
                        result[i] = new Position(--horizontal, vertical - 2);
                        i++;
                    }
                }
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal + 2 <= 8 && vertical - 1 >= 1) {
                    if (board.getFigure(new Position(horizontal + 2, vertical - 1)) == null) {
                        result[i] = new Position(horizontal + 2, --vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal + 2, vertical - 1)) != null
                            && board.getFigure(new Position(horizontal + 2, vertical - 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(horizontal + 2, --vertical);
                        i++;
                    }
                }
                horizontal = fig.getPos().getHorizontal();
                vertical = fig.getPos().getVertical();
                if (horizontal - 2 >= 1 && vertical - 1 >= 1) {
                    if (board.getFigure(new Position(horizontal - 2, vertical - 1)) == null) {
                        result[i] = new Position(horizontal - 2, --vertical);
                        i++;
                    } else if (board.getFigure(new Position(horizontal - 2, vertical - 1)) != null
                            && board.getFigure(new Position(horizontal - 2, vertical - 1)).getColor() != selectedFigureColor) {
                        result[i] = new Position(horizontal - 2, --vertical);
                        i++;
                    }
                }
                return sorter(result);
            
        }
        return null;
    }
    
    private Position[] sorter(Position[] p) {
        
        ArrayList<Position> temp = new ArrayList<>();
        Position[] result;
        for (Position position : p) {
            if (position != null) {
                temp.add(position);
            }
        }
        result = new Position[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
    
    public boolean validTarget(Figure fig, Board board, Position target) {
        Position[] tempList = getPossiblePositions(fig, board);
        for (Position position : tempList) {
            if (position != null && position.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
