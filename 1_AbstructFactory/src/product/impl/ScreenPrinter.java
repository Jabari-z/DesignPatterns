package product.impl;

import product.Printer;

public class ScreenPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("screen打印机");
    }
}
