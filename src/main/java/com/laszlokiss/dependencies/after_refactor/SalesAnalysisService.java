package com.laszlokiss.dependencies.after_refactor;


import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalysisService
{
    private final SalesRepository repo;

    // constructor injection for dependency
    // any for db solution
    public SalesAnalysisService(SalesRepository repo)
    {
        this.repo = repo;
    }

    public Map<String, Integer> tallyProductSales()
    {
        return tallySalesBy(Sale::getProduct);
    }

    public Map<String, Integer> tallyStoreSales()

    {
        return tallySalesBy(Sale::getStore);
    }



    private Map<String,Integer> tallySalesBy(Function<Sale, String> classifier)
    {
        return repo.loadSales()
                .stream()
                .collect(groupingBy(classifier,
                        summingInt(Sale::getValue)));
    }

}
