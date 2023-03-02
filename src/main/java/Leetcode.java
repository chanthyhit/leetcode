public class Leetcode {
    public static void main(String[] args) {
        //int n = numberOfSteps(14);
        /*ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(5, listNode);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(5, listNode3);
        System.out.println(middleNode(listNode4).val);*/
        //System.out.println("ab".indexOf("z"));
        String str = "Hello world!";
        reverseHelper(str.toCharArray(), 0);

    }

    private static void reverseHelper(char[] str, int index) {
        if (str == null || index >= str.length / 2) {
            System.out.println(str);
            return; // Base case: if string is empty or has only one character, or index has reached the middle of the array
        }

        // Swap the characters at index and the corresponding position from the end of the array
        int endIndex = str.length - 1 - index;
        char temp = str[index];
        str[index] = str[endIndex];
        str[endIndex] = temp;
        // Recursive case: call the function recursively with the next index
        reverseHelper(str, index + 1);
    }

    static int numberOfSteps(int num) {
        if (num == 0) return num;
        return 1 + (num % 2 == 0 ? numberOfSteps(num / 2) : numberOfSteps(num - 1));
        /*
        int step = 0;
        while(num>0){
            if(num%2==0) num /= 2;
            else num --;
            step ++;
        }
        return step;

         */
    }

    static ListNode middleNode(ListNode head) {
        ListNode middle = head;
        ListNode end = head;
        while(end != null && end.next != null){
            middle = middle.next;
            end = end.next.next;
        }
        return middle;
        /*ArrayList<ListNode> array = new ArrayList<>();
        int length = 0;
        while(head != null){
            array.add(head);
            head = head.next;
            length++;
        }
        return array.get(length / 2);*/
    }

}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }