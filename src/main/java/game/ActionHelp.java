package game;

/**
 * Třída implementující příkaz pro zobrazení nápovědy ke hře.
 *
 * @author Tomáš Schenk, Jan Říha
 * @version LS-2021, 2021-06-06
 */
public class ActionHelp implements IAction
{
    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>nápověda</b>..
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "napoveda";
    }

    /**
     * Metoda vrací obecnou nápovědu ke hře. Co je cílem, a jaké příkazy může hráč použít.
     * @param parameters parametry příkazu <i>(aktuálně se ignorují)</i>
     * @return nápověda, kterou hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        return "Musíš se vydat najít svou dceru a zachránit jí před zlou čarodějnicí.\nMáš k dispozici několik příkazů které můžeš zadat do konzole a to:\njdi\nprozkoumej\nrozhledni_se\n"+
        "seber\nzahod\nodemkni\nmluv_s\nnapoveda\npo zadání příkazu je samozřejmě třeba zadat další parametr (pokud je to třeba). Např. po zadání příkazu seber je nutno napsat, co cheš sebrat."+
        " Kdyby jsi chtěl(a) zjistit co máš v inventáři zadej příkaz 'prozkoumej inventar'.";
    }
}
