package com.laszlokiss.cafeForTesting;

/**
 * A coffee shop that brew coffee and maintains an internal stock
 * of beans and milk
 */

public final class Cafe
{
    private int beanInStock = 0;
    private int milkInStock = 0;

    public Coffee brew (CoffeeType coffeeType){
        return brew(coffeeType, 1);
    }

    public Coffee brew (CoffeeType coffeeType, int quantity){
        requirePositive(quantity);

        int requiredBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;
        if(requiredBeans > beanInStock || requiredMilk > milkInStock){
            throw new IllegalStateException("Insufficient beans or milk");
        }

        beanInStock -= requiredBeans;
        milkInStock -= requiredMilk;
        return new Coffee(coffeeType, requiredBeans, requiredMilk);
    }

    public int getBeanInStock(){
        return beanInStock;
    }

    public int getMilkInStock(){
        return milkInStock;
    }

    public void restockBeans(int weightInGrams){
        requirePositive(weightInGrams);

        beanInStock += weightInGrams;
    }

    public void restockMilk(int weightInGrams){
        requirePositive(weightInGrams);
        milkInStock += weightInGrams;
    }

    public void requirePositive(int value){
        if(value < 1){
            throw new IllegalArgumentException();

        }
    }

}
