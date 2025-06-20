package coffee.order;

public class App {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Lucifer");
        board.add("Satan");
        board.add("Stepan");
        board.draw();
        board.deliver();
    }
}
