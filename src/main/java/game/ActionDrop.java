package game;

/**
 * Třída implementující příkaz pro zahození konkrétního předmětu.
 *
 * @author Tomáš Schenk
 * @version LS-2021, 2021-06-13
 */
public class ActionDrop implements IAction
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionDrop(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu slovo tj.&nbsp; slovo <b>zahod</b>..
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "zahod";
    }

    /**
     * Metoda se pokusí odebrat předmět z hráčova inventáře. pokud nebyl zadán žádný
     * parametr <i>(tj. neznáme požadovaný předmět)</i>, nebo bylo zadáno dva a
     * více parametrů <i>(tj. hráč chce zahodit více předmětů současně)</i>, vrátí
     * chybové hlášení. Pokud byl zadán právě jeden parametr, zkontroluje zda je tento předmět v inventáři.
     * Dále kontroluje, zda se náhodou hráč nepokouší vyhodit klíč v bažině, pokud se tak děje, hráč prohrává,
     * stejně tak, pkud se pokouší zahodit hůl. Pokud zahazuje v bažině jiný předmět, tak se tento předmět maže a
     * do lokace se nepřidává. V jiných lokacích se předmět přidá do současné lokace. Program vrátí informace o zahození předmětu.
     * @param parameters parametry příkazu (očekává se pole s jedním prvkem, konkrétně jaký předmět chce zahodit)
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Musím vědět, co chceš zahodit.";
        }

        if (parameters.length > 1) {
            return "Zahazuj věci postupně.";
        }
        
        String itemName = parameters[0];
        Inventory inventory = game.getWorld().getInventory();
        Area currentArea = game.getWorld().getCurrentArea();
        int num = inventory.find(itemName);        
        if (num==-1) {
            return "Předmět '" + itemName + "' nemáš.";
        }
        Item item = inventory.getItem(num);
        if (currentArea.getName().equals("bazina") && (itemName.equals("veleklic") || itemName.equals("klic"))) {
            game.setGameState(2);
            return "Zahodil jsi klíč do bažiny. Po několika hodinách hledání jsi maximálně vyčerpán a v bažině se utápíš. Dobrá práce";
        }
        
        if (currentArea.getName().equals("bazina") && (itemName.equals("hul"))) {
            game.setGameState(2);
            return "Zahodil jsi klacek, který ti pomáhal určovat, kam se můžeš v bažině pohybovat a utopil jsi se. Dobrá práce.";
        }
        
        
        if (currentArea.getName().equals("bazina")) {
            inventory.removeFromInventory(inventory.find(itemName));
            return "Zahodil jsi '" + itemName + "' pryč.";
        }
        
        currentArea.addItem(item);
        inventory.removeFromInventory(inventory.find(itemName));
        
        
        return "Zahodil jsi '" + itemName + "' pryč.";
    }
}
