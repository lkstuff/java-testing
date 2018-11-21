package com.laszlokiss.outsideInTesting;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SalesAnalyserTest
{
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Ózd", 10, 200 ),
            new Sale( "Ózd", 3, 500),
            new Sale( "Ózd", 6, 200),
            new Sale( "Budapest", 5, 700)
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

        SalesAnalyser analyser = new SalesAnalyser(mockRepo);

        //when
        Map<String, Integer> storeSales = analyser.tallyCitySales();

        //then
        assertEquals("Calculated wrong store sales", expectedStoreSales, storeSales);
        verify(mockRepo, times(1)).loadSales();
    }

}
