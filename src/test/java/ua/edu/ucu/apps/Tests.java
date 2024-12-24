package ua.edu.ucu.apps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testUserBuilder() {
        User user = User.builder()
                .name("Alice")
                .age(25)
                .gender(Gender.FEMALE)
                .weight(55.5)
                .height(165.0)
                .build();

        assertEquals("Alice", user.getName());
        assertEquals(25, user.getAge());
        assertEquals(Gender.FEMALE, user.getGender());
        assertEquals(55.5, user.getWeight());
        assertEquals(165.0, user.getHeight());
    }

    @Test
    public void testMailInfoCreation() {
        Client client = new Client("Bob", 30, Gender.MALE);
        MailInfo mailInfo = new MailInfo(client, "birthday");

        assertEquals(client, mailInfo.getClient());
        assertEquals("birthday", mailInfo.getMailCode());
    }

    @Test
    public void testBirthdayLetterStrategy() {
        Client client = new Client("Alice", 25, Gender.FEMALE);
        LetterStrategy birthdayStrategy = new BirthdayLetter();

        String letter = birthdayStrategy.createLetter(client);
        assertEquals("Happy Birthday, Alice!", letter);
    }

    @Test
    public void testGiftLetterStrategy() {
        Client client = new Client("Bob", 30, Gender.MALE);
        LetterStrategy giftStrategy = new GiftLetter();

        String letter = giftStrategy.createLetter(client);
        assertEquals("Dear Bob, you have a gift waiting!", letter);
    }

    @Test
    public void testMailBoxSendAll() {
        Client client1 = new Client("Alice", 25, Gender.FEMALE);
        Client client2 = new Client("Bob", 30, Gender.MALE);

        MailInfo info1 = new MailInfo(client1, "birthday");
        MailInfo info2 = new MailInfo(client2, "gift");

        MailBox mailBox = new MailBox();
        mailBox.addMailInfo(info1);
        mailBox.addMailInfo(info2);

        MailSender sender = new MailSender();

        mailBox.sendAll(sender, new BirthdayLetter());

        assertTrue(mailBox.infos.isEmpty());
    }

    @Test
    public void testProxyImageLazyLoading() {
        ProxyImage proxyImage = new ProxyImage("example.jpg");

        assertNull(getRealImage(proxyImage));
        proxyImage.display();

        assertNotNull(getRealImage(proxyImage));
    }

    private RealImage getRealImage(ProxyImage proxyImage) {
        try {
            java.lang.reflect.Field realImageField = ProxyImage.class.getDeclaredField("realImage");
            realImageField.setAccessible(true);
            return (RealImage) realImageField.get(proxyImage);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
