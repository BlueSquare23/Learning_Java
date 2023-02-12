import java.time.LocalDate;
import java.time.Period;

public class User {
    private String name;
    private LocalDate birthDay;

    // Constructor method
    User(String name, String birthDay) {
        this.name = name;
        this.birthDay = LocalDate.parse(birthDay);
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Getter for birthDay
    public String getBirthDay() {
        return this.birthDay.toString();
    }

    // Age method
    public int age() {
        int age = Period.between(this.birthDay, LocalDate.now()).getYears();
        return age;
    }
}
