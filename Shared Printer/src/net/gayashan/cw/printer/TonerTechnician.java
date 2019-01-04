/*
 * @author Gayashan Bombuwala | 2015047 | W1582950
 * https://gayashan.net | gayashan@gayashan.net
 */
package net.gayashan.cw.printer;

import java.util.stream.IntStream;


public class TonerTechnician extends Technician {

    private String name;

    public TonerTechnician(String name, ThreadGroup threadGroup, LaserPrinter printer) {
        // calling the parent constructor
        super(name, threadGroup, printer);
        this.name = name;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 3).forEach(attemptId -> {
            int randomSleepTime = RandomNumbersGenerator.getOneInt(1000, 2000);
            try {
                // call the method that tries to refill papers
                this.printer.replaceTonerCartridge(attemptId, name);

                // sleep the current thread for a random amount of time
                sleep(randomSleepTime);
            } catch (InterruptedException exception) {
                System.out.println(exception);
            }
        });
    }

}
