package com.yourssu.model.player;

import com.yourssu.model.board.Board;
import com.yourssu.model.board.Position;
import com.yourssu.model.stone.WhiteStone;

public class WhitePlayer implements Player {
    @Override
    public Board play(Board board, Position position) {
        return board.placeStone(new WhiteStone(), position);
    }
}
