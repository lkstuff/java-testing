package com.laszlokiss.outsideInTesting;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ApplicationRunner{

    public String run(final String inputFile)
    {
        // instead of using regulas PrintStream build a string up
        // backs an outputStream onto a byte array
        ByteArrayOutputStream dummyOutput = new ByteArrayOutputStream();
        SalesReportRunner app = new SalesReportRunner(new PrintStream(dummyOutput));

        //when we run this our application writes into that PrintStream
        // PrintStream delegate our dummyOutput
        // dummyOutput converted to a string and our test test that string
        app.run(inputFile);

        try
        {
            return dummyOutput.toString("UTF-8");
        } catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
