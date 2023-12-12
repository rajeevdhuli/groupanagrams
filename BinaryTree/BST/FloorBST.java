
public class solution {
	public static int Floor(BinaryTreeNode<Integer> node, int x) {
	    int floor = -1;
	    while(node != null){
		    if(node.data == x){
				return x;
			}
			else if(node.data < x){
				floor = node.data;
				node = node.right;
			}
			else if(node.data > x){
				node  = node.left;

			}
	    }
		return floor;
	}

}
