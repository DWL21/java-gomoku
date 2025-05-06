package com.yourssu.eternity.movie.step02;


import com.yourssu.eternity.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
