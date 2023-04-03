package org.evolution.jvm;

public class MyStack {
    private Object[] elements;
    private int top = -1;
    private int maxSize;
    /*定义一个top来表示栈顶，初始化为-1*/

    /*初始化栈*/
    public MyStack(int capacity) {
        this.elements = new Object[capacity];
        this.maxSize = capacity;
    }

    /*将栈清空*/
    public void clearStack() {

    }

    /*栈满*/
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /*若栈为空返回ture，要不false*/
    public boolean isEmpty() {
        return top == -1;
    }

    /**/
    public void push(Object element) throws Exception {
        if(isFull()) {
            throw new Exception("栈满");
        }
        top++;
        elements[top] = element;
    }

    /**/
    public Object pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("栈为空");
        }
        Object element = elements[top];
        top --;
        return element;
    }

    /**/
    public void stackLength() {

    }

    /*字符串暴力破解*/
    public static int md(String str1,String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = str1.length();
        int s2Len = str2.length();

        int i = 0;
        int j = 0;

        while (i < s1Len && j < s2Len) {  // 保证匹配不越界
            if (s1[i] == s2[j]) { // 匹配成功
                i++;
                j++;
            } else {
                i = i -(j - 1);
                j = 0;
            }
        }

        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack(10);
        myStack.push(1);
        System.out.println(myStack.pop());
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
