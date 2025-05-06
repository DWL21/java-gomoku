package com.yourssu.eternity.movie.step02.pricing;

import com.yourssu.eternity.money.Money;
import com.yourssu.eternity.movie.step02.DiscountPolicy;
import com.yourssu.eternity.movie.step02.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
