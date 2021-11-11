package test;

import game.*;
import java.util.*;

/**
 * Třída obsahuje logiku pro výpis a vyhodnocování testovacích scénářů.
 *
 * @author  Jan Říha
 * @version LS-2021, 2021-05-10
 */
public class Runner
{
    private List<IChecker> checkers;

    /**
     * Konstruktor třídy, vytvoří nový spouštěč testů a množinu prováděných kontrol.
     */
    public Runner()
    {
        checkers = new ArrayList<>();

        checkers.add(new ActionResultChecker());
        checkers.add(new CurrentAreaChecker());
        checkers.add(new CurrentAreaExitsChecker());
    }

    /**
     * Metoda vrátí výpis testovacích scénářů definovaných ve třídě {@link Scenarios}.
     *
     * @return výpis testovacích scénářů
     */
    public String showAllScenarios()
    {
        String result = "";

        for (Scenario s : Scenarios.SCENARIOS) {
            result += s.toString();
        }

        return result;
    }

    /**
     * Metoda spustí testovací scénáře definované ve třídě {@link Scenarios} a vrátí
     * podrobný výpis výsledků.
     *
     * @return podrobný výpis výsledků provedených testovacích scénářů
     */
    public String runAllScenarios()
    {
        String result = "";

        for (Scenario s : Scenarios.SCENARIOS) {
            result += run(s);
        }

        return result;
    }

    private String run(Scenario scenario)
    {
        if (scenario.getSteps().isEmpty()) {
            return "Scénář: " + scenario.getName()
                    + "\n##################################################"
                    + "\n(scénář neobsahuje žádné kroky)"
                    + "\n\n";
        }

        int i = 1;
        boolean success = true;
        Game game = new Game();
        String result = "Scénář: " + scenario.getName();

        for (Step step : scenario.getSteps()) {
            result += "\n##################################################"
                    + "\n" + i++ + ". " + step.getAction();

            String actionResult = null;
            try {
                actionResult = game.processAction(step.getAction());

                for (IChecker checker : checkers) {
                    CheckResult checkResult = checker.check(step, game, actionResult);

                    success &= checkResult.isSuccess();

                    result += "\n--------------------------------------------------"
                            + "\n" + checkResult.getMessage();
                }
            } catch (Exception e) {
                success = false;

                result += "\n--------------------------------------------------"
                        + "\nBěhem zpracovávání příkazu došlo k výjimce:"
                        + "\n" + e.getMessage();

                        throw e;
            }

            // Pokud dojde k chybě, nebudeme provádět zbývající kroky
            if (!success) {
                break;
            }
        }

        result += "\n##################################################";

        if (success) {
            result += "\n              SCÉNÁŘ PROBĚHL ÚSPĚŠNĚ.";
        } else {
            result += "\n         BĚHEM SCÉNÁŘE SE VYSKYTLY CHYBY.";
        }

        result += "\n##################################################"
                + "\n\n";

        return result;
    }
}
