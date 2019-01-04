/*
 * @author Gayashan Bombuwala | 2015047 | W1582950
 * https://gayashan.net | gayashan@gayashan.net
 */
package net.gayashan.cw.printer;


public class Technician extends Thread {

    protected LaserPrinter printer;
    protected final String NAME;

    public Technician(String name, ThreadGroup group, LaserPrinter printer) {
        super(group, name);
        this.printer = printer;
        NAME = name;
    }
}
