package com.yourssu.model.stone;

public class WhiteStone implements Stone {
    @Override
    public void validateRule() {
        throw new IllegalArgumentException();
    }
}
