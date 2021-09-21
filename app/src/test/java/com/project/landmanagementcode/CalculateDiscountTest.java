package com.project.landmanagementcode;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateDiscountTest {
    private CalculateDiscount calc;
    @BeforeEach
    public void setup(){
        calc = new CalculateDiscount();

    }

    @Test
    public void testDiscountt1(){

        int result = calc.disc_calcc(6,3);
        assertEquals(2,result);


    }



}
