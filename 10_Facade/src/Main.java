// 外观模式
// 隐藏了系统的复杂性
// 它为客户端提供了一个简单的接口，客户端使用接口与系统交互。

class ShapeFacade {
    // 接口
    interface Shape {
        void draw();
    }
    //具体
    class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Rectangle::draw()");
        }
    }
    //具体
    class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Square::draw()");
        }
    }
    //具体
    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Circle::draw()");
        }
    }
    //    它为客户端提供了一个简单的接口，
    private Shape circle = new Circle();
    private Shape rectangle = new Rectangle();
    private Shape square = new Square();

    public ShapeFacade() {
    }
    public void drawCircle() {
        circle.draw();
    }
    public void drawRectangle() {
        rectangle.draw();
    }
    public void drawSquare() {
        square.draw();
    }
}
public class Main {
    public static void main(String[] args) {
        ShapeFacade shapeFacade = new ShapeFacade();
        shapeFacade.drawCircle();
        shapeFacade.drawRectangle();
        shapeFacade.drawSquare();
    }
}