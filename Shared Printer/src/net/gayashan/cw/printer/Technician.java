/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
