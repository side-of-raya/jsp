package model;

import java.util.ArrayList;

public class Man {
    private int id;
    private String name;
    private int age;
    private ArrayList<Pet> pets;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public ArrayList<Pet> getPets() {
        return pets;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void addPet(Pet pet) {
        this.pets.add(pet);
    }
    public void delPet(Pet pet) {
        this.pets.add(pet);
    }
}