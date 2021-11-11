package start;

import game.Game;
import test.Runner;
import ui.TextUI;

/**
 * Spouštěcí třída aplikace.
 *
 * @author Jan Říha
 * @version LS-2021, 2021-05-10
 */
public class Start
{
    /**
     * Spouštěcí metoda aplikace. Vyhodnotí parametry, se kterými byla aplikace
     * spuštěna, a na základě nich rozhodne, jakou operaci provede (hra, výpis
     * testovacích scénářů, spuštění testovacích scénářů).
     * Pokud byla aplikace spuštěna s nepodporovanými parametry, vypíše nápovědu
     * a skončí.
     *
     * param args parametry aplikace z příkazové řádky
     */
    public static void main(String[] args)
    {
        if (args.length < 1) {
            Game game = new Game();
            TextUI ui = new TextUI(game);

            ui.play();
        } else if (args.length == 1 && args[0].equalsIgnoreCase("SHOW_SCENARIOS")) {
            Runner runner = new Runner();

            System.out.println(runner.showAllScenarios());
        } else if (args.length == 1 && args[0].equalsIgnoreCase("RUN_SCENARIOS")) {
            Runner runner = new Runner();

            System.out.println(runner.runAllScenarios());
        } else {
            System.out.println("Hra byla spuštěna s nepodporovanými parametry!");

            System.out.println("\nAplikaci je možné spustit s následujícími parametry:");
            System.out.println("  <bez parametrů>     : Spustí hru");
            System.out.println("  SHOW_SCENARIOS      : Vypíše kroky testovacích scénářů");
            System.out.println("  RUN_SCENARIOS       : Provede testy testovacích scénářů");
        }
    }
}
