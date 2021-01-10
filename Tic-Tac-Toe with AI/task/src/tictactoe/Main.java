package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[][] chars = new String[3][3];
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static String coordinates = "";

    public static void main(String[] args) {

        String command;
        boolean entrance = true;

        do {
            System.out.print("Input command: ");
            entrance = true;
            command = scanner.nextLine();
            String[] arguments = command.split("\\s+");

            if ("exit".equals(command)) {
                break;
            } else if (arguments.length != 3 || !"start".equals(arguments[0])) {
                System.out.println("Bad parameters!");
                continue;
            }

            System.out.println();

            for (String[] s : chars) {
                Arrays.fill(s, " ");
            }

            print();
            first:{
                for (int i = 0; i < 9; i++) {
                    do {
                        chekPlayers(arguments[1], arguments[2], i);
                    } while (enterSymbol(coordinates, i));
                    print();
                    if (i > 3) {
                        switch (chekWinner()) {
                            case "X":
                                System.out.println("X wins");
                                entrance = false;
                                break first;
                            case "O":
                                System.out.println("O wins");
                                entrance = false;
                                break first;
                            case "D":
                                System.out.println("Draw");
                                entrance = false;
                                break first;
                            case "G":
                                System.out.println("Game not finished");
                                entrance = false;
                                break first;
                        }
                    }
                }

            }
        }while (true);

    }

    public static void chekPlayers(String player1, String player2, int turn){
        switch (player1){
            case "easy":
                switch (player2){
                    case "easy":
                        setCoordinates("easy",0);
                        break;
                    case "user":
                        if(turn % 2 == 0){
                            setCoordinates("easy",0);
                        }else{
                            setCoordinates("user",0);
                        }
                        break;
                    case "medium":
                        if(turn % 2 == 0){
                            setCoordinates("easy",0);
                        }else{
                            setCoordinates("medium",0);
                        }
                        break;
                    case "hard":
                        if(turn % 2 == 0){
                            setCoordinates("easy",0);
                        }else{
                            setCoordinates("hard",1);
                        }
                        break;
                }
                break;
            case "user":
                switch (player2){
                    case "user":
                        setCoordinates("user",0);
                        break;
                    case "easy":
                        if(turn % 2 == 0){
                            setCoordinates("user",0);
                        }else{
                            setCoordinates("easy",0);
                        }
                        break;
                    case "medium":
                        if(turn % 2 == 0){
                            setCoordinates("user",0);
                        }else{
                            setCoordinates("medium",0);
                        }
                        break;
                    case "hard":
                        if(turn % 2 == 0){
                            setCoordinates("user",0);
                        }else{
                            setCoordinates("hard",1);
                        }
                        break;
                }
                break;
            case "medium":
                switch (player2){
                    case "easy":
                        if(turn % 2 == 0){
                            setCoordinates("medium",0);
                        }else{
                            setCoordinates("easy",0);
                        }
                        break;
                    case "user":
                        if(turn % 2 == 0){
                            setCoordinates("medium",0);
                        }else{
                            setCoordinates("user",0);
                        }
                        break;
                    case "medium":
                        setCoordinates("medium",0);
                        break;
                    case "hard":
                        if(turn % 2 == 0){
                            setCoordinates("medium",0);
                        }else{
                            setCoordinates("hard",1);
                        }
                }
                break;
            case "hard":
                switch (player2){
                    case "easy":
                        if(turn % 2 == 0){
                            setCoordinates("hard",0);
                        }else{
                            setCoordinates("easy",0);
                        }
                        break;
                    case "user":
                        if(turn % 2 == 0){
                            setCoordinates("hard",0);
                        }else{
                            setCoordinates("user",0);
                        }
                        break;
                    case "medium":
                        if(turn % 2 == 0){
                            setCoordinates("hard",0);
                        }else{
                            setCoordinates("medium",0);
                        }
                        break;
                    case "hard":
                        if(turn % 2 == 0){
                            setCoordinates("hard",0);
                        }else{
                            setCoordinates("hard",1);
                        }
                }
                break;
        }
    }

    public static String mediumLvl(){
        String arr[] = new String[3];
        int sign = 0 ;

        exit:
        {
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 4; j++) {
                    String line = "";
                    for (int k = 1; k < 4; k++) {
                        if (i == 0) {
                            line += chars[j-1][k-1];
                            arr[k-1] = (j) + " " + (k);
                        } else {
                            if (i == 1) {
                                line += chars[k-1][j-1];
                                arr[k-1] = (k) + " " + (j);
                            } else {
                                if (i == 2) {
                                    if(j == 1) {
                                        line = chars[0][0] + chars[1][1] + chars[2][2];
                                        arr[0] = "1 1";
                                        arr[1] = "2 2";
                                        arr[2] = "3 3";
                                    }
                                    if(j == 2){
                                        line = chars[0][2] + chars[1][1] + chars[2][0];
                                        arr[0] = "1 3";
                                        arr[1] = "2 2";
                                        arr[2] = "3 1";
                                    }
                                }
                            }
                        }
                    }
                    if (line.equals("XX ") || line.equals("OO ")) {
                        sign = 1;
                        break exit;
                    } else {
                        if (line.equals(" XX") || line.equals(" OO")) {
                            sign = 2;
                            break exit;
                        } else {
                            if (line.equals("X X") || line.equals("O O")) {
                                sign = 3;
                                break exit;
                            } else {
                                sign = 4;
                            }
                        }
                    }
                }
            }
        }
        switch (sign) {
            case 1:
                return arr[2];
            case 2:
                return arr[0];
            case 3:
                return arr[1];
            case 4:
                String coor = (random.nextInt(3) + 1) + " " + (random.nextInt(3) + 1);
                return coor;
            default:
                return "";
        }
    }

    public static void setCoordinates(String lvl, int turnHard){
        switch (lvl){
            case "user":
                System.out.print("Enter the coordinates: ");
                coordinates = scanner.nextLine();
                break;
            case "easy":
                System.out.println("Making move level \"easy\"");
                coordinates = (random.nextInt(3) + 1) + " " + (random.nextInt(3) + 1);
                break;
            case "medium":
                System.out.println("Making move level \"medium\"");
                coordinates = mediumLvl();
                break;
            case "hard":
                System.out.println("Making move level \"hard\"");
                coordinates = hardLevel(turnHard);
                break;
        }
    }

    public static String hardLevel(int turn){
        if(turn == 1) {
            int bestScore = Integer.MAX_VALUE;
            String move = "";

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (chars[i][j] == " ") {
                        chars[i][j] = "O";
                        int score = minimax(chars,12,Integer.MIN_VALUE,Integer.MAX_VALUE, true);
                        chars[i][j] = " ";
                        if (score < bestScore) {
                            bestScore = score;
                            move = (i + 1) + " " + (j + 1);
                        }
                    }
                }
            }
            return move;
        }else{
            int bestScore = Integer.MIN_VALUE;
            String move = "";

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (chars[i][j] == " ") {
                        chars[i][j] = "X";
                        int score = minimax(chars, 12,Integer.MIN_VALUE,Integer.MAX_VALUE, false);
                        chars[i][j] = " ";
                        if (score > bestScore) {
                            bestScore = score;
                            move = (i + 1) + " " + (j + 1);
                        }
                    }
                }
            }
            return move;
        }

    }

    public static int minimax(String[][] board,int depth, int alpha, int beta,boolean isMax){
        String score = chekWinner();

        if (score.equals("X"))
            return 10;
        if (score.equals("O"))
            return -10;
        if (score.equals("D"))
            return 0;

        if (isMax) {
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals(" ")) {
                        board[i][j] = "X";

                        best = Math.max(best, minimax(board, depth-1,alpha,beta, !isMax));
                        board[i][j] = " ";
                        alpha = Math.max(alpha,best);
                        if(alpha>=beta){
                            return best;
                        }
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals(" ")) {
                        board[i][j] = "O";

                        best = Math.min(best, minimax(board, depth - 1,alpha,beta, !isMax));
                        board[i][j] = " ";
                        beta = Math.min(beta, best);
                        if(beta<=alpha){
                            return best;
                        }
                    }
                }
            }
            return best;
        }
    }

    public static boolean enterSymbol(String coordinates, int turn){
        if(coordinates.matches("\\d \\d")){
            int i = Integer.parseInt(String.valueOf(coordinates.charAt(0)));
            int j = Integer.parseInt(String.valueOf(coordinates.charAt(2)));

            if(i > 0 &&  i < 4 && j > 0 &&  j < 4){
                if (chars[i-1][j-1].equals(" ")) {
                    if(turn % 2 == 0) {
                        chars[i-1][j-1] = "X";
                    }else{
                        chars[i-1][j-1] = "O";
                    }
                    return false;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }else{
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }else{
            System.out.println("You should enter numbers!");
        }
        return true;
    }

    public static void print() {
        System.out.println("---------");
        System.out.println("| " + chars[0][0] + " " + chars[0][1] + " " + chars[0][2] + " |");
        System.out.println("| " + chars[1][0] + " " + chars[1][1] + " " + chars[1][2] + " |");
        System.out.println("| " + chars[2][0] + " " + chars[2][1] + " " + chars[2][2] + " |");
        System.out.println("---------");
    }

    public static String chekWinner() {
        if(check("O")){
            return "O";
        }else{
            if(check("X")){
                return "X";
            }else {
                if(!haveSpace()){
                    return "D";
                }
            }
        }
        return "";
    }
    public static boolean haveSpace() {
        for (int i = 0; i < 3; i++) {
            if (Arrays.asList(chars[i]).contains(" ")) {
                return true;
            }
        }
        return false;
    }

    public static int countX() {
        int countX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                if(chars[i][j].equals("X")){
                    countX++;
                }
            }
        }
        return countX;
    }

    public static int countO() {
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                if(chars[i][j].equals("O")){
                    countO++;
                }
            }
        }
        return countO;
    }

    public static boolean check(String sign) {
        for (int i = 0; i < 8; i++) {
            String line = "";
            switch (i) {
                case 0:
                    line += chars[0][0] + chars[0][1] + chars[0][2];
                    break;
                case 1:
                    line += chars[1][0] + chars[1][1] + chars[1][2];
                    break;
                case 2:
                    line += chars[2][0] + chars[2][1] + chars[2][2];
                    break;
                case 3:
                    line += chars[0][0] + chars[1][0] + chars[2][0];
                    break;
                case 4:
                    line += chars[0][1] + chars[1][1] + chars[2][1];
                    break;
                case 5:
                    line += chars[0][2] + chars[1][2] + chars[2][2];
                    break;
                case 6:
                    line += chars[0][2] + chars[1][1] + chars[2][0];
                    break;
                case 7:
                    line += chars[0][0] + chars[1][1] + chars[2][2];
                    break;
            }
            switch (sign) {
                case "X":
                    if (line.equals("XXX")) {
                        return true;
                    }
                    break;
                case "O":
                    if (line.equals("OOO")) {
                        return true;
                    }
                    break;
            }

        }

        return false;
    }
}
