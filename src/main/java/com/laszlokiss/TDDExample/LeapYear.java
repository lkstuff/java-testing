package com.laszlokiss.TDDExample;

public class LeapYear
{
    public static boolean isLeapYear(final int year)
    {
        return isDivisable(year, 4) && (!isDivisable(year, 100)) || isDivisable(year, 400);
    }

    private static boolean isDivisable(final int year, final int denominator)
    {
        return year % denominator == 0;
    }
}
