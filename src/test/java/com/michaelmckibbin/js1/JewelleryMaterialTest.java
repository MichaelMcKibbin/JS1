package com.michaelmckibbin.js1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JewelleryMaterialTest {

    @Test
    void getJewelleryMaterialId() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        assertEquals("101", jewelleryMaterial.getJewelleryMaterialId());
    }

    @Test
    void setMaterialId() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101"
                , "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        jewelleryMaterial.setMaterialId("102");
        assertEquals("102", jewelleryMaterial.getJewelleryMaterialId());
    }

    @Test
    void getJewelleryMaterialName() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        assertEquals("Silver Chain", jewelleryMaterial.getJewelleryMaterialName());
    }

    @Test
    void setMaterialName() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        jewelleryMaterial.setMaterialName("Ruby");
        assertEquals("Ruby", jewelleryMaterial.getJewelleryMaterialName());
    }

    @Test
    void getJewelleryMaterialDescription() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        assertEquals("1 inch silver chain", jewelleryMaterial.getJewelleryMaterialDescription());
    }

    @Test
    void setMaterialDescription() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        jewelleryMaterial.setMaterialDescription("1 cm ruby");
        assertEquals("1 cm ruby", jewelleryMaterial.getJewelleryMaterialDescription());
    }

    @Test
    void getJewelleryMaterialUnit() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        assertEquals("each", jewelleryMaterial.getJewelleryMaterialUnit());
    }

    @Test
    void setMaterialUnit() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        jewelleryMaterial.setMaterialUnit("cm");
        assertEquals("cm", jewelleryMaterial.getJewelleryMaterialUnit());
    }

    @Test
    void getJewelleryMaterialImage() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        assertEquals("/images/jewelleryGeneral.jpg", jewelleryMaterial.getJewelleryMaterialImage());
    }

    @Test
    void setMaterialImage() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        jewelleryMaterial.setMaterialImage("/images/ruby.jpg");
        assertEquals("/images/ruby.jpg", jewelleryMaterial.getJewelleryMaterialImage());
    }

    @Test
    void getJewelleryMaterialQuantity() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        assertEquals(10, jewelleryMaterial.getJewelleryMaterialQuantity());
    }

    @Test
    void setMaterialQuantity() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        jewelleryMaterial.setMaterialQuantity(20);
        assertEquals(20, jewelleryMaterial.getJewelleryMaterialQuantity());
    }

    @Test
    void getJewelleryMaterialPrice() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        assertEquals(100, jewelleryMaterial.getJewelleryMaterialPrice());
    }

    @Test
    void setMaterialPrice() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        jewelleryMaterial.setMaterialPrice(200);
        assertEquals(200, jewelleryMaterial.getJewelleryMaterialPrice());
    }

    @Test
    void testToString() {
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial("101", "Silver Chain", "1 inch silver chain", "each", "/images/jewelleryGeneral.jpg", 10, 100);
        assertEquals("jewelleryMaterialId=101, jewelleryMaterialName=Silver Chain, jewelleryMaterialDescription=1 inch silver chain, jewelleryMaterialUnit=each, jewelleryMaterialImage=/images/jewelleryGeneral.jpg, jewelleryMaterialQuantity=10, jewelleryMaterialPrice=100.0", jewelleryMaterial.toString());
    }
}