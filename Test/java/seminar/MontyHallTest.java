package java.seminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar.MontyHallGame;

public class MontyHallTest {

    @Test
    void probabilityTest() {
        MontyHallGame game = new MontyHallGame();
        int totalGames = 1000;
        int stayWins = 0;
        int switchWins = 0;

        for (int i = 0; i < totalGames; i++) {
            if (game.playGame(false)) { // Игрок не меняет дверь
                stayWins++;
            }
            if (game.playGame(true)) { // Игрок меняет дверь
                switchWins++;
            }
        }

        System.out.println("Победы без смены двери: " + stayWins);
        System.out.println("Победы со сменой двери: " + switchWins);

        Assertions.assertTrue(switchWins > stayWins, "Победы при смене двери должны быть больше");
    }

}
