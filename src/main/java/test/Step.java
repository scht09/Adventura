package test;

/**
 * Třída představující krok testovacího scénáře. Krok scénáře obsahuje
 * informace sloužící k provedení příkazu a následnému ověření správné
 * reakce hry na tento příkaz.
 *
 * @author Jan Říha
 * @version LS-2021, 2021-05-10
 */
public class Step
{
    private String action;
    private String message;
    private String area;
    private String[] exits;

    // private String[] items;
    // private String[] inventory;
    // private String[] persons;
    // private Boolean gameOver;

    /**
     * Metoda vrátí příkaz, který hra v rámci tohoto kroku provede.
     *
     * @return herní příkaz včetně parametrů
     */
    public String getAction()
    {
        return action;
    }

    /**
     * Metoda nastaví příkaz, který hra v rámci tohoto kroku provede,
     * a následně celý krok vrátí.
     *
     * @param action herní příkaz včetně parametrů
     * @return tento krok testovacího scénáře
     */
    public Step setAction(String action)
    {
        this.action = action;

        return this;
    }

    /**
     * Metoda vrátí zprávu, kterou by hra měla vypsat po provedení příkazu.
     *
     * @return zpráva vypsaná po provedení příkazu
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Metoda nastaví zprávu, kterou by hra měla vypsat po provedení příkazu,
     * a následně vrátí celý tento krok.
     *
     * @param message zpráva vypsaná po provedení příkazu
     * @return tento krok testovacího scénáře
     */
    public Step setMessage(String message)
    {
        this.message = message;

        return this;
    }

    /**
     * Metoda vrátí název lokace, ve které by se měl hráč nacházet po provedení
     * příkazu.
     *
     * @return název aktuální lokace po provedení příkazu
     */
    public String getArea()
    {
        return area;
    }

    /**
     * Metoda nastaví název lokace, ve které by se měl hráč nacházet po provedení
     * příkazu, a následně vrátí celý tento krok.
     *
     * @param area název aktuální lokace po provedení příkazu
     * @return tento krok testovacího scénáře
     */
    public Step setArea(String area)
    {
        this.area = area;

        return this;
    }

    /**
     * Metoda vrátí pole názvů sousedních lokací, do kterých hráč po provedení
     * příkazu může z aktuální lokace odejít.
     *
     * @return pole názvů sousedních lokací
     */
    public String[] getExits()
    {
        if (exits == null) {
            return null;
        }

        return exits.clone();
    }

    /**
     * Metoda nastaví pole názvů sousedních lokací, do kterých hráč po provedení
     * příkazu může z aktuální lokace odejít, a následně vrátí celý tento krok.
     *
     * @param exits pole názvů sousedních lokací
     * @return tento krok testovacího scénáře
     */
    public Step setExits(String... exits)
    {
        if (exits == null) {
            this.exits = null;
        } else {
            this.exits = exits.clone();
        }

        return this;
    }

    /**
     * Metoda vrátí kompletní popis kroku testovacího scénáře.
     *
     * @return kompletní popis kroku testovacího scénáře
     */
    @Override
    public String toString()
    {
        return action
                + "\n--------------------------------------------------"
                + "\nOdpověď : " + (message == null ? "(nevyhodnocuje se)" : message)
                + "\n--------------------------------------------------"
                + "\nLokace  : " + (area == null ? "(nevyhodnocuje se)" : area)
                + "\nVýchody : " + (exits == null ? "(nevyhodnocuje se)" : String.join(", ", exits));
    }
}
