import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split("");
        String res = "";
        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i].equals(arr[i-1])) {
                count++;
            } else {
                res += arr[i-1].toString() + count;
                count = 1;
            }
        }
        res += arr[arr.length - 1].toString() + count;
        System.out.print(res);
    }
}