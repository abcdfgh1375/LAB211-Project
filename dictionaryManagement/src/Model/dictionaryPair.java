/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import common.libraryDict;

public class dictionaryPair {
    private String engMean;
    private String vietMean;
    libraryDict lib = new libraryDict();

    public dictionaryPair() {
    }

    public dictionaryPair(String engMean, String vietMean) {
        this.engMean = engMean;
        this.vietMean = vietMean;
    }

    public String getEngMean() {
        return engMean;
    }

    public void setEngMean(String engMean) {
        this.engMean = engMean;
    }

    public String getVietMean() {
        return vietMean;
    }

    public void setVietMean(String vietMean) {
        this.vietMean = vietMean;
    }

    @Override
    public String toString() {
        return String.format("%-15s%s", engMean, vietMean);
    }    
    


           
}
