package model;

import java.util.ArrayList;

public class Man {
    public String name;
    public int age;
    private ArrayList<Pet> pets;
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