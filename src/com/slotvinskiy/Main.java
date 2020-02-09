package com.slotvinskiy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        IntLinkedList intLinkedList = new IntLinkedList();
        Deque<Integer> queue = new LinkedList<>();

        intLinkedList.push(1);
        intLinkedList.push(2);
        intLinkedList.push(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("queue (" + queue.size() + ") - " + queue);
        System.out.println("IntLinkedList (" + intLinkedList.size() + ") - " + intLinkedList);
        System.out.println("queue.element() = " + queue.element());
        System.out.println("intLinkedList.element() = " + intLinkedList.element());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("intLinkedList.peek() = " + intLinkedList.peek());
        intLinkedList.pop();
        intLinkedList.pop();
        intLinkedList.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println("Deque (" + queue.size() + ") - " + queue + ";  IntLinkedList (" + intLinkedList.size() + ") - " + intLinkedList);

        System.out.println("=============================");

        intLinkedList.clear();
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        intLinkedList.add(0);
        intLinkedList.add(10);
        intLinkedList.add(20);
        intLinkedList.add(30);
        intLinkedList.add(40);
        intLinkedList.add(50);
        printBothLists(intLinkedList, linkedList);
        System.out.println("linkedList.get(5) = " + linkedList.get(5) + ";    intLinkedList.get(5) = " + intLinkedList.get(5));
        System.out.println("linkedList.get(0) = " + linkedList.get(0) + ";    intLinkedList.get(0) = " + intLinkedList.get(0));

        linkedList.add(0, 100);
        intLinkedList.add(0, 100);
        printBothLists(intLinkedList, linkedList);

        linkedList.add(100);
        intLinkedList.add(100);
        printBothLists(intLinkedList, linkedList);

        intLinkedList.removeByValue(100);           //удаление первого из двух значений
        intLinkedList.removeByValue(999);           //удаление не происходит, т.к. нет такого значения
        intLinkedList.removeByValue(50);            //удаление уникального значения
        linkedList.remove((Integer) 100);
        linkedList.remove((Integer) 999);
        linkedList.remove((Integer) 50);
        printBothLists(intLinkedList, linkedList);
        linkedList.add(0, -1);
        linkedList.add(3, 333);
        linkedList.add(8, 888);
        intLinkedList.add(0, -1);       //вставка в начало
        intLinkedList.add(3, 333);      //вставка в середину
        intLinkedList.add(8, 888);      //вставка в конец
        printBothLists(intLinkedList, linkedList);
        intLinkedList.set(0, 5);                      //изменение элемента в начале
        intLinkedList.set(5, 33);                     //изменение элемента в середине
        intLinkedList.set(8, 999);                    //изменение элемента в конце
        linkedList.set(0, 5);
        linkedList.set(5, 33);
        linkedList.set(8, 999);
        printBothLists(intLinkedList, linkedList);

        System.out.println("============= subList(1, 5) ================");

        List<Integer> subList = linkedList.subList(1, 5);
        IntList subList1 = intLinkedList.subList(1, 5);

        System.out.println(subList);
        System.out.println(subList1);

        System.out.println("============== isEmpty() ===============");

        System.out.print(linkedList.isEmpty() + " - ");
        System.out.println(intLinkedList.isEmpty());
        intLinkedList.clear();
        linkedList.clear();
        System.out.print(linkedList.isEmpty() + " - ");
        System.out.println(intLinkedList.isEmpty());

    }

    private static void printBothLists(IntLinkedList list1, List<Integer> list) {
        System.out.println("LinkedList (" + list.size() + ") - " + list + ";  IntLinkedList (" + list1.size() + ") - " + list1);
    }
}
