package com.laszlokiss.TDDExample;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearTest
{
    // a year is a leap year if it is divisible by four
    // but, years divisible by 100, are not leap year
    // except years divisible by 400
    // defined in modern gregorian calendar system

    @Test
    public void leapYearsDivisibleByFour()
    {
        assertTrue(LeapYear.isLeapYear(2016));
    }

    // negative example
    @Test
    public void normalYearsAreNotDivisibleByFour()
    {
        assertFalse(LeapYear.isLeapYear(3));
    }
}
