package com.adviters.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "character", schema = "videogame")
public class PlayableCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private double height;
    private int weight;
    private int bagId;
    private String sex;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public PlayableCharacter(){}
    public PlayableCharacter(String name, int age, double height, int weight, int bagId, int id, String sex)
    {
        setName(name);
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setBagId(bagId);
        setId(id);
        setSex(sex);
    }
    public void showCharacterInfo()
    {
        System.out.printf("Nombre: %s%n", this.getName());
        System.out.printf("Edad: %s%n", this.getAge());
        System.out.printf("Peso: %s%n", this.getWeight());
        System.out.printf("Altura: %s%n", this.getHeight());
    }
}
