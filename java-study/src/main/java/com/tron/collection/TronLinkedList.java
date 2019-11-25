package com.tron.collection;

import java.util.*;

/**
 *
 * linkedList除了实现{@link List}外，还实现了{@link Queue}和{@link Deque}
 *提供了双端操作方法
 *
 *
 */
public class TronLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("1", "2", "3"));
        linkedList.addFirst("添加头部");
        print(linkedList);  //添加头部123

        linkedList.addLast("添加尾部");
        print(linkedList); //添加头部123添加尾部

        linkedList.getFirst(); //-------------对集合无影响
        print(linkedList); //添加头部123添加尾部

        linkedList.getLast(); //-------------对集合无影响
        print(linkedList); //添加头部123添加尾部

        linkedList.peekFirst();//-------------对集合无影响
        print(linkedList); //添加头部123添加尾部

        linkedList.peekLast();//-------------对集合无影响
        print(linkedList); //添加头部123添加尾部

        linkedList.pollFirst();//-------------对集合有影响
        print(linkedList); //123添加尾部

        linkedList.pollLast();//-------------对集合有影响
        print(linkedList); //123

        linkedList.removeFirst();//-------------对集合有影响
        print(linkedList); //23

        linkedList.removeLast();//-------------对集合有影响
        print(linkedList);   //2
    }

    private static void print(LinkedList<String> linkedList) {
        for (String s : linkedList) {
            System.out.print(s);
        }
        System.out.println("--------------------\n");
    }
}
