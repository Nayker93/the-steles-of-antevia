import java.util.Stack;

/**
 * Classe RoomHistory - Gère l'historique des pièces empruntées par le joueur
 * 
 * Gère le retour aux salles précédentes
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class RoomHistory
{
    /**
     * L'historique des pièces
     */
    private Stack<Room> aPreviousRooms;
    
    /**
     * Crée l'historique du joueur
     */
    public RoomHistory()
    {
        this.aPreviousRooms = new Stack<>();
    } // RoomHistory()
    
    /**
     * Stocke la pièce actuelle du joueur
     * 
     * @param pCurrentRoom La pièce actuelle du joueur
     */
    public void storeRoom( final Room pCurrentRoom )
    {
        if (pCurrentRoom != null)
        {
            this.aPreviousRooms.push(pCurrentRoom);
        }
    } // storeRoom()
    
    /**
     * Vérifie s'il y'a une pièce précédente
     * 
     * @return true s'il y'en a une, false sinon
     */
    public boolean canGoBack()
    {
        return !this.aPreviousRooms.isEmpty();
    } // canGoBack()
    
    /**
     * Retourne la pièce précédente (en la supprimant)
     * 
     * @return La pièce précédente
     */
    public Room goBack()
    {
        if (this.aPreviousRooms.isEmpty())
        {
            return null;
        }
        return this.aPreviousRooms.pop();
    } // goBack()
    
    /**
     * Retourne la pièce précédente (sans la supprimer)
     * 
     * @return La pièce précédente
     */
    public Room getPreviousRoom()
    {
        if (this.aPreviousRooms.isEmpty())
        {
            return null;
        }
        return this.aPreviousRooms.peek();
    } // getPreviousRoom()
} // RoomHistory

