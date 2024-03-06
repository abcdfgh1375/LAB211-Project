package common;

import Model.StringInput;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THANH HUYEN
 */
public class libraryStringAnalyze {

    public List<Integer> getAllNumber(StringInput input) {
        String[] listNumber = input.getInput().replaceAll("\\D", " ").split(" ");
        List<Integer> list = new ArrayList<>();
        for (String s : listNumber) {
            if (!s.isEmpty()) {
                list.add(Integer.parseInt(s));
            }
        }
        return list;
    }



    public List<Integer> getEvenOddNumber(List<Integer> list, String msg) throws Exception {
        List<Integer> resList = new ArrayList();
        try {
            for (Integer s : list) {
                if (msg.equalsIgnoreCase("even")) {
                    if (s % 2 == 0) {
                        resList.add(s);
                    }
                }
                if (msg.equalsIgnoreCase("odd")) {
                    if (s % 2 != 0) {
                        resList.add(s);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return resList;
    }

    public List<Integer> getSquareNumber(List<Integer> list) {
    List<Integer> resList = new ArrayList<>();
    for (Integer s : list) {
        if(Math.sqrt(s) * Math.sqrt(s) == s){
            resList.add(s);
        }
    }
    return resList;
}


    public StringBuilder getAllCharacter(StringInput input) {
        String listChar = input.getInput().replaceAll("\\\\d", "");
        return new StringBuilder(listChar);
    }

    public StringBuilder getUpperLowerChar(String inputString, String msg) throws Exception {
        String res = null;
        try {
            if (msg.equalsIgnoreCase("UpperCase")) {
                res = inputString.replaceAll("\\W|[0-9]|[a-z]", "");
            } else if (msg.equalsIgnoreCase("LowerCase")) {
                res = inputString.replaceAll("\\W|[0-9]|[A-Z]", "");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new StringBuilder(res);
    }

    public StringBuilder getSpecialChar(String inputString) {
        String special = inputString.replaceAll("\\w", "");
        return new StringBuilder(special);
    }

}
