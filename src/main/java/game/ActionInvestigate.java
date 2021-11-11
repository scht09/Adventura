package game;

/**
 * Třída implementující příkaz pro průzkum konkrétního předmětu, nebo inventáře.
 *
 * @author Tomáš Schenk, Jan Říha
 * @version LS-2021, 2021-06-13
 */
public class ActionInvestigate implements IAction
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionInvestigate(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>prozkoumej</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "prozkoumej";
    }

    /**
     * Metoda vrátí detailní popis vybraného předmětu v aktuální lokaci, v inventáři, nebo inventář celý vypíše.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, co mám prozkoumat.";
        }

        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím zkoumat více věcí současně.";
        }

        String itemName = parameters[0];
        Area currentArea = game.getWorld().getCurrentArea();
        Inventory inventory = game.getWorld().getInventory();
        if (itemName.equals("inventar")) {
            return inventory.getItems();
        }
        
        int result = inventory.find(itemName);
        if (!currentArea.containsItem(itemName) && result==-1) {
            return "Předmět '" + itemName + "' tady není a není ani v inventáři.";
        }
        if (currentArea.containsItem(itemName)){
            Item item = currentArea.getItem(itemName);
            return "Díváš se na předmět '" + itemName + "'.\n" +
                item.getDescription();
        }
        else{
            Item item = inventory.getItem(inventory.find(itemName));
            return "Díváš se na předmět '" + itemName + "'.\n" + item.getDescription();
        }
        
        
           
        

        
    }
}
