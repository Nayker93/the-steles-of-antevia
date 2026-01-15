
/**
 * Classe Door - Une porte entre deux pièces
 * 
 * Une porte peut être fermée ou ouverte. Dans le cas où elle est fermée, alors 
 * le joueur doit avoir la clé reliée à la porte pour la déverouiller.
 * Une porte peut se reverrouiller automatiquement après le passage du joueur.
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class Door
{
    /**
     * Indication pour savoir si la porte est ouverte
     */
    private boolean aIsUnlocked;
    /**
     * La clé reliée à la porte
     */
    private Item aKeyDoor;
    /**
     * Indication si la porte se reverrouille
     */
    private boolean aAutoLock;
    
    /**
     * Crée une porte fermée nécessitant une clé pour l'ouvrir
     * 
     * @param pKeyDoor La clé nécessaire
     * @param pAutoLock true si la porte se verrouille après le passage du joueur, false sinon
     */
    public Door( final Item pKeyDoor, final boolean pAutoLock)
    {
        this.aIsUnlocked = false;
        this.aKeyDoor = pKeyDoor;
        this.aAutoLock = pAutoLock;
    } // Door()
    
    /**
     * Vérifie si le joueur tente d'ouvrir une porte avec une clé
     * 
     * @param pKeyDoor La clé nécessaire
     * @return true si la porte est ouverte
     */
    public boolean tryUnlocking( final Item pKeyDoor )
    {
        // Si la porte est déjà déverrouiller
        if (this.aIsUnlocked)
        {
            return true;
        }
        
        // Si la porte n'est pas verrouillée
        if (this.aKeyDoor == null)
        {
            this.aIsUnlocked = true;
            return true;
        }
        
        // Si la porte est verouiller et le joueur utilise la bonne clé
        if (pKeyDoor != null && pKeyDoor.equals(this.aKeyDoor))
        {
            this.aIsUnlocked = true;
            return true;
        }
        
        return false;
    } // tryUnlocking()
    
    /**
     * Ferme la porte
     */
    public void closeDoor()
    {
        this.aIsUnlocked = false;
    } // closeDoor()
    
    /**
     * Vérifie si la porte est déverrouillée
     * 
     * @return true si déverrouillée
     */
    public boolean isUnlocked()
    {
        return this.aIsUnlocked;
    } // isUnlocked()
    
    /**
     * Vérifie si la porte est verrouillée
     * 
     * @return true si la porte est verrouillée, false sinon
     */
    public boolean isLocked()
    {
        return this.aKeyDoor != null;
    } // isLocked()
    
    /**
     * Vérifie si la porte se referme après passage du joueur
     * 
     * @return true si la porte se referme, false sinon
     */
    public boolean autoLock()
    {
        return this.aAutoLock;
    } // autoLock()
    
    /**
     * Retourne la clé nécessaire de la porte
     * 
     * @return La clé nécessaire
     */
    public Item getKeyDoor()
    {
        return this.aKeyDoor;
    } // getKeyDoor()
    
    /**
     * Description de la porte si elle est ouverte, fermée verrouillée ou fermée déverrouillée
     * 
     * @return l'état actuel de la porte
     */
    public String getDoorDescription()
    {
        if (this.aIsUnlocked)
        {
            return "The door is open.";
        }
        else if (this.isLocked())
        {
            return "The door is closed and locked.";
        }
        else
        {
            return "The door is closed.";
        }
    } // getDoorDescription()
} // Door


