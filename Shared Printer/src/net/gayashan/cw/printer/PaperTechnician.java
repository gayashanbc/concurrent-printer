/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gayashan.cw.printer;

import java.util.stream.IntStream;


public class PaperTechnician extends Technician {
    private String name;

    // constructor for the paper technician class
    public PaperTechnician(String name, ThreadGroup threadGroup, LaserPrinter printer) {
        // calling the parent constructor
        super(name, threadGroup, printer);
        this.name = name;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 3).forEach(attemptId -> {
            int randomSleepTime = RandomNumbersGenerator.getInstance().ints(1, 1000, 2000).findFirst().getAsInt();
            try {
                // call the method that tries to refill papers
                this.printer.refillPaper(attemptId, name);

                // sleep the current thread for a random amount of time
                sleep(randomSleepTime);
            } catch (InterruptedException exception) {
                System.out.println(exception);
            }
        });
    }
}
