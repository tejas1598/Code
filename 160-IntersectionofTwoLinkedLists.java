public class IntersectionofTwoLinkedLists {

    // --- 1. ListNode Class ---
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // --- 2. Main Method (Test Setup) ---
    public static void main(String[] args) {
        // Constructing the Y-Shape intersection manually
        // List A: 4 -> 1 -> 8 -> 4 -> 5
        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        // Intersection starts at '8'
        
        // 1. Create the Common Part (8 -> 4 -> 5)
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // 2. Create Head A (4 -> 1 -> common)
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common; // Connect to intersection

        // 3. Create Head B (5 -> 6 -> 1 -> common)
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common; // Connect to intersection

        System.out.println("Finding Intersection...");

        IntersectionofTwoLinkedLists solver = new IntersectionofTwoLinkedLists();
        ListNode result = solver.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersected at node with value: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }
    }

    // --- 3. The Solution Logic ---
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check
        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Iterate until they collide
        // If they never intersect, they will both eventually become null at the same time (end of second run)
        while (ptrA != ptrB) {
            
            // Logic: If pointer hits end, switch to OTHER list head.
            // Otherwise, move to next node.
            
            if (ptrA == null) {
                ptrA = headB;
            } else {
                ptrA = ptrA.next;
            }

            if (ptrB == null) {
                ptrB = headA;
            } else {
                ptrB = ptrB.next;
            }
            
            // Shorthand version preferred by pros:
            // ptrA = (ptrA == null) ? headB : ptrA.next;
            // ptrB = (ptrB == null) ? headA : ptrB.next;
        }

        return ptrA; // returns the intersection node, or null if no intersection
    }

}
