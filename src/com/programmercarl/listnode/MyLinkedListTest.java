package com.programmercarl.listnode;

/**
 * ClassName: MyLinkedListTest
 * Package: com.programmercarl.listnode
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/3/4 14:13
 * @Version 1.0
 */
public class MyLinkedListTest {
    public static void main(String[] args) {
        String[] commands = {"MyLinkedList", "addAtTail", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"};
        int[][] vals = {{}, {1}, {3}, {1, 2}, {1}, {1}, {2}};

        MyLinkedList obj = new MyLinkedList();

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "MyLinkedList":
                    //MyLinkedList obj = new MyLinkedList();
                    break;
                case "get":
                    System.out.println(obj.get(vals[i][0]));
                    break;
                case "addAtHead":
                    obj.addAtHead(vals[i][0]);
                    break;
                case "addAtTail":
                    obj.addAtTail(vals[i][0]);
                    break;
                case "addAtIndex":
                    obj.addAtIndex(vals[i][0], vals[i][1]);
                    break;
                case "deleteAtIndex":
                    obj.deleteAtIndex(vals[i][0]);
                    break;
            }
        }
    }
}
