package factory;

import product.*;
import product.impl.PaperPrinter;
import product.impl.ScreenPrinter;
import product.impl.WebPrinter;

public class PrinterFactory extends AbstructFactory {
    @Override
    public Printer getPrinter(String type) {
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("paper")){
            return new PaperPrinter();
        } else if(type.equalsIgnoreCase("web")){
            return new WebPrinter();
        } else if(type.equalsIgnoreCase("Screen")){
            return new ScreenPrinter();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
