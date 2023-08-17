import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Move {

    private final Random random = new Random();

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

}
