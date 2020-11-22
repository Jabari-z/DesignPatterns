class MainWindow {
    //create an object of MainWindow
    //    static
    private static MainWindow instance = new MainWindow();

    //make the constructor private so that this class cannot be
    //instantiated by other class
    //    private
    private MainWindow(){}

    //Get the only object available
    //  public
    public static MainWindow getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World! Singleton");
    }
}