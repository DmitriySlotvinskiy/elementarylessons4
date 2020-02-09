package com.slotvinskiy;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {

        int value;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.value = value;
        }
    }

    private int size;
    private Entry first;
    private Entry last;

    @Override
    public boolean add(int value) {
        Entry newElement = new Entry(value);
        if (size == 0) {
            first = newElement;
        } else {
            last.next = newElement;
            newElement.previous = last;
        }
        last = newElement;
        size++;
        return false;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry temp = first;
        for (int i = 0; i < size; i++) {
            result[i] = temp.value;
            temp = temp.next;
        }
        return result;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int get(int index) {
        throwExceptionIfIndexOut(index);
        return getEntry(index).value;
    }

    private Entry getEntry(int index) {
        Entry temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private void throwExceptionIfIndexOut(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Size is:" + size + " and index:" + index + " is out.");
        }
    }

    @Override
    public int remove() {
        throwExceptionIfEmpty();
        Entry temp = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first.next.previous = null;
            first = first.next;
        }
        size--;
        return temp.value;
    }

    private void throwExceptionIfEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("Trying to delete element from empty list");
        }
    }

    @Override
    public int element() {
        throwExceptionIfEmpty();
        return first.value;
    }

    @Override
    public void add(int index, int element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Size is:" + size + " and index:" + index + " is out.");
        }
        if (index == 0) {
            push(element);
            return;
        }
        Entry newEntry = new Entry(element);
        if (index == size) {
            newEntry.previous = last;
            last.next = newEntry;
            last = newEntry;
        } else {
            Entry temp = getEntry(index);
            newEntry.next = temp;
            newEntry.previous = temp.previous;
            temp.previous.next = newEntry;
            temp.previous = newEntry;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int remove(int index) {
        throwExceptionIfIndexOut(index);
        throwExceptionIfEmpty();
        Entry temp = getEntry(index);
        ;
        if (index == 0) {
            remove();
        } else if (index == size - 1) {
            last = temp.previous;
            size--;
        } else {
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            size--;
        }
        return temp.value;
    }

    @Override
    public boolean removeByValue(int value) {
        throwExceptionIfEmpty();
        int index = 0;
        Entry temp = first;
        for (index = 0; index < size; index++) {
            if (temp.value == value) {
                remove(index);
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public int set(int index, int element) {
        throwExceptionIfIndexOut(index);
        Entry temp = getEntry(index);
        int oldValue = temp.value;
        temp.value = element;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        throwExceptionIfIndexOut(fromIndex);
        throwExceptionIfIndexOut(toIndex);
        IntLinkedList subList = new IntLinkedList();
        int subListSize = toIndex - fromIndex;

        Entry originEntry = getEntry(fromIndex); //Don't spoil it!!!
        for (int i = 0; i < subListSize; i++) {
            subList.add(originEntry.value);
            if (i < subListSize - 1) {
                originEntry = originEntry.next;
            }
        }
        return subList;
    }


    @Override
    public void push(int value) {
        Entry temp = new Entry(value);
        if (size == 0) {
            last = temp;
        } else {
            temp.next = first;
            first.previous = temp;
        }
        first = temp;
        size++;
    }

    @Override
    public int pop() {
        return remove();
    }

    @Override
    public int peek() {
        if (size == 0) {
            return 0; //в стандартном листе тут должен быть null
        } else {
            return first.value;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
