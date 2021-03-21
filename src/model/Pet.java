package model;

public class Pet {
    public Pet() {}
    private int id;
    public Pet(String name, int age, int master_id, String masterName) {
        this.name = name;
        this.age = age;
        this.master_id = master_id;
        this.masterName = masterName;
    }
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean equals(Pet obj) {
        if (!(this.age == obj.age                 ||
                this.master_id == obj.master_id   ||
                this.name.equals(obj.name)        ||
                this.masterName == obj.masterName
        )) return false;
        return true;
    }
    private String name;
    private int age;
    private int master_id;
    private String masterName;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getMasterID() {
        return master_id;
    }
    public void setMasterName(String masterName) { this.masterName = masterName; }
    public String getMasterName() {
        return masterName;
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