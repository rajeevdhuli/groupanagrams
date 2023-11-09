class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode cur = head;
        while(cur != null && cur.next != null){

            ListNode temp = cur.next;

            int gcd = findGCD(cur.val,temp.val);

            ListNode nex = new ListNode(gcd);
            cur.next = nex;
            nex.next = temp;

            cur = cur.next.next;

        }
        return head;
    }

    public static int findGCD(int a, int b){
        int gcd = 0;
        while( a != b && a != 1 && b != 1){
            if( a > b)
                a = a - b;
            else
                b = b - a;    
        }
        gcd = (a <= b) ? a : b;
        return gcd;
    }
}
