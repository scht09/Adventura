package test;

import game.*;

/**
 * Třída implementující kontrolu aktuální lokace po vykonání příkazu.
 *
 * @author Jan Říha
 * @version LS-2021, 2021-05-10
 */
public class CurrentAreaChecker implements IChecker
{
    @Override
    public CheckResult check(Step step, Game game, String actionResult)
    {
        String message = "Lokace     : " + game.getWorld().getCurrentArea().getName() + "\nVýsledek   : ";

        if (step.getArea() == null) {
            return new CheckResult(true, message + "(nekontroluje se)");
        }

        if (game.getWorld().getCurrentArea().getName().equals(step.getArea())) {
            return new CheckResult(true, message + "OK");
        }

        return new CheckResult(false, message + "CHYBA, test očekává: " + step.getArea());
    }
}
