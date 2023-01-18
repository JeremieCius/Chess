package com.chess.model;

import com.chess.model.util.Colors;
import com.chess.model.util.Pieces;

import java.util.List;
import java.util.Set;

/*
 *  Note that the following methods use 0-indexed rows and columns to refer to the spaces on the chess board.
 */
public interface ChessGameInterface {
    /**
     * @throws IllegalArgumentException if either row or col are not between 0 and 7 (inclusive).
     * @param row
     * @param col
     * @return true if the space at (row, col) contains a piece of the current player's color, false otherwise.
     */
    public boolean doesTileContainPieceOfCurrentPlayersColor(int row, int col);

    /**
     * Gives a set of the spaces that the piece at the given space can move to.
     *
     * @throws IllegalArgumentException if
     *  - the space doesn't contain a piece, or
     *  - the space contains a piece of the color of the inactive player, or
     *  - the game is over.
     * @param row
     * @param col
     * @return
     */
    public Set<Tile> getAvailableMovesForTile(int row, int col);

    /**
     * Moves the piece at the startRow row and startCol column to the space at the endRow row and endCol column.
     *
     * @throws IllegalArgumentException if:
     *  - the starting space doesn't contain the current player's piece, or
     *  - the ending space isn't available, or
     *  - the game is over
     * @param startRow
     * @param startCol
     * @param endRow
     * @param endCol
     */
    public void move(int startRow, int startCol, int endRow, int endCol);

    /**
     * Reverts the game to it's state prior to the last move that was made.
     */
    public void undoLastMove();

    /**
     * @return true if the current player is in check, false otherwise.
     */
    public boolean isCurrentPlayerInCheck();

    /**
     * @return true if the current player is in checkmate, false otherwise.
     */
    public boolean isCurrentPlayerInCheckmate();

    /**
     * @return true if the game is in stalemate, false otherwise.
     */
    public boolean isGameInStalemate();

    /**
     * @return the state of the board as a 2D array of Pieces.
     */
    public Pieces[][] getBoardState();

    /**
     * @return a list of the white pieces on the board, sorted in descending order.
     */
    public List<Pieces> getActiveWhitePieces();

    /**
     * @return a list of the black pieces on the board, sorted in descending order.
     */
    public List<Pieces> getActiveBlackPieces();

    /**
     * @return a list of the captured white pieces, sorted in descending order.
     */
    public List<Pieces> getCapturedWhitePieces();

    /**
     * @return a list of the captured black pieces, sorted in descending order.
     */
    public List<Pieces> getCapturedBlackPieces();

    /**
     * @return the current player's color.
     */
    public Colors getCurrentPlayerColor();
}
