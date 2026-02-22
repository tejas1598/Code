public class RemoveDuplicates {

    // --- ListNode Class ---
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // --- Main Method ---
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example 1: 1 -> 1 -> 2
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.print("Input: ");
        printList(head1);
        ListNode res1 = solver.deleteDuplicates(head1);
        System.out.print("Output: ");
        printList(res1); // Expected: 1 -> 2
        
        System.out.println("-----------------");

        // Example 2: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.print("Input: ");
        printList(head2);
        ListNode res2 = solver.deleteDuplicates(head2);
        System.out.print("Output: ");
        printList(res2); // Expected: 1 -> 2 -> 3
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    // --- SOLUTION CLASS ---
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // Edge case: if the list is empty, just return null
            if (head == null) {
                return null;
            }

            // Start a pointer at the head of the list
            ListNode current = head;

            // Traverse the list until we reach the last node
            while (current != null && current.next != null) {
                // If the current node and the next node have the same value
                if (current.val == current.next.val) {
                    // Skip the next node
                    current.next = current.next.next;
                } else {
                    // Otherwise, just move the pointer forward
                    current = current.next;
                }
            }

            // Return the head of the modified list
            return head;
        }
    }
}