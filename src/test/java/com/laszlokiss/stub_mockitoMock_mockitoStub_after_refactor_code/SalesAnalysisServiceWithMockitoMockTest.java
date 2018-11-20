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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SalesAnalysisServiceWithMockitoMockTest
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

        SalesRepository mockRepo =mock(SalesRepository.class);
        // we have to tell mockito what to return
        when(mockRepo.loadSales()).thenReturn(exampleSales);

        SalesAnalysisService analysisService = new SalesAnalysisService(mockRepo);

        //when
        Map<String, Integer> storeSales = analysisService.tallyStoreSales();

        //then
        //assertEquals(expectedStoreSales, storeSales);
        // have to verify tallyStoreSales has called the loadSales
        // not just hardcoded
        verify(mockRepo).loadSales();
    }


}
