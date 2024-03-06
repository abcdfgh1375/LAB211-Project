
package Controller;

import Model.StringInput;
import View.viewStringAnalyze;
import java.util.HashMap;
import java.util.List;

import common.libraryStringAnalyze;

public class AnalysisStringController {

    libraryStringAnalyze lib = new libraryStringAnalyze();
    viewStringAnalyze view = new viewStringAnalyze();

    public void run() throws Exception {
        view.displayTitle("Analysis String program ", '=');
        StringInput s = view.getInput();
        view.displayTitle("Result Analysis", '-');
        view.displayHash(getNumber(s));
        view.displayHash(getCharacter(s));

    }

    public HashMap<String, List<Integer>> getNumber(StringInput input) throws Exception {
        HashMap<String, List<Integer>> a = new HashMap();
        List<Integer> n = lib.getAllNumber(input);
        List<Integer> evenN = lib.getEvenOddNumber(n, "even");
        List<Integer> oddN = lib.getEvenOddNumber(n, "odd");
        List<Integer> squareN = lib.getSquareNumber(n);

        a.put("1.All Numbers", n);
        a.put("Perfect Square Numbers", squareN);
        a.put("Odd Numbers", oddN);
        a.put("Even Numbers", evenN);
        return a;
    }

    public HashMap<String, StringBuilder> getCharacter(StringInput input) throws Exception {
        HashMap<String, StringBuilder> a = new HashMap();
        StringBuilder s = lib.getAllCharacter(input);
        String str = s.toString();
        StringBuilder upperC = new StringBuilder(lib.getUpperLowerChar(str, "uppercase"));
        StringBuilder lowerC = new StringBuilder(lib.getUpperLowerChar(str, "lowercase"));
        StringBuilder specialC = new StringBuilder(lib.getSpecialChar(str));

        a.put("1.All Characters", s);
        a.put("Uppercase Characters", upperC);
        a.put("Lowercase Characters", lowerC);
        a.put("Special Characters", specialC);

        return a;
    }
}
