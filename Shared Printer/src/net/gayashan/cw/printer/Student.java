/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gayashan.cw.printer;

import java.util.stream.IntStream;


public class Student extends Thread {

    private String name;
    private LaserPrinter printer;

    public Student(String name, ThreadGroup threadGroup, LaserPrinter printer) {
        super(threadGroup, name);
        this.name = name;
        this.printer = printer;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 5).forEach(documentId -> {
            int randomPageCount = RandomNumbersGenerator.getInstance().ints(1, 10, 30).findFirst().getAsInt();
            int randomSleepTime = RandomNumbersGenerator.getInstance().ints(1, 1000, 2000).findFirst().getAsInt();
            String documentName = "DOC-" + randomPageCount + "-" + randomSleepTime;
            Document document = new Document(name, documentName, randomPageCount);
            this.printer.printDocument(document);

            try {
                sleep(randomSleepTime);
            } catch (InterruptedException exception) {
                System.out.println(exception);
            }
        });
    }

}
