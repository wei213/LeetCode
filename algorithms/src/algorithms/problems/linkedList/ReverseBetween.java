package algorithms.problems.linkedList;

public class ReverseBetween {
	// some LeetCode problems related with LinkedList
	
	public ListNode removeElements(ListNode head, int val) {
		// remove the element(s) with specific values
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null){
            if(head.val == val){
                pre.next = head.next;
            }else{
                pre = pre.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
	
	public static ListNode  reverseBetween(ListNode head, int m, int n) {
		// reverse nodes in between the list
		if(head == null) return head;
		ListNode cur = head, pre = null;
		while(m>1) {
			pre = cur;
			cur = cur.next;
			m--;
			n--;
		}
		
		ListNode tail = cur, con = pre;
		ListNode third = null;
		
		while(n>0) {
			third = cur.next;
			cur.next = pre;
			pre = cur;
			cur = third;
			n--;
		}
		if(con != null) con.next = pre;
		else head = pre;
		
		tail.next = cur;
		return head;
	}
	// utilities
	public static void printListNode(ListNode head) {
		if(head == null) {
			System.out.print("null");
			return;
		}
		while(head != null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("null");
		
	}
	public static void main(String[] args) {
		//1->2->3->4->5->NULL
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		printListNode(one);
		ListNode ans = reverseBetween(one, 2, 4);
		printListNode(ans);
	}
}
