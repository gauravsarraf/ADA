import java.util.*;
class kobj
{
    float w, p, r;
}

class kk_gp
{
    static final int max = 20;
    static int n;
    static float m;
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of objects:");
        n = in.nextInt();
        kobj[] obj = new kobj[n];
        for ( int i = 0; i < n; i++)
            obj[i] = new kobj();
        read(obj);
        knap(obj);
        in.close();
    }

    static  void read(kobj obj[])
    {
        kobj temp = new kobj();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the max capacity of knapsack:");
        m = in.nextFloat();
        System.out.println("Enter Weight:");
        for ( int i = 0; i < n; i++)
            obj[i].w = in.nextFloat();
        System.out.println("Enter Profits:");
        for ( int i = 0; i < n; i++)
            obj[i].p = in.nextFloat();
        for ( int i = 0; i < n; i++)
            obj[i].r = obj[i].p / obj[i].w;
        for ( int i = 0; i < n; i++)
            for ( int j = 0; j < n-1; j++)
                if (obj[i].r < obj[j+1].r)
                {
                    temp = obj[j];
                    obj[j] = obj[j+1];
                    obj[j+1] = temp;
                }
                in.close();
    }

    static void knap(kobj kkobj[])
    {
        float x[] = new float[max];
        float totalprofit;
        int i;
        float u;
        u = m;
        totalprofit = 0;
        for ( i = 0; i < n; i++)
            x[i] = 0;
        for ( i = 0; i < n; i++)
            if (kkobj[i].w > u)
                break;
            else
            {
                x[i] = 1;
                totalprofit = totalprofit + kkobj[i].p;
                u = u - kkobj[i].w;
            }
        System.out.println("i= "+i);
        if (i < n)
            x[i] = u / kkobj[i].w;
        totalprofit = totalprofit + (x[i] * kkobj[i].p);
        System.out.println("The solution vector, x[]:");
        for ( i = 0; i < n; i++)
            System.out.println(x[i]+ " ");
        System.out.println("\n Total Profit is=" +totalprofit);
    }
}