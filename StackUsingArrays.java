class MyStack
{
    int top;
	int arr[] = new int[1000];

    MyStack()
	{
		top = -1;
	}
	
	//Function to push an integer into the stack.
    void push(int a)
	{
	    // Your code here
	    if(top > 999){
	       //System.out.println("Stack Overflow");
	       return;
	    }
	   // top++;
	    arr[++top] = a;
	} 
	
    //Function to remove an item from top of the stack.
	int pop()
	{
        // Your code here
        if(top == -1){
            //System.out.println("Empty Stack");
            return -1;
        }
        else{
        // int y = top;
        // top--;
        return arr[top--];
        }
	}

	int top(){
	    if(isEmpty() == true)
	       return -1;
	    return arr[top];  
	}
	
	boolean isEmpty(){
	   if(top == -1)
	       return true;
	   return false;
	}
	
