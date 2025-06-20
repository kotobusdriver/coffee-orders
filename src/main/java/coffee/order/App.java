package coffee.order;

public class App {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Mephistopheles");
        board.add("Lucifer");
        board.add("Satan");
        board.add("Stepan");
        board.draw();
        board.deliver();
        board.deliver();
        board.deliver(1);
        board.deliver(3);
    }
}
