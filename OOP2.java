public class OOP2 {
    public static void main(String[] args){
        // Normal base Book class object instantiation
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Inherited AudioBook class object instantiation
        AudioBook book2 = new AudioBook("Dracula", "Bram Stoker", 30000);

        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }
}
