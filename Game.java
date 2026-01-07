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
     * Le parser pour analyser les commandes saisies par le joueur
     */
    private Parser aParser;
    
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

