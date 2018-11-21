package com.laszlokiss.outsideInTesting;

import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalyser
{

    private final SalesRepository repo;

    public SalesAnalyser(SalesRepository repo){
        this.repo = repo;
    }

    public Map<String, Integer> tallyCitySales()
    {
        // load up the sales, stream them and collect the result together
        return repo.loadSales().
                stream().collect(groupingBy(Sale::getStore,
                summingInt(Sale::getValue)));

    }
}
