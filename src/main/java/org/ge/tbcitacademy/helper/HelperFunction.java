package org.ge.tbcitacademy.helper;

public class HelperFunction {
    public static double parseToDouble(String price) {
        return Double.parseDouble(price.replaceAll("[^\\d]", ""));
    }
}
