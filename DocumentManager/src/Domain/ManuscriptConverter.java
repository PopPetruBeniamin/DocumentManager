package Domain;

public class ManuscriptConverter extends DocumentConverter<Manuscript> {
    @Override
    public String toString(Manuscript manuscript) {
        return manuscript.getAuthor() + "," + manuscript.getNumberOfWords() + "," + manuscript.getNumberOfPages();
    }

    @Override
    public Manuscript fromString(String line) {
        String[] parts = line.split(",");
        String author = parts[0];
        int numberOfWords = Integer.parseInt(parts[1]);
        int numberOfPages = Integer.parseInt(parts[2]);
        return new Manuscript(author, numberOfWords, numberOfPages);
    }
}
