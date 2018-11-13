package com.laszlokiss.TDDExample;

import static java.lang.Math.min;

public class WorldWrap
{

    public static String wrap(final String inputLine, final int lineLenght)
    {
        final StringBuilder accumulator = new StringBuilder();
        final int length = inputLine.length();

        accumulator.append(inputLine, 0, min(length, lineLenght ));

        int split = lineLenght;
        while(length > split)
        {
            accumulator.append("\n");
            accumulator.append(inputLine, split, min(split + lineLenght, length));
            split += lineLenght;
        }

        return accumulator.toString();
    }
}
