/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Menu;
import java.util.Arrays;
import Repository.classManageEastAsiaCountries;

public class geographicController extends Menu {
    private classManageEastAsiaCountries countryManage;
    private static String[] list = {"Input the information of 11 countries in East Asia",
        "Display the information of country you've just input",
        "Search the information of country by user-entered name",
        "Display the information of countries sorted name in ascending order",
        "Exit"};
//                                   MENU
//==========================================================================
//1. Input the information of 11 countries in East Asia
//2. Display the information of country you've just input
//3. Search the information of country by user-entered name
//4. Display the information of countries sorted name in ascending order  
//5. Exit 
//==========================================================================

    public geographicController() {
        super("MENU", Arrays.asList(list));
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

}
