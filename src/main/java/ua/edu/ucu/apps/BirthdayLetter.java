package ua.edu.ucu.apps;

public class BirthdayLetter implements LetterStrategy {
    @Override
    public String createLetter(Client client) {
        return "Happy Birthday, " + client.getName() + "!";
    }
}