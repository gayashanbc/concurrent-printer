/*
 * @author Gayashan Bombuwala | 2015047 | W1582950
 * https://gayashan.net | gayashan@gayashan.net
 */
package net.gayashan.cw.printer;


public class Document {

    private final String STUDENT_NAME;
    private final String NAME;
    private final int NUMBER_OF_PAGES;

    public Document(String studentName, String name, int numberOfPages) {
        this.STUDENT_NAME = studentName;
        this.NAME = name;
        this.NUMBER_OF_PAGES = numberOfPages;
    }

    public String getStudentName() {
        return STUDENT_NAME;
    }

    public String getName() {
        return NAME;
    }

    public int getNumberOfPages() {
        return NUMBER_OF_PAGES;
    }

    @Override
    public String toString() {
        return "Document[ "
                + "Student Name: " + STUDENT_NAME + ", "
                + "Document Name: " + NAME + ", "
                + "Number of Pages: " + NUMBER_OF_PAGES
                + "]";
    }
}
