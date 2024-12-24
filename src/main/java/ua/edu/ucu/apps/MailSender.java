package ua.edu.ucu.apps;

public class MailSender {
    public void sendMail(MailInfo mailInfo, LetterStrategy strategy) {
        String letter = strategy.createLetter(mailInfo.getClient());
        System.out.println("Sending email to " + mailInfo.getClient().getName() + ": " + letter);
    }
}