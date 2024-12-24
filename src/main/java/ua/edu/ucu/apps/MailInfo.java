package ua.edu.ucu.apps;

public class MailInfo {
    private final Client client;
    private final String mailCode;

    public MailInfo(Client client, String mailCode) {
        this.client = client;
        this.mailCode = mailCode;
    }

    public Client getClient() {
        return client;
    }

    public String getMailCode() {
        return mailCode;
    }
}
