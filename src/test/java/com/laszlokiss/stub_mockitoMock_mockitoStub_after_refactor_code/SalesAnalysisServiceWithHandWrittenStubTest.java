package com.laszlokiss.stub_mockitoMock_mockitoStub_after_refactor_code;

import com.laszlokiss.dependencies.after_refactor.Sale;
import com.laszlokiss.dependencies.after_refactor.SalesAnalysisService;
import com.laszlokiss.dependencies.after_refactor.SalesRepository;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SalesAnalysisServiceWithHandWrittenStubTest
{

    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Apples", "Ózd", 10, 200 ),
            new Sale("Oranges", "Ózd", 3, 500),
            new Sale("Bananas", "Ózd", 6, 200),
            new Sale("Oranges", "Budapest", 5, 700)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
    static {
        expectedStoreSales.put("Ózd", 4700);
        expectedStoreSales.put("Budapest", 3500);
    }

    @Test
    public void shouldAggregateStoreSales()
    {
        // given
        //stub -- hand-written
        // use a new anonymous in a class
        // class got no name jut in-lines in the method implementation
        //  call loadSales and return exampleSales from up.
        SalesRepository stubRepo = new SalesRepository(){
            @Override
            public List<Sale> loadSales(){
                return exampleSales;
            }
        };
        SalesAnalysisService analysisService = new SalesAnalysisService(stubRepo);

        //when
         Map<String, Integer> storeSales = analysisService.tallyStoreSales();

         //then
         assertEquals(expectedStoreSales, storeSales);
    }
}
