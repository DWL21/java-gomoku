package com.yourssu.eternity.movie.step01.pricing;


import com.yourssu.eternity.money.Money;
import com.yourssu.eternity.movie.step01.DiscountCondition;
import com.yourssu.eternity.movie.step01.DiscountPolicy;
import com.yourssu.eternity.movie.step01.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
