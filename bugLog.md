## Bug 1
Brief description: The Computer constructor does not correctly set the memory value provided as a parameter.
Failed unit test: testConstructorSetsMemory

## Bug 2
Brief description: The Computer constructor does not correctly set the price value provided as a parameter.
Failed unit test: testConstructorSetsPrice

## Bug 3
Brief description: The setOS() method ignores the provided OS value and always sets the operating system to "None".
Failed unit test: testSetOS

## Bug 4
Brief description: The buy() method ignores the Computer object passed as a parameter and instead creates a new Computer object to add to the inventory.
Failed unit test: testBuyAddsComputer

## Bug 5
Brief description: The printInventory() method iterates incorrectly through the inventory list, causing an IndexOutOfBoundsException.
Failed unit test: testPrintInventoryDoesNotCrash

## Bug 6
Brief description: The buy() method does not throw a RuntimeException when attempting to add a duplicate computer to the inventory.
Failed unit test: testBuyThrowsExceptionForDuplicateComputer

## Bug 7
Brief description: The sell() method does not throw a RuntimeException when trying to sell a computer that is not in the inventory. 
Failed unit test: testSellThrowsExceptionIfNotInInventory

## Bug 8
Brief description: The refurbish() method incorrectly compares strings using "!=" instead of .equals(), which can cause incorrect behavior when checking for "None".
Failed unit test: testRefurbishWithNoneDoesNotChangeOS

## Bug 9
Brief description: The refurbish() method cannot correctly update the operating system because the setOS() method is implemented incorrectly.
Failed unit test: testSetOS

## Bug 10
Brief description: The buy() method always creates and adds a hardcoded "2019 MacBook Pro" instead of preserving the information of the computer passed as a parameter.
Failed unit test: testBuyAddsCorrectComputerInformation

# Identifying more bugs (for the revision)

## Bug 11
Brief description: The refurbish() method sets the price of computers made between 2000 and 2011 to 2500 instead of the expected price 250.
Failed unit test: testRefurbishSetsCorrectPriceForOlderComputer

## Bug 12
Brief description: The ResaleShop constructor incorrectly starts the inventory with a hardcoded computer instead of starting with an empty inventory.
Failed unit test: testResaleShopStartsWithEmptyInventory