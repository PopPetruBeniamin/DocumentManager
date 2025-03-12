package Domain;

public class Manuscript extends Document {

    private final int numberOfWords;
    private final int numberOfPages;

    public Manuscript(String author, int NumberOfWords, int NumberOfPages) {
        super(author);
        this.numberOfWords = NumberOfWords;
        this.numberOfPages = NumberOfPages;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public boolean isConformant() {
        return numberOfWords > 2000 && numberOfPages < 5;
    }

    @Override
    public String toString() {
        return "Author: " + author + ", Number Of Words: " + numberOfWords + ", Number Of Pages: " + numberOfPages;
    }
}
