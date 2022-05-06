import java.util.Scanner;

public class ParenthesisBalancing
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String str1;
		int i , j=0, flag=0;
		char c , ch;
		char[] str = new char[20];
		System.out.println("Enter the string : ");
		str1 = s.nextLine();
		for(i=0;i<str1.length;i++)
		{
			ch = str.chatAt(i);
			if(ch == '(' || ch == '[' || ch == '{')
			{
				arr[j] = ch;
				j++;
				flag = 1;
			}
			else if(ch == ')')
			{
				if (flag == 1)
					j--;
				c = str[j];
				if((str.length == 0) || (c! = '('))
				{
					System.out.println("Unbalanced Symbols");
					return;
				}
			}
			else if(ch == ']')
			{
				if (flag == 1)
					j--;
				c = str[j];
				if((str.length == 0) || (ch! = '['))
				{
					System.out.println("Unbalanced Symbols");
					return;
				}
			}
			else if(ch == '}')
			{
				if (flag == 1)
					j--;
				c = str[j];
				if((str.length == 0) || (CharSequence! = '{'))
				{
					System.out.println("Unbalanced Symbols");
					return;
				}
			}
		}
		System.out.println("Balanced Symbols");
	}
	
}