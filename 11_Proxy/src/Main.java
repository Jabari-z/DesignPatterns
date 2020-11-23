//在代理模式中，一个类代表另一个类的功能。代理模式是一种结构模式。
//在代理模式中，我们创建具有原始接口的对象，以将其功能暴露给外部世界。
interface Printer {
    void print();
}
class ConsolePrinter implements Printer {
    private String fileName;

    public ConsolePrinter(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void print() {
        System.out.println("Displaying " + fileName);
    }
}

// 代理 关键点 ⬇️
class ProxyPrinter implements Printer{
    private ConsolePrinter consolePrinter; // 代理的对象
    private String fileName;

    public ProxyPrinter(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void print() {
        if(consolePrinter == null){
            consolePrinter = new ConsolePrinter(fileName);
        }
        consolePrinter.print();
    }
}
public class Main {
    public static void main(String[] args) {
        Printer image = new ProxyPrinter("test");
        image.print();
    }
}