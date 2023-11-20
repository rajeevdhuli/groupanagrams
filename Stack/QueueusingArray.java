class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=-1;
		rear=-1;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(isFull())
	        return;
	    else if (isEmpty()){
	        front = 0;
	        rear = 0;
	        arr[rear] = x;
	    }     
	    else{
	        rear = (rear+1)%100005;
	        arr[rear] = x;
	    }
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		int temp = -1;
		if(isEmpty())
		   return -1;
		 else if(front == rear){
		     temp = front;
		     front  = -1;
		     rear = -1;
		 }
		 else{
		     temp = front;
		     front = (front +1 )%100005;
		 }  
		 return arr[temp];
	} 
	
	boolean isEmpty(){
	    if(front == -1 && rear == -1)
	        return true;
	    return false;
	}
	
	boolean isFull(){
	    if((rear+1)%100005 == front)
	       return true;
	    return false;     
	}
}
