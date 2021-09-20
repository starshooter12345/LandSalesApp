package com.project.landmanagementcode;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CalculateDiscountTest {
    private CalculateDiscount calc;
    @BeforeEach
    public void setup(){
        calc = new CalculateDiscount();

    }


    @Test
    public void testDiscountt(){

        int result = calc.disc_calcc(6,3);
        assertEquals(2,result);

    }


}
