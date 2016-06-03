/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CHRIS
 */
public class Weapon extends Item 
{
    
    private int damage;
    
    public Weapon(String name, String description, int goldValue, int damage) 
    {
        super(name, description, goldValue);
        this.damage = damage;
    }
    
    public void increaseDamage(int amount)
    {
        damage += amount;
    }
    
    public int getDamage() 
    {
        return damage;
    }
    
}