package Sort;

/**
 * @author 年年
 * @date 2021/12/14 09:13
 */
public class Sort {
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortWithBreak(int[] array) {
        int length = array.length;
        boolean flag = true;
        for (int i = 1; i < length && flag; i++) {
            flag = false;
            for (int j = 0; j < length - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    public static void selectSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int minindex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minindex] > array[j]) {
                    minindex = j;
                }
            }
            swap(array, minindex, i);
        }
    }

    public static void insertSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = temp;
        }
    }

    /**
     * [left,right);
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {
        if (left < right - 1) {
            //最右边的点作为key
            int key = array[right - 1];

            int l = left - 1;
            int r = right - 1;
            while (l < r) {
                while (l < r && array[++l] < key) ;
                swap(array, l, r);
                while (l < r && array[--r] > key) ;
                swap(array, l, r);
                /*
                * 下面是错误写法
                * */
//                while (l < r && array[++l] < key) {
//                    swap(array, l, r);
//                }
//
//                while (l < r && array[--r] > key) {
//                    swap(array, l, r);
//                }
            }
            array[l] = key;
            quickSort(array, left, l);
            quickSort(array, l + 1, right);
        }
    }

    public static void quickSort2(int[] array, int left, int right) {
        if (left < right - 1) {
            int key = array[right - 1];
            int l = left, r = right - 1;
            for (; l < r; ) {
                if (array[l] > key) {
                    array[r--] = array[l];
                    array[l] = array[r];
                } else {
                    l++;
                }
            }
            array[l] = key;
            quickSort2(array, left, l);
            quickSort2(array, r + 1, right);
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right - 1) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid, right);
            int[] buf = new int[right - left];
            int i = 0;
            int l = left;
            int r = mid;
            for (; i < buf.length && l < mid && r < right; i++) {
                if (array[l] < array[r]) {
                    buf[i] = array[l++];
                } else {
                    buf[i] = array[r++];
                }
            }
            for (; l < mid; ) {
                buf[i++] = array[l++];
            }
            for (; r < right; ) {
                buf[i++] = array[r++];
            }
            for (int j = 0; j < buf.length; j++) {
                array[left + j] = buf[j];
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        quickSort(array, 0, array.length);
        printArray(array);
    }
}
