import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    private final Random random = new Random();

    public static void main(String[] args) {

        App app = new App();
        Scanner scan = new Scanner(System.in);
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println("Enter box number to select. Enjoy!\n");

        // Викликаємо новий метод, щоб показати початковий стан поля гри
        displayGameBoard(box);

        byte winner = 0;
        while (winner == 0) {
            // Хід гравця
            byte playerMove = getPlayerMove(scan, box);
            box[playerMove - 1] = 'X';
            displayGameBoard(box);
            // Перевірка на перемогу гравця після його ходу
            winner = checkWinner(box);
            if (winner != 0) break;

            // Хід комп'ютера
            byte computerMove = app.getComputerMove(box);
            box[computerMove] = 'O';
            displayGameBoard(box);

            // Перевірка на перемогу комп'ютера після його ходу
            winner = checkWinner(box);
        }

        // Вивід результату гри
        displayGameResult(winner);
    }

    public static void displayGameBoard(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    // Метод для отримання ходу гравця
    public static byte getPlayerMove(Scanner scan, char[] box) {
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    return input;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    public static byte checkWinner(char[] box) {
        // Перевірка по рядках
        for (int i = 0; i <= 6; i += 3) {
            if (box[i] == box[i + 1] && box[i] == box[i + 2]) {
                return (byte) (box[i] == 'X' ? 1 : 2);
            }
        }

        // Перевірка по стовпцях
        for (int i = 0; i < 3; i++) {
            if (box[i] == box[i + 3] && box[i] == box[i + 6]) {
                return (byte) (box[i] == 'X' ? 1 : 2);
            }
        }

        // Перевірка по діагоналі
        if ((box[0] == box[4] && box[0] == box[8]) || (box[2] == box[4] && box[2] == box[6])) {
            return (byte) (box[4] == 'X' ? 1 : 2);
        }

        // Перевірка на нічию
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return 0; // Продовжуємо гру, ще є незаповнені клітинки
            }
        }

        return 3; // Нічия, всі клітинки заповнені, але немає переможця
    }

    public byte getComputerMove(char[] box) {
        List<Byte> availableMoves = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                availableMoves.add((byte) i);
            }
        }

        if (!availableMoves.isEmpty()) {

            int randomIndex = this.random.nextInt(availableMoves.size());

            return availableMoves.get(randomIndex);
        }
        throw new NoAvailableMovesException("No available moves.");
    }

    public static void displayGameResult(byte winner) {

        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");

        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");

        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");

        }
    }
}