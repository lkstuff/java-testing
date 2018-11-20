package com.laszlokiss.stub_mockitoMock_mockitoStub_after_refactor_code;

import com.laszlokiss.dependencies.after_refactor.Sale;
import com.laszlokiss.dependencies.after_refactor.SalesAnalysisService;
import com.laszlokiss.dependencies.after_refactor.SalesRepository;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalesAnalysisServiceWithMockitoStubTest
{
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Apples", "Ózd", 10, 200 ),
            new Sale("Oranges", "Ózd", 3, 500),
            new Sale("Bananas", "Ózd", 6, 200),
            new Sale("Oranges", "Budapest", 5, 700)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
    static
    {
        expectedStoreSales.put("Ózd", 4700);
        expectedStoreSales.put("Budapest", 3500);
    }

    @Test
    public void shouldAggregateStoreSales()
    {
        //given

        //Mockito uses a mock extensively often means mock&stub
        // we using here for stubing
        SalesRepository stubRepo =mock(SalesRepository.class);
        // we have to tell mockito what to return
        when(stubRepo.loadSales()).thenReturn(exampleSales);


        SalesAnalysisService analysisService = new SalesAnalysisService(stubRepo);

        //when
        Map<String, Integer> storeSales = analysisService.tallyStoreSales();

        //then
        assertEquals(expectedStoreSales, storeSales);
    }
}
