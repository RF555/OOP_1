package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {
    @Test
    void register() {
        GroupAdmin test = new GroupAdmin();
        ConcreteMember name1 = new ConcreteMember();
        test.register(name1);
        assertEquals(name1, test.getLast());

    }

    @Test
    void unregister() {
        GroupAdmin test = new GroupAdmin();
        ConcreteMember name1 = new ConcreteMember();
        test.register(name1);
        test.unregister(name1);
        assertNull(test.getLast());

    }

    @Test
    void insert() {
        GroupAdmin tets = new GroupAdmin();
        tets.append("This is");
        tets.insert(7, " a test");
        assertEquals("This is a test", tets.getUSB().toString());

    }

    @Test
    void append() {
        GroupAdmin test = new GroupAdmin();
        test.append("This is a test");
        assertEquals("This is a test", test.getUSB().toString());

    }

    @Test
    void delete() {
        GroupAdmin test = new GroupAdmin();
        test.append("This is a test");
        test.delete(7, 14);
        assertEquals("This is", test.getUSB().toString());

    }

    @Test
    void undo() {
        GroupAdmin test = new GroupAdmin();
        test.append("This is a test");
        test.delete(4, 8);
        test.undo();
        assertEquals("This is a test", test.getUSB().toString());
    }
}