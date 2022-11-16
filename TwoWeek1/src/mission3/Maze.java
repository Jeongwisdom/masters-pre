package mission3;

import java.util.Stack;

public class Maze {
    public static int[][] myMaze ={
            {0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}
    };

    static void printMyMaze() {
        for (int[] ints : myMaze) {
            for (int j = 0; j < myMaze.length; j++) {
                if (ints[j] == 0)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Stack<Integer> stackX = new Stack<>();
    static Stack<Integer> stackY = new Stack<>();

    static void DFS(int x, int y) {
        int xx;
        int yy;
        int i;
        stackX.push(x);
        stackY.push(y);

        for(i = 0; i < 4; i++) {
            xx = x + dx[i];
            yy = y + dy[i];
            if(xx == (myMaze.length-1) && yy == (myMaze.length-1)) {
                while (!stackX.isEmpty()) {
                    System.out.print("(" + stackX.elementAt(0) + "," + stackY.elementAt(0) + ") -> ");
                    stackX.remove(0);
                    stackY.remove(0);
                }
                System.out.println("(7,7)");
                return;
            }
            if(xx < 0 || yy < 0 || xx > 7 || yy > 7)
                continue;
            if(myMaze[xx][yy] == 0) {
                myMaze[xx][yy] = 2;
                DFS(xx, yy);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("출구는 (" + (myMaze.length-1) + "," + (myMaze.length-1) + ") 입니다.");
        printMyMaze();
        Maze.DFS(0,0);
    }
}
