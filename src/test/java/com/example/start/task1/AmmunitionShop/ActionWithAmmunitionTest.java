package com.example.start.task1.AmmunitionShop;

import com.example.start.task1.Ammunition.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActionWithAmmunitionTest {

    Shop getShop() {
        List<MotorcycleHelmet> motorcycleHelmetList = new ArrayList<MotorcycleHelmet>();
        List<MotorcycleGloves> motorcycleGlovesList = new ArrayList<MotorcycleGloves>();
        List<MotorcycleJacket> motorcycleJacketList = new ArrayList<MotorcycleJacket>();
        List<MotorcycleTrousers> motorcycleTrousersList = new ArrayList<MotorcycleTrousers>();
        List<MotorcycleBoots> motorcycleBootsList = new ArrayList<MotorcycleBoots>();

        motorcycleBootsList.add(new MotorcycleBoots("abc", "fb", 10.1, 1.1, 35, "eir", "red"));
        motorcycleGlovesList.add(new MotorcycleGloves("das", "etec", 4.3, 2.0, "11", "try"));
        motorcycleHelmetList.add(new MotorcycleHelmet("String name", "fsd", 1.2, 1.5, "Stringial", "Str"));
        motorcycleJacketList.add(new MotorcycleJacket("kjn", "Stri", 1.2, .02, "22", "oojn", "String jacketa"));
        motorcycleTrousersList.add(new MotorcycleTrousers("Strin", "facturer", 1.2, 1.3, "ousersSize", "color", "Sing"));
        return new Shop(motorcycleHelmetList, motorcycleGlovesList, motorcycleJacketList, motorcycleTrousersList, motorcycleBootsList);
    }

    @Test
    void getEmptyShop() {
        Shop shop = new Shop(new ArrayList<MotorcycleHelmet>(), new ArrayList<MotorcycleGloves>(), new ArrayList<MotorcycleJacket>(),
                new ArrayList<MotorcycleTrousers>(), new ArrayList<MotorcycleBoots>());
        ActionWithAmmunition action = new ActionWithAmmunition(shop);
        assertEquals(shop, action.getShop());
    }

    @Test
    void getNotEmptyShop() {
        List<MotorcycleHelmet> motorcycleHelmetList = new ArrayList<MotorcycleHelmet>();
        List<MotorcycleGloves> motorcycleGlovesList = new ArrayList<MotorcycleGloves>();
        List<MotorcycleJacket> motorcycleJacketList = new ArrayList<MotorcycleJacket>();
        List<MotorcycleTrousers> motorcycleTrousersList = new ArrayList<MotorcycleTrousers>();
        List<MotorcycleBoots> motorcycleBootsList = new ArrayList<MotorcycleBoots>();

        motorcycleBootsList.add(new MotorcycleBoots("abc", "fb", 10.1, 1.1, 35, "eir", "red"));
        motorcycleGlovesList.add(new MotorcycleGloves("das", "etec", 4.3, 2.0, "11", "try"));
        motorcycleHelmetList.add(new MotorcycleHelmet("String name", "fsd", 1.2, 1.5, "Stringial", "Str"));
        motorcycleJacketList.add(new MotorcycleJacket("kjn", "Stri", 1.2, .02, "22", "oojn", "String jacketa"));
        motorcycleTrousersList.add(new MotorcycleTrousers("Strin", "facturer", 1.2, 1.3, "ousersSize", "color", "Sing"));
        Shop shop = new Shop(motorcycleHelmetList, motorcycleGlovesList, motorcycleJacketList, motorcycleTrousersList, motorcycleBootsList);
        ActionWithAmmunition action = new ActionWithAmmunition(shop);
        assertEquals(shop, action.getShop());
    }

    @Test
    void setShop() {
        Shop shop = new Shop(new ArrayList<MotorcycleHelmet>(), new ArrayList<MotorcycleGloves>(), new ArrayList<MotorcycleJacket>(),
                new ArrayList<MotorcycleTrousers>(), new ArrayList<MotorcycleBoots>());
        ActionWithAmmunition action = new ActionWithAmmunition(shop);

        List<MotorcycleHelmet> motorcycleHelmetList = new ArrayList<MotorcycleHelmet>();
        List<MotorcycleGloves> motorcycleGlovesList = new ArrayList<MotorcycleGloves>();
        List<MotorcycleJacket> motorcycleJacketList = new ArrayList<MotorcycleJacket>();
        List<MotorcycleTrousers> motorcycleTrousersList = new ArrayList<MotorcycleTrousers>();
        List<MotorcycleBoots> motorcycleBootsList = new ArrayList<MotorcycleBoots>();

        motorcycleBootsList.add(new MotorcycleBoots("abc", "fb", 10.1, 1.1, 35, "eir", "red"));
        motorcycleGlovesList.add(new MotorcycleGloves("das", "etec", 4.3, 2.0, "11", "try"));
        motorcycleHelmetList.add(new MotorcycleHelmet("String name", "fsd", 1.2, 1.5, "Stringial", "Str"));
        motorcycleJacketList.add(new MotorcycleJacket("kjn", "Stri", 1.2, .02, "22", "oojn", "String jacketa"));
        motorcycleTrousersList.add(new MotorcycleTrousers("Strin", "facturer", 1.2, 1.3, "ousersSize", "color", "Sing"));
        Shop shop2 = new Shop(motorcycleHelmetList, motorcycleGlovesList, motorcycleJacketList, motorcycleTrousersList, motorcycleBootsList);
        action.setShop(shop2);
        assertEquals(shop2, action.getShop());

    }

    @Test
    void showItemsInfo() {
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            ActionWithAmmunition action = new ActionWithAmmunition(getShop());
            List<MotorcycleBoots> motorcycleBootsList = new ArrayList<MotorcycleBoots>();
            motorcycleBootsList.add(new MotorcycleBoots("abc", "fb", 10.1, 1.1, 35, "eir", "red"));
            action.showItemsInfo(motorcycleBootsList);
            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("abc- " + "fb: " +
                "Price: " + 10.1 + " Weight: " + 1.1 +
                " BootsSize: " + 35 + " Lacing: eir" + " Color: red\r\n", consoleOutput);
    }

    @Test
    void isAmmunitionListNotEmpty() {
    }

    @Test
    void inputIndexValue() {
    }

    @Test
    void isInputIndexValidationTrue() {
    }

    @Test
    void parseValue() {
    }

    @Test
    void inputYesNoValue() {
    }

    @Test
    void isYesNoValidationTrue() {
    }

    @Test
    void isInputIndexNumberBeInRangeListSize() {
    }

    @Test
    void isDenial() {
    }

    @Test
    void isYesOrNo() {
    }

    @Test
    void selectAmmunition() {
    }

    @Test
    void sortByWeight() {
    }

    @Test
    void inputMaxMinValue() {
    }

    @Test
    void isMaxMinValidationTrue() {
    }

    @Test
    void findAndShowItemsInRangePrice() {
    }
}