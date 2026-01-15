 /**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * Cette classe crée une instance de GameEngine et de UserInterface puis les
 * connecte ensemble, le jeu s'exécute ensuite par événements GUI, sans 
 * l'affichage de la console.
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class Game
{
    /**
     * Lancement du jeu.
     * 
     * @param pArgs Arguments de la ligne de commande (non utilisés)
     */
    public static void main(final String[] pArgs)
    {
        new Game();
    } // main(final String[] pArgs)
    /**
     * Lance le jeu en créant GameEngine et UserInterface.
     */
    public Game()
    {
        GameEngine vEngine = new GameEngine();
        UserInterface vUI = new UserInterface(vEngine);
        vEngine.setGUI(vUI);
    } // Game()
} // Game

