public class rotating_linkedList {

    // --- ListNode Class ---
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // --- Main Method ---
    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        System.out.print("Original: ");
        printList(head);

        Solution solver = new Solution();
        ListNode newHead = solver.rotateRight(head, k);

        System.out.print("Rotated by " + k + ": ");
        printList(newHead);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // --- Solution Logic ---
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            // Edge Cases: Empty list, single node, or no rotation needed
            if (head == null || head.next == null || k == 0) {
                return head;
            }

            // Step 1: Calculate Length and find the old Tail
            ListNode tail = head;
            int length = 1;
            while (tail.next != null) {
                tail = tail.next;
                length++;
            }

            // Step 2: Optimize k (remove full circles)
            k = k % length;
            if (k == 0) return head; // No change if k is multiple of length

            // Step 3: Make it a Circle
            tail.next = head; 

            // Step 4: Find the New Tail
            // We need to move (Length - k) steps from the beginning
            // Or (Length - k) steps from the old tail (since it's a circle now)
            int stepsToNewTail = length - k;
            ListNode newTail = tail;
            
            for (int i = 0; i < stepsToNewTail; i++) {
                newTail = newTail.next;
            }

            // Step 5: Break the Circle
            ListNode newHead = newTail.next;
            newTail.next = null;

            return newHead;
        }
    }
}