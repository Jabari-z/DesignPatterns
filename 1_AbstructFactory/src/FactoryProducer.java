import factory.AbstructFactory;
import factory.PrinterFactory;
import factory.ShapeFactory;

public class FactoryProducer {
    public static <AbstructFactory> AbstructFactory getFactory(String choice){
        // 根据名字选择工厂
        if(choice.equalsIgnoreCase("SHAPE")){
            return (AbstructFactory) new ShapeFactory();
        } else if(choice.equalsIgnoreCase("Printer")){
            return (AbstructFactory) new PrinterFactory();
        }
        return null;
    }
}
