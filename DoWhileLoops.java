class DoWhileLoops {
    public static void main(String[] args) {
        int num = 5;
        int multiplier = 1;

        do {
            System.out.printf("%d X %d = %d\n", num, multiplier, num * multiplier);
            multiplier++;
        } while(multiplier <= 10);
    }
}
