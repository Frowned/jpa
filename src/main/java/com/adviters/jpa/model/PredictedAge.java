package com.adviters.jpa.model;

public class PredictedAge {
    private String name;
    private int age;
    private int count;

    public PredictedAge() {

    }

    public PredictedAge(String name, int age, int count) {
        setAge(age);
        setName(name);
        setCount(count);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
