/*
 * @author Gayashan Bombuwala | 2015047 | W1582950
 * https://gayashan.net | gayashan@gayashan.net
 */
package net.gayashan.cw.printer;

public class PrintingSystem {

    public static void main(String[] args) {

        // declaring and initializing the two thread groups technician and student
        ThreadGroup studentGroup = new ThreadGroup("Student Thread Group");
        ThreadGroup technicianGroup = new ThreadGroup("Technician Thread Group");

        // the laser printer object
        LaserPrinter laserPrinter = new LaserPrinter("Cannon LP-X25M", studentGroup);

        // the student and technician threads
        Student student1 = new Student("Simon", studentGroup, laserPrinter);
        Student student2 = new Student("Tina", studentGroup, laserPrinter);
        Student student3 = new Student("Cindy", studentGroup, laserPrinter);
        Student student4 = new Student("Derk", studentGroup, laserPrinter);

        Technician paperTechnician = new PaperTechnician("Sasha", technicianGroup, laserPrinter);
        Technician tonerTechnician = new TonerTechnician("Johnny", technicianGroup, laserPrinter);

        // starting all threads
        student1.start();
        student2.start();
        student3.start();
        student4.start();
        paperTechnician.start();
        tonerTechnician.start();

        // wait for all the threads to complete
        try {
            student1.join();
            student2.join();
            student3.join();
            student4.join();
            paperTechnician.join();
            tonerTechnician.join();
        } catch (InterruptedException exception) {
            System.out.println(exception);
        }
    }

}
