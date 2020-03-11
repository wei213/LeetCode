package algorithms.problems.linkedList;

public class DetectCycle {
	/**
	 * @problem LeetCode 142. Linked List Cycle II
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode quick = head;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick) break;
        }
        //System.out.println(quick.val);
        if( quick == null || quick.next == null) return null;
        
        slow = head;
        while(slow != quick){
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
}
