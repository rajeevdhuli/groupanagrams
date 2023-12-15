class Pair{
	Node root;
	int level;
	Pair(Node root,int level){
		this.root = root;
		this.level = level;
	}
}

class Solution
{
	/*
		A binary tree node is defined as:

		class Node
		{
			int data;			// data field
			Node left, right;	// pointer to the left and right child

			Node() {}
			Node(int data) { this.data = data; this.left = this.right = null; }
		}
	*/
	

	public static List<Integer> findVerticalTraversal(Node root)
	{
		// Write your code here...
		List<Integer> list = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        
        if (root == null) {
            return list;
        }
        
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node node = temp.root;
            int level = temp.level;
            
            if (!mp.containsKey(level)) {
                mp.put(level, new ArrayList<>());
            }
            mp.get(level).add(node.data);
            
            if (node.left != null) {
                queue.offer(new Pair(node.left, level - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
        }
        
        for (List<Integer> v : mp.values()) {
            list.addAll(v);
        }
        return list;
		
	}
}
