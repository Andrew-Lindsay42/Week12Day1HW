package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", 2, ParkingSpot.B1);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasRating() {
        assertEquals(2, tobaccoStall.getRating());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void hasMinAge() {
        Visitor visitorRightAge = new Visitor(18, 180, 10);
        Visitor visitorWrongAge = new Visitor(17, 180, 10);
        assertTrue(tobaccoStall.isAllowedTO(visitorRightAge));
        assertFalse(tobaccoStall.isAllowedTO(visitorWrongAge));
    }
}
