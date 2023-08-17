public class Winner {

    Winner win = new Winner();

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
}
