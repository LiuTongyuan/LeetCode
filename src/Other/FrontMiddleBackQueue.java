package Other;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 年年
 * @Date 2021/12/24 9:58
 * @Description
 */
public class FrontMiddleBackQueue {
    private Deque<Integer> front;
    private Deque<Integer> back;
    int length;

    public FrontMiddleBackQueue() {
        front = new LinkedList<Integer>();
        back = new LinkedList<Integer>();
        length = 0;
    }

    public void pushFront(int val) {
        front.addFirst(val);
        if(front.size()>back.size()){
            back.addFirst(front.pollLast());
        }
        length++;
    }

    public void pushMiddle(int val) {
        if(front.size()<back.size()){
            front.addLast(val);
        }else{
            back.addFirst(val);
        }
        length++;
    }

    public void pushBack(int val) {
        back.addLast(val);
        if(front.size()<back.size()-1){
            front.addLast(back.pollFirst());
        }
        length++;
    }

    public int popFront() {
        if(length<=0){
            return -1;
        }
        length--;
        if(front.size()<back.size()){
            front.addLast(back.pollFirst());
        }
        return front.pollFirst();
    }

    public int popMiddle() {
        if(length<=0){
            return -1;
        }
        length--;
        if(front.size()<back.size()){
            return back.pollFirst();
        }else {
            return front.pollLast();
        }
    }

    public int popBack() {
        if(length<=0){
            return -1;
        }
        length--;
        if(front.size()>=back.size()){
            back.addFirst(front.pollLast());
        }
        return back.pollLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
