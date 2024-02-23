/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author THANH HUYEN
 */
import Model.dictionaryPair;
import common.libraryDict;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class demo {
     public static boolean checkExistByCode(HashMap<String, String> hash, String code) {
       return hash.containsKey(code);
    }
    public static void main(String[] args) throws IOException {
        
        
        HashMap<String,String> dictionList = new HashMap<>();
        libraryDict lib = new libraryDict();
        lib.loadFromFile(dictionList, "diction.txt");
//        Map<String, String> sortedHash = new TreeMap<>(dictionList);
        String a = "cat";
        
//        dictionList.forEach((key, value) -> System.out.println(String.format("%-10s%s",key,value )));
//        for(String aa : dictionList.keySet()){
//            if(aa.equalsIgnoreCase(a)){
//                System.out.println(aa + dictionList.get(aa));
//                System.out.println("Find successful");
//                break;
//            }
//        }
        System.out.println(lib.removeWord(dictionList, a));
        lib.saveToFile("diction.txt", dictionList);
//        System.out.println(dictionList.containsKey(a));
//        System.out.println(lib.search(dictionList,"cat"));
//        
    }
}
