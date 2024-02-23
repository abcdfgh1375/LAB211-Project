/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.HashMap;

/**
 *
 * @author THANH HUYEN
 */
public class validationDict {
      public boolean checkExistByCode(HashMap<String, String> hash, String code) {
       return hash.containsKey(code);
    }
}
