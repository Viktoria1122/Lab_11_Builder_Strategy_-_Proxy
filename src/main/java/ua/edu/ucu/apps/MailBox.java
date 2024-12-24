package ua.edu.ucu.apps;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private final List<MailInfo> infos = new ArrayList<>();

    public void addMailInfo(MailInfo info) {
        infos.add(info);
    }

    public void sendAll(MailSender sender, LetterStrategy strategy) {
        for (MailInfo info : infos) {
            sender.sendMail(info, strategy);
        }
        infos.clear();
    }
}