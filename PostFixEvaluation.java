import java.util.Scanner;
import java.util.Stack;
class Evaluation
{
	int size;
	char [] arr;
	int top;

	public Evaluation(int size)
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
public class PostfixEvaluation
{
	public static void main(String[] args) 
	{
		Evaluation e = new Evaluation(20);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the postfix String : ");
		String postfix = sc.nextLine();
		
		int len = postfix.length();

		for(int i=0;i<len;i++)
		{
			char ch = postfix.charAt(i);
			switch(ch)
			{
				case '+':
						int a = e.pop();
						int b = e.pop();
						e.push(b+a);
						break;
				case '-':
						int c = e.pop();
						int d = e.pop();
						e.push(d-c);
						break;
				case '*':
						int f = e.pop();
						int g = e.pop();
						e.push(g*f);
						break;
				case '/':	
						int j = e.pop();
						int k = e.pop();
						e.push(k/j);
						break;
				default : 
						e.push(ch - '0');		
			}
		}
		System.out.println(e.pop());
	}
}