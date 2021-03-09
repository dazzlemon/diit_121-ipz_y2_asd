package pr;

public class Human {
    private String name;
    private String birthDate;
    private boolean gender;//m - true, f - false
    private int weightKg;

    public Human(String name, String birthDate, boolean gender, int weightKg) {
        this.name      = name;
        this.birthDate = birthDate;
        this.gender    = gender;
        this.weightKg  = weightKg;
    }

    public String toString() {
        return String.format(
            "Human: { name: %s, birthDate: %s, gender: %s, weightKg: %s }",
            name, birthDate, gender, weightKg    
        );
    }

    public int getWeightKg() {
        return weightKg;
    }
}
