package Domain;

public class PresentationConverter extends DocumentConverter<Presentation> {
    @Override
    public String toString(Presentation presentation) {
        return presentation.getAuthor() + "," + presentation.getNumberOfSlides() + "," + presentation.getText();
    }

    @Override
    public Presentation fromString(String line) {
        String[] parts = line.split(",");
        String author = parts[0];
        int numberOfSlides = Integer.parseInt(parts[1]);
        String text = parts[2];
        return new Presentation(author, numberOfSlides, text);
    }
}
