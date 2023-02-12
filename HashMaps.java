import java.util.HashMap;

class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> examScores = new HashMap<String, Integer>();
        examScores.put("Math", 75);
        examScores.put("Sociology", 85);
        examScores.put("English", 65);
        examScores.put("Philosophy", 98);

        System.out.println(examScores.toString());
    }
}
