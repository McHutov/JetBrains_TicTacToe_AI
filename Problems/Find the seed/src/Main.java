import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Random r;

        int max = 0;
        int min = 999_999_999;
        int seed = 0;

        for(int i = a; i <= b; i++) {
            r = new Random(i);
            for(int j = 0; j < n; j++){
                int numbers = r.nextInt(k);

                if(max < numbers){
                    max = numbers;
                }
            }

            if(max < min){
                min = max;
                seed = i;
            }

            max = 0;
        }

        System.out.println(seed + "\n" + min);
    }
}