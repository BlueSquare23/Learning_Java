import java.util.Scanner;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
*  All credit for SQLite database code goes to:
*
*  https://www.sqlitetutorial.net/sqlite-java/
*
*  I just adapted their samples to my usecase.
*/

public class Main {
    static void printMainMenu() {
        System.out.printf("\n 1) Enter a New Song");
        System.out.printf("\n 2) List All Songs");
        System.out.printf("\n 3) Search for a Song");
        System.out.printf("\n 4) Delete a song");
        System.out.printf("\n 5) Play a Song");
        System.out.printf("\n\nWhat would you like to do? (1,2,3,4,5): ");
    }

    // Initalizes connection to database
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:musicLibrary.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Creates songs table schema
    public void createTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS songs (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	title text NOT NULL,\n"
                + "	artist text NOT NULL,\n"
                + " year text NOT NULL,\n"
                + "	path text NOT NULL\n"
                + ");";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new row into the songs table
     *
     * @param title
     * @param artist
     * @param year
     * @param filePath
     */
    public void insert(String title, String artist, String year, String filePath) {
        String sql = "INSERT INTO songs(title,artist,year,path) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, artist);
            pstmt.setString(3, year);
            pstmt.setString(4, filePath);
            pstmt.executeUpdate();
            System.out.println("Song Added To Database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Select all rows in the songs table
    */
    public void selectAll(){
        String sql = "SELECT id, title, artist, year, path FROM songs";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                   rs.getString("title") + "\t" +
                                   rs.getString("artist") + "\t" +
                                   rs.getString("year") + "\t" +
                                   rs.getString("path"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Select all rows in the songs table that match the search string
    */
    public void searchTable(String searchQuery){
        String sql = "SELECT id, title, artist, year, path FROM songs" +
            " WHERE id LIKE " + "'%" + searchQuery + "%'" + " OR title LIKE " + "'%" + searchQuery + "%'" +
            " OR artist LIKE " + "'%" + searchQuery + "%'" + " OR year LIKE " + "'%" + searchQuery + "%'" +
            " OR path LIKE " + "'%" + searchQuery + "%'";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                   rs.getString("title") + "\t" +
                                   rs.getString("artist") + "\t" +
                                   rs.getString("year") + "\t" +
                                   rs.getString("path"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Select path for row with given id from the songs table
    */
    public String getPath(int index){
        String sql = "SELECT path FROM songs" +
            " WHERE id LIKE " + index;        

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                return rs.getString("path");
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    // Okay sure compiler
    return "";
    }

    /**
     * Delete a song specified by the id
     *
     * @param id
     */

    public void delete(int id) {
        String sql = "DELETE FROM songs WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

            System.out.println("Song Deleted From Database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.createTable();
        
        System.out.println("##### Java Music Database & Player #####");
        Scanner scanner = new Scanner(System.in);

        printMainMenu();
        String option = scanner.nextLine();

        switch (option) {
            // Enter a New Song
            case "1":
                System.out.printf("\n### Please enter the following details ###\n\n");
                System.out.print("Song Title: ");
                String title = scanner.nextLine();
                System.out.print("Song Artist: ");
                String artist = scanner.nextLine();
                System.out.print("Song Year: ");
                String year = scanner.nextLine();
                System.out.print("Song File Path: ");
                String filePath = scanner.nextLine();

                // Am I doing oop right?
                Song newSong = new Song(title, artist, year, filePath);
                app.insert(newSong.getTitle(), newSong.getArtist(), newSong.getYear(), newSong.getFilePath());
                break;

            // List All Songs
            case "2":
                System.out.printf("\nIndex\tTitle\tArtist\tYear\tFile Path\n\n");
                app.selectAll();
                break;

            // Search for a Song
            case "3":
                System.out.printf("\n### Please enter a search string ###\n\n");
                System.out.print("Search String: ");
                String searchString = scanner.nextLine();

                System.out.printf("\nIndex\tTitle\tArtist\tYear\tFile Path\n\n");
                app.searchTable(searchString);
                break;

            // Delete a song
            case "4":
                System.out.printf("\n### Please enter the index of a song to delete ###\n\n");
                System.out.print("Song Index: ");
                int deleteIndex = scanner.nextInt();
                // Flush input buffer
                scanner.nextLine();
                
                app.delete(deleteIndex);
                break;

            // Play a Song
            case "5":
                System.out.printf("\n### Please enter the index of a song to delete ###\n\n");
                System.out.print("Song Index: ");
                int playSongIndex = scanner.nextInt();
                // Flush input buffer
                scanner.nextLine();
                
                String path = app.getPath(playSongIndex);

                // Use external program to play the music file
                ProcessBuilder processBuilder = new ProcessBuilder();
                // Uses mpv music player to play song.
                processBuilder.command("mpv", path);

                try {

                    Process process = processBuilder.start();

                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(process.getInputStream()));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                    int exitCode = process.waitFor();
                    System.out.println("\nExited with error code : " + exitCode);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            default:
                System.out.println("Invalid Operation!");
            }
 
        scanner.close();
    }

}
