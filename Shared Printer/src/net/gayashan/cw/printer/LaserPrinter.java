/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gayashan.cw.printer;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LaserPrinter implements ServicePrinter {

    private int currentPaperLevel = MAX_SHEET_STACK;
    private int currentTonerLevel = MAX_TONER_LEVEL;
    private int printedDocumentsCount = 0;
    private final String PRINTER_ID;
    private ThreadGroup students;

    public LaserPrinter(String PRINTER_ID, ThreadGroup students) {
        this.PRINTER_ID = PRINTER_ID;
        this.students = students;
    }

    @Override
    public synchronized void printDocument(Document document) {

        logMessage("Before printing", toString(), false);

        // wait until there is enough of resources to print
        while (currentPaperLevel < document.getNumberOfPages() || currentTonerLevel < document.getNumberOfPages()) {
            try {
                logMessage("Waiting to print", document.getName() + " (student: " + document.getStudentName() + ")", false);
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }

        // check if the printer has the sufficient resources to print the document
        if (currentPaperLevel > document.getNumberOfPages() && currentTonerLevel > document.getNumberOfPages()) {
            currentPaperLevel -= document.getNumberOfPages();
            currentTonerLevel -= document.getNumberOfPages();
            printedDocumentsCount += 1;
            logMessage("Student", document.getStudentName() + " printed the document: "
                    + document.getName() + " (pages: " + document.getNumberOfPages() + ")", false);
        }

        logMessage("After printing", toString(), true);

        // notify all other threads
        notifyAll();

    }

    @Override
    public synchronized void refillPaper(int attempt, String technicianName) {
        while (currentPaperLevel + SHEETS_PER_PACK > MAX_SHEET_STACK) {
            try {
                if (hasActiveStudents()) {
                    logMessage("Refill paper", "Waiting (attempt = " + attempt + ")", true);
                    wait(5000);
                } else {
                    logMessage("Refill paper", "No active students, operation aborted (attempt = " + attempt + ")", true);
                    return;
                }
            } catch (InterruptedException exception) {
                System.out.println(exception);
            }
        }

        if (currentPaperLevel + SHEETS_PER_PACK <= MAX_SHEET_STACK) {
            int newPaperLevel = currentPaperLevel += SHEETS_PER_PACK;
            logMessage("Refill paper", "Complete, new level: " + newPaperLevel
                    + ", technician: " + technicianName + " (attempt = " + attempt + ")", true);
        }

        notifyAll();
    }

    @Override
    public synchronized void replaceTonerCartridge(int attempt, String technicianName) {

        while (currentTonerLevel > MIN_TONER_LEVEL) {
            try {
                if (hasActiveStudents()) {
                    logMessage("Refill toner", "Waiting (attempt = " + attempt + ")", true);
                    wait(5000);
                } else {
                    logMessage("Refill toner", "No active students, operation aborted (attempt = " + attempt + ")", true);
                    return;
                }

            } catch (InterruptedException exception) {
                System.out.println(exception);
            }
        }

        if (currentTonerLevel < MIN_TONER_LEVEL) {
            currentTonerLevel = MAX_TONER_LEVEL;
            logMessage("Refill toner", "Complete, new level: " + currentTonerLevel
                    + ", technician: " + technicianName + " (attempt = " + attempt + ")", true);
        }
        notifyAll();

    }

    private boolean hasActiveStudents() {
        return students.activeCount() > 0;
    }

    private void logMessage(String context, String message, boolean shouldAppendNewLine) {
        if (shouldAppendNewLine) {
            System.out.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss SSS a"))
                    + "] " + PRINTER_ID + "):: " + context + ": " + message + "\n");
        } else {
            System.out.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss SSS a"))
                    + "] " + PRINTER_ID + "):: " + context + ": " + message);
        }
    }

    @Override
    public String toString() {
        return "[ "
                + "PrinterID: " + PRINTER_ID
                + ", Paper Level: " + currentPaperLevel
                + ", Toner Level: " + currentTonerLevel
                + ", Documents Printed: " + printedDocumentsCount
                + " ]";
    }

}
