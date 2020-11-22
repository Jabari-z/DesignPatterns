package product.impl;

import product.Printer;

public class PaperPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("paper打印机");
    }
}
