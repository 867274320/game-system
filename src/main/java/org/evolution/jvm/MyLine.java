package org.evolution.jvm;

public class MyLine {
    private int[] elements; // 表示数据元素的线性结构
    private int size; // 有多少个数据元素
    private int capacity; // 开辟多大的空间


    /*先构造一个线性表*/
    private MyLine(int capacity) {
        this.elements = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    /*查询*/
    public int select(int index) throws Exception {
        if (index < 0 || index > capacity) {
            throw new Exception("输入的索引已超出范围");
        }
        return elements[index];
    }

    /*增加*/
    public void insert(int data) throws Exception {
        if (size == capacity) { //表示容量已满，arraylist就是在这扩容的，只不过人家是满足了容量的百分之75就扩容
            throw new Exception("输入的索引已超出范围");
        }
        elements[size++] = data;
    }

    /*修改*/
    public void update(int index,int data) {

    }

    /*修改*/
    public void update(int data) {
        for(int i = 0;i < capacity;i ++) {
            if (elements[i] == data) {
                elements[i] = data;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        MyLine myLine = new MyLine(4);
        myLine.insert(9);
        myLine.insert(8);
        myLine.insert(7);
        myLine.insert(6);
        System.out.println(myLine.select(0));
    }

}
