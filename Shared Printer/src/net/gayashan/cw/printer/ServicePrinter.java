/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gayashan.cw.printer;


public interface ServicePrinter extends Printer {


    // Printer constants 

    int Full_Paper_Tray = 250;
    int Full_Toner_Level = 500;

    int Minimum_Toner_Level = 10;

    int SheetsPerPack = 50;

    int PagesPerTonerCartridge = 500;


    // Technician methods

    void replaceTonerCartridge();

    void refillPaper();

}
