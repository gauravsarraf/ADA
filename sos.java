import java.util.*;

public class sos
{
    static int n, s[], sol[], d;

    public static void main(String args[])
    {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        n = in.nextInt();
        s = new int[n+1];
        sol = new int[n+1];
        int sum = 0;

        System.out.println("Enter the set of increasing order:");
        for (int i = 1;  i <= n; i++)
        {
            System.out.println("Enter element "+(i)+":");
            s[i] = in.nextInt();
        }

        System.out.println("Enter the maximum subset value:");
        d = in.nextInt();

        for (int i = 0;i <= n; i++)
            sum = sum + s[i];
        if( sum < d || s[1] > d )
            System.out.println("Subset not possible!");
        else
            sumofsub(0, 0, sum);
        in.close();
    }

     static void sumofsub(int i, int weight, int total)
    {
        if( promising(i, weight, total) == true )
            if( weight == d )
            {
                for(int j = 0;j <= i; j++)
                    if( sol[j] == 1)
                        System.out.print(s[j]+" ");
                System.out.println();
            }

            else
            {
                sol[i + 1] = 1;
                sumofsub( i + 1, weight + s[i +1], total - s[i + 1]);
                sol[i + 1] = 0;
                sumofsub( i + 1, weight, total - s[i + 1]);
            }
    }
    static  boolean promising( int i, int weight, int total)
    {
        return(( weight + total >= d) && (weight == d || weight + s[i  +1] <= d));
    }
}