package model;

public class Pet {
    public Pet() {}
    public Pet(String name, int age, int master_id) {
        this.name = name;
        this.age = age;
        this.master_id = master_id;
    }
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean equals(Pet obj) {
        if (this.age != obj.age) return false;
        if (!this.name.equals(obj.name)) return false;
        if (this.master_id != obj.master_id) return false;
        return true;
    }
    private String name;
    private int age;
    private int master_id;
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getMaster() {
        return master_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMaster(int id) {
        this.master_id = id;
    }
}