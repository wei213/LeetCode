package problems.linkedList;

public class RemoveDuplicates {
	//Given a sorted linked list, delete all duplicates such that each element appear only once.
	public ListNode deleteDuplicatesI(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = null, cur = head;
        
        while(cur != null){
            if(pre != null && pre.val == cur.val){
                cur = cur.next;
                    
            }else if(pre != null && pre.val != cur.val){
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }else if(pre == null){
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = cur;//link together
        
        return dummy.next;
        
    }
	//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	public ListNode deleteDuplicatesII(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){ 
                cur = cur.next;
            }
            if(pre.next == cur){
                pre = pre.next;
                cur = cur.next;
            }else{
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
