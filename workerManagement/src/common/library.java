package common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import model.SalaryHistory;
import model.worker;

public class library {

    public HashMap<String, worker> workerList = new HashMap<>();
    public List<SalaryHistory> salaryList = new ArrayList<>();
    validationWorker valid = new validationWorker();

    public HashMap<String, worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(HashMap<String, worker> workerList) {
        this.workerList = workerList;
    }

    public List<SalaryHistory> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<SalaryHistory> salaryList) {
        this.salaryList = salaryList;
    }
    
    
    public library() {
    }

    //ADD
    public void add(HashMap<String, worker> hash,worker w) {
        hash.put(w.getId(), w);
    }

    public boolean addWorker(HashMap<String, worker> hash,worker w) throws Exception {
        try {
            if (hash == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Database does not exist");
            return false;
        }
        try {
            if (w == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Data does not exist");
            return false;
        }
        add(hash,w);
        return true;
    }

    //UPDATE_SALARY
        enum SalaryStatus {
        UP, DOWN;
    }
    public void UpSalary(List<SalaryHistory> l,worker w, double amount, Date day) {
        double sal = w.getSalary() + amount;
        l.add(new SalaryHistory(w.getId(),w.getName(),w.getAge(),sal,w.getWorkLoc(),"UP",day));
    }

    public void DownSalary(List<SalaryHistory> l,worker w, double amount, Date day) {
        double sal = w.getSalary() - amount;
        l.add(new SalaryHistory(w.getId(),w.getName(),w.getAge(),sal,w.getWorkLoc(),"DOWN",day));
    }
    

        public SalaryStatus takeStatus(String status) {
            SalaryStatus s = null;
        if (status.equalsIgnoreCase("UP")) {
            s = SalaryStatus.UP;
        }
        if (status.equalsIgnoreCase("DOWN")) {
            s = SalaryStatus.DOWN;
        }
        return s;
    }
        
    public boolean changeSalary(HashMap<String, worker> hash,List<SalaryHistory> l,SalaryStatus status, String code, double amount, Date day) throws Exception {
        try {
            if (hash == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Database does not exist");
            return false;
        }
        worker w = hash.get(code);
        switch (status) {
            case UP -> {
                UpSalary(l,w, amount, day);
                w.setSalary(w.getSalary()+amount);
            }
            case DOWN -> {
                DownSalary(l,w, amount, day);
                w.setSalary(w.getSalary()-amount);
            }
        }
        return true;
    }
    

    //SHOW
    public List<SalaryHistory> getInfomationSalary(List<SalaryHistory> l) {
        l.sort(Comparator.comparing(SalaryHistory::getId));
        return l;
    }
}
