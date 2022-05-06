
public class CircularQueue 
{
	int front;
	int rear;
	int size;
	int [] arr;
	
	public CircularQueue(int size)
	{
		this.size = size;
		front = 0;
		rear = -1;
		arr = new int[size];
	}
	
	public boolean isOverflow()
	{
		return ((front == -1 && rear == size-1)||(rear == front && rear != -1));
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
		rear = rear + 1; // linerly traversing
		rear = (rear + 1) % size; // circular traversing
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
			front = (front + 1) % size;
		return temp;
	}
	
	public int peek()
	{
		return arr[front];
	}
	
	public void displayQueue()
	{
		int i;
		for(i=front;i!=rear;i=(i+1)%size)
			System.out.print(arr[i]+" ");
		System.out.print(arr[i]+" ");
	}
	
	public static void main(String[] args) 
	{
		CircularQueue q = new CircularQueue(4);
		q.enque(10);
		q.enque(20);
		q.enque(30);
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
		System.out.println();
		q.enque(60);
		q.enque(70);
		System.out.println("After Enqueue Operation : ");
		q.displayQueue();
		System.out.println();
		System.out.println("After Peek Operation : ");
		System.out.println("Peeked Element : "+q.peek());
	}
}
