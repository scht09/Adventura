package test;

import game.*;
import java.util.*;

/**
 * Třída implementující kontrolu sousedních lokací po vykonání příkazu.
 *
 * @author Jan Říha
 * @version LS-2021, 2021-05-10
 */
public class CurrentAreaExitsChecker implements IChecker
{
    @Override
    public CheckResult check(Step step, Game game, String actionResult)
    {
        Set<String> exitNames = new TreeSet<>();
        for (Area exit : game.getWorld().getCurrentArea().getExits()) {
            exitNames.add(exit.getName());
        }

        String message = "Východy    : " + String.join(", ", exitNames) + "\nVýsledek   : ";

        if (step.getExits() == null) {
            return new CheckResult(true, message + "(nekontroluje se)");
        }

        Set<String> expectedNames = new TreeSet<>(Arrays.asList(step.getExits()));

        if (exitNames.equals(expectedNames)) {
            return new CheckResult(true, message + "OK");
        }

        return new CheckResult(false, message + "CHYBA, test očekává: " + String.join(", ", expectedNames));
    }
}
