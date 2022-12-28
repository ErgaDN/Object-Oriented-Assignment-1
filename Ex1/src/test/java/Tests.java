import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    GroupAdmin text;
    ConcreteMember client_1;
    ConcreteMember client_2;
    ConcreteMember client_3;
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    @BeforeEach
    void init() {
        text = new GroupAdmin();
        client_1 = new ConcreteMember();
        client_2 = new ConcreteMember();
        client_3 = new ConcreteMember();
        text.register(client_1);
        text.register(client_2);
        text.register(client_3);
    }

    @Test
    void register() {
        ConcreteMember client_4 = new ConcreteMember();
        text.register(client_4);
        assertEquals("[, , , ]", text.toString());
    }

    @Test
    void unregister() {
        text.unregister(client_1);
        text.unregister(client_3);
        assertEquals("[]", text.toString());
    }

    @Test
    void insert() {
        text.insert(0, "Hello");
        assertEquals("[Hello, Hello, Hello]", text.toString());

        text.insert(5, " World");
        assertEquals("[Hello World, Hello World, Hello World]", text.toString());

        text.insert(5, " Class");
        assertEquals("[Hello Class World, Hello Class World, Hello Class World]", text.toString());
    }

    @Test
    void append() {
        text.append("Hi");
        assertEquals("[Hi, Hi, Hi]", text.toString());

        text.append(" Everyone");
        assertEquals("[Hi Everyone, Hi Everyone, Hi Everyone]", text.toString());
    }

    @Test
    void delete() {
        text.append("Hello Good World");
        text.delete(5, 10);
        assertEquals("[Hello World, Hello World, Hello World]", text.toString());

        text.delete(5, 11);
        assertEquals("[Hello, Hello, Hello]", text.toString());
    }

    @Test
    void undu() {
        text.append("Hello");
        text.append(" Good");
        text.append(" World");
        text.undo();
        assertEquals("[Hello Good, Hello Good, Hello Good]", text.toString());
        text.undo();
        assertEquals("[Hello, Hello, Hello]", text.toString());
        text.undo();
        assertEquals("[, , ]", text.toString());
    }


    @Test
    public void test() {
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(() -> JvmUtilities.objectFootprint(s1));

        logger.info(() -> JvmUtilities.objectFootprint(s1, s2));

        logger.info(() -> JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void JVMUNIT_test()
    {
        logger.info(() -> JvmUtilities.objectFootprint(text));

        text.unregister(client_3);
        logger.info(() -> JvmUtilities.objectFootprint(text));

        text.append("Hello World");
        logger.info(() -> JvmUtilities.objectFootprint(text));

        GroupAdmin text_2 = new GroupAdmin();
        logger.info(() -> JvmUtilities.objectFootprint(text, text_2));

        logger.info(() -> JvmUtilities.objectTotalSize(text));
        text.unregister(client_2);
        logger.info(() -> JvmUtilities.objectTotalSize(text));
        text.register(client_2);
        text.delete(4,8);
        logger.info(() -> JvmUtilities.objectTotalSize(text));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
