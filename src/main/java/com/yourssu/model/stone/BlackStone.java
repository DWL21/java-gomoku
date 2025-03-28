package com.yourssu.model.stone;

public class BlackStone implements Stone {
    @Override
    public void enforceImmovableStoneRule() {
        throw new IllegalArgumentException();
    }
}
