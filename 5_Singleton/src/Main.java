public class Main {
    public static void main(String[] args) {
        //Get the only object available
        MainWindow object = MainWindow.getInstance();
        MainWindow obj = MainWindow.getInstance();

        System.out.println(obj);
        System.out.println(object);

        //show the message
        object.showMessage();
    }
}