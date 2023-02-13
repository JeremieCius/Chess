# Problem Description

The application being built is a Chess application that allows two users to play chess on a single device, and also allows a single user to play against the computer.

When the application is launched, the user will be taken to the home screen, which contains a button for playing locally and a button for playing against the computer.

If the user clicks the button to play locally, a window will be displayed with the initial state of a chess board, with white pieces on bottom and black pieces on top.
When a user takes their turn, the current player's color changes and the other user can take their turn.

If the user clicks the button to play against the computer, an identical screen to the one described above will be shown.
The only difference is that when a user takes their turn, the computer takes its turn directly afterwards.

## Rules
The game will be played according to standard chess game rules as follows:
- The game is has two colors corresponding to each player, white and black.
  - White *always* gets the first turn, and the players alternate turns thereafter.
- On a turn, a player can select any one of their pieces and move them according to the following rules:
  - The **King** can move to any adjacent square (including diagonals).
    - If that tile contains an opposing piece, that piece will be captured.
    - If that tile contains a piece of the same color, you cannot move to that tile.
    - If the king hasn't been moved yet, one of the rooks of the same color hasn't been moved yet, the tiles between them are empty, and the king isn't currently in check, you can perform a *castle*.
      - In a *castle*, move the king two tiles towards the rook, and move the rook to the opposite side of the king.
  - The **Queen** can move along diagonal or rectangular vectors until it gets to another piece.
    - If that piece belongs to the opposing player, that piece can be captured.
    - If that piece belongs to the same player, you cannot move to that tile.
  - The **Rook** moves along rectangular vectors just as a queen does.
  - The **Bishop** moves along diagonal vectors just as a queen does.
  - The **Knight** moves in an L shape. 
  This means that it moves two tiles according to one rectangular vector, and one tile that's orthogonal to that vector.
    - If that tile contains an opposing piece, that piece will be captured.
    - If that tile contains a piece of the same color, you cannot move to that tile.
  - The **Pawn** can move in multiple ways:
    - It can move one tile forward if that tile does not contain a piece.
    - It can move two tiles forward if it hasn't been moved yet and both tiles in front of it do not contain a piece.
    - It can move forward diagonally if that tile contains an opposing piece, in which case it captures that piece.
    - If an opposing pawn is adjacent to it (on the left or right), that pawn was move on the last turn, and the diagonal tile in that direction is empty, the pawn can move to that empty tile and capture the adjacent pawn (the rule is called en passant).
- The above moves are only valid if they do not put the current player's king in **check**.
    - A player's king is in check if that king can be captured on the next turn.
- If the turn ends with a pawn on the opposite end of the board, the player can promote it to either a queen, rook, bishop, or knight.
    - To keep the application simple, a pawn will automatically be promoted to a queen.
- Turns alternate until the game ends. A game ends when either one of the players is in checkmate, or if there's a stalemate.
  - Checkmate occurs when a player has no remaining moves and their king is in check.
  - Stalemate occurs when the current player has no remaining moves.

## User Interface

The user interface is composed of two types of screens, the home screen and the chess board screen.
The home screen will allow the user to select whether they would like to play locally or against the computer.
If they'd like to play against the computer, they get to choose which bot they'd like to play against.
They also get to select the time limit that each player has.
Once they've selected the time limit, they can move on to the game screen.
There's a home icon/button in the top left corner of the game screen which takes the user back to the home screen.

#### Game Screen
There's only one screen to deal with in the game, which contains the board.

Only the current player can select a piece. When the current player hovers over a selectable tile, that tile will be highlighted.
- A tile is selectable if it contains that player's piece, or if the player's currently selected piece can move to that tile.

When a player selects a piece, all the tiles it can move to should be highlighted.

If a piece is selected and the user selects a tile that it can be moved to, then that piece will be moved there and the next player can take their turn.
If the user is playing against the computer, the computer will automatically take it's turn after the user.

If the game ends with a checkmate, a message should be displayed indicating which player won.
If the game ends with a stalemate, a message should be displayed indicating that there was a tie.

### User Interface Design

![](resources/ui_design.png)