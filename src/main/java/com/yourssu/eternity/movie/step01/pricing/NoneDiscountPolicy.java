package com.yourssu.eternity.movie.step01.pricing;

import com.yourssu.eternity.money.Money;
import com.yourssu.eternity.movie.step01.DiscountPolicy;
import com.yourssu.eternity.movie.step01.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
