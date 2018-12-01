import java.util.*;
class mergesort
{
    static int a[];
    static int n;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter MAX Array Size:");
        n = in.nextInt();
        a= new int[n];
        Random random = new Random();
        System.out.printf("Do you want to enter %d values by keyboard? (Y/N)", n);
        char ch = in.next().charAt(0);
        if (ch == 'Y')
        {
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
        }
        else
            for (int i = 0; i < n; i++)
                a[i] = random.nextInt(9999);
        long start = System.nanoTime();
        msalgo(0, n - 1);
        long stop = System.nanoTime();
        long time = stop - start;
        System.out.println("Time Complexity is milliseconds for n=" + n + " is=" + ((double) time / 1000000)+" miliseconds.");
        int c = 0;
        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i]+ " ");
            c++;
            if(c > 10)
            {
                System.out.println();
                c = 0;
            }
        }
        //System.out.println("Sorted Array (Merge Sort):");
        //for (int i=0; i < n; i++)
          //  System.out.println(a[i]+ " ");
        in.close();
    }

    public static void msalgo(int low, int high)
    {
        int mid;
        if(low < high)
        {
            mid = (low+high)/2;
            msalgo(low, mid);
            msalgo(mid+1, high);
            merge(low, mid, high);
        }
    }

    public  static  void merge(int low, int mid, int high)
    {
        int b [] = new int [n];
        int i, h, j, k;
        h = i = low;
        j = mid+1;
        while ((h <= mid) && (j <= high))
            if (a[h] < a[j])
                b[i++] = a[h++];
            else
                b[i++] = a[j++];

        if(h > mid)
            for(k = j; k <= high; k++)
                b[i++] = a[k];
        else
            for(k = h; k <= mid; k++)
                b[i++] = a[k];
        for(k = low; k <= high; k++)
            a[k] = b[k];
    }
}
