package factory;

import product.Circle;
import product.Printer;
import product.Shape;
import product.impl.Rectangle;
import product.impl.Square;

public class ShapeFactory extends AbstructFactory {
//Shape工厂
    @Override
    public Printer getPrinter(String shapeType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        //根据不同的shapeType选择不同的形状
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
