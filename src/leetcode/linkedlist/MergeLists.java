package leetcode.linkedlist;

public class MergeLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode outList = null;
        ListNode curList = null;

        while( !(list1 == null && list2 == null) ) {
            // pull from list 1
            if( list2 == null || (list1 != null && list1.val <= list2.val) ) {
                if( outList == null ) {
                    outList = list1;
                    curList = outList;
                } else {
                    curList.next = list1;
                    curList = curList.next;
                }
                list1 = list1.next;
            } else { // must be pulling from list2
                if( outList == null ) {
                    outList = list2;
                    curList = outList;
                } else {
                    curList.next = list2;
                    curList = curList.next;
                }
                list2 = list2.next;
            }
        }
        return outList;
    }

}
