import java.util.Scanner;
class Node
{
	public int info;
	public Node link;

	public Node(int i)
	{
		info = i;
		link = null;
	}
}
class List
{
	private Node start;

	public List()
	{
		start = null;
	}

	public void displayList()
	{
		Node p;
		if(start == null)
		{
			System.out.println("List is Empty");
			return ;
		}
		System.out.print("List is : ");
		p=start;
		while(p!=null)
		{
			System.out.print(p.info+" ");
			p=p.link;
		}
		System.out.println();
	}

	public void insertAtBeginning(int data)
	{
		Node temp = new Node(data);
		temp.link = start;
		start = temp;
	}

	public void insertAtEnding(int data)
	{
		Node p;
		Node temp = new Node(data);
		
		if(start == null)
		{
			start = temp;
			return;
		}
		p = start;

		while(p.link != null)
			p=p.link;
		p.link = temp;
	}

	public void insertAtPosition(int data , int k)
	{
		Node temp;
		int i;
		if(k==1)
		{
			temp = new Node(data);
			temp.link = start;
			start = temp;
			return;
		}
		Node p = start;
		for(i=1;i<k-1 && p!=null;i++)
			p=p.link;

		if(p==null)
			System.out.println("You can insert upto"+i+"th position");
		else
		{
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}		
	}

	public void createList()
	{
		int i,n,data;
		
		Scanner sc = new Scanner(System.in); 
				
		System.out.print("Enter the number of nodes : ");
		n = sc.nextInt();
		
		if(n==0)
			return;
		
		for(i=1; i<=n; i++)
		{
			System.out.print("Enter the element to be inserted : ");
			data = sc.nextInt();
			insertAtEnding(data);	
		}
	}
	
	public void insertAfter(int data,int x)
	{
		Node p=start;
		while(p!=null)
		{
			if(p.info==x)
				break;
			p=p.link;
		}
		
		if(p==null)
			System.out.println(x + " not present in the list");	
		else
		{
			Node temp=new Node(data);
			temp.link=p.link;
			p.link=temp;
		}
	}

	public void insertBefore(int data,int x)
	{
		Node temp;
		
		/*If list is empty*/
		if(start==null)
		{
			System.out.println("List is empty");
			return;
		}	
		
		/*x is in first node,new node is to be inserted before first node*/
		if(x==start.info)
		{
			temp=new Node(data);
			temp.link=start;
			start=temp;
			return;
		}	
		
		/*Find reference to predecessor of node containing x*/
		Node p=start;
		while(p.link!=null) 
		{
			if(p.link.info==x)
				break;	
			p=p.link;
		}
		
		if(p.link==null)
			System.out.println(x + " not present in the list");
		else
		{
			temp=new Node(data);
			temp.link=p.link;
			p.link=temp;
		}
	}/*End of insertBefore()*/
	
	public void deleteFirstNode()
	{
		if(start==null)
			return;
		start=start.link;  
	}
	
	public void deleteLastNode()
	{
		if(start==null)
			return;
		
		if(start.link==null)
		{
			start=null;
			return;
		}
			
		Node p=start;
		while(p.link.link!=null)
			p=p.link;
		p.link=null;
	}
	
	public void deleteNode(int x)  
	{
		if(start==null)
		{
			System.out.println("List is empty\n");
			return;
		}
		/*Deletion of first node*/
		if(start.info==x)
		{
			start=start.link;  
			return;
		}
		/*Deletion in between or at the end*/
		Node p=start;
		while(p.link!=null)
		{
			if(p.link.info==x)   
				break;	
			p=p.link;
		}
		
		if(p.link==null)
			System.out.println("Element " + x + " not in list");
		else
			p.link = p.link.link;
	}

	public void reverseList()
	{
		Node prev, p, next;
		prev=null;
	   	p=start;
		while(p!=null)
		{
			next=p.link;
			p.link=prev;
			prev=p;
			p=next;
		}
		start=prev;
	}/*End of reverseList()*/
		
	public void search(int x)
	{
		Node p;
		int pos=1;
		p=start;
		while(p!=null)
		{
			if(p.info == x)
				break;
			p=p.link;
			pos++;
		}
		if(p==null)
		{
			System.out.println(x +" not found in the list");
			//return false;
		}
		else
		{
			System.out.println(x +" is found at position "+pos);
			//return true;
		}
	}
	
	public void traverse()
	{
		Node p = start;
		while(p!=null)
		{
			System.out.print(p.info + " ==>");
			p=p.link;
		}
		System.out.println();
	}
}

public class LinkedList
{
	public static void main(String[] args) 
	{
		List l = new List();
		Scanner sc = new Scanner(System.in);
		int choice,data,k,x;
		l.createList();
		while(true)
		{
			System.out.println("1.Insert in empty list/Insert in beginning of the list");
			System.out.println("2.Insert a node at the end of the list");
			System.out.println("3.Insert a node at a given position");
			System.out.println("4.Display List");
			System.out.println("5.Search for an element : ");
			System.out.println("6.Traversal of linked list");
			System.out.println("7.Insert a node after specified node : ");
			System.out.println("8.Insert a node before specified node :");
			System.out.println("9.Delete First Node : ");
			System.out.println("10.Delete Last Node : ");
			System.out.println("11.Delete any Node : ");
			System.out.println("12.Reverse the List : ");
			System.out.println("Enter choice : ");
			choice = sc.nextInt();

			if(choice == 13)
				break;
			switch(choice)
			{
				case 1 :
					System.out.println("Enter the element to be inserted : ");
					data = sc.nextInt();
					l.insertAtBeginning(data);
					break;
				case 2 :
					System.out.println("Enter the element to be inserted : ");
					data = sc.nextInt();
					l.insertAtEnding(data);
					break;
				case 3 :
					System.out.println("Enter the element to be inserted : ");
					data = sc.nextInt();
					System.out.println("Enter the position at which to insert element : ");
					k = sc.nextInt();
					l.insertAtPosition(data,k);
					break;	
				case 4 :
					l.displayList();
					break;
				case 5 :
					System.out.println("Enter element to be searched ");
					data = sc.nextInt();
					l.search(data);
					break;
				case 6:
					l.traverse();
					break;
				case 7:
					System.out.println("Enter the element to be inserted : ");
					data=sc.nextInt();
					System.out.println("Enter the element after which to insert : ");
					x=sc.nextInt();
					l.insertAfter(data,x);
					break;
				case 8:
					System.out.println("Enter the element to be inserted : ");
					data=sc.nextInt();
					System.out.println("Enter the element before which to insert : ");
					x=sc.nextInt();
					l.insertBefore(data,x);
					break;
				case 9:
					l.deleteFirstNode();
					break;
				case 10:
					l.deleteLastNode();
					break;
				case 11:
					System.out.println("Enter the element to be deleted : ");
					data=sc.nextInt();
					l.deleteNode(data);	
					break;
				case 12:
					l.reverseList();
					break;								
				default :
					System.out.println("Wrong choice");
					break;			
			}
		}
	}
}