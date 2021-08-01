public class TwiceTest3 {

    public ListNode reverse(ListNode head){

        if(head == null){
            return null;
        }


        if(head.next == null){
            return head;
        }


        ListNode revHead = null;

        ListNode curNode = head;

        while(curNode != null){
            ListNode tmpNode = curNode.next;
            curNode.next = revHead;
            revHead = curNode;
            curNode = tmpNode;
        }

        return revHead;
    }

    public static void main(String[] args) {
        TwiceTest3 test = new TwiceTest3();

        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();

        head.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 4;
        temp4.value = 5;
        temp5.value = 6;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = null;

        System.out.println("反转前--------");
        test.printList(head);
        System.out.println();

        System.out.println("反转后--------");
        ListNode reverseHead = test.reverse(head);
        test.printList(reverseHead);

    }


    public void printList(ListNode head){
        while(head != null){
            System.out.print(head.value + "  ");
            head = head.next;
        }
    }
}

class ListNode{
    int value;
    ListNode next;
}