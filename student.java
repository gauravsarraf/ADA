import java.util.Scanner;
class stud
{
	String usn, name, branch, phone;
	Scanner in = new Scanner(System.in);
	
	void read()
	{
		System.out.println("Enter Student Details:");
		System.out.print("Enter USN:");
		usn = in.nextLine();
		System.out.print("Enter Name:");
		name = in.nextLine();
		System.out.print("Enter Branch:");
		branch = in.nextLine();
		System.out.print("Enter Phone:");
		phone = in.nextLine();
	}
	
	void display()
	{
		System.out.printf("%-20s%-20s%-20s%-20s", usn, name, branch, phone);
	}
}
	

class studentdetails
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of student details you want to create:");
		int num = in.nextInt();
		stud s[] = new stud[num];
		for(int i=0; i<num; i++)
		{
			s[i] = new stud();
			s[i].read();
		}
		
		System.out.printf("%-20s%-20s%-20s%-20s", "USN", "NAME", "BRANCH", "PHONE NUMBER");
		System.out.println();
		for(int i=0; i<num; i++)
		{
			s[i].display();
		}
		
		in.close();
		
	}
}

	
