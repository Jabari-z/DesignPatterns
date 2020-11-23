//桥接模式将定义与其实现分离。它是一种结构模式。
//
//        此模式涉及充当桥接的接口。桥使得具体类与接口实现者类无关。
//
//        这两种类型的类可以改变而不影响对方。

//接口
interface Printer {
    public void print(int radius, int x, int y);
}

// 实现 这里实现 不影响 draw
class ColorPrinter implements Printer {
    @Override
    public void print(int radius, int x, int y) {
        System.out.println("Color: " + radius +", x: " +x+", "+ y +"]");
    }
}
class BlackPrinter implements Printer {
    @Override
    public void print(int radius, int x, int y) {
        System.out.println("Black: " + radius +", x: " +x+", "+ y +"]");
    }
}
//抽象类
abstract class Shape {
//   桥接  打印机  关键点  ⬇️
    protected Printer print;

    protected Shape(Printer p){
        this.print = p;
    }
    public abstract void draw();
}
// 实现
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, Printer draw) {
        super(draw);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        print.print(radius,x,y);
    }
}
public class Main {
    public static void main(String[] args) {
//         构造函数 传什么 打印机🖨️  就怎么打印
        Shape redCircle = new Circle(100,100, 10, new ColorPrinter());
        Shape blackCircle = new Circle(100,100, 10, new BlackPrinter());

        redCircle.draw();
        blackCircle.draw();
    }
}