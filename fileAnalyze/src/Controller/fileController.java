/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.FilePath;
import View.viewFileAnalyze;

public class fileController {

    viewFileAnalyze v = new viewFileAnalyze();

    public void run() throws Exception {
        FilePath f = new FilePath();
        v.inputPath(f);
        v.displayResult(f);
    }
}
