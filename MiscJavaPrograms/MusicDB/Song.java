public class Song {
    private String title;
    private String artist;
    private String year;
    private String filePath;

    Song(String title, String artist, String year, String filePath) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.filePath = filePath;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getYear() {
        return this.year;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String toString() {
        return String.format("Artist: %s\nTitle: %s\nYear: %s", this.artist, this.title, this.year);
    }
}
