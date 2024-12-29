package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pencils = getNumberOfPencils(scanner);
        String currentPlayer = getFirstPlayer(scanner);

        playGame(scanner, pencils, currentPlayer);

        scanner.close();
    }

    private static int getNumberOfPencils(Scanner scanner) {
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (isNumeric(input)) {
                int pencils = Integer.parseInt(input);
                if (pencils > 0) {
                    return pencils;
                } else {
                    System.out.println("The number of pencils should be positive");
                }
            } else {
                System.out.println("The number of pencils should be numeric");
            }
        }
    }

    private static String getFirstPlayer(Scanner scanner) {
        System.out.println("Who will be the first (John, Jack):");
        while (true) {
            String player = scanner.nextLine().trim();
            if (player.equals("John") || player.equals("Jack")) {
                return player;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }
    }

    private static void playGame(Scanner scanner, int pencils, String currentPlayer) {
        while (pencils > 0) {
            System.out.println("|".repeat(pencils));
            System.out.println(currentPlayer + "'s turn!");

            int taken;
            if (currentPlayer.equals("Jack")) {
                taken = botTurn(pencils);
                System.out.println(taken); // Бот объявляет свой ход
            } else {
                taken = getPlayerTurn(scanner, pencils);
            }

            pencils -= taken;

            if (pencils > 0) {
                currentPlayer = switchPlayer(currentPlayer);
            }
        }
        System.out.println(currentPlayer.equals("John") ? "Jack won!" : "John won!");
    }

    private static int botTurn(int pencils) {
        // Выигрышная стратегия бота
        int remainder = pencils % 4;
        if (remainder == 0) {
            return 3;
        } else if (remainder == 3) {
            return 2;
        } else if (remainder == 2) {
            return 1;
        } else {
            // Проигрышная позиция, выбираем случайное число
            Random random = new Random();
            if (pencils == 1) {
                return 1; // Только 1 карандаш можно взять
            } else if (pencils == 2) {
                return random.nextInt(2) + 1; // Число от 1 до 2
            } else {
                return random.nextInt(3) + 1; // Число от 1 до 3
            }
        }
    }

    private static int getPlayerTurn(Scanner scanner, int pencils) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (isNumeric(input)) {
                int turn = Integer.parseInt(input);
                if (turn >= 1 && turn <= 3) {
                    if (turn <= pencils) {
                        return turn;
                    } else {
                        System.out.println("Too many pencils were taken");
                    }
                } else {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            } else {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String switchPlayer(String currentPlayer) {
        return currentPlayer.equals("John") ? "Jack" : "John";
    }
}
