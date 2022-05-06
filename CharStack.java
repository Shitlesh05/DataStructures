public class CharStack
{
	int size;
	int top = -1;
	char arr[];

	public CharStack(int size)
	{
		this.size = size;
		arr = new char[size];
	}

	public boolean isFull()
	{
		return top == size-1;
	}

	public boolean isEmpty()
	{
		return top == -1;
	}

	public char push(char c)
	{
		if(isFull())
		{
			System.out.println("Stack is full");
			return (char)-1;
		}
		else
		{
			top++;
			arr[top] = c;
		}
	}

	public char peek(char c)
	{
		if(isEmpty())
			return (char)-1;
		else
		{
			char d = arr[top];
			return d;
		}
	}

	public char pop(char c)
	{
		if(isFull())
		{
			System.out.println("Stack is empty");
			return 0;
		}
		else
		{
			return arr[top--];
		}
	}

	public void printChar()
	{
		for(char c : arr)
			System.out.println(c);
	}

	public static void main(String[] args) 
	{
		CharStack cs = new CharStack(20);
		cs.push('a');
		cs.push('b');
		cs.push('c');
		cs.push('d');
		cs.push('e');
		cs.push('f');

		System.out.println("After push operation : ");
		cs.printChar();
		System.out.println();
		System.out.println("After peek operation : ");
		System.out.println("Top : "+cs.peek());
		System.out.println();
		cs.pop();
		cs.pop();
		cs.pop();
		cs.pop();
		System.out.println("After push operation : ");
		cs.printChar();
		System.out.println("After peek operation : ");
		System.out.println("Top : "+cs.peek());
	}
}