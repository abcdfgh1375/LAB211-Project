package DataAccess;

import Model.Country;
import Model.EastAsiaCountries;
import Utils.InputterGeo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate; 
import java.util.stream.Collectors;

public class geographicAccess {
    private static geographicAccess coun;
    private InputterGeo input;
    public geographicAccess() {
        input = new InputterGeo();
    }
    
    public static geographicAccess Countries(){
        if(coun==null){
            synchronized (geographicAccess.class){
                if(coun==null){
                    coun = new geographicAccess();
                }
            } 
        }
        return coun;
    }
    
//function 1: create an East Asia country 
//    public void addCountry(HashMap<String, String> hashCountries, ArrayList<Country> countries) throws Exception{
//        addEastCountry(hashCountries, countries);
//    }
//    @SuppressWarnings("empty-statement")
//    public Country inputCountry(HashMap<String, String> hashCountries) {
//        Country aCountry = new Country();
//        do{
//        aCountry.setCountryCode(input.inputPattern("Enter code of country: ", "\\w+"));
//        }while(hashCountries.containsKey(aCountry.getCountryCode()));
//        aCountry.setCountryName(input.getAlphabelticStringFromInput("Enter name of country: "));
//        aCountry.setTotalArea(input.getFloatFromInput("Enter total area: ", 0));
//        return aCountry;
//    }
//    public EastAsiaCountries inputEastAsiaCountry(Country aCountry){
//        String terrain = input.getAlphabelticStringFromInput("Enter terrain of country: ");
//        aCountry = new EastAsiaCountries(aCountry.getCountryCode(),aCountry.getCountryName(),aCountry.getTotalArea(),terrain);
//        return (EastAsiaCountries) aCountry;
//    }
//
//    public void addEastCountry(HashMap<String, String> hashCountries, ArrayList<Country> countries) {
//        EastAsiaCountries eCountry = inputEastAsiaCountry(inputCountry(hashCountries));
//        countries.add(eCountry);
//        hashCountries.put(eCountry.getCountryCode(), eCountry.getCountryName());
//    }
    
    public void addCountry( ArrayList<Country> countries) throws Exception{//--mainFT1--
        addEastCountry( countries);
    }
    @SuppressWarnings("empty-statement")
    public Country inputCountry(ArrayList<Country> countries) throws Exception {
        Country aCountry = new Country();
        List<Country> listCountries = null;
        do{
        aCountry.setCountryCode(input.inputPattern("Enter code of country: ", "\\w+"));
        if(!countries.isEmpty()){
        listCountries = countries.stream().filter((anoCountry)->(anoCountry).getCountryCode().equals(aCountry.getCountryCode())).collect(Collectors.toList());
        } else {
            listCountries = new ArrayList<>();
        }}while(!listCountries.isEmpty());
        System.gc();
        aCountry.setCountryName(input.getAlphabelticStringFromInput("Enter name of country: "));
        aCountry.setTotalArea(input.getFloatFromInput("Enter total area: ", 0));
        return aCountry;
    }
    public EastAsiaCountries inputEastAsiaCountry(Country aCountry){
        String terrain = input.getAlphabelticStringFromInput("Enter terrain of country: ");
        aCountry = new EastAsiaCountries(aCountry.getCountryCode(),aCountry.getCountryName(),aCountry.getTotalArea(),terrain);
        return (EastAsiaCountries) aCountry;
    }

    public void addEastCountry( ArrayList<Country> countries) throws Exception{
        EastAsiaCountries eCountry = inputEastAsiaCountry(inputCountry(countries));
        countries.add(eCountry);
    }
//function 2: display recently country information

    public void displayRecentlyCountry(ArrayList<Country> countries) throws Exception{//---mainFT2---
        displayDetailEACountry(countries.get(countries.size()-1));
    }

    public void displayDetailEACountry(Country aCountry) throws Exception{
        System.out.println(String.format("%-10s%-10s%-15s%-10s", "ID","Name","Total Area","Terrain"));
        aCountry.display();
    }
//function 3: search country by name

    public void searchInformationByName(ArrayList<Country> countries)throws Exception {//---mainFT3---
        Country aCountry = searchCountryByName(countries,inputSearchingCountryName());
        if(aCountry == null){
            return;
        }
        displayDetailEACountry(aCountry);
    }

    public String inputSearchingCountryName() {
        String name = input.getAlphabelticStringFromInput("Enter the name you want to search for: ");
        return name;
    }

    public Country searchCountryByName(ArrayList<Country> countries,String keyName) throws Exception{
       List<Country> equivalentCountry = countries.stream() .filter((aCountry) -> aCountry.getCountryName().equalsIgnoreCase(keyName))  .collect(Collectors.toList()); 
       if(equivalentCountry.isEmpty()){
           System.out.println("Country have name " + keyName + " haven't added yet!");
           return null;
       }
       for (Country c : equivalentCountry){
            return c;
       }
       return null;
    }
//function 4: sort and display sorted country list

    public void sortInformationByAscendingOrder(ArrayList<Country> countries) throws Exception{//---mainFT4---
        displaySortedCountry(sortCountry(countries));        
    }

    public ArrayList<Country> sortCountry(ArrayList<Country> countries)throws Exception {
    countries.sort(Comparator.comparing(Country::getCountryName));
    return countries;
    }

    public void displaySortedCountry(ArrayList<Country> countries) {
        System.out.println(String.format("%-10s%-10s%-15s%-10s", "ID","Name","Total Area","Terrain"));
        countries.forEach((aCountry)->aCountry.display());
    }

}
