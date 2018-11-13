package com.laszlokiss.cafeForTesting;

import org.junit.*;

import static com.laszlokiss.cafeForTesting.CoffeeType.ESPRESSO;
import static com.laszlokiss.cafeForTesting.CoffeeType.LATTE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CafeTest
{

    public static final int ESPRESSO_BEANS = ESPRESSO.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    private Cafe cafe;


    // to demonstrate in the terminal before after concept --->
    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("after class");
    }

    @After
    public void after()
    {
        System.out.println("after");
    }

    public CafeTest()
    {
        System.out.println("constructor");
    }

    // <--- to demonstrate in the terminal before after concept

    @Before
    public void before()
    {
        cafe = new Cafe();
        System.out.println("before");
    }



    @Test
    public void canBrewEspresso(){
        // given clause
        withBeans();

        // when clause
        Coffee coffee = cafe.brew(ESPRESSO);

        // then clause

        assertEquals("Wrong coffee type", ESPRESSO, coffee.getType()); // is it an expresso!
        assertEquals("Wrong amount of milk", 0, coffee.getMilk()); // no milk in espresso
        assertEquals("Wrong number of beans", 8, coffee.getBeans());// that we've got enough cofee


        assertThat(coffee, hasProperty("beans"));
        assertThat(coffee, hasProperty("beans", equalTo(ESPRESSO_BEANS)));

        assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
        assertEquals("Wrong coffee type", ESPRESSO, coffee.getType());
    }


    @Test
    public void brewingEspressoConsumesBeans()
    {
        // given clause
        withBeans();

        // when clause
        cafe.brew(ESPRESSO);

        // then clause
        //Assert.assertEquals(0, cafe.getBeanInStock());
        assertEquals(NO_BEANS, cafe.getBeanInStock());
    }

    @Test
    public void canBrewLatte()
    {
        //given
        withBeans();
        cafe.restockMilk(LATTE.getRequiredMilk());

        //when
        Coffee coffee = cafe.brew(LATTE);

        //then
        assertEquals("Wrong coffee type", LATTE, coffee.getType());
    }



    @Test(expected = IllegalArgumentException.class)
    public void mustRestoreMilk()
    {
        //when
        cafe.restockMilk(NO_MILK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestoreBeans()
    {
        //when
        cafe.restockBeans(NO_BEANS);
    }


    // then clause we need to say exeptions are okey
    @Test(expected = IllegalStateException.class)
    public void lattesRequireMilk()
    {
        // given clause
        withBeans();

        // when clause
        cafe.brew(LATTE);
    }

    //extrated duplications in method
    private void withBeans()
    {
        cafe.restockBeans(ESPRESSO_BEANS);
    }


}
