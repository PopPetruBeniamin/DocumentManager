package Domain;

public class Presentation extends Document {
    int numberOfSlides;
    String text;

    public Presentation(String author, int numberOfSlides, String text) {
        super(author);
        this.numberOfSlides = numberOfSlides;
        this.text = text;
    }

    public int getNumberOfSlides() {
        return numberOfSlides;
    }
    public String getText() {
        return text;
    }

    @Override
    public boolean isConformant() {
        return (text.length()/numberOfSlides) < 200;
    }

    @Override
    public String toString() {
        return "Author: " + author + ", Number Of Slides: " + numberOfSlides + ", Text: " + text;
    }
}
