package game;

import java.util.*;

/**
 * Třída implementující Osoby.
 *
 * @author Tomáš Schenk
 * @version LS-2021, 2021-06-06
 */

public class Person
{
    private String name;
    private String description;
    private boolean talkable;
    private String dialog;

    
    /**
     * Konstruktor třídy.
     *
     * @param name jméno - udává jméno osoby
     * @param description popis - popis osoby
     * @param talkable zda je možno s ním mluvit - určuje zda je možné s osobou mluvit
     * @param dialog - udává dialog, které má postava k dispozici
     */
    
    public Person(String name, String description, boolean talkable, String dialog)
    {
        this.name = name;
        this.description = description;
        this.talkable = talkable;
        this.dialog = dialog;
    }

    public Person(String name, String description)
    {
        this(name, description, true, "S touto postavou nelze mluvit.");
    }
    
    /**
     * Metoda vrací jméno osoby.
     *
     * @return jméno
     */
    
    public String getName()
    {
        return name;
    }

    /**
     * Metoda vrací popis osoby.
     *
     * @return popis osoby
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Metoda vrací zda je možno s osobou mluvit.
     *
     * @return {@code true}, pokud ano; jinak {@code false}
     */
    public boolean isTalkable()
    {
        return talkable;
    }
    
    /**
     * updatuje hodnotu talkable
     * param zda je talkable
     */
    public void setTalkable(boolean talkable)
    {
        this.talkable = talkable;
    }
    
    
    public void setDialog(String dialog)
    {
        this.dialog = dialog;
    }
    
    /**
     * Metoda vrací dialog.
     *
     * @return dialog
     */
    public String getDialogue(){
        return dialog;
    }
}
