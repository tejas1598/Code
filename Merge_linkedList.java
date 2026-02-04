public class Merge_linkedList {

    // --- 1. The ListNode Class ---
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // --- 2. Main Method (Test Setup) ---
    public static void main(String[] args) {
        // Create List 1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create List 2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);

        // Run the Solution
        Solution solver = new Solution();
        ListNode mergedHead = solver.mergeTwoLists(list1, list2);

        System.out.print("Merged: ");
        printList(mergedHead);
    }

    // Helper to print lists
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // --- 3. The Solution Logic ---
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // Step 1: Create a Dummy Node
            // This acts as a placeholder for the start of our new list
            ListNode dummy = new ListNode(-1);
            
            // Step 2: Create a 'tail' pointer
            // This will move forward as we add new nodes
            ListNode tail = dummy;

            // Step 3: Loop while BOTH lists have data
            while (list1 != null && list2 != null) {
                
                // Compare the values
                if (list1.val <= list2.val) {
                    tail.next = list1;   // Attach list1 node
                    list1 = list1.next;  // Move list1 forward
                } else {
                    tail.next = list2;   // Attach list2 node
                    list2 = list2.next;  // Move list2 forward
                }
                
                tail = tail.next; // Move our tail pointer forward
            }

            // Step 4: Handle the leftovers
            // One list is empty, but the other might still have nodes.
            // Since the remaining nodes are already sorted, just attach the whole chain!
            if (list1 != null) {
                tail.next = list1;
            } else if (list2 != null) {
                tail.next = list2;
            }

            // Step 5: Return the real head (skip the dummy)
            return dummy.next;
        }
    }
}