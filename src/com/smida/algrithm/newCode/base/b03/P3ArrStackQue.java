package com.smida.algrithm.newCode.base.b03;

/**
 * 数组实现大小固定的栈和队列
 *
 * @author YYF
 * @date 2022/9/7 19:15.
 */
public class P3ArrStackQue {
    /**
     * 数组实现大小固定的栈
     */
    public static class P3Stack {

        public P3Stack(int size) {
            this.arr = new int[size];
        }

        int[] arr;
        int stackSize;

        public void push(int e) {
            if (stackSize == arr.length) {
                throw new IllegalArgumentException("栈已满");
            }
            arr[stackSize++] = e;
            System.out.println(e + " 入栈");
        }

        public Integer pop() {
            if (stackSize == 0) {
                throw new IllegalArgumentException("栈已空");
            }
            int stackTop = arr[--stackSize];
            System.out.println(stackTop + "出栈");
            return stackTop;
        }

        public boolean isEmpty() {
            return stackSize == 0;
        }

        public Integer peek() {
            if (isEmpty()) {
                throw new IllegalArgumentException("栈已空，没有栈顶");
            }
            return arr[stackSize - 1];
        }
    }

    /**
     * 数组实现大小固定的队列
     */
    public static class P3Queue {

        public P3Queue(int size) {
            this.arr = new int[size];
        }

        int[] arr;
        //head表示下一个元素入队位置，tail表示下一个元素出队位置
        // head==tail 表示队空/满
        int head;
        int tail;
        int queSize;

        public void offer(int e) {
            if (queSize == arr.length) {
                System.out.println("队列已满");
                return;
            }
            arr[head] = e;
            head = (head + 1) == arr.length ? 0 : head + 1;
            queSize++;
            System.out.println(e + " 入队");
        }

        public Integer pull() {
            if (queSize == 0) {
                System.out.println("队已空");
                return null;
            }
            int queTail = arr[tail];
            tail = (tail + 1) == arr.length ? 0 : tail + 1;
            System.out.println(queTail + "出队");
            queSize--;
            return queTail;
        }
    }

    public static void main(String[] args) {
        System.out.println("--------------------------");
        P3Queue que = new P3Queue(3);
        que.offer(1);
        que.offer(2);
        que.offer(3);
        que.offer(3);
        que.pull();
        que.pull();
        que.offer(4);
        que.pull();
        que.pull();
        que.pull();
    }
}
