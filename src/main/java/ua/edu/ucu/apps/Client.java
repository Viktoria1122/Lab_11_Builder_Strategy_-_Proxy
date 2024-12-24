package ua.edu.ucu.apps;

public class Client {
    private static int idCounter = 0;
    @SuppressWarnings("unused")
    private final int id;
    private final String name;
    private final int age;
    private final Gender gender;

    public Client(String name, int age, Gender gender) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
