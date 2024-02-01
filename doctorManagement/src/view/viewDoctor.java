package view;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import model.doctor;

/**
 *
 * @author THANH HUYEN
 */
public class viewDoctor {

    public void displayResultFunction(boolean res, String functionName) {
        if (res) {
            System.out.println(functionName + " successfull!");
        } else {
            {
                System.out.println(functionName + " fail!");
            }
        }
    }

    public void displayHash(HashMap<String, doctor> hash, String msg, char c) {
        if(hash.isEmpty()){
            System.out.println("Hash is empty!");
            return;
        }
        displayTitle(msg, c);
        System.out.println(String.format("%-10s%-10s%-20s%s", "Code", "Name", "Specialization", "Availability"));
        Map<String, doctor> sortedHash = new TreeMap<>(hash);
        sortedHash.forEach((key, value) -> System.out.println(value.toString()));
    }
    

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }


}
