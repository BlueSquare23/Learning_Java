class WhileLoops {
    public static void main(String[] args) {
        int num = 5;
        int multiplier = 1;

        while(multiplier <= 10) {
            System.out.printf("%d X %d = %d\n", num, multiplier, num * multiplier);
            multiplier++;
        }
    }
}
