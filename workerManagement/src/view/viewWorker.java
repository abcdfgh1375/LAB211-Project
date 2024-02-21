package view;

import Utils.InputterWorker;
import common.library;
import common.validationWorker;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import model.SalaryHistory;
import model.worker;

public class viewWorker {
//input

    private final AtomicInteger code = new AtomicInteger(0);
    private final InputterWorker input = new InputterWorker();
    private final validationWorker valid = new validationWorker();
    private final library lib = new library();

    public worker inputWorker(HashMap<String, worker> hash) {
        worker worker = new worker();
        String id = null;
        int var;
        //input code
        String msg;
        do {
            id = input.getStringFromInput("Enter Code: ");
            msg = valid.checkNullCode(id)? "Code cannot null":"";
            msg = valid.checkExistByCode( hash, id)?"Code is duplicate":"";
            if(!msg.isEmpty())System.out.println(msg);
        } while (!msg.isEmpty());
        worker.setId(id);
        //input name
        worker.setName(input.getAlphabelticStringFromInput("Enter Name: "));
        //input age
        do {
            var = input.getIntFromInput("Enter Year of Birth: ");
            msg = valid.checkAvailabilityAge(var)?"":"Age should be > 18";
           if(!msg.isEmpty())System.out.println(msg);
        } while (!msg.isEmpty());
        worker.setAge(var);
        //input salary
        do {
            var = input.getIntFromInput("Enter Salary: ");
             msg = valid.checkAvailabilityPositive(var)?"":"Salary should be > 0";
            if(!msg.isEmpty())System.out.println(msg);
        } while (!msg.isEmpty());
        worker.setSalary(var);
        //input location
        worker.setWorkLoc(input.getStringFromInput("Enter work location: "));
        return worker;
    }

    public String inputSearchWorkerCode(HashMap<String, worker> hash) {
         String msg;
         String id;
        do {
            id = input.getStringFromInput("Enter Code: ");
            msg = valid.checkNullCode(id)? "Code cannot null":"";
            msg = valid.checkExistByCode(hash, id)?"":"Code is not exist";
            if(!msg.isEmpty())System.out.println(msg);
        } while (!msg.isEmpty());
        return id;
    }

    public double inputAmountSalary() {
        double var;String msg;
        do {
            var = input.getDoubleFromInput("Enter Salary: ");
             msg = valid.checkAvailabilityPositive(var)?"":"Salary should be > 0";
            if(!msg.isEmpty())System.out.println(msg);
        } while (!msg.isEmpty());
        return var;
    }

    public Date inputDateSalary(){
        Date date = input.getFormattedDateFromInput("Enter Date e.c.23/12/2023: ");
        if(date.toString().isBlank()){
           Date dateNow = new Date(); 
            date = dateNow; 
        }
        return date;
    }

    //display
    public void displayResultFunction(boolean res, String functionName) {
        if (res) {
            System.out.println(functionName + " successfull!");
        } else {
            {
                System.out.println(functionName + " fail!");
            }
        }
    }

    public void displayHash(HashMap<String, worker> hash, String msg, char c) {
        if (hash.isEmpty()) {
            System.out.println("Hash is empty!");
            return;
        }
        displayTitle(msg, c);
        System.out.println(String.format("%-8s%-10s%-10s%-13s%s", "Code", "Name", "Age", "Salary","Work Location"));
        Map<String, worker> sortedHash = new TreeMap<>(hash);
        sortedHash.forEach((key, value) -> System.out.println(value.displayWorker()));
    }

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }
    public void displayArrList(String msg, char c, List<SalaryHistory> l){
        displayTitle(msg,c);
        System.out.println(String.format("%-8s%-10s%-10s%-13s%-13s%-10s", "Code","Name",
                "Age","Salary","Status","Date"));
        for(SalaryHistory s: l){
            System.out.println(s.toString());
        }
    }
    
        public void displaySalaryHistory(List<SalaryHistory> l) throws Exception {
            try{
                if(l.isEmpty()){
                    System.out.println("History is empty!");
                    return;
                }
                if(l==null){
                    throw new NullPointerException();
                }
            }catch(NullPointerException e){
                System.out.println(e.getMessage());
            }
       displayArrList("Display Information Salary", '-', l);
    }
    
       public void displayHash(HashMap<String, worker> hash) {
        displayHash(hash, "Worker List", '-');
    }
    
}
