import java.util.*;
public class TSP
{
    static final int infinity = 999;
    static int n;
    public static void main(String args [])
    {
        int cost = infinity;
        System.out.println("Enter the Number of Cities:");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int c[][] = new int[n][n];
        int tour[] = new int[n];
        System.out.println("Enter Cost Matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                c[i][j] = in.nextInt();
                if(c[i][j] == 0)
                    c[i][j] = 999;
            }
        for (int i = 0; i < n; i++)
            tour[i] = i;
        cost = tspdp(c, tour, 0, n);
        System.out.println("Minimum Tour Cost:"+cost);
        System.out.println("Tour:");
        for( int i = 0; i < n; i++)
            System.out.print(tour[i]+" -> ");
        System.out.println(tour[0]+"\n");
        in.close();
    }

    static int tspdp(int c[][], int tour[], int start, int n)
    {
        int i, j, k, mincost, cost;
        int temp[] = new int[n];
        int mintour[] = new int[n];
        if (start == n - 2)
            return c[tour[n - 2]][tour[n - 1]] + c[tour[n - 1]][0];
        mincost = infinity;
        for (i = start + 1; i < n; i++) {
            for (j = 0; j < n; j++)
                temp[j] = tour[j];
            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];
            if (c[tour[start]][tour[i]] + (cost = tspdp(c, temp, start + 1, n)) < mincost) {
                mincost = c[tour[start]][tour[i]] + cost;
                for (k = 0; k < n; k++)
                    mintour[k] = temp[k];
            }
        }
        for (i = 0; i < n; i++)
            tour[i] = mintour[i];
        return mincost;
    }
}