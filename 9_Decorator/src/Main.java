//装饰模式在不链接其结构的情况下向现有对象添加新功能。
//它是一种结构型模式，因为它充当现有类的包装器。
//装饰模式创建一个装饰器类来包装原始类并提供其他功能。


interface Printer{
    void print();
}

// 具体
class PaperPrinter implements Printer{
    @Override
    public void print() {
        System.out.println("Paper Printer");
    }
}

class PlasticPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Plastic Printer");
    }
}

// 装饰器 抽象
abstract class PrinterDecorator implements Printer {
    protected Printer decoratedPrinter;
    public PrinterDecorator(Printer d){
        this.decoratedPrinter = d;
    }
    public void print(){
        decoratedPrinter.print();
    }
}

//具体装饰器 实现
class Printer3D extends PrinterDecorator{
    public Printer3D(Printer decoratedShape){
        super(decoratedShape);
    }

    @Override
    public void print() {
        System.out.println("3D.");
        decoratedPrinter.print();
    }
}
public class Main {
    public static void main(String[] args) {
        Printer plasticPrinter = new PlasticPrinter();
        // 装饰  传入 打印机对象
        Printer plastic3DPrinter = new Printer3D(new PlasticPrinter());
        Printer paper3DPrinter = new Printer3D(new PaperPrinter());

        plasticPrinter.print();
        plastic3DPrinter.print();
        paper3DPrinter.print();
    }

}
