package java.seminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;
import seminar.Door;
import seminar.MontyHallGame;

public class MontyHallGameTest {

    private MontyHallGame montyHallGame;

    @BeforeEach
    void setup() {
        montyHallGame = new MontyHallGame();
    }

    @Test
    void playgametestNoSwitch() {
        MontyHallGame montyHallGame = new MontyHallGame();
        boolean result = montyHallGame.playGame(false);
        Assertions.assertTrue(result);
    }

    @Test
    void playGameWithSwitch() {
        MontyHallGame montyHallGame = new MontyHallGame();
        boolean result = montyHallGame.playGame(true);
        Assertions.assertTrue(result);
    }

    @Test
    void doorInitializationTest() {
        MontyHallGame game = new MontyHallGame();
        Door[] doors = game.getDoors();

        int carCount = 0;
        for (Door door : doors) {
            if (door.hasCar()) {
                carCount++;
            }
        }
        // Проверяем, что только одна дверь содержит машину
        Assertions.assertEquals(1, carCount);
    }

    @Test
    void getHostOpensCorrectDoorTest() {
        MontyHallGame game = new MontyHallGame();
        int playerChoice = 0;
        int hostOpens = game.getHostOpens(playerChoice);

        Assertions.assertNotEquals(playerChoice, hostOpens);
        Assertions.assertFalse(game.getDoors()[hostOpens].hasCar());

    }

    @Test
    void testsReproducibility() {
        Random random = new Random(42);
        MontyHallGame game = new MontyHallGame();

        Door[] doors = game.getDoors();
        int choosenDoor = random.nextInt(doors.length);

        Assertions.assertEquals(1, choosenDoor);
    }

    @Test
    void testInvalidDoorChoice() {
        MontyHallGame game = new MontyHallGame();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.getHostOpens(-1); // Неверный индекс для двери
        });
    }

}
