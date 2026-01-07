 /**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * Cette classe crée une instance de GameEngine et de UserInterface puis les
 * connecte ensemble, le jeu s'exécute ensuite par événements GUI, sans 
 * l'affichage de la console.
 *
 * @author Clément RUAN
 * @version 17/12/2025
 */
public class Game
{
    /**
     * Pour lancer le jeu Anthevia depuis le terminal.
     *
     * @param pArgs Les arguments de la ligne de commande
     */
    public static void main(final String[] pArgs)
    {
        new Game();
    } // main()

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

