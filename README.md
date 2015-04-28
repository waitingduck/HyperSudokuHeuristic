# HyperSudokuHeuristic
a Sudoku solver using more OO design.

This Sudoku solve is using OO disign. There are some options for this application.

Indicator:how to decide next field to fill?
normalIndicator: using back trackin CSP.
heuristicIndicator: using less constrain heuristic method.
choose either way to use.

SudokuConstrain: constrain of sudoku game
normalSudokuConstrain: basic Sudoku constrain, which means you cannot have same number in the same row, column, and 9*9 board.
hyperSudokuConstrain: add 4 more 9*9 board constrain(it only contain these four, so basically you still need to include normalSudokuConstrain).

