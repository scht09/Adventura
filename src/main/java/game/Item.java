package game;

/**
 * Třída implementující Předměty.
 *
 * @author Tomáš Schenk, Jan Říha
 * @version LS-2021, 2021-06-06
 */

public class Item implements Comparable<Item>
{
    private String name;
    private String description;
    private boolean moveable;
    private boolean unlockable;
    
    /**
     * Konstruktor třídy.
     *
     * @param name jméno - udává jméno předmětu
     * @param description popis - popis předmětu
     * @param moveable přenositelný - určuje zda je možné s předmětem manipulovat
     * @param unlockable odemknutelné - určuje zda je možné s předmět odemknout
     */
    public Item(String name, String description, boolean moveable, boolean unlockable)
    {
        this.name = name;
        this.description = description;
        this.moveable = moveable;
        this.unlockable = unlockable;
    }

    public Item(String name, String description)
    {
        this(name, description, true, true);
    }
    
    /**
     * Metoda vrací jméno předmětu.
     *
     * @return jméno
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Metoda vrací popis předmětu.
     *
     * @return popis předmětu
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Metoda vrací zda je přenositelný.
     *
     * @return {@code true}, pokud je; jinak {@code false}
     */
    public boolean isMoveable()
    {
        return moveable;
    }
    
    /**
     * nastavuje hodnotu moveable
     * 
     *
     */
    public void setMoveable(boolean moveable)
    {
        this.moveable = moveable;
    }
    
     /**
     * Metoda vrací zda je předmět odemknutelný.
     *
     * @return {@code true}, pokud je; jinak {@code false}
     */
    public boolean isUnlockable()
    {
        return unlockable;
    }
    
    /**
     * updatuje hodnotu unlockable
     * 
     * param zda je odemknutelný, nebo ne
     */
    public void setUnlockable(boolean unlockable)
    {
        this.unlockable = unlockable;
    }
    
    
    @Override
    public boolean equals(final Object object)
    {
        if (object == this) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (object instanceof Item) {
            Item item = (Item) object;

            return name.equals(item.getName());
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public int compareTo(Item item)
    {
        return name.compareTo(item.getName());
    }
}
