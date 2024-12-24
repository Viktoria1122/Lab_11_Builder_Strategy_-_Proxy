package ua.edu.ucu.apps;

public class GiftLetter implements LetterStrategy {
    @Override
    public String createLetter(Client client) {
        return "Dear " + client.getName() + ", you have a gift waiting!";
    }
}
