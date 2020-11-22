import part.MainWindow;

public class Main {
    public static void main(String[] args) {
        // 生成器模式用于使用简单对象创建复杂对象。它从小而简单的对象逐步创建更大的对象。
        MainWindow obj = WindowBuilder.createWindow();
    }
}
