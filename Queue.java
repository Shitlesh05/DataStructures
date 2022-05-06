
public class Queue 
{
	int front;
	int rear;
	int size;
	int [] arr;
	
	public Queue(int size)
	{
		this.size = size;
		front = 0;
		rear = -1;
		arr = new int[size];
	}
	
	public boolean isOverflow()
	{
		return rear == size-1;
	}
	
	public boolean isUnderflow()
	{
		return (rear == -1 && front == -1);
	}
	
	public void enque(int a)
	{
		if(isOverflow())
			System.out.println("Queue is full");
		
		if(front == -1)
			front++;
		rear++;
		arr[rear] = a;
	}
	
	public int dequeue()
	{
		if(isUnderflow())
			System.out.println("Queue is empty");
		
		int temp = arr[front];
		if(front == rear)
			front= rear =  -1;
		else
			front++;
		return temp;
	}
	
	public int peek()
	{
		return arr[front];
	}
	
	/*public int peek()
	{
		return arr[rear];
	}*/
	
	public void displayQueue()
	{
		for(int i=front;i<=rear;i++)
			System.out.print(arr[i]+" ");
	}
	
	public static void main(String[] args) 
	{
		Queue q = new Queue(10);
		q.enque(10);
		q.enque(20);
		q.enque(30);
		q.enque(40);
		q.enque(50);
		System.out.println("After Enqueue Operation : ");
		q.displayQueue();
		System.out.println();
		System.out.println("After Peek Operation : ");
		System.out.println("Peeked Element : "+q.peek());
		System.out.println();
		q.dequeue();
		q.dequeue();
		System.out.println("After Dequeue Operation : ");
		q.displayQueue();
		System.out.println();
		System.out.println("After Peek Operation : ");
		System.out.println("Peeked Element : "+q.peek());
	}
}
