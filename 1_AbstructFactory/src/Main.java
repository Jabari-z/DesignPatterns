import factory.AbstructFactory;
import product.Printer;
import product.Shape;

public class Main {
    public static void main(String[] args) {

        //抽象工厂的得到具体工厂
        AbstructFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //从工厂得到一个圆
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //call draw method of product.Shape product.Circle
        shape1.draw();

        //从工厂的得一个长方形
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //call draw method of product.Shape product.product.impl.Rectangle
        shape2.draw();

        //从工厂的得一个长方形
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //call draw method of product.Shape product.product.impl.Square
        shape3.draw();

        //////////////////////////////////////////////////////////////////////////////////////
        //打印机工厂
        AbstructFactory printerFactory = FactoryProducer.getFactory("printer");

        Printer printer1 = printerFactory.getPrinter("Paper");
        printer1.print();
        Printer printer2 = printerFactory.getPrinter("Web");
        printer2.print();
        Printer printer3 = printerFactory.getPrinter("Screen");
        printer3.print();
    }
}