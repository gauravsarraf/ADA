import java.util.*;
public class krus
{
    static int cost[][], n;
    static Scanner in = new Scanner(System.in);

    public static void main(String [] args)
    {
        readm();
        kruskal();
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

    static void kruskal() {
        int a, b, v, u, i, j, min, mincost, ne = 1;
        a = u = b = v = mincost = 0;

        System.out.println("The edges of the Minimum Cost Spanning Tree are:");
        while (ne < n)
        {
            for (i = 0, min = 999; i < n; i++)
                for (j = 0; j < n; j++)
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
            u = find(u);
            v = find(v);
            if (u != v)
            {
                uni(u, v);
                System.out.println(ne++ + " edge(" + a + "," + b + ")=" + min);
                mincost = mincost + min;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.println("Minimum Cost:" + mincost);
    }

    static int find(int i)
    {
        int parent[] = new int[9];
        while (parent[i] == 1)
            i = parent[i];
        return i;
    }

    static void uni(int i, int j)
    {
        int parent[] = new int[9];
        parent[j] = i;
    }
}