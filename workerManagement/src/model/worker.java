package model;

import common.library;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import view.viewWorker;

public class worker {

    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLoc;

    public worker() {
    }

//    Enter Code:
//Enter Name:
//Enter Age:
//Enter Salary: 
//Enter work location:
//	Code(id) cannot be null or duplicated with existed Code in DB.
//	Age must be in range 18 to 50
//	Salary must be greater than 0
    viewWorker view = new viewWorker();
    library lib = new library();

    public worker(String id, String name, int age, double salary, String workLoc) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLoc = workLoc;
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
        Calendar instance = Calendar.getInstance();
        int yearNow = instance.get(Calendar.YEAR);
        this.age = yearNow - age;
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

    @Override
    public String toString() {
        return "worker{" + "id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", workLoc=" + workLoc + ", view=" + view + ", lib=" + lib + '}';
    }

     public String displayWorker() {
        return String.format("%-8s%-10s%-10s%-13s%s", id, name, age, salary,workLoc);
    }
    public boolean addWorker(HashMap<String, worker> hash) throws Exception {
        return lib.addWorker(hash,view.inputWorker(hash));
    }

        public boolean changeSalary(HashMap<String, worker> hash,List<SalaryHistory> l,String s) throws Exception {
        return lib.changeSalary(hash,l,lib.takeStatus(s), view.inputSearchWorkerCode(hash), view.inputAmountSalary(), view.inputDateSalary());
    }

    public List<SalaryHistory> getInfomationSalary(List<SalaryHistory> l) {
        return lib.getInfomationSalary(l);
    }
}
