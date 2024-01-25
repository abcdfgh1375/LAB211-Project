
package Repository;
import DataAccess.geographicAccess;
import Model.Country;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class classManageEastAsiaCountries implements interfaceManageEastAsiaCountries{
    private List<Country> countries = new ArrayList();

    public classManageEastAsiaCountries() {
    }
    
    public classManageEastAsiaCountries(List<Country> countries) {
        this.countries = new ArrayList();
    }
    
    @Override
    public void addCountryInformation() {
        try {
            geographicAccess.Countries().addCountry((ArrayList<Country>) countries);
        } catch (Exception ex) {
            Logger.getLogger(classManageEastAsiaCountries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getRecentlyEnteredInformation() {
        try {
            geographicAccess.Countries().displayRecentlyCountry((ArrayList<Country>) countries);
        } catch (Exception ex) {
            Logger.getLogger(classManageEastAsiaCountries.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    @Override
    public void searchInformationByName() {
        try {
            geographicAccess.Countries().searchInformationByName((ArrayList<Country>) countries);
        } catch (Exception ex) {
            Logger.getLogger(classManageEastAsiaCountries.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    @Override
    public void sortInformationByAscendingOrder() {
        try {
            geographicAccess.Countries().sortInformationByAscendingOrder((ArrayList<Country>) countries);
        } catch (Exception ex) {
            Logger.getLogger(classManageEastAsiaCountries.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
}
