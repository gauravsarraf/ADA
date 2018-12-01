import java.util.*;
class stack
{
	int arr[], top, max, element, i;
	
	stack(int num)				//constructor
	{
		max = num;
		arr = new int[max];
		top = -1;
	}
	
	void push(int i)
	{
		if(top == max-1)
			System.out.println("*****The Stack is Full! OVERFLOW*****\n");
		else
			arr[++top] = i;
	}
	
	void pop()
	{
		if(top == -1)
			System.out.println("*****The Stack is Empty! UNDERFLOW*****\n");
		else
		{
			element = arr[top--];
			System.out.printf("The Popped Element is:%d", +element);
		}
	}
	
	void display()
	{
		System.out.println("\nStack = ");
		if(top == -1)
		{
			System.out.println("*****Stack is Empty!!*****\n");
			return;
		}
		
		for(i=top; i >= 0; i--)
			System.out.println(arr[i]+"");
		System.out.println();
	}
}

class stck
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of the Stack:");
		int n = in.nextInt();
		boolean done = false;
		stack stk = new stack(n);
		do
		{
			System.out.println("\n\nStack Operations:");
			System.out.println("1. PUSH\n2. POP\n3. DISPLAY\n4. EXIT");
			int choice = in.nextInt();
			switch(choice)
			{
				case 1:
						System.out.println("Enter Integer elements to push:");
						stk.push(in.nextInt());
						break;
						
				case 2:
						stk.pop();
						break;
				
				case 3:
						stk.display();
						break;
						
				case 4:
						done = true;
						break;
				
				default:
						System.out.println("Invalid Input!! Try again.");
			}
		}
		while(!done);
		in.close();
	}
}