import java.util.Scanner;
public class BalancingSymbols
{
	int top;
	char [] stk;
	int size;

	public BalancingSymbols(int size)
	{
		this.size = size;
		stk = new char[size];
		top=-1;
	}

	public boolean isFull()
	{
		return top==size-1;
	}

	public boolean isEmpty()
	{
		return top==-1;
	}

	public char push(char c)
	{
		if(isFull())
		{
			System.out.println("Stack is full");
		}
		else 
		{
			stk[++top]=c;
		}
		return 0;
	}

	public int peek()
	{
		if(isEmpty())
			System.out.println("Stack is empty");
		else
		{
			return stk[top];
		}
		return '*'; 	
	}

	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
		}
		else
			return stk[top--];
		return 0;
	}

	public void print()
	{
		for(char ch : stk)
		{
			System.out.print(ch);
		}
	}

	public static void main(String[] args) 
	{
		BalancingSymbols s = new BalancingSymbols(10);
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Expression : ");
		String str = sc.nextLine();
		int i;
		int n = str.length();
		for(i=0;i<n;i++)
		{
			char ch = str.charAt(i);
			switch(ch)
			{
				case '(':
				case '[':
				case '{':
						System.out.println(ch);
						s.push(ch);
						break;
				case ')':
				case ']':
				case '}':
						char peek = (char)s.peek();
						if((ch == ')' && peek == '(') || (ch == ']' && peek == '[') || (ch == '}' && peek == '{'))
							System.out.println(s.pop());
						else
							count=1;
				//default:
						//System.out.println("Ignore the values");
						//break;						
			}
			if(count == 1)
				break;
		}
		if(i==n && s.isEmpty())
			System.out.println("Given statement is balanced");
		else
			System.out.println("Given statement is not balanced");
	}
}