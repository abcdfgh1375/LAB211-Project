
package Utils;
import Controller.equationController;
import java.util.HashMap;

public class demo {

    public static void main(String[] args) throws Exception {
        equationController con = new equationController();
        HashMap<Character,Float> hash = new HashMap<Character,Float>();
//        con.displayCoefficients(con.inputTypeCoefficients(hash, 2));
//        con.findSolutionQuadaricEquation(hash);
        con.determineTypeNumList(hash, con.calSolutionQuadaricEquation(hash));
    }
}
