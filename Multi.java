import java.util.Random;
class ShS implements Runnable
{
    int n = 10;
    int[] sequence = new int[n];
    Random random = new Random();
    public void shellSort()
    {
        int increment = sequence.length / 2;
        while (increment > 0)
        {
            for (int i = increment; i < sequence.length; i++)
            {
                int j = i;
                int temp = sequence[i];
                while (j >= increment && sequence[j - increment] > temp)
                {
                    sequence[j] = sequence[j - increment];
                    j = j - increment;
                }
                sequence[j] = temp;
            }
            if (increment == 2)
                increment = 1;
            else
                increment *= (5.0 / 11);
        }
    }
    public void run()
    {
        int i;
        System.out.println("\n\n----SHELL SORT THREAD----");
        System.out.println("Input Unsorted Values:");
        for (i = 0; i < n; i++)
        {
            sequence[i] = random.nextInt(1000);
            System.out.print(sequence[i]+", ");
        }
        shellSort();
        System.out.println("\nOutput Sorted Values:");
        for (i = 0; i < n; i++)
            System.out.print(sequence[i]+", ");
    }
}


class SS implements Runnable
{
    int n = 10;
    int[] arr = new int[n];
    Random random = new Random();

    public void sort( int arr[] )
    {
        int N = n;
        int i, j, pos, temp;
        for (i = 0; i < N-1; i++)
        {
            pos = i;
            for (j = i+1; j < N; j++)
                if (arr[j] < arr[pos])
                    pos = j;
            temp = arr[i];
            arr[i] = arr[pos];
            arr[pos]= temp;
        }
    }
    public void run()
    {
        int i;
        System.out.println();
        System.out.println("\n\n----SELECTION SORT THREAD----");
        System.out.println("Input Unsorted Values:");
        for (i = 0; i < n; i++)
        {
            arr[i] = random.nextInt(1000);
            System.out.print(arr[i]+", ");
        }
        sort(arr);
        System.out.println();
        System.out.println("Output Sorted Values:");
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+", ");

    }

}


class RS implements Runnable
{
    int n = 10;
    int[] arr = new int[n];
    Random random = new Random();

    public void sort( int[] a)
    {
        int i, m = a[0], exp = 1;
        int[] b = new int[n];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;
        }
    }

    public void run()
    {
        int i;
        System.out.println("\n\n----RADIX SORT THREAD----");
        System.out.println("Input Unsorted Values:");
        for (i = 0; i < n; i++)
        {
            arr[i] = random.nextInt(1000);
            System.out.print(arr[i]+", ");
        }
        sort(arr);
        System.out.println("\nOutput Sorted Values:");
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+", ");
    }
}


class IS implements Runnable
{
    int n = 10;
    int[] arr = new int[n];
    Random random = new Random();

    public void insertionSort(int array[])
    {
        for (int j = 1; j < n; j++)
        {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }

    public void run()
    {
        int i;
        System.out.println("\n\n----INSERTION SORT THREAD----");
        System.out.println("Input Unsorted Values:");
        for (i = 0; i < n; i++)
        {
            arr[i] = random.nextInt(1000);
            System.out.print(arr[i]+", ");
        }
        insertionSort(arr);
        System.out.println("\nOutput Sorted Values:");
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+", ");
    }
}


class MS implements Runnable
{
    int n = 10;
    int[] a = new int[n];
    Random random = new Random();

    public void MergeSortAlgorithm(int low, int high)
    {
        int mid;
        if (low < high)
        {
            mid = (low + high) / 2;
            MergeSortAlgorithm(low, mid);
            MergeSortAlgorithm(mid + 1, high);
            Merge(low, mid, high);
        }
    }

    public void Merge(int low, int mid, int high)
    {
        int[] b = new int[n];
        int i, h, j, k;
        h = i = low;
        j = mid + 1;
        while ((h <= mid) && (j <= high))
            if (a[h] < a[j])
                b[i++] = a[h++];
            else
                b[i++] = a[j++];
            if (h > mid)
                for (k = j; k <= high; k++)
                    b[i++] = a[k];
            else
                for (k = h; k <= mid; k++)
                    b[i++] = a[k];
            for (k = low; k <= high; k++)
                a[k] = b[k];
    }

    public void run()
    {
        try
        {
            int i;
            int N = n;
            System.out.println("\n\n----MERGE SORT THREAD----");
            System.out.println("Input Unsorted Values:");
            for (i = 0; i < N; i++) {
                a[i] = random.nextInt(1000);
                System.out.print(a[i] + ", ");
            }
            MergeSortAlgorithm(0, N-1);
            System.out.println("\nOutput Sorted Values:");
            for (i = 0; i < N; i++)
                System.out.print(a[i] + ", ");
        }

        catch(ArrayIndexOutOfBoundsException exception)
        {
            System.out.print("");
        }
    }
}


class QS implements Runnable
{
    int n = 10;
    int[] a = new int[n];
    Random random = new Random();

    void QuickSortAlgorithm(int p, int r)
    {
        int i, j, temp, pivot;
        if (p < r)
        {
            i = p;
            j = r + 1;
            pivot = a[p];
            while (true)
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
            QuickSortAlgorithm(p, j - 1);
            QuickSortAlgorithm(j + 1, r);
        }
    }

    public void run()
    {
        int i;
        int N = n;
        System.out.println("----QUICK SORT THREAD----");
        System.out.println("Input Unsorted Values:");
        for (i = 0; i < N; i++)
        {
            a[i] = random.nextInt(1000);
            System.out.print(a[i]+", ");
        }
        long btqs = System.nanoTime();
        QuickSortAlgorithm(0, N - 1);
        long etqs = System.nanoTime();
        long epqs = etqs - btqs;
        System.out.println("\nOutput Sorted Values:");
        for (i = 0; i < N; i++)
            System.out.print(a[i]+", ");

    }
}


class RT implements Runnable
{
    Thread t1,t2,t3,t4,t5,t6;
    public void run()
    {
        try
        {
            System.out.println("****Main Thread Generated!****");
            System.out.println("--------------------------------------\n");
            t1 = new Thread(new QS());
            t1.start();
            Thread.sleep(1000);
            t2 = new Thread(new MS());
            t2.start();
            Thread.sleep(1000);
            t3 = new Thread(new IS());
            t3.start();
            Thread.sleep(1000);
            t4 = new Thread(new RS());
            t4.start();
            Thread.sleep(1000);
            t5 = new Thread(new SS());
            t5.start();
            Thread.sleep(1000);
            t6 = new Thread(new ShS());
            t6.start();
            Thread.sleep(1000);
            System.out.println("\n\n--------------------------------------");
        }

        catch(InterruptedException ex)
        {
            System.out.println("Interrupted Exception");
        }
        System.out.println("****Main Thread Ending!****");
    }
}


public class Multi
{

    public static void main(String[] args)
    {
        RT thread_obj = new RT();
        Thread t1 = new Thread(thread_obj);
        t1.start();
    }
}