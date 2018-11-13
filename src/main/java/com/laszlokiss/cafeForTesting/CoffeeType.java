package com.laszlokiss.cafeForTesting;

public enum CoffeeType
{
    ESPRESSO(8, 0),
    LATTE(7, 227),
    FILTERCOFFEE(10, 0);

    private final int requiredBeans;
    private final int requiredMilk;

    CoffeeType(int requiredBeans, int requiredMilk){
        this.requiredBeans = requiredBeans;
        this.requiredMilk = requiredMilk;
    }

    public int getRequiredBeans(){
        return requiredBeans;
    }

    public int getRequiredMilk(){
        return requiredMilk;
    }
}
