import java.util.Hashtable;

// 在原型模式中，将返回一个现有对象的克隆，而不是创建新的对象。
// 原型管理器
public class ShapeProtoType {
    private static Hashtable<String,Shape> shapeMap = new Hashtable<>();
//    根据id进行克隆
    public static Shape getShape(String shapeId){
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape)cachedShape.clone();
    }

//    创建好原型
    public static void loadCache() {
        Circle circle = new Circle();

        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
