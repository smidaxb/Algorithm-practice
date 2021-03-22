package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 找到数组中最小的k个值
 * <p>
 * 用堆排序，建个大顶堆，可以达到Nlogk的时间复杂度
 */
public class Problem_04_FindMinKNums {
    // My
    public static int[] getMinKNumsByHeapMy(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        //前k个数先进堆，建堆
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsertMy(kHeap, arr[i], i);
        }
        //从第k+1个数开始,如果大于堆顶直接跳过，小于堆顶令其称为堆顶，然后调整堆
        for (int i = k; i != arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapifyMy(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    //堆排序
    public static void heapSortMy(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //建堆
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int value = arr[index];
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (arr[parent] < value) {
                    swap(arr, parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }
        printArray(arr);
        //调整堆:将当前堆最后一个元素跟堆顶元素换，则当前最大值到达最终位置，然后由堆顶调整堆
        int heapSize = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapSize--;
            heapifyMy(arr, 0, heapSize);
        }
    }

    //入堆建堆
    public static void heapInsertMy(int[] arr, int value, int index) {
        //先直接进数组
        arr[index] = value;
        while (index != 0) {
            //比较父节点和其的值，父节点小于它就交换，保证父节点一定大于子节点
            int parentInd = (index - 1) / 2;
            if (arr[parentInd] < value) {
                swap(arr, parentInd, index);
                index = parentInd;
            } else {
                break;
            }
        }
    }

    //从index位置开始调整堆
    public static void heapifyMy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int large = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                large = left;
            }
            if (right < heapSize && arr[right] > arr[left]) {
                large = right;
            }
            if (large != index) {
                swap(arr,index,large);
            } else {
                break;
            }
            index = large;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    // O(N*logK)标准答案
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        //前k个数先进堆，建堆
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsert(kHeap, arr[i], i);
        }
        //从第k+1个数开始
        for (int i = k; i != arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    public static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    //Test and print
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getMinKNumsByHeap(arr, 10));
        printArray(getMinKNumsByHeapMy(arr, 10));
        heapSortMy(arr);
        printArray(arr);
    }
}
