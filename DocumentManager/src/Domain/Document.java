package Domain;

import java.io.Serializable;

public abstract class Document implements Serializable {
    protected String author;

    public Document(String date) {
        this.author = date;
    }


    //Get function
    public String getAuthor() {
        return author;
    }
    public abstract boolean isConformant();
    public abstract String toString();
}
