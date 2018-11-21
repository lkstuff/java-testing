package com.laszlokiss.outsideInTesting;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class SalesReportSystemTest
{
    @Test
    public void shouldPrintStoreReportForSampleData()
    {
        // it is not going to be a test class itself
        // it is a class what used by other tests
        ApplicationRunner runner = new ApplicationRunner();

        String report = runner.run("src/main/resources/example-sales.csv");
        assertThat(report, containsString("- London          -    235 -"));
    }
}
