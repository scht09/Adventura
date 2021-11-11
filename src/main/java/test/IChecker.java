package test;

import game.Game;

/**
 * Rozhraní definující metody nutné pro implementaci kontroly kroku testovacího
 * scénáře. Pro každou kontrolu, která má být po vykonání kroku provedena, je
 * nutné vytvořit třídu obsahující logiku kontroly. Třída musí implementovat
 * metodu definovanou tímto rozhraním.
 *
 * @author Jan Říha
 * @version LS-2021, 2021-05-10
 */
public interface IChecker
{
    /**
     * Metoda zajišťující provedení dílčí kontroly po vykonání kroku testovacího
     * scénáře. Metoda má k dispozici data vykonaného kroku, zprávu, kterou by hra
     * vypsala hráči na konzoli a objekt reprezentující celou hru. Na základě těchto
     * vstupů provede kontrolu a vrátí informaci, zda je vše v pořádku, nebo zda se
     * hra odchýlila od požadovaného scénáře.
     *
     * @param step krok testovacího scénáře
     * @param game hra
     * @param actionResult výsledek zpracování, který by hra vypsala hráči na konzoli
     * @return objekt obsahující výsledek provedené kontroly
     */
    CheckResult check(Step step, Game game, String actionResult);
}
