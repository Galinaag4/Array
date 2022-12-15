package org.example;

import java.util.Arrays;
import java.util.Random;

public class IntegerListImpl implements IntegerList {
    private final Integer[] storage;
    private int size;

   public IntegerListImpl(){
       storage = new Integer[10];
   }
    public IntegerListImpl(int intSize){
        storage = new Integer[intSize];
    }
    private void validateSize(){};
    private void validateItem(Integer item){};
    private void validateIndex(int index){};

    @Override
    public Integer add(Integer item) {
       validateSize();
       validateItem(item);
       storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if(index==size){
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage,index,storage,index+1,size-index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];
        if(index!=size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item)!=-1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)){
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i >=0 ; i--) {
            if (storage[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Integer[] toArray() {
        return new Integer[0];
    }

    public static Integer[] toRandomArray(){
        Integer[] integers = new Integer[100000];
        for (int i = 0; i < integers.length; i++) {
            integers[i]=new Random().nextInt(1000);

        }
        return integers;
    }
    public static void sortInsertion(Integer[]integers) {
        for (int i = 1; i < integers.length; i++) {
            int temp = integers[i];
            int j = i;
            while (j > 0 && integers[j - 1] >= temp) {
                integers[j] = integers[j - 1];
                j--;
            }
            integers[j] = temp;
        }
    }

    public static void sortBubble(Integer[]integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - 1 - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    swapElements(integers, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(Integer[]integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }





    private static void swapElements(Integer[]arr,int indexA,int indexB){
        int tmp = arr[indexA];
        arr[indexA]=arr[indexB];
        arr[indexB] = tmp;
    }
    private static int binarySearch(Integer[]integers,Integer item){
        IntegerListImpl.sortInsertion(integers);
        return Arrays.binarySearch(integers,item);

    }
   public static void main (String[] args){
        Integer[] integers1 = IntegerListImpl.toRandomArray();
       Integer[] integers2 = IntegerListImpl.toRandomArray();
       Integer[] integers3 = IntegerListImpl.toRandomArray();
       long start1 = System.currentTimeMillis();
       sortInsertion(integers1);
       System.out.println("Сортировка вставками " + (System.currentTimeMillis()-start1));
       long start2 = System.currentTimeMillis();
       sortSelection(integers2);
       System.out.println("Сортировка выбором " + (System.currentTimeMillis()-start2));
       long start3 = System.currentTimeMillis();
       sortBubble(integers3);
       System.out.println("Сортировка пузырьком " + (System.currentTimeMillis()-start3));
   }



}
