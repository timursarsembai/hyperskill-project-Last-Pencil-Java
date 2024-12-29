import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        String[] letters = str.split("");
        int sum = 0;
        for (String letter : letters) {
            if (letter.equals("g") || letter.equals("c")) {
                sum++;
            }
        }
        double res = (double) sum / str.length() * 100;
        System.out.println(res);
    }
}