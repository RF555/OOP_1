package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {
    @Test
    void update() {
        GroupAdmin test = new GroupAdmin();
        ConcreteMember name1 = new ConcreteMember();
        ConcreteMember name2 = new ConcreteMember();
        test.register(name1);
        test.register(name2);
        test.append("This is a test");
        assertEquals("This is a test",name1.getUsb().toString());
        assertEquals("This is a test",name2.getUsb().toString());
        // test for shallow
        assertEquals(JvmUtilities.objectFootprint(test.USB), JvmUtilities.objectFootprint(name1.getUsb()));
        assertEquals(JvmUtilities.objectFootprint(test.USB), JvmUtilities.objectFootprint(name2.getUsb()));
    }
}