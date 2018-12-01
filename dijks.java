import java.util.*;
public class dijks
{
    final static int max = 20, infinity = 9999;
    static int a[][], n;
    static Scanner in = new Scanner(System.in);
    int i, j, k;
    public static void main(String [] args)
    {
        readm();
        int s = 0;
        System.out.print("Enter the starting node:");
        s = in.nextInt();
        dijk(s);
    }

    static void readm()
    {
        a =  new int[max][max];
        System.out.print("Enter the number of nodes:");
        n = in.nextInt();
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = in.nextInt();
    }

    static void dijk(int s)
    {
        int st[] = new int[max];
        int d[] = new int[max];
        int u, v;
        for (int i = 0; i <= n; i++)
        {
            st[i] = 0;
            d[i] = a[s][i];
        }
        st[s] =1;
        d[s] = 1;
        int i = 2;
        while ( i <= n)
        {
            u = extract(st, d);
            st[u] = 1;
            i++;
            for (v = 1; v <= n; v++)
                if (((d[u] + a[u][v] < d[v]) && (st[v] == 0)))
                    d[v] = d[u] + a[u][v];
        }
        for (i = 1; i <= n; i++)
            if (i != s)
                System.out.println(i+":"+d[i]);
    }

    static int extract(int st[], int d[])
    {
        int i, j=1, min;
        min = infinity;
        for (i = 1; i <=n; i++)
            if ((d[i] < min) && (st[i] == 0))
            {
                min = d[i];
                j = i;
            }
        return (j);
    }
}