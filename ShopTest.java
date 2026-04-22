import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the Computer and ResaleShop classes.
 * These tests are designed to reveal bugs in the provided implementation.
 */

public class ShopTest {

    /**
     * Tests that the Computer constructor correctly sets memory.
     */
    @Test
    public void testConstructorSetsMemory() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        assertEquals(32, comp.memory);
    }

    /**
     * Tests that the Computer constructor correctly sets price.
     */
    @Test
    public void testConstructorSetsPrice() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        assertEquals(1200, comp.price);
    }

    /**
     * Tests that getYear returns the computer's year.
     */
    @Test
    public void testGetYear() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        assertEquals(2020, comp.getYear());
    }

    /**
     * Tests that setPrice correctly updates the price.
     */
    @Test
    public void testSetPrice() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        comp.setPrice(900);
        assertEquals(900, comp.price);
    }

    /**
     * Tests that setOS correctly updates the operating system.
     */
    @Test
    public void testSetOS() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        comp.setOS("Linux");
        assertEquals("Linux", comp.operatingSystem);
    }

    /**
     * Tests that buy adds the given computer to the inventory.
     */
    @Test
    public void testBuyAddsComputer() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        shop.buy(comp);

        assertTrue(shop.inventory.contains(comp));
    }

    /**
     * Tests that printInventory does not crash.
     */
    @Test
    public void testPrintInventoryDoesNotCrash() {
        ResaleShop shop = new ResaleShop();
        shop.printInventory();
    }

    /**
     * Tests that refurbish throws an exception if the computer is not in inventory.
     */
    @Test
    public void testRefurbishThrowsExceptionIfNotInInventory() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        try {
            shop.refurbish(comp, "Linux");
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            // Expected exception.
        }
    }

    /**
     * Tests that buy throws an exception when adding a duplicate computer.
     */
    @Test
    public void testBuyThrowsExceptionForDuplicateComputer() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        try {
            shop.buy(comp);
            shop.buy(comp);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            // Expected exception.
        }
    }

    /**
     * Tests that sell throws an exception if the computer is not in inventory.
     */
    @Test
    public void testSellThrowsExceptionIfNotInInventory() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        try {
            shop.sell(comp);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            // Expected exception.
        }
    }

    /**
     * Tests that refurbish does not change the OS when newOS is "None".
     */
    @Test
    public void testRefurbishWithNoneDoesNotChangeOS() {
        ResaleShop shop = new ResaleShop();
        Computer comp = shop.inventory.get(0);

        String oldOS = comp.operatingSystem;
        shop.refurbish(comp, new String("None"));

        assertEquals(oldOS, comp.operatingSystem);
    }

    /**
     * Tests that buy preserves the information of the computer being added.
     */
    @Test
    public void testBuyAddsCorrectComputerInformation() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        shop.buy(comp);

        Computer addedComp = shop.inventory.get(shop.inventory.size() - 1);
        assertEquals("Dell", addedComp.description);
    }

    /**
     * Tests that a new ResaleShop starts with an empty inventory.
     */
    @Test
    public void testResaleShopStartsWithEmptyInventory() {
        ResaleShop shop = new ResaleShop();
        assertTrue(shop.inventory.isEmpty());
    }

    /**
     * Tests that refurbish sets the correct price for a computer made between 2000 and 2011.
     */
    @Test
    public void testRefurbishSetsCorrectPriceForOlderComputer() {
        ResaleShop shop = new ResaleShop();
        shop.inventory.clear();

        Computer comp = new Computer("Old Dell", "Intel", 256, 8, "Windows", 2010, 500);
        shop.inventory.add(comp);

        shop.refurbish(comp, "Linux");

        assertEquals(250, comp.price);
    }
}