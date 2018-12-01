import java.util.*;
class kk_dp
{
    static final int max = 20;
    static int w[], p[], n, m, v[][], keep[][];
    public static void main(String [] args)
    {
        w = new int[max];
        p = new int[max];
        v = new int[max][max];
        keep = new int[max][max];
        int optsoln;
        read();
        for ( int i = 0; i <= m; i++)
            v[0][i] = 0;
        for ( int i = 0; i <= n; i++)
            v[i][0] = 0;
        optsoln = knap();
        System.out.println("Optimal Solution= "+optsoln);
    }

    static int knap()
    {
        int r;
        for( int i = 1; i <= n; i++)
            for( int j = 0; j <= m; j++)
                if ((w[i] <= j) && ((p[i] + v[i - 1][j - w[i]]) > v[i - 1][j]))
                {
                    v[i][j] = p[i] + v[i - 1][j -w[i]];
                    keep[i][j] = 1;
                }
                else
                {
                    v[i][j] = v[i-1][j];
                    keep[i][j] = 0;
                }
        r = m;
        System.out.println("Items =");
        for ( int i =n; i > 0; i--)
            if(keep[i][r] == 1)
            {
                System.out.print(i + "   ");
                r = r - w[i];
            }
        System.out.println();
        return v[n][m];
    }

    static void read()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Knapsack Problem- Dynamic Programming Solution:");
        System.out.println("Enter the max capacity of Knapsack:");
        m = in.nextInt();
        System.out.println("Enter the number of objects:");
        n = in.nextInt();
        System.out.println("Enter the Weights:");
        for (int i = 0; i <= n; i++)
            w[i] = in.nextInt();
        System.out.println("Enter Profits:");
        for (int i = 0; i <= n; i++)
            p[i] = in.nextInt();
        in.close();
    }
}