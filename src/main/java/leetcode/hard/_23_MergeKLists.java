package leetcode.hard;

import linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2021/9/4 23:52
 */
public class _23_MergeKLists {
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }


    class MyCompare implements Comparator<ListNode>{

        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val-n2.val;
        }
    }
    Queue<ListNode> minHeap = new PriorityQueue<>(new MyCompare());
    public ListNode mergeKLists1(ListNode[] lists) {
        for (ListNode head: lists) {
            while (head != null) {
                minHeap.offer(head);
                head = head.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!minHeap.isEmpty()) {
            head.next = minHeap.poll();
            head = head.next;
            if(minHeap.size()==0){
                head.next = null;
            }
        }
        return dummy.next;
    }
}
