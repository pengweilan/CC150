package chap2;
import java.util.*;
import CtCILibrary.*;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */

public class C2Q1 {
	private static void removeDup(LinkedListNode root) {
		Set<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = new LinkedListNode();
		while(root != null) {
			if(set.contains(root.data)) {
				previous.next = root.next;
			} else {
				set.add(root.data);
				previous = root;
			}
			root = root.next;
		}
	}
	
	private static void removeDupNoBuffer(LinkedListNode root) {
		LinkedListNode cur = root;
		LinkedListNode scout = cur;
		
		while(cur != null) {
			scout = cur;
			while(scout.next != null) {
				/* If the value of the next node is not equal to the current value
				 * The scout need to move ahead in order to continue the comparison
				 * Otherwise, the successive node can already be reached 
				 * because the duplicate node has been removed.
				 */
				if(scout.next.data == cur.data) {
					scout.next = scout.next.next;
				} else {
					scout = scout.next;
				}
			}
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode test = AssortedMethods.randomLinkedList(10, 0, 10);
		LinkedListNode clone = test.clone();
		System.out.println(test.printForward());
		removeDup(test);
		System.out.println(test.printForward());
		removeDupNoBuffer(clone);
		System.out.println(clone.printForward());
	}
}
