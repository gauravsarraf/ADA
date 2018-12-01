import java.util.*;
class staff
{
    String id, name, phone, salary;
    Scanner in = new Scanner(System.in);

    void read()
    {
        System.out.println("Enter the Staff ID:");
        id = in.nextLine();
        System.out.println("Enter the Staff Name:");
        name = in.nextLine();
        System.out.println("Enter the Staff Phone:");
        phone = in.nextLine();
        System.out.println("Enter the Staff Salary:");
        salary = in.nextLine();
    }

    void display()
    {
        System.out.printf("%-15s", "STAFF ID:");
        System.out.printf("%-15s\n", id);
        System.out.printf("%-15s", "NAME:");
        System.out.printf("%-15s\n", name);
        System.out.printf("%-15s", "PHONE");
        System.out.printf("%-15s\n", phone);
        System.out.printf("%-15s", "SALARY");
        System.out.printf("%-15s\n", salary);
    }
}

class teaching extends staff
{
    String domain, publication;

    void read_teaching()
    {
        super.read();
        System.out.println("Enter Domain:");
        domain = in.nextLine();
        System.out.println("Enter Publication:");
        publication = in.nextLine();
    }

    void display_teaching()
    {
        super.display();
        System.out.printf("%-15s", "DOMAIN:");
        System.out.printf("%-15s\n", domain);
        System.out.printf("%-15s", "PUBLICATION:");
        System.out.printf("%-15s\n", publication);
    }
}

class techinal extends staff
{
    String skills;

    void read_technical()
    {
        super.read();
        System.out.println("Enter Skills:");
        skills = in.nextLine();
    }

    void display_technical()
    {
        super.display();
        System.out.printf("%-15s", "SKILLS:");
        System.out.printf("%-15s\n", skills);
    }
}

class contract extends staff
{
    String period;

    void read_contract()
    {
        super.read();
        System.out.println("Enter Period:");
        period = in.nextLine();
    }

    void display_contract()
    {
        super.display();
        System.out.printf("%-15s", "PERIOD:");
        System.out.printf("%-15s\n", period);
    }
}

class staffdetail
{
    public static void main(String [] args)
    {
        int i, n;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of staff details to be created:");
        n = in.nextInt();
        teaching steach [] = new teaching[n];
        techinal stech [] = new techinal[n];
        contract scon [] = new contract[n];

        for(i = 0; i < n; i++)
        {
            System.out.println("Enter Teaching Staff Information:");
            steach[i] = new teaching();
            steach[i].read_teaching();
        }

        for(i = 0; i < n; i++)
        {
            System.out.println("Enter Technical Staff Information:");
            stech[i] = new techinal();
            stech[i].read_technical();
        }

        for(i = 0; i < n; i++)
        {
            System.out.println("Enter Contract Staff Information:");
            scon[i] = new contract();
            scon[i].read_contract();
        }

        System.out.println("\n STAFF DETAILS:\n");
        System.out.println("*****TEACHING STAFF DETAILS*****");
        for(i = 0; i < n; i++)
            steach[i].display_teaching();
        System.out.println();

        System.out.println("*****TECHNICAL STAFF DETAILS*****");
        for(i = 0; i < n; i++)
            stech[i].display_technical();
        System.out.println();

        System.out.println("*****CONTRACT STAFF DETAILS*****");
        for(i = 0; i < n; i++)
            scon[i].display_contract();
        System.out.println();
        in.close();
    }
}