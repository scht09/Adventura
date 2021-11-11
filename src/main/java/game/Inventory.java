package game;

import java.util.*;

/**
 * Instance třídy Inventory představují kolekci věcí, které si uživatel přidal 
 * do inventáře v průběhu hraní.
 *
 * @author    Tomáš Schenk
 * @version LS-2021, 2021-03-06
 */
public class Inventory
{
    private List<Item> inventoryContains;            // Seznam věcí v batohu
    private static final int INVENTORY_LIMIT=2;

    /**
     *  Vytvážíme list, do kterého se nám budou zapisovat předměty, které sebereme
     */
    public Inventory() {
        inventoryContains = new ArrayList<Item>();
    }
    
    /**
     * Metoda na přidání předmětu do inventáře. Zkontroluje zda inventář není pnlý a zda je předmět přenesitelný.{@code true}, pokud je; jinak {@code false}
     * Pokud tyto podmínky splní, je přidán.
     *
     *@param item jaký předmět chceme přidat
     *
     *@return výsledek, zda se to povedlo
     */
    public boolean addSomewhere(Item item) {
        boolean result = false;
        if (inventoryLimit() && moveableItem(item)) {          
            inventoryContains.add(item);
            result = true;
           }
        return result;
    }
    
    /**
     * Kontroluje zda je obsah inventáře v limitu. {@code true}, pokud je; jinak {@code false}
     *
     *@return zda je či není v limitu
     */
    public boolean inventoryLimit() {
         if (inventoryContains.size() < INVENTORY_LIMIT) {
            return true;   
        }        
        return false;
    }
    
    /**
     * Kontroluje zda je předmět přenositelný. {@code true}, pokud je; jinak {@code false}
     * 
     *
     * 
     * @return zda je přenositelný
     */
    public boolean moveableItem(Item item) {          
        if(item.isMoveable()){
            return true;
    }   
            return false;
  }
    
    /**
     * Vrací seznam věcí v batohu. Jeden po druhém.
     * 
     * @return seznam věcí v batohu
     */
    public String getItems() {
        String itemsInInventory = "";
        /*for(int i = 0; i < inventoryContains.size(); i++){
            itemsInInventory += " " + inventoryContains.get(i).getName();
        }*/
        for (Item item: inventoryContains) {
            itemsInInventory += " " + item.getName();
        }
        return itemsInInventory;
    }
 
    /***
     * Odebrání předmětu z batohu.{@code true}, pokud se to povedlo; jinak {@code false}
     * 
     *
     * 
     * @return result vrací výsledek
     */
    public boolean removeFromInventory(int number){
        boolean result = false;
        if(inventoryContains.size()>=number){
            inventoryContains.remove(number);
            result = true;
        }        
        return result;
    }
    
    /***
     *
     *Pokusi se najit predmet v inventari podle nazvu. Postupně projede všechny předměty v inventáři, vždy z čísla umístění předmětu dostaně jeho jméno pomocí 
     * getName(),a to pak porovná se jménem které hledá. Pak vzací číslo, kolikátý item v pořadí to je, nebo vrát -1 pokud tam není.
     *
     *
     *
     *@return vrací pořadí itemu v inventáři, pokud tam je, jinak vrací -1
     */
    public int find(String itemName){
        for(int  i = 0; i < inventoryContains.size(); i++){
            Item fromInv = inventoryContains.get(i);
            if(fromInv.getName().equals(itemName)){
                return i;
            }
        }
        return -1;
    }
    
     /**
     * Metoda vyhledá v inventáři předmět s daným názvem a vrátí na něj odkaz.
     *
     * @param number pořadí v listu itemů v inventáři
     * @return předmět s daným číslem pořadí; {@code null}, pokud v lokaci není

     */
    public Item getItem(int number){
        if(inventoryContains.size()>=number){
           return inventoryContains.get(number);
        }        
        return null;
    }
    //== Soukromé metody (instancí i třídy) ========================================

}
