package com.laszlokiss.outsideInTesting;

import java.io.PrintStream;

public class SalesReportRunner
{
    private final PrintStream out;


    public static void main(String[] args)
    {
        String fileLocation = args[0];
        new SalesReportRunner(System.out).run(fileLocation);

    }

    public SalesReportRunner(final PrintStream out)
    {
        this.out = out;

    }

    public void run(final String fileLocation)
    {
        SalesRepository repo = new SalesRepository(fileLocation);
        // busines logic
        // make calls to repo to get the data that needs to analyze
        SalesAnalyser analyser = new SalesAnalyser(repo);
        // make calls to SalesAnalyser to get the results to print out
        SalesReport report = new SalesReport(analyser, out);
        report.run();

    }
}
