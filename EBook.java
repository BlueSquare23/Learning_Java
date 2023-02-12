public class EBook extends Book {
    private int runTime;

    AudioBook(String title, String author, int pageCount) {
        super(title, author);
        this.pageCount = pageCount;
    }
}
