public class remove_nth_node {

    // --- 1. The ListNode Class (Standard LeetCode Definition) ---
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // --- 2. Main Method (To Run and Test) ---
    public static void main(String[] args) {
        // Create the list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // --- Execute Your Logic ---
        Solution solver = new Solution();
        int n = 2; // Remove the 2nd node from the end (Value '4')
        
        ListNode newHead = solver.remove_nth_node(head, n);

        System.out.println("After Removal:");
        printList(newHead); // Expected: 1 -> 2 -> 3 -> 5 -> null
    }

    // --- 3. Helper to Print ---
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // --- 4. Your Solution Class (Exact Logic Preserved) ---
    static class Solution {
        public ListNode remove_nth_node(ListNode head, int n) {
            // Edge case: List with only 1 node
            if (head.next == null) {
                return null;
            }
    
            // Step 1: Calculate Size
            int size = 0;
            ListNode curr = head;
            while (curr != null) {
                curr = curr.next;
                size++;
            }
    
            // Step 2: Handle removing the Head (First Node)
            if (n == size) {
                return head.next;
            }
    
            // Step 3: Find the Previous Node
            int indexToSearch = size - n;
            ListNode prev = head;
            int i = 0;
            
            // YOUR FIX: Stop loop at (indexToSearch - 1)
            while (i < indexToSearch - 1) {
                prev = prev.next;
                i++;
            }
    
            // Step 4: Delete the Node
            prev.next = prev.next.next;
            
            return head;
        }
    }
}