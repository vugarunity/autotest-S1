package seminar;

import java.util.Random;

public class MontyHallGame {
    private final Door[] doors;
    private final Player player;
    private final Random random;

    public MontyHallGame() {
        doors = new Door[3];
        player = new Player();
        random = new Random();
    }

    public Door[] getDoors() {
        return doors;
    }

    // Метод для игры
    public boolean playGame(boolean switchChoice) {
        // Инициализация дверей (одна с машиной, две с козами)
        doors[0] = new Door(random.nextBoolean());
        doors[1] = new Door(random.nextBoolean());
        doors[2] = new Door(random.nextBoolean());

        // Игрок выбирает случайную дверь
        int playerChoice = random.nextInt(3);
        player.chooseDoor(playerChoice);

        // Ведущий открывает дверь с козой
        int hostOpens = -1;
        for (int i = 0; i < 3; i++) {
            if (i != playerChoice && !doors[i].hasCar()) {
                hostOpens = i;
                break;
            }
        }
        // Если игрок решил поменять дверь
        if (switchChoice) {
            // Игрок меняет выбор на оставшуюся дверь
            for (int i = 0; i < 3; i++) {
                if (i != playerChoice && i != hostOpens) {
                    player.switchDoor(i);
                    break;
                }
            }
        }
        // Проверяем, выиграл ли игрок
        return doors[player.getChosenDoor()].hasCar();
    }

    public int getHostOpens(int playerChoice) {
        for (int i = 0; i < doors.length; i++) {
            if (i != playerChoice && !doors[i].hasCar()) {
                return i;
            }
        }
        return -1;
    }

}
