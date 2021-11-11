package game;

/**
 * Třída představující mapu lokací herního světa. V datovém atributu
 * {@link #currentArea} uchovává odkaz na aktuální lokaci, ve které
 * se hráč právě nachází. Z aktuální lokace je možné se prostřednictvím
 * jejích sousedů dostat ke všem přístupným lokacím ve hře.
 * <p>
 * Veškeré informace o stavu hry <i>(mapa prostorů, inventář, vlastnosti
 * hlavní postavy, informace o plnění úkolů apod.)</i> by měly být uložené
 * zde v podobě datových atributů.
 *
 * @author Tomáš Schenk, Jan Říha
 * @version LS-2021, 2021-06-13
 */
public class GameWorld
{
    private Area currentArea;
    private Inventory inventory;

    /**
     * Konstruktor třídy, vytvoří jednotlivé lokace a propojí je pomocí východů, dále vytváří předměty a osoby které pak zasazuje do daných lokací.
     */
    public GameWorld()
    {
        Area house = new Area("domek", "Tady bydlíš, malý domek na kraji lesa, není to nic velkého, ale je to tvoje. ");
        Area garden = new Area("zahrada", "Spíše je to takový prostor okolo domku, kde máš malý kurník a ohrádku s prasaty, taky tam je kůlna, kde skladuješ naštípané dříví na zimu.");
        Area glade = new Area("mytina", "Malá mýtina, kde posledních pár dní dřevorubci z blízkého města kácí stromy.");
        Area forest = new Area("les", "Les natolik hustý, že nehledě na to, kolik je hodin, paprsky světla jsou schopny do této části lesa dosáhnout jen zřídka, a proto zde panuje permanentní šero.");
        Area bog = new Area("bazina", "ve středu tohoto hlubokého lesa se nachází černočerná bažina, jen těžko říct, jak hluboká asi tak může být. ");
        Area lodge = new Area("chatrc", "V povzdálí, na druhé straně bažiny, je vidět malá zkroucená chatrč. Přes jedno jediné okno, které je viditelné sice nejde říct, co je vevnitř, ale díky světlu můžeme usoudit, že se v ní nejspíše bude nacházet rozsvícená lucerna, nebo louč.");
        Area well = new Area("studna", "Stará kamenná studna, kdo ví kdy byla postavena, těžko říct, kdo by ji takto daleko od nejbližší vesnice, či města mohl používat.");

        house.addExit(garden);
        garden.addExit(house);

        garden.addExit(glade);
        glade.addExit(garden);

        glade.addExit(forest);
        forest.addExit(glade);

        forest.addExit(bog);
        bog.addExit(forest);
        
        bog.addExit(lodge);
        lodge.addExit(bog);
        
        forest.addExit(well);
        well.addExit(forest);

        currentArea = house;

        Item bed = new Item("postel", "Postel na které leží spletené větvičky",false,false);
        Item twigs = new Item("vetvicky","Větve spletené do pentagramu, už když se sem se svou rodinou stěhoval, slíchal od lidí z blízké vesnice zvěsti o čarodějnici, která unáší děti a spletené větvičky nechává na jejich posteli", true, false);
        Item table = new Item("stul","Obyčejný dřevněný stůl, dělal ho sám Jindra", false,false);
        Item chairs = new Item("zidle","U stolu jsou zasunuté čtyři židle, jednu pro každého člena domácnosti",false,false);
        Item hunk = new Item("spalek","Na něm seká ve volném čase Jinda dříví na zimu, prostě klasický špalek",false,false);
        Item axe = new Item("sekera","hned vedle špalku stojí stará sekera, kterou Jindra zdědil po svém otci, je už sice už zrezlá, ale Jindra jí udržuje stále naostřenou",true,false);
        Item pig = new Item("prase","vepř Bertík, teď už dostatečně vypasený,Jindra ho plánuje nadcházející měsíc prodat ve městě",false,false);
        Item egg = new Item("vajicko","klasický vejce, těžko říct, k čemu by se mu mohlo v této šlamastice hodit",true,false);
        Item mushrooms = new Item("houby","Jinda je lovec a na zběr hub si nikdy moc nepotrpěl, těžko říct jestli jsou jedovaté nebo ne, ale zkoušet to určitě nebude",true,false);
        Item logs = new Item("klady","Jsou na sobě naskládané hned u cesty, dřevorubci si museli máknou, včera byla hromada poloviční",false,false);
        Item stump = new Item("parez","na čerstvých pařezech sedí místní dřevorubci a dávají si pauzu na svačinu",false,false);
        Item tree = new Item("strom","v hlubokém lese se takových stromů nachází tisíce, tento se od ostatních v ničem neliší",false,false);
        Item sign = new Item("cedule","Jindřich sice není schopen číst, ale obrázek lebky, která se na ceduli nacházela byl schopen identifokovat",false,false);
        Item stone_well = new Item("studna","velmi stará kamenná studna, zdá se ti, že z ní slyšíš zvuky, zní to jako pláč, když se přiblížíš, zjištíš ze je ze zhora zakrytý a zamčené na zámek",false,true);
        Item chest= new Item("truhlicka","taková větší dřevěná truhlička na stole",false,true);
        Item caldron= new Item("kotel","veliký a kovový, ještě bublá, nejspiš v něm vaří svoje lektvary",false,false);
        Item key= new Item("klic","mlaý klíček, vypadá jako, že by mohl pasovat do té truhly na stole",true,false);
        
        Person wife= new Person("manzelka", "Je to tvoje žena.",true,"Tak dělej jdi už! Zítra už bude možná pozdě. A hlavně si s sebou vem něco, čím se proti té čarodějnici budeš bránit, kdyby to bylo třeba.");
        Person woodcutter=new Person("drevorubec","Z blízkého města, třeba ti poradí kudy se vydat",true,"Co říkáš? Že tvojí dceru unesla čarodějnice? No ve vesnici kolujdou hvěsti že v lesích opravdu žije čarodějnice,"+
        "ale někde hluboko za bažinou, tak by normálního člověka nikdy nenapadlo jít, je to tam hrozně o hubu.... Jeden špatnej krok a bažina tě pohltí, zkus se tu po něčem porozhlídnout, co by ti mohlo pomoct. No nic, tak hodně štěstí, snad tu svojí dceru najdeš");
        Person bagger= new Person("tulak","Starý tulák spí na zemi pod cedulí, asi ho nemá cenu budit",false,"");
        Person witch= new Person("carodejnice","Stará ošklivá baba, naštěstí jsi přišel, zrovna když spí, asi bude nejlepší, když to tak i zůstane",true,"Čarodějnice se rázem vzbudila a než stihnul Jinda cokoliv udělat, čarodějnice spustila zaklínadlo:"+
        "khandar estrada khandar thrus indactu nosfrandus khandar dematos khandar");
        
        
        
        house.addItem(bed);
        house.addItem(twigs);
        house.addItem(table);
        house.addItem(chairs);
        house.addPerson(wife);
        garden.addItem(hunk);
        garden.addItem(axe);
        garden.addItem(pig);
        garden.addItem(egg);
        glade.addItem(mushrooms);
        glade.addItem(logs);
        glade.addItem(stump);
        glade.addPerson(woodcutter);
        forest.addItem(tree);
        forest.addItem(sign);
        forest.addPerson(bagger);
        well.addItem(stone_well);
        lodge.addItem(chest);
        lodge.addItem(caldron);
        lodge.addItem(key);
        lodge.addPerson(witch);
        inventory=new Inventory();
    }
    
    /**
     * Metoda vrací odkaz na inventář.
     * 
     * @return aktuální lokace
     */
    public Inventory getInventory() {
        return this.inventory;
    }
    
    /**
     * Metoda vrací odkaz na aktuální lokaci, ve které se hráč právě nachází.
     *
     * @return aktuální lokace
     */
    public Area getCurrentArea()
    {
        return currentArea;
    }

    /**
     * Metoda nastaví aktuální lokaci. Používá ji příkaz {@link ActionMove}
     * při přechodu mezi lokacemi.
     *
     * @param currentArea lokace, která bude nastavena jako aktuální
     */
    public void setCurrentArea(Area currentArea)
    {
        this.currentArea = currentArea;
    }

    /**
     * Metoda vrací aktuální stav hry <i>(běžící hra, výhra, prohra)</i>.
     *
     * @return aktuální stav hry
     */
    public GameState getGameState(int param)
    {
        
        if (param==1) {
            return GameState.WON;
        }

        else if (param==2) {
            return GameState.LOST;
        }

        return GameState.PLAYING;
    }
    
    /***
     * metoda vracejici vyhru
     * 
     * @return vrací výhru
     */
    public GameState getWin(){
        return GameState.WON;
    }
       
}
