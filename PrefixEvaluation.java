import java.util.Scanner;
class Evaluation1
{
	int size;
	char [] arr;
	int top;

	public Evaluation1(int size)
	{
		this.size = size;
		arr = new char[size];
		top = -1;
	}

	public boolean isFull()
	{
		return top==size-1;
	}

	public boolean isEmpty()
	{
		return top==-1;
	}

	public int push(int i)
	{
		if(isFull())
			System.out.println("Stack is full");
		
		else
			arr[++top] = (char) i;
		return 0;
	}

	public char peek()
	{
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			return arr[top];
		return '*';
	}

	public int pop()
	{
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			return arr[top--];
		return '*' ;
	}
	
	public int preceedence(char ch)
	{
		if(ch == '^' || ch == '$')
			return 4;
		if(ch == '*' || ch == '/')
			return 3;
		if(ch == '+' || ch == '-')
			return 2;
		if(ch == '(' || ch == '[' || ch == '{')
			return 1;
		return -1;
	}
}
public class PrefixEvaluation
{
	public static void main(String[] args) 
	{
		Evaluation1 e = new Evaluation1(20);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the prefix String : ");
		String prefix = sc.nextLine();
		
		int len = prefix.length()-1;

		for(int i=len;i>=0;i--)
		{
			char ch = prefix.charAt(i);
			switch(ch)
			{
				case '+':
						int a = e.pop();
						int b = e.pop();
						e.push(a+b);
						break;
				case '-':
						int c = e.pop();
						int d = e.pop();
						e.push(c-d);
						break;
				case '*':
						int f = e.pop();
						int g = e.pop();
						e.push(f*g);
						break;
				case '/':	
						int j = e.pop();
						int k = e.pop();
						e.push(j/k);
						break;
				default : 
						e.push(ch - '0');		
			}
		}
		System.out.println(e.pop());
	}
}