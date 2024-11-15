package seminar;

public class MontyHall {
    public static void main(String[] args) {
        int totalGames = 1000;
        int stayWins = 0;
        int switchWins = 0;
        MontyHallGame game = new MontyHallGame();

        for (int i = 0; i < totalGames; i++) {
            if (game.playGame(false)) { // Не меняем дверь
                stayWins++;
            }
            if (game.playGame(true)) { // Меняем дверь
                switchWins++;
            }
        }

        System.out.println("Результаты после 1000 игр:");
        System.out.println("Победы, если не менять дверь: " + stayWins);
        System.out.println("Победы, если менять дверь: " + switchWins);
    }
}
