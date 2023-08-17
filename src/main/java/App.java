import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println("Enter box number to select. Enjoy!\n");

        // Викликаємо новий метод, щоб показати початковий стан поля гри
        Display.displayGameBoard(box);

        byte winner = 0;
        while (winner == 0) {
            // Хід гравця
            byte playerMove = Move.getPlayerMove(scan, box);
            box[playerMove - 1] = 'X';
            Display.displayGameBoard(box);
            // Перевірка на перемогу гравця після його ходу
            winner = Winner.checkWinner(box);
            if (winner != 0) break;

            // Хід комп'ютера
            Move move = new Move();
            byte computerMove = move.getComputerMove(box);
            box[computerMove] = 'O';
            Display.displayGameBoard(box);

            // Перевірка на перемогу комп'ютера після його ходу
            winner = Winner.checkWinner(box);
        }

        // Вивід результату гри
        Result.displayGameResult(winner);
    }


}