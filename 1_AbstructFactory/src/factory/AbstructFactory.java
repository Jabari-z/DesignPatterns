package factory;
import product.Printer;
import product.Shape;

public abstract class AbstructFactory {
//    抽象工厂
    public abstract Printer getPrinter(String type);
    public abstract Shape getShape(String shapeType);
}
