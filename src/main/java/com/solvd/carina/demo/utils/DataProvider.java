package com.solvd.carina.demo.utils;

public class DataProvider {

    @org.testng.annotations.DataProvider(parallel = false, name = "ProductProvider")
    private static Object[][] productProvider() {
        return new Object[][]{
                {"TUID: Data_1", 0, "Sauce Labs Bike Light"},
                {"TUID: Data_2", 1, "Sauce Labs Bolt T-Shirt"},
                {"TUID: Data_3", 2, "Sauce Labs Onesie"},
                {"TUID: Data_4", 3, "Test.allTheThings() T-Shirt (Red)"},
                {"TUID: Data_5", 4, "Sauce Labs Backpack"},
                {"TUID: Data_6", 5, "Sauce Labs Fleece Jacket"}
        };
    }

    @org.testng.annotations.DataProvider(parallel = false, name = "ProductNameProvider")
    private static Object[][] productNameProvider() {
        return new Object[][]{
                {"TUID: Data_1", "Sauce Labs Bike Light"},
                {"TUID: Data_2", "Sauce Labs Bolt T-Shirt"},
                {"TUID: Data_3", "Sauce Labs Onesie"},
                {"TUID: Data_4", "Test.allTheThings() T-Shirt (Red)"},
                {"TUID: Data_5", "Sauce Labs Backpack"},
                {"TUID: Data_6", "Sauce Labs Fleece Jacket"}
        };
    }
}
