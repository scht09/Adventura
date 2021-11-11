package game;

import java.util.*;

/**
 * Třída implementující příkaz pro odemykání.
 *
 * @author Tomáš Schenk
 * @version LS-2021, 2021-06-06
 */

public class ActionUnlock implements IAction
{ 
    private Game game;
    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionUnlock(Game game)
    {
        this.game = game;
    }
    
    /**
     * Metoda vrací název příkazu, slovo tj.&nbsp; slovo <b>odemkni</b>..
     * @return název příkazu
     */
    public String getName()
    {
        return "odemkni";
    }
    
    /**
     *  Metoda se pokusí odemknout předmět z aktuální lokace a uložit předmět v něm do hráčova
     * inventáře. Nejprve zkontroluje počet parametrů. Pokud nebyl zadán žádný
     * parametr <i>(tj. neznáme požadovaný předmět)</i>, nebo bylo zadáno dva a
     * více parametrů <i>(tj. hráč chce odemknout více předmětů současně)</i>, vrátí
     * chybové hlášení. Pokud byl zadán právě jeden parametr, zkontroluje, zda
     * v aktuální lokaci je předmět s daným názvem, zda je odemknutelný a zda
     * na má hráč správný klíč <i>(tj. zda ho lze odemknout)</i>. Pokud ne,
     * vrátí chybové hlášení. Pokud odemkne studnu, vyhrává hru.
     * Pokud odemkne něco jíného tak se přidá předmět do inventáře.
     * @param parameters parametry příkazu (očekává se prázdné pole)
     * @vrací informace pro hráče, které hra vypíše na konzoli
     */
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Je potřeba uvést,co cheš odemknout.";
        }

        if (parameters.length > 1) {
            return "Nemůžeš odemykat více věcí najednou.";
        }

        String itemName = parameters[0];
        Area currentArea = game.getWorld().getCurrentArea();
        
        if (!currentArea.containsItem(itemName)) {
            return "Tohle tady není.";
        }
        
        Item item = currentArea.getItem(itemName);
        
        if (!item.isUnlockable()) {
            return "Nelze odemknout.";
        }
        Inventory inventory = game.getWorld().getInventory();
        
        if(itemName.equals("truhlicka")){
            int resultOfFinding = inventory.find("klic");
            if(resultOfFinding==-1){
                return "Nemáš správný klíč.";
            }
            //odeber klic
            inventory.removeFromInventory(resultOfFinding);
            //todo dej novej klic
            Item well_key= new Item ("veleklic","vypadá že odemyká vlhká místa",true,false);
            inventory.addSomewhere(well_key);
            return "Odemkl(a) jsi \'" + itemName + "\' a sebral jsi \'" + well_key.getName() +"\' který se tam nacházel";
        }
        else if(itemName.equals("studna")){  
            int resultOfFinding = inventory.find("veleklic");
            if(resultOfFinding==-1){
                return "Nemáš správný klíč.";
            }
            //odeber klic
            inventory.removeFromInventory(resultOfFinding);            
            //vlez do studny - konec hry - výhra
            ///TODO game.setGameState(2); je konec - prohra
            game.setGameState(1);
            //return game.getEpilogue();
            return "";
        }
        else
        {
            return "Snažíš se odemknout něco bez zámku.";
        }
        //hledam klic v inventari
        
        //odeberu klic z inventare
        
        //obsah truhly dam hraci
        
        //
    }
}
