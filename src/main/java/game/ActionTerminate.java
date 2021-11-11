package game;

/**
 * Třída implementující příkaz pro předčasné ukončení hry.
 *
 * @author Tomáš Schenk, Jan Říha
 * @version LS-2021, 2021-06-06
 */
public class ActionTerminate implements IAction
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionTerminate(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu, slovo tj.&nbsp; slovo <b>konec</b>..
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "konec";
    }

    /**
     * Metoda ukončí hru.
     *
     * @param parameters parametry příkazu <i>(aktuálně se ignorují)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        game.setGameOver(true);

        return "Hru jsi ukončil.";
    }
}
