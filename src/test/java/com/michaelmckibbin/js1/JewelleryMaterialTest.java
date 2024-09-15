package com.michaelmckibbin.js1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JewelleryMaterialTest {
    JewelleryMaterial jewelleryMaterial;

    @BeforeEach
    void setUp() {
        jewelleryMaterial = new JewelleryMaterial("999", "Gold", "Gold Bar", "oz", "/images/goldBars.jpg",10, 7999.00F, 24);
    }

    @AfterEach
    void tearDown() {
        jewelleryMaterial = null;
    }

    @Test
    void testGetJewelleryMaterialName() {
        assertEquals("Gold", jewelleryMaterial.getJewelleryMaterialName());
    }
    @Test
    void testGetJewelleryMaterialQuality() {
        assertEquals(24, jewelleryMaterial.getJewelleryMaterialQuality());
    }
    @Test
    void testGetJewelleryMaterialPrice() {
        assertEquals(7999.00F, jewelleryMaterial.getJewelleryMaterialPrice());
    }
    @Test
    void testGetJewelleryMaterialQuantity() {
        assertEquals(10, jewelleryMaterial.getJewelleryMaterialQuantity());
    }
    @Test
    void testGetJewelleryMaterialUnit() {
        assertEquals("oz", jewelleryMaterial.getJewelleryMaterialUnit());
    }
    @Test
    void testGetJewelleryMaterialImage() {
        assertEquals("/images/goldBars.jpg", jewelleryMaterial.getJewelleryMaterialImage());
    }
    @Test
    void testGetJewelleryMaterialDescription() {
        assertEquals("Gold Bar", jewelleryMaterial.getJewelleryMaterialDescription());
    }
    @Test
    void testGetJewelleryMaterialId() {
        assertEquals("999", jewelleryMaterial.getJewelleryMaterialId());
    }
    @Test
    void testSetJewelleryMaterialQuality() {
        jewelleryMaterial.setJewelleryMaterialQuality(99);
        assertEquals(99, jewelleryMaterial.getJewelleryMaterialQuality());
    }
    @Test
    void testSetJewelleryMaterialPrice() {
        jewelleryMaterial.setJewelleryMaterialPrice(9999.00F);
        assertEquals(9999.00F, jewelleryMaterial.getJewelleryMaterialPrice());
    }
    @Test
    void testSetJewelleryMaterialQuantity() {
        jewelleryMaterial.setJewelleryMaterialQuantity(99);
        assertEquals(99, jewelleryMaterial.getJewelleryMaterialQuantity());
    }
    @Test
    void testSetJewelleryMaterialUnit() {
        jewelleryMaterial.setJewelleryMaterialUnit("g");
        assertEquals("g", jewelleryMaterial.getJewelleryMaterialUnit());
    }
    @Test
    void testSetJewelleryMaterialImage() {
        jewelleryMaterial.setJewelleryMaterialImage("/images/goldBars2.jpg");
        assertEquals("/images/goldBars2.jpg", jewelleryMaterial.getJewelleryMaterialImage());
    }
    @Test
    void testSetJewelleryMaterialDescription() {
        jewelleryMaterial.setJewelleryMaterialDescription("Gold Bar 2");
        assertEquals("Gold Bar 2", jewelleryMaterial.getJewelleryMaterialDescription());
    }
    @Test
    void testSetJewelleryMaterialId() {
        jewelleryMaterial.setJewelleryMaterialId("998");
        assertEquals("998", jewelleryMaterial.getJewelleryMaterialId());
    }
    @Test
    void testSetJewelleryMaterialName() {
        jewelleryMaterial.setJewelleryMaterialName("Silver");
        assertEquals("Silver", jewelleryMaterial.getJewelleryMaterialName());
    }
    @Test
    void testToString() {
        assertEquals("jewelleryMaterialId=999, jewelleryMaterialName=Gold, jewelleryMaterialDescription=Gold Bar, jewelleryMaterialUnit=oz, jewelleryMaterialImage=/images/goldBars.jpg, jewelleryMaterialQuantity=10, jewelleryMaterialPrice=7999.0, jewelleryMaterialQuality= 24.0", jewelleryMaterial.toString());
    }

}