/*
 * @author Gayashan Bombuwala | 2015047 | W1582950
 * https://gayashan.net | gayashan@gayashan.net
 */
package net.gayashan.cw.printer;


public interface ServicePrinter extends Printer {

    // Printer constants
    int MAX_SHEET_STACK = 250;
    int MAX_TONER_LEVEL = 500;
    int MIN_TONER_LEVEL = 10;
    int SHEETS_PER_PACK = 50;

    // Technician methods
    void refillPaper(int attempt, String technicianName);

    void replaceTonerCartridge(int attempt, String technicianName);

}
