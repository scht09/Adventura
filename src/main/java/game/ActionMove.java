package game;

/**
 * Třída implementující příkaz pro pohyb mezi herními lokacemi.
 *
 * @author Tomáš Schenk, Jan Říha
 * @version LS-2021, 2021-06-06
 */
public class ActionMove implements IAction
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionMove(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>jdi</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "jdi";
    }

    /**
     * Metoda se pokusí přesunout hráče do jiné lokace. Nejprve zkontroluje počet
     * parametrů. Pokud nebyl zadán žádný parametr <i>(tj. neznáme cíl cesty)</i>,
     * nebo bylo zadáno dva a více parametrů <i>(tj. hráč chce jít na více míst
     * současně)</i>, vrátí chybové hlášení. Pokud byl zadán právě jeden parametr,
     * zkontroluje, zda s aktuální lokací sousedí lokace s daným názvem <i>(tj.
     * zda z aktuální lokace lze jít do požadovaného cíle)</i>. Pokud ne, vrátí
     * chybové hlášení. Pokud je v lokaci <i>(bažina)</i> a nemá <i>(hůl)</i> ,tak hra končí. 
     * Pokud všechny kontroly proběhnou v pořádku, provede přesun
     * hráče do cílové lokace a vrátí její popis.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, kam mám jít.";
        }

        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím jít do více lokací současně.";
        }

        String areaName = parameters[0];
        Area currentArea = game.getWorld().getCurrentArea();
        Area targetArea = currentArea.getExit(areaName);

        if (!currentArea.hasExit(areaName)) {
            return "Do lokace '" + areaName + "' se odsud jít nedá.";
        }
        Inventory inventory = game.getWorld().getInventory();
        int inInv=inventory.find("hul");
        if (targetArea.getName().equals("bazina") && inInv==-1) {
            game.setGameState(2);
            return "Vstoupil jsi do bažiny a brzy jsi se začal bořit, za chvíli jsi se do bažiny uplně propadl a utopil se";
        }
        
        
        game.getWorld().setCurrentArea(targetArea);
        
        return targetArea.getFullDescription();
    }
}
