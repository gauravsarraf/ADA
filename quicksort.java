import java.util.*;
class quicksort
{
    static int a[];
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter MAX Array Size:");
        int n = in.nextInt();
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
        //a = Arrays.copyOf(a, n);
       // Arrays.sort(a);
        System.out.println("\n*****Input Array:*****\n");
        int c = 0;
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i] + " ");
            c++;
            if(c > (n/100))
            {
                System.out.println();
                c = 0;
            }
        }
        long start = System.nanoTime();
        qsalgo(0, n - 1);
        long stop = System.nanoTime();
        long time = stop - start;
        System.out.println("\n\n*****Sorted Array:*****");
        int d = 0;
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i] + " ");
            d++;
            if(d > (n/100))
            {
                System.out.println();
                d = 0;
            }
        }
        System.out.println();
        System.out.print("Time Complexity is milliseconds for n=" + n + " is=" + ((double) time / 1000000)+" miliseconds.");
    }

    public static void qsalgo(int p, int r)
    {
        int i, j, temp, pivot;
        if(p < r)
        {
            i = p;
            j = r+1;
            pivot = a[p];
            while(true)
            {
                i++;
                while (a[i] < pivot && i < r)
                    i++;
                j--;
                while (a[j] > pivot)
                    j--;
                if (i < j)
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                else
                    break;
            }
            a[p] = a[j];
            a[j] = pivot;
            qsalgo(p, j-1);
            qsalgo(j+1, r);
        }
    }
}
