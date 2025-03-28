package com.yourssu.model.player;

import com.yourssu.model.board.Board;
import com.yourssu.model.board.Position;

public interface Player {
    Board play(Board board, Position position);
}
