class TypeConversion {
    public static void main(String[] args){
        int num1 = 5;
        double num2 = num1;  // Implicit

        double num3 = 1.234;
        int num4 = (int)num3;  // Explicit

        System.out.println(num2);
        System.out.println(num4);
    }
}

