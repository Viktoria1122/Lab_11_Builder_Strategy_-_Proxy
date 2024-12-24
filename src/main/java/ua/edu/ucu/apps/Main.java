package ua.edu.ucu.apps;

public class Main {
    public static void main(String[] args) {
        // Task 2 Example
        Client client1 = new Client("Alice", 25, Gender.FEMALE);
        Client client2 = new Client("Bob", 30, Gender.MALE);

        MailInfo info1 = new MailInfo(client1, "birthday");
        MailInfo info2 = new MailInfo(client2, "gift");

        MailBox mailBox = new MailBox();
        mailBox.addMailInfo(info1);
        mailBox.addMailInfo(info2);

        MailSender sender = new MailSender();
        mailBox.sendAll(sender, new BirthdayLetter());
        mailBox.sendAll(sender, new GiftLetter());

        // Task 3 Example
        MyImage image = new ProxyImage("example.jpg");
        image.display();
    }
}
