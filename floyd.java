import java.util.*;
public class floyd {
    static int cost[][], n;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        readm();
        floyds();
        printm();
    }

    static void readm() {
        System.out.print("Enter the number of nodes:");
        n = in.nextInt();
        cost = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = in.nextInt();
    }

    static void floyds() {
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if ((cost[i][k] + cost[k][j]) < cost[i][j])
                        cost[i][j] = cost[i][k] + cost[k][j];
    }

    static void printm() {
        System.out.println("The all pair shortest path matrix is:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++)
                System.out.print(cost[i][j]+ "\t");
            System.out.println("\n");
        }
    }
}