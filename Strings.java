class Strings {
    public static void main(String[] args) {
        String literalSting1 = "abc";
        String literalSting2 = "abc";

        String objectSting1 = new String("xyz");
        String objectSting2 = new String("xyz");

        System.out.println(literalSting1 == literalSting2);
        System.out.println(objectSting1 == objectSting2);
    }
}
