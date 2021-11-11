package test;

import java.util.*;

/**
 * Třída obsahující statickou množinu s testovacími scénáři pro tuto hru.
 *
 * @author Jan Říha, Tomáš Schenk
 * @version LS-2021, 2021-06-13
 */
public class Scenarios
{
    /**
     * Soukromý konstruktor. Zajistí, že nebude možné vytvářet instance této třídy.
     */
    private Scenarios()
    {
    }

    /** Množina testovacích scénářů. */
    public static final Set<Scenario> SCENARIOS = new HashSet<>(Arrays.asList(
    
                new Scenario("PROHRA_SMRT_V_BAŽINĚ")
                    .addStep(new Step()
                            .setAction("jdi zahrada")
                            .setMessage("v lokaci 'zahrada'")
                            .setArea("zahrada")
                            .setExits("domek", "mytina"))
                    .addStep(new Step()
                            .setAction("jdi mytina")
                            .setMessage("v lokaci 'mytina'")
                            .setArea("mytina")
                            .setExits("zahrada","les"))
                    .addStep(new Step()
                            .setAction("jdi les")
                            .setMessage("v lokaci 'les'")
                            .setArea("les")
                            .setExits("bazina","studna","mytina"))
                    .addStep(new Step()
                            .setAction("jdi bazina")
                            .setMessage("Vstoupil jsi do bažiny a brzy jsi se začal bořit, za chvíli jsi se do bažiny uplně propadl a utopil se")
                            .setArea("les")
                            .setExits("bazina, mytina, studna")),
                            

                new Scenario("PROHRA_SMRT_NA_ČARODĚJNICI")
                    .addStep(new Step()
                            .setAction("jdi zahrada")
                            .setMessage("v lokaci 'zahrada'")
                            .setArea("zahrada")
                            .setExits("domek", "mytina"))
                    .addStep(new Step()
                            .setAction("jdi mytina")
                            .setMessage("v lokaci 'mytina'")
                            .setArea("mytina")
                            .setExits("zahrada","les"))
                    .addStep(new Step()
                            .setAction("mluv_s drevorubec")
                            .setMessage("Co říkáš? Že tvojí dceru unesla čarodějnice? No ve vesnici kolujdou hvěsti že v lesích opravdu žije čarodějnice,"+
        "ale někde hluboko za bažinou, tak by normálního člověka nikdy nenapadlo jít, je to tam hrozně o hubu.... Jeden špatnej krok a bažina tě pohltí, zkus se tu po něčem porozhlídnout, co by ti mohlo pomoct. No nic, tak hodně štěstí, snad tu svojí dceru najdeš")
                            .setArea("mytina")
                            .setExits("zahrada","les"))
                    .addStep(new Step()
                            .setAction("seber hul")
                            .setMessage("Sebral(a) jsi předmět 'hul' a uložil(a) ho do inventáře.")
                            .setArea("mytina")
                            .setExits("zahrada", "les"))
                    .addStep(new Step()
                            .setAction("jdi les")
                            .setMessage("v lokaci 'les'")
                            .setArea("les")
                            .setExits("bazina","studna","mytina"))
                    .addStep(new Step()
                            .setAction("jdi bazina")
                            .setArea("bazina")
                            .setExits("les","chatrc"))
                    .addStep(new Step()
                            .setAction("jdi chatrc")
                            .setArea("chatrc")
                            .setExits("bazina"))
                    .addStep(new Step()
                            .setAction("seber klic")
                            .setMessage("Čarodějnice se rázem vzbudila a než stihnul Jinda cokoliv udělat, čarodějnice spustila zaklínadlo:"+
                                        "khandar estrada khandar thrus indactu nosfrandus khandar dematos khandar")
                            .setArea("chatrc")
                            .setExits("bazina")),
                            
                new Scenario("VÝHRA")
                    .addStep(new Step()
                            .setAction("jdi zahrada")
                            .setMessage("v lokaci 'zahrada'")
                            .setArea("zahrada")
                            .setExits("domek", "mytina"))
                     .addStep(new Step()
                            .setAction("seber sekera")
                            .setMessage("Sebral(a) jsi předmět 'sekera' a uložil(a) ho do inventáře.")
                            .setArea("zahrada")
                            .setExits("domek", "mytina"))
                    .addStep(new Step()
                            .setAction("jdi mytina")
                            .setMessage("v lokaci 'mytina'")
                            .setArea("mytina")
                            .setExits("zahrada","les"))
                    .addStep(new Step()
                            .setAction("mluv_s drevorubec")
                            .setMessage("Co říkáš? Že tvojí dceru unesla čarodějnice? No ve vesnici kolujdou hvěsti že v lesích opravdu žije čarodějnice,"+
        "ale někde hluboko za bažinou, tak by normálního člověka nikdy nenapadlo jít, je to tam hrozně o hubu.... Jeden špatnej krok a bažina tě pohltí, zkus se tu po něčem porozhlídnout, co by ti mohlo pomoct. No nic, tak hodně štěstí, snad tu svojí dceru najdeš")
                            .setArea("mytina")
                            .setExits("zahrada","les"))
                    .addStep(new Step()
                            .setAction("seber hul")
                            .setMessage("Sebral(a) jsi předmět 'hul' a uložil(a) ho do inventáře.")
                            .setArea("mytina")
                            .setExits("zahrada", "les"))
                    .addStep(new Step()
                            .setAction("jdi les")
                            .setMessage("v lokaci 'les'")
                            .setArea("les")
                            .setExits("bazina","studna","mytina"))
                    .addStep(new Step()
                            .setAction("jdi bazina")
                            .setArea("bazina")
                            .setExits("les","chatrc"))
                    .addStep(new Step()
                            .setAction("jdi chatrc")
                            .setArea("chatrc")
                            .setExits("bazina"))
                    .addStep(new Step()
                            .setAction("seber klic")
                            .setMessage("Všiml jsi si, že se čarodějnice probouzí, tak jsi neváhal a jednou ranou jsi jí sekerou setnul hlavu a sebral(a) jsi 'klic' a uložil(a) ho do inventáře. Topůrko ti zůstalo v ruce, ale násada zůstala v čarodějnici. Je rozbitá.")
                            .setArea("chatrc")
                            .setExits("bazina"))
                    .addStep(new Step()
                            .setAction("odemkni truhlicka")
                            .setMessage("Odemkl(a) jsi 'truhlicka' a sebral jsi 'veleklic' který se tam nacházel")
                            .setArea("chatrc")
                            .setExits("bazina"))
                    .addStep(new Step()
                            .setAction("jdi bazina")
                            .setArea("bazina")
                            .setExits("les","chatrc"))
                     .addStep(new Step()
                            .setAction("jdi les")
                            .setMessage("v lokaci 'les'")
                            .setArea("les")
                            .setExits("bazina","studna","mytina"))
                     .addStep(new Step()
                            .setAction("jdi studna")
                            .setMessage("v lokaci 'studna'")
                            .setArea("studna")
                            .setExits("les"))
                     .addStep(new Step()
                            .setAction("odemkni studna")
                            .setMessage("")
                            .setArea("studna")
                            .setExits("les")),


            new Scenario("PRAZDNY_SCENAR")
    ));
}
