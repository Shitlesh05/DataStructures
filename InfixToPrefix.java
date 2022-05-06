import java.util.Scanner;
class Prefix
{
	int size;
	char [] arr;
	int top;

	public Prefix(int size)
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

	public void push(int c)
	{
		if(isFull())
			System.out.println("Stack is full");
		else
			arr[++top] = (char) c;	
	}

	public char peek()
	{
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			return (char) arr[top];
		return '0';
	}

	public char pop()
	{
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			return (char) arr[top--];
		return 0;
	}

	public void printStack()
	{
		for(int ch : arr)
			System.out.println(ch+" ");
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

public class InfixToPrefix
{
	public static void main(String[] args) 
	{
		Prefix pf = new Prefix(100);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Infix Expression : ");
		String infix = sc.nextLine();
		String prefix = "";
		int len = infix.length()-1;
		for(int i=len;i>=0;i--)
		{
			char ch = infix.charAt(i);
			switch(ch)
			{
				case ')':
				case ']':
				case '}':
						pf.push(ch);
						break;

				case '{':
				case '[':
				case '(':
						char peek = (char)pf.peek();
						while((ch == '(' && pf.peek() != ')') || (ch == '[' && pf.peek() != ']') || (ch == '{' && pf.peek() != '}'))
							prefix = pf.pop()+prefix;
						char p = pf.pop();
						break;
						
				case '^':		
				case '+':
				case '-':
				case '*':
				case '/':
						while(!(pf.isEmpty()) && pf.preceedence(ch) < pf.preceedence(pf.peek()))
							prefix = pf.pop()+prefix;
						pf.push(ch);
						break;

				default :
						prefix = ch + prefix;
						break;		
			}
		}
		while(!pf.isEmpty())
		{
			char ch = pf.peek();
			if(ch == ')' || ch == ']' || ch == '}')
				pf.pop();
			prefix = pf.pop()+prefix;
		}
		System.out.println("Prefix Expression : \n"+prefix);
	}
}