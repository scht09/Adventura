package game;

import java.util.*;

/**
 * Třída implementující příkaz pro odemykání.
 *
 * @author Tomáš Schenk
 * @version LS-2021, 2021-06-06
 */

public class ActionTalk implements IAction
{ 
    private Game game;
    private List<String> wife; 
    
    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    
    public ActionTalk(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>mluv s</b>.
     *
     * @return název příkazu
     */
    public String getName()
    {
        return "mluv_s";
    }
    
    public void Dialog() {
    wife = new ArrayList<String>();
    
    String dialog1="Tak dělej jdi už! Zítra už bude možná pozdě. A hlavně si s sebou vem něco, čím se proti té čarodějnici budeš bránit, kdyby to bylo třeba.";
    String dialog2="No tak jdi už!";
    String dialog3="Co tu furt děláš";
    
    wife.add(dialog1);
    wife.add(dialog2);
    wife.add(dialog3);
}

    /**
     * Metoda se pokusí mluvit s určitou osobou. Nejprve zkontroluje počet parametrů.
     * Pokud nebyl zadán žádný
     * parametr <i>(tj. neznáme požadovanou osobu)</i>, nebo bylo zadáno dva a
     * více parametrů <i>(tj. hráč chce mluvit s více lidmi současně)</i>, vrátí
     * chybové hlášení. Pokud byl zadán právě jeden parametr, zkontroluje, zda
     * v aktuální lokaci je osoba s daným jménem a zda se s ní dá mluvit. Pokud ne,
     * vrátí chybové hlášení. Pokud budu hráč mluvit s dřevorubcem, přidá se do lokace hůl
     * a už s ním nepůjde mluvit. Pokud se hráč pokouší mluvit s čarodějnicí,
     * tak ho prokleje a hráč prohrává hru.
     * Pokud všechny kontroly proběhnou v pořádku, vrátí se dialog dané postavy.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Je potřeba uvést,s kým chceš mluvit.";
        }

        if (parameters.length > 1) {
            return "Nemůžeš mluvit s více lidmi najednou.";
        }

        String personName = parameters[0];
        Area currentArea = game.getWorld().getCurrentArea();
        Person person = currentArea.getPerson(personName);
        if (!currentArea.containsPerson(personName)) {
            return "Tohle tady není.";
        }
        
        if (!person.isTalkable()) {
            return "A nic. Asi s tebou nechce mluvit";
        }
        
        if (person.getName().equals("drevorubec")) {
            person.setTalkable(false);
            Item stick = new Item("hul","klasická ze dřeva, musel jí zde někdo odhodit",true,false);
            currentArea.addItem(stick);
            return  personName +" říká:" + "\n"+ person.getDialogue();
        }
        int i = 0;
        if (person.getName().equals("manzelka")) {
            if(i<3)
                {
                person.setDialog(wife.get(i));
                i++;
                return person.getDialogue();  
        }
            else{
                return "...";    
            }
        }
        
        if (!person.getName().equals("carodejnice")) {
            return  personName +" říká:" + "\n"+ person.getDialogue();
        }
        game.setGameState(2);
        return person.getDialogue();
    }
}
