//package List;
//
//public class Test {
//    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.get(2);    // 返回 1
//        lRUCache.print();
//        lRUCache.put(2, 6); // 缓存是 {1=1}
//        lRUCache.print();
//        lRUCache.get(1);    // 返回 1
//        lRUCache.print();
//        lRUCache.put(1, 5); // 缓存是 {1=1}
//        lRUCache.print();
//        lRUCache.put(1, 2); // 缓存是 {1=1}
//        lRUCache.print();
//        lRUCache.get(1);    // 返回 1
//        lRUCache.print();
//        lRUCache.get(2);    // 返回 1
//        lRUCache.print();
//    }
//
//    static class LRUCache {
//        class ListNode {
//            int key;
//            int value;
//            ListNode next;
//        }
//
//        int size;
//        int capacity;
//        ListNode head, tail;
//
//        public LRUCache(int capacity) {
//            size = 0;
//            this.capacity = capacity;
//            head = new ListNode();
//            head.next = null;
//            tail = head;
//        }
//
//        public int get(int key) {
//            ListNode buf = head;
//            while (buf.next != null) {
//                if (buf.next.key == key) {
//                    ListNode next = buf.next;
//                    buf.next = buf.next.next;
//                    tail.next = next;
//                    tail = next;
//                    buf.next = next.next;
//                    tail.next = null;
//                    return next.value;
//                } else {
//                    buf = buf.next;
//                }
//            }
//            return -1;
//        }
//
//        public void put(int key, int value) {
//            ListNode buf = head;
//            while (buf.next != null) {
//                if (buf.next.key == key) {
//                    buf.next.value = value;
//                    ListNode next = buf.next;
//                    buf.next = buf.next.next;
//                    tail.next = next;
//                    tail = next;
//                    buf.next = next.next;
//                    tail.next = null;
//                    return;
//                } else {
//                    buf = buf.next;
//                }
//            }
//            if (size >= capacity) {
//                head = head.next;
//                size--;
//            }
//            ListNode last = new ListNode();
//            last.key = key;
//            last.value = value;
//            tail.next = last;
//            tail = last;
//            tail.next = null;
//            size++;
//        }
//
////        public void print(){
////            ListNode buf = head;
////            while(buf.next != null){
////                System.out.print(buf.next.key+"="+buf.next.value+"  ");
////                buf = buf.next;
////            }
////            System.out.println();
////        }
//    }
//}
