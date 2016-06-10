/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ViktorKim
 */
public class PlayerTest 
{
    
    static Player p;
    
    public PlayerTest() 
    {
        
    }

    @BeforeClass
    public static void setUpBeforeClass()
    {
        p = new Player();
    }
    
    /**
     * Test of levelUp method, of class Player.
     */
    @Test
    public void testLevelUp() 
    {
        System.out.println("levelUp");
        p.levelUp();
        assertEquals(p.getMaxHp(), 40);
    }

    /**
     * Test of hasItem method, of class Player.
     */
    @Test
    public void testHasItem() 
    {
        System.out.println("hasItem");
        boolean expResult = true;
        p.addItem(new Item("TestItem", "Test", -1));
        boolean result = p.hasItem("TestItem");
        assertEquals(expResult, result);
    }

    /**
     * Test of getItem method, of class Player.
     */
    @Test
    public void testGetItem() 
    {
        System.out.println("getItem");
        Item expResult = new Item("TestItem", "Test", -1);
        p.addItem(expResult);
        Item result = p.getItem("TestItem");
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseMaxHp method, of class Player.
     */
    @Test
    public void testIncreaseMaxHp() 
    {
        System.out.println("increaseMaxHp");
        int amount = 50;
        int previous = p.getMaxHp();
        p.increaseMaxHp(amount);
        assertEquals(p.getMaxHp(), previous + amount);
    }

    /**
     * Test of damagePlayer method, of class Player.
     */
    @Test
    public void testDamagePlayer() 
    {
        System.out.println("damagePlayer");
        int damage = 5;
        p.damagePlayer(damage);
        assertEquals(p.getMaxHp() - 5 , p.getCurrentHp());
    }

    /**
     * Test of removeFromInventory method, of class Player.
     */
    @Test
    public void testRemoveFromInventory() 
    {
        System.out.println("removeFromInventory");
        String name = "TestItem2";
        p.addItem(new Item(name, "Test", -1));
        p.removeFromInventory(name);
        assertEquals(p.hasItem(name), false);
    }

    /**
     * Test of getBestWeapon method, of class Player.
     */
    @Test
    public void testGetBestWeapon() 
    {
        System.out.println("getBestWeapon");
        Weapon wep1 = new Weapon("wep1", "test", -1, 3000);
        Weapon wep2 = new Weapon("wep2", "test", -1, 3001);
        p.addItem(wep1);
        p.addItem(wep2);
        Weapon expResult = wep2;
        Weapon result = p.getBestWeapon();
        assertEquals(expResult, result);
    }
    
}
