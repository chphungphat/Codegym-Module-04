package com.codegym.injection.setter;

public class Tran {
    private int id;

    private String fullName;

    private Clazz clazz;

    public Tran(int id, String fullName, Clazz clazz) {
        this.id = id;
        this.fullName = fullName;
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Tran{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}
