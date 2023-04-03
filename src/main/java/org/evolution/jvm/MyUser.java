package org.evolution.jvm;

public class MyUser {
    private int id;
    private String name;

    byte[] a = new byte[1024*100];

    public MyUser(){}

    public MyUser(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
