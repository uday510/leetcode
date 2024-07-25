class Solution {
    public int[] sortArray(int[] array) {
       buildMaxHeap(array);
       for (int endIdx = array.length - 1; endIdx > 0; --endIdx) {
           swap(0, endIdx, array);
           siftDown(0, endIdx - 1, array);
       }
        return array;
    }
    public void buildMaxHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx > -1; --currentIdx) {
            siftDown(currentIdx, array.length - 1, array);
        }
    }
    public void siftDown(int currentIdx, int endIdx, int[] heap) {
        int childOneIdx = currentIdx * 2 + 1;
        while (childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap[childTwoIdx] > heap[childOneIdx]) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap[idxToSwap] > heap[currentIdx]) {
                swap(idxToSwap, currentIdx, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }
    public void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}