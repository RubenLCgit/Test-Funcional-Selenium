package org.selenium;

import BaseTest.BaseTest;

public class Main {
    public static void main(String[] args) /*throws InterruptedException*/ {

        BaseTest test = new BaseTest();
        test.setup();
        test.aceptCookie();
        test.searchProduct();
    }
}