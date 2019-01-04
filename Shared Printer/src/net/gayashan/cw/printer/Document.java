/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gayashan.cw.printer;


public class Document {

    private final String userID;
    private final String documentName;
    private final int numberOfPages;

    public Document(String UID, String name, int length) {
        this.userID = UID;
        this.documentName = name;
        this.numberOfPages = length;
    }

    public String getUserID() {
        return userID;
    }

    public String getDocumentName() {
        return documentName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Document[ "
                + "UserID: " + userID + ", "
                + "Name: " + documentName + ", "
                + "Pages: " + numberOfPages
                + "]";
    }
}
