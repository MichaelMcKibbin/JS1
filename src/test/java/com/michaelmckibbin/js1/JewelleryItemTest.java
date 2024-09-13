package com.michaelmckibbin.js1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JewelleryItemTest {

    @Test
    void getItemID() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        assertEquals("123", item.getItemID());
    }

    @Test
    void getItemId() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        assertEquals(123, item.getItemId());
    }

    @Test
    void setItemID() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        item.setItemID("456");
        assertEquals("456", item.getItemID());
    }

    @Test
    void getItemName() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        assertEquals("Test Item", item.getItemName());
    }

    @Test
    void setItemName() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        item.setItemName("New Item Name");
        assertEquals("New Item Name", item.getItemName());
    }

    @Test
    void getItemType() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        assertEquals("Test Type", item.getItemType());
    }

    @Test
    void setItemType() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        item.setItemType("New Type");
        assertEquals("New Type", item.getItemType());
    }

    @Test
    void getItemDescription() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        assertEquals("Test Description", item.getItemDescription());
    }

    @Test
    void setItemDescription() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        item.setItemDescription("New Description");
        assertEquals("New Description", item.getItemDescription());
    }

    @Test
    void getItemTargetGender() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        assertEquals("Test Gender", item.getItemTargetGender());
    }

    @Test
    void setItemTargetGender() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        item.setItemTargetGender("New Gender");
        assertEquals("New Gender", item.getItemTargetGender());
    }

    @Test
    void getItemImage() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        assertEquals("Test Image", item.getItemImage());
    }

    @Test
    void setItemImage() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        item.setItemImage("New Image");
        assertEquals("New Image", item.getItemImage());
    }

    @Test
    void getItemPrice() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        assertEquals(19.99f, item.getItemPrice());
    }

    @Test
    void setItemPrice() {
        JewelleryItem item = new JewelleryItem("123", "Test Item", "Test Type", "Test Description", "Test Gender", "Test Image", 19.99f);
        item.setItemPrice(29.99f);
        assertEquals(29.99f, item.getItemPrice());
    }


    @Test
    void testAddJewelleryMaterial() {
        JewelleryItem item = new JewelleryItem("1", "Ring", "Accessories", "Stainless Steel", "Male", "ring.jpg", 99.99f);
        item.addJewelleryMaterial();
        assertEquals(0, item.getJewelleryMaterials().size());
    }
}