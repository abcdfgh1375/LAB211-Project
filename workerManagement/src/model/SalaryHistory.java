/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.library;
import java.util.Date;
import java.util.List;
import view.viewWorker;

/**
 *
 * @author THANH HUYEN
 */
public class SalaryHistory  {
    private String id;
    private String name;
    private int age;
    private String status;
    private Date date;
    private double salary;
    private String workLoc;
    
    viewWorker view = new viewWorker();
    library lib = new library();

    public SalaryHistory() {
    }

    public SalaryHistory(String id, String name, int age, double salary, String workLoc, String status, Date date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLoc = workLoc;
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
//        public void setStatus(String st) {
//        SalaryStatus s = null;
//        if (st.equalsIgnoreCase("UP")) {
//            this.status = SalaryStatus.UP;
//        }
//        if (st.equalsIgnoreCase("DOWN")) {
//            this.status = SalaryStatus.DOWN;
//        }
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLoc() {
        return workLoc;
    }

    public void setWorkLoc(String workLoc) {
        this.workLoc = workLoc;
    }

    public viewWorker getView() {
        return view;
    }

    public void setView(viewWorker view) {
        this.view = view;
    }

    public library getLib() {
        return lib;
    }

    public void setLib(library lib) {
        this.lib = lib;
    }

    @Override
    public String toString() {
        return String.format("%-8s%-10s%-10s%-13s%-13s%-10s", id, name, age, salary,status, date);
    }


}
