package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void hasSecurity() {
        Visitor visitorRightHeightRightAge = new Visitor(13, 146, 10);
        Visitor visitorRightHeightWrongAge = new Visitor(12, 146, 10);
        Visitor visitorWrongHeightWrongAge = new Visitor(12, 145, 10);
        assertTrue(rollerCoaster.isAllowedTO(visitorRightHeightRightAge));
        assertFalse(rollerCoaster.isAllowedTO(visitorRightHeightWrongAge));
        assertFalse(rollerCoaster.isAllowedTO(visitorWrongHeightWrongAge));
    }

    @Test
    public void extraTallExtraFee() {
        Visitor visitorSuperTall = new Visitor(21, 201, 10);
        Visitor visitorRegularHeight = new Visitor(27, 180, 10);
        assertEquals(16.80, rollerCoaster.priceFor(visitorSuperTall), 0);
        assertEquals(8.40, rollerCoaster.priceFor(visitorRegularHeight), 0);
    }
}
