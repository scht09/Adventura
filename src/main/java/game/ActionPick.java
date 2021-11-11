package game;

/**
 * Třída implementující příkaz pro sbírání předmětů.
 *
 * @author Tomáš Schenk, Jan Říha
 * @version LS-2021, 2021-06-13
 */
public class ActionPick implements IAction
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionPick(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu "seber".
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "seber";
    }

    /**
     * Metoda se pokusí sebrat předmět z aktuální lokace a uložit ho do hráčova
     * inventáře. Nejprve zkontroluje počet parametrů. Pokud nebyl zadán žádný
     * parametr <i>(tj. neznáme požadovaný předmět)</i>, nebo bylo zadáno dva a
     * více parametrů <i>(tj. hráč chce sebrat více předmětů současně)</i>, vrátí
     * chybové hlášení. Pokud byl zadán právě jeden parametr, zkontroluje, zda
     * v aktuální lokaci je předmět s daným názvem, zda je přenositelný a zda
     * na něj hráč má v inventáři místo <i>(tj. zda ho lze sebrat)</i>. Pokud ne,
     * vrátí chybové hlášení. Pokud hráč sbíra klíč na krku čarodějnice a má sekeru,
     * tak jí zabije, jinak prohrává hru.
     * Pokud všechny kontroly proběhnou v pořádku, provede
     * přesun předmětu z lokace do inventáře a vrátí informaci o sebrání předmětu.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, co mám sebrat.";
        }

        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím sebrat více věcí současně."; 
        }                                                               
        String itemName = parameters[0];
        Area currentArea = game.getWorld().getCurrentArea();

        if (!currentArea.containsItem(itemName)) {
            return "Předmět '" + itemName + "' tady není.";
        }
        Inventory inventory = game.getWorld().getInventory();
        Person person = currentArea.getPerson("carodejnice");
        Item item = currentArea.getItem(itemName);
        int inInv=inventory.find("sekera");
        if (itemName.equals("klic") && inInv==-1) {
            game.setGameState(2);
            return person.getDialogue();
        }
        
        if (itemName.equals("klic") && inInv!=-1) {
            inventory.removeFromInventory(inventory.find("sekera"));
            inventory.addSomewhere(item);
            currentArea.removeItem(itemName);
            currentArea.removePerson("carodejnice");
            return "Všiml jsi si, že se čarodějnice probouzí, tak jsi neváhal a jednou ranou jsi jí sekerou setnul hlavu a sebral(a) jsi '" + itemName + "' a uložil(a) ho do inventáře. Topůrko ti zůstalo v ruce, ale násada zůstala v čarodějnici. Je rozbitá.";
        }
               
        
        return getText(item, itemName);
    }
    
    public String getText(Item item, String itemName){
        Area currentArea = game.getWorld().getCurrentArea();
        Inventory inventory = game.getWorld().getInventory();
        if (item.isMoveable() && inventory.addSomewhere(item)) {
            currentArea.removeItem(itemName);
            return "Sebral(a) jsi předmět '" + itemName + "' a uložil(a) ho do inventáře.";
        }    
        else if(item.isMoveable()){
            return "Předmět " + itemName + " se ti tam už nevejde.";            
        }
        else{                
            return "Předmět '" + itemName + "' fakt neuneseš.";
        }
    }
}
