public class AudioBook extends Book {
    private int runTime;

    AudioBook(String title, String author, int runTime) {
        super(title, author);
        this.runTime = runTime;
    }
}
