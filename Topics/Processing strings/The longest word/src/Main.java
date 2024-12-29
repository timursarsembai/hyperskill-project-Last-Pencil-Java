import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        String res = arr[0];
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i+1].length() > res.length()) {
                res = arr[i+1];
            }
        }
        System.out.println(res);
    }
}