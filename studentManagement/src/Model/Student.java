/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Student implements Comparable<Student> {
    public String id;
    public String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
        super();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
    return s.name.compareTo(this.name);
    }
    
}
