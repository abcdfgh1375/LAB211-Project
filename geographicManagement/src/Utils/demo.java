
package Utils;

import DataAccess.geographicAccess;
import Model.Country;
import Model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class demo {

    public static void main(String[] args) throws Exception {
        InputterGeo an = new InputterGeo();
        List<Country> ne = new ArrayList<>();
        geographicAccess access = new geographicAccess();
        HashMap<String, String> hashCountries = new HashMap();
        access.addCountry( (ArrayList<Country>) ne);
        access.addCountry((ArrayList<Country>) ne);
        access.sortInformationByAscendingOrder((ArrayList<Country>) ne);
//        access.displayRecentlyCountry((ArrayList<Country>) ne);
//        access.searchInformationByName((ArrayList<Country>) ne);
        String a = an.getAlphabelticStringFromInput("enter:");
        System.out.println(a);
    }
}
