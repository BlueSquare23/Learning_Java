class OOP {
    public static void main(String[] args) {
        User youngerUser = new User("Billy Bob", "1993-12-23");  // Initializes new user object w/ constructor call.

        System.out.printf("%s was born on %s and is now %d years old.\n", youngerUser.getName(), youngerUser.getBirthDay(), youngerUser.age());

        User olderUser = new User("Bobby Bill", "1965-07-18");  // Initializes new user object w/ constructor call.

        System.out.printf("%s was born on %s and is now %d years old.\n", olderUser.getName(), olderUser.getBirthDay(), olderUser.age());
    }
}
