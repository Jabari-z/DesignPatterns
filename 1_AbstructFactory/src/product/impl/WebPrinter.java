package product.impl;

import product.Printer;

public class WebPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("web打印机");
    }
}
