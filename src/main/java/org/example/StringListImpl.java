package org.example;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private String[] stringList;
    private int size;
    private static final String WRONG_DATA_ENTERED = "Некорректно введены данные.";


    public StringListImpl(int size) {
        this.stringList = new String[size];
        this.size = size;
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] == null) {
                stringList[i] = item;
                return item;
            }


        }

        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > stringList.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Элемент выходит за рамки массива");
        }
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (i > index) {
                stringList[i] = stringList[i - 1];
            }

        }
        stringList[index] = item;
        return item;

    }

    @Override
    public String set(int index, String item) {
        if (index >= stringList.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Такого индекса в массиве нет");
        }
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        stringList[index] = item;
        return null;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if (!stringList[i].equals(item)) {
                throw new IllegalArgumentException("Нет такой строки в массиве");
            } else {
                return stringList[i] = null;
            }

        }

        return null;
    }

    @Override
    public String remove(int index) {
        return stringList[index] = null;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null && stringList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null && stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (stringList[i] != null && stringList[i].equals(item)) {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null || otherList.get(i) != null) {
                if (!stringList[i].equals(otherList.get(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int size() {
        int factSize = 0;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null) {
                factSize++;
            }
        }

        return factSize;
    }

    @Override
    public boolean isEmpty() {
        int factSize = 0;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null) {
                factSize++;
            }
        }

        return factSize == 0;

    }

    @Override
    public void clear() {
        Arrays.fill(stringList, null);


    }

    @Override
    public String[] toArray() {
        String[] strings = new String[stringList.length];
        for (int i = 0; i < stringList.length; i++) {
            strings[i] = stringList[i];
        }
        return strings;
    }

    @Override
    public String toString() {
        return "Array{" +
                "stringList=" + Arrays.toString(stringList) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringListImpl array)) return false;
        return size == array.size && Arrays.equals(stringList, array.stringList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(stringList);
        return result;
    }
}
