import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {
    @Test
    public void testConstructorSetsMemory() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        assertEquals(32, comp.memory);
    }

    @Test
    public void testConstructorSetsPrice() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        assertEquals(1200, comp.price);
    }

    @Test
    public void testGetYear() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        assertEquals(2020, comp.getYear());
    }

    @Test
    public void testSetPrice() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        comp.setPrice(900);
        assertEquals(900, comp.price);
    }

    @Test
    public void testSetOS() {
        Computer comp = new Computer("Dell XPS", "Intel", 512, 32, "Windows", 2020, 1200);
        comp.setOS("Linux");
        assertEquals("Linux", comp.operatingSystem);
    }

    @Test
    public void testBuyAddsComputer() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);
        
        shop.buy(comp);

        assertTrue(shop.inventory.contains(comp));
    }

    @Test
    public void testPrintInventoryDoesNotCrash() {
        ResaleShop shop = new ResaleShop();
        shop.printInventory();
    }

    @Test
    public void testRefurbishThrowsExceptionIfNotInInventory() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        try {
            shop.refurbish(comp, "Linux");
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {}
    }

    @Test
    public void testBuyThrowsExceptionForDuplicateComputer() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        try {
            shop.buy(comp);
            shop.buy(comp);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {}
}

    @Test
    public void testSellThrowsExceptionIfNotInInventory() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        try {
            shop.sell(comp);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {}
    }

    @Test
    public void testRefurbishWithNoneDoesNotChangeOS() {
        ResaleShop shop = new ResaleShop();
        Computer comp = shop.inventory.get(0);

        String oldOS = comp.operatingSystem;
        shop.refurbish(comp, new String("None"));

        assertEquals(oldOS, comp.operatingSystem);
    }

    @Test
    public void testBuyAddsCorrectComputerInformation() {
        ResaleShop shop = new ResaleShop();
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2020, 800);

        shop.buy(comp);

        Computer addedComp = shop.inventory.get(shop.inventory.size() - 1);
        assertEquals("Dell", addedComp.description);
    }

}
