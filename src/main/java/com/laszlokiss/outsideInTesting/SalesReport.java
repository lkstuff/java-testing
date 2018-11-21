package com.laszlokiss.outsideInTesting;

import java.io.PrintStream;
import java.util.Map;

public class SalesReport
{
    private final SalesAnalyser analyser;
    private final PrintStream out;

    public SalesReport(SalesAnalyser analyser, PrintStream out)
    {

        this.analyser = analyser;
        this.out = out;
    }

    public void run()
    {
        // Todo: print things out here
        analyser.tallyCitySales().
                forEach((city, tally) ->
        {
            out.printf("- %-15s - %6.6s -%n", city, tally);
        } );
    }
}
