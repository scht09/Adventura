package test;

import game.*;

/**
 * Třída implementující kontrolu odpovědi hry po vykonání příkazu.
 *
 * @author Jan Říha
 * @version LS-2021, 2021-05-10
 */
public class ActionResultChecker implements IChecker
{
    @Override
    public CheckResult check(Step step, Game game, String actionResult)
    {
        String message = "Odpověď    : " + actionResult
                + "\n.................................................."
                + "\nVýsledek   : ";

        if (step.getMessage() == null) {
            return new CheckResult(true, message + "(nekontroluje se)");
        }

        if (actionResult.toLowerCase().contains(step.getMessage().toLowerCase())) {
            return new CheckResult(true, message + "OK");
        }

        return new CheckResult(false, message + "CHYBA, test očekává:\n" + step.getMessage());
    }
}
