import java.util.Scanner;

class Main {
    public static void decompositions(int n,int i, String result){
        if(n == 0){
            System.out.println(result);
            return;
        }

        for(int j = 1; j <= Math.min(n,i); j++){
            decompositions(n-j,j, result + j + " ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        decompositions(n,n,"");
    }
}




//1 1 1 1 1 1 1 1 1 1
//2 1 1 1 1 1 1 1 1
//2 2 1 1 1 1 1 1
//2 2 2 1 1 1 1
//2 2 2 2 1 1
//2 2 2 2 2
//3 1 1 1 1 1 1 1
//3 2 1 1 1 1 1
//3 2 2 1 1 1
//3 2 2 2 1
//3 3 1 1 1 1
//3 3 3 1
//4 1 1 1 1 1 1
//4 2 1 1 1 1
//4 2 2 1 1
//4 2 2 2
//4 3 1 1 1
//4 3 2 1
//4 3 3
//4 4 1 1
//4 4 2
//5 1 1 1 1 1
//5 2 1 1 1
//5 2 2 1
//5 3 1 1
//5 3 2
//5 4 1
//5 5
//6 1 1 1 1
//6 2 1 1
//6 2 2
//6 3 1
//6 4
//7 1 1 1
//7 2 1
//7 3
//8 1 1
//8 2
//9 1
//10
