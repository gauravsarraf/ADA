import java.util.*;
public class prim
{
    static int cost[][], n;
    static Scanner in = new Scanner(System.in);

    public static void main(String [] args)
    {
        readm();
        prims();
    }

    static void readm()
    {
        System.out.print("Enter the number of nodes:");
        n = in.nextInt();
        cost = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                cost[i][j] = in.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
    }

    static void prims()
    {
        int visited[] = new int[10];
        int ne = 1, min, i, j, a = 0, v = 0, b = 0, u = 0;
        int mincost = 0;
        visited[1] = 1;
        while (ne < n)
        {
            for (i = 0, min = 999; i < n; i++ )
                for (j =0; j < n; j++)
                    if (cost[i][j] < min)
                        if (visited[i] != 0)
                        {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;
                        }
            if (visited[u] == 0 || visited[v] == 0)
            {
                System.out.println("Edge "+ne++ +":("+a+", "+b+")"+"cost:"+min);
                mincost = mincost + min;
                visited[b] = 1;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.println("\n Minimum Cost"+mincost);
    }
}