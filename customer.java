import java.util.*;
class customer
{
    public static void main(String [] args)
    {
        String name;
        int count, i;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Name and Date Of Birth in the format  <name,DD/MM/YYYY>");
        name = in.nextLine();
        StringTokenizer st = new StringTokenizer(name, ",/");
        count = st.countTokens();

        for (i=0; i <= count && st.hasMoreTokens(); i++)
        {
            System.out.print(st.nextToken());
            if(i < count)
                System.out.println(",");
        }

    }
}