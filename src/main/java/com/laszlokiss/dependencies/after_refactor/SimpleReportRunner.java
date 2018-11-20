package com.laszlokiss.dependencies.after_refactor;

public class SimpleReportRunner{

    public static void main(String[] args)
    {
        if(args.length < 1)
        {
            System.err.println("You must provide a commandLine argument specifiying the file to analyse");
            System.exit(-1);
        }
        CsvSalesRepository repo = new CsvSalesRepository(args[0]);
        repo.setError(System.err);
        // instatntiate and SalesReport depends on it and takes it as contsructor param.
        final  SalesAnalysisService analyser =  new SalesAnalysisService(repo);
        // constructor injection  SalesAnalysisService
        SalesReport report = new SalesReport(System.out, analyser);
        report.report();
    }
}
