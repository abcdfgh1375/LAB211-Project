package Controller;

import Model.Country;
import Model.EastAsiaCountries;
import View.Menu;
import Utils.InputterGeo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class geographicController extends Menu {

    private classManageEastAsiaCountries countryManage;

    public geographicController() {
        super("MENU", Arrays.asList(new String[]{"Input the information of 11 countries in East Asia",
            "Display the information of country you've just input",
            "Search the information of country by user-entered name",
            "Display the information of countries sorted name in ascending order",
            "Exit"}));
        countryManage = new classManageEastAsiaCountries();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                countryManage.addCountryInformation();
                break;
            case 2:
                countryManage.getRecentlyEnteredInformation();
                break;
            case 3:
                countryManage.searchInformationByName();
                break;
            case 4:
                countryManage.sortInformationByAscendingOrder();
                break;
            default:
                System.exit(0);
        }
    }

    class classManageEastAsiaCountries {

        private List<Country> countries = new ArrayList();

        public classManageEastAsiaCountries() {
        }

        public classManageEastAsiaCountries(List<Country> countries) {
            this.countries = new ArrayList();
        }

        public void addCountryInformation() {
            geographicAccess access = new geographicAccess();
            //switch choice cho người dùng chọn load hay input
            String[] menuAddCountry = {"1. Load from file", "2. Input country"};
            for(String str : menuAddCountry ){
                System.out.println(str);
            }
            switch (getChoice()) {
                case 1:
                    access.loadFromFile((ArrayList<Country>) countries, "countries.txt");
                    break;
                case 2:
                    try {
                    access.Countries().addCountry((ArrayList<Country>) countries);
                } catch (Exception ex) {
                    Logger.getLogger(classManageEastAsiaCountries.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                default:
                    return;
            }
        }

        public void getRecentlyEnteredInformation() {
            geographicAccess access = new geographicAccess();
            try {
                access.Countries().displayRecentlyCountry((ArrayList<Country>) countries);
            } catch (Exception ex) {
                Logger.getLogger(classManageEastAsiaCountries.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void searchInformationByName() {
            geographicAccess access = new geographicAccess();
            try {
                access.Countries().searchInformationByName((ArrayList<Country>) countries);
            } catch (Exception ex) {
                Logger.getLogger(classManageEastAsiaCountries.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void sortInformationByAscendingOrder() {
            geographicAccess access = new geographicAccess();
            try {
                access.Countries().sortInformationByAscendingOrder((ArrayList<Country>) countries);
            } catch (Exception ex) {
                Logger.getLogger(classManageEastAsiaCountries.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public class geographicAccess {

        private static volatile geographicAccess coun;
        private final InputterGeo input;

        public geographicAccess() {
            input = new InputterGeo();
        }

        public geographicAccess Countries() {
            geographicAccess aCountry = geographicAccess.coun;
            if (aCountry == null) {
                synchronized (geographicAccess.class) {
                    aCountry = geographicAccess.coun;
                    if (aCountry == null) {
                        geographicAccess.coun = aCountry = new geographicAccess();
                    }
                }
            }
            return aCountry;
        }

//        String fileName = "countries.txt";
        public ArrayList<Country> loadFromFile(ArrayList<Country> countries, String fileName) throws NumberFormatException {
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                if ((line = br.readLine()) == null) {
                    System.out.println("File is empty");
                    return null;
                }
                while ((line = br.readLine()) != null) {
                    String[] linearr = line.split("\\|");
                    try {
                        countries.add(new EastAsiaCountries(linearr[0], linearr[1], Float.parseFloat(linearr[2]), linearr[3]));
                        //id|name|area|terrain
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing float at line: " + line);
                    }
                }
                br.close();
            } catch (FileNotFoundException nfe) {
                System.out.println("File not found " + fileName);
            } catch (IOException ex) {
                System.out.println("An error occurred while reading the file");
            }
            System.out.println("Load from file successfulled!");
            return countries;
        }

        public void addCountry(ArrayList<Country> countries) throws Exception {//--mainFT1--
            addEastCountry(countries);
        }

        @SuppressWarnings("empty-statement")
        public Country inputCountry(ArrayList<Country> countries) throws Exception {
            Country aCountry = new Country();
            List<Country> listCountries = null;
            do {
                aCountry.setCountryCode(input.inputPattern("Enter code of country: ", "\\w+"));
                if (!countries.isEmpty()) {
                    listCountries = countries.stream().filter((anoCountry) -> (anoCountry).getCountryCode().equals(aCountry.getCountryCode())).collect(Collectors.toList());
                } else {
                    listCountries = new ArrayList<>();
                }
            } while (!listCountries.isEmpty());
            System.gc();
            aCountry.setCountryName(input.getAlphabelticStringFromInput("Enter name of country: "));
            aCountry.setTotalArea(input.getFloatFromInput("Enter total area: ", 0));
            return aCountry;
        }

        public EastAsiaCountries inputEastAsiaCountry(Country aCountry) {
            String terrain = input.getAlphabelticStringFromInput("Enter terrain of country: ");
            aCountry = new EastAsiaCountries(aCountry.getCountryCode(), aCountry.getCountryName(), aCountry.getTotalArea(), terrain);
            return (EastAsiaCountries) aCountry;
        }

        public void addEastCountry(ArrayList<Country> countries) throws Exception {
            EastAsiaCountries eCountry = inputEastAsiaCountry(inputCountry(countries));
            countries.add(eCountry);
        }
//function 2: display recently country information

        public void displayRecentlyCountry(ArrayList<Country> countries) throws Exception {//---mainFT2---
            if (countries.isEmpty()) {
                System.out.println("List of countries is empty!");
                return;
            }
            displayDetailEACountry(countries.get(countries.size() - 1));
        }

        public void displayDetailEACountry(Country aCountry) throws Exception {
            System.out.println(String.format("%-10s%-15s%-15s%-10s", "ID", "Name", "Total Area", "Terrain"));
            aCountry.display();
        }
//function 3: search country by name

        public void searchInformationByName(ArrayList<Country> countries) throws Exception {//---mainFT3---
            Country aCountry = searchCountryByName(countries, inputSearchingCountryName());
            if (aCountry == null) {
                return;
            }
            displayDetailEACountry(aCountry);
        }

        public String inputSearchingCountryName() {
            String name = input.getAlphabelticStringFromInput("Enter the name you want to search for: ");
            return name;
        }

        public Country searchCountryByName(ArrayList<Country> countries, String keyName) throws Exception {
            List<Country> equivalentCountry = countries.stream().filter((aCountry) -> aCountry.getCountryName().equalsIgnoreCase(keyName)).collect(Collectors.toList());
            if (equivalentCountry.isEmpty()) {
                System.out.println("Country have name " + keyName + " haven't added yet!");
                return null;
            }
            for (Country c : equivalentCountry) {
                return c;
            }
            return null;
        }
//function 4: sort and display sorted country list

        public void sortInformationByAscendingOrder(ArrayList<Country> countries) throws Exception {//---mainFT4---
            displaySortedCountry(sortCountry(countries));
        }

        public ArrayList<Country> sortCountry(ArrayList<Country> countries) throws Exception {
            countries.sort(Comparator.comparing(Country::getCountryName));
            return countries;
        }

        public void displaySortedCountry(ArrayList<Country> countries) {
            if (countries.isEmpty()) {
                System.out.println("List of countries is empty!");
                return;
            }
            System.out.println(String.format("%-10s%-15s%-15s%-10s", "ID", "Name", "Total Area", "Terrain"));
            countries.forEach((aCountry) -> aCountry.display());
        }

    }

}
