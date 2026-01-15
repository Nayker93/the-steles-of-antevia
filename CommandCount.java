
/**
 * Classe CommandCount - Gère le compteur de commandes
 * 
 * Compte les commandes et vérifie combien il en reste
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class CommandCount
{
    /**
     * Nombre de commandes utilisable par le joueur
     */
    private static final int COMMAND_LIMIT = 100;
    /**
     * Le compteur de commandes
     */
    private int aCommandCount;
    /**
     * Vérification de la limite du joueur
     */
    private boolean aTimeLimitReached;
    
    /**
     * Crée un compteur
     */
    public CommandCount()
    {
        this.aCommandCount = 0;
        this.aTimeLimitReached = false;
    } // CommandCount()
    
    /**
     * Incrémente le compteur
     */
    public void increaseCommandCount()
    {
        this.aCommandCount++;
    } // increaseCommandCount()
    
    /**
     * Retourne le nombre de commandes utilisées
     * 
     * @return Le nombre de commandes
     */
    public int getCommandCount() 
    {
        return this.aCommandCount;
    } // getCommandCount()
    
    /**
     * Retourne la limite de commandes
     * 
     * @return La limite de commandes
     */
    public static int getCommandLimit() {
        return COMMAND_LIMIT;
    } // getCommandLimit() 
    
    /**
     * Vérifie si la limite a été atteinte
     * 
     * @return true si atteinte
     */
    public boolean isTimeLimitReached() {
        return this.aCommandCount >= COMMAND_LIMIT;
    } // isTimeLimitReached()
    
    /**
     * Marque que la limite est atteinte
     */
    public void setTimeLimitReached() {
        this.aCommandCount = COMMAND_LIMIT;
    } // setTimeLimitReached()
} // CommandCount