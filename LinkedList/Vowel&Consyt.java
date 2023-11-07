class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node vow = new Node('0');
        Node con = new Node('0');
        Node i = vow;
        Node j = con;
        while(head != null){
            if(isVowel(head.data) == true){
                i.next = head;
                i = i.next;
            }
            else{
                j.next = head;
                j = j.next;
            }
            head = head.next;
        }
        i.next = con.next;
        j.next = null;
        return vow.next;
    }
    
     private boolean isVowel(char c) {
        c = Character.toLowerCase(c); // Convert to lowercase for case-insensitive comparison
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
