package org.ge.tbcitacademy.data;

import org.testng.annotations.DataProvider;

public class priceDataProvider {
    @DataProvider(name = "priceData")
    public Object[][] priceData() {
        return new Object[][]{
                {"100","1000"},
                {"1","20"},
                {"5000","15000"},
                {"15000","0"},
                {"123","9999"},
        };
    }
}
