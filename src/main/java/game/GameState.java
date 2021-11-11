package game;

/**
 * Enumerace představuje možné stavy hry <i>(běžící hra, výhra, prohra apod.)</i>.
 *
 * @author Jan Říha
 * @version LS-2021, 2021-05-10
 */
public enum GameState
{
    /** Hra stále běží. */
    PLAYING,

    /** Hráč vyhrál. */
    WON,

    /** Hráč prohrál. */
    LOST;
}
