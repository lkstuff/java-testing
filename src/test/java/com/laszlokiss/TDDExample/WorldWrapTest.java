package com.laszlokiss.TDDExample;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WorldWrapTest
{
    public static final int  LINE_LENGHT = 10;

    // a method that breaks words in a specific space with new line, like worldprocessor would do

    @Test
    public void lineShouldWrapIfOverLineLenght()
    {
        String result = WorldWrap.wrap("Longer than line xxx", LINE_LENGHT);
        assertEquals("Longer tha\nn line xxx", result);
    }

    @Test
    public void shortLineShouldNotWrap()
    {
        String result = WorldWrap.wrap("The", LINE_LENGHT);
        assertEquals("The", result);
    }


    @Test
    public void longerLinesShouldWrapTwice()
    {
        String result = WorldWrap.wrap("Longer than line lenght xxxxxx", LINE_LENGHT);
        assertEquals("Longer tha\nn line len\nght xxxxxx", result);
    }

    @Test
    public void evenLongerLinesShouldWrapThreeTimes()
    {
        String result = WorldWrap.wrap("Longer than line lenght xxxxxx 123456789", LINE_LENGHT);
        assertEquals("Longer tha\nn line len\nght xxxxxx\n 123456789", result);
    }

    @Test
    public void longLinesDoNotHaveToBeMultipleOfLineLenght()
    {
        String result = WorldWrap.wrap("Longer than line lenght xxxxxx 12345678", LINE_LENGHT);
        assertEquals("Longer tha\nn line len\nght xxxxxx\n 12345678", result);
    }
}
