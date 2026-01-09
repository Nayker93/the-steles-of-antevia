/**
 * Classe Beamer - Téléporteur pour le jeu d'aventure
 * 
 * Un Beamer est un objet spécial qui :
 * - Peut être ramassé et transporté comme un Item
 * - Peut être "chargé" pour mémoriser une pièce
 * - Peut être "déclenché" pour téléporter le joueur vers la pièce mémorisée
 * - Ne peut être utilisé qu'une seule fois (option recommandée)
 * 
 * Conçu selon les principes:
 * - Beamer hérite de Item (c'est un objet du jeu)
 * - La pièce mémorisée est stockée DANS le Beamer (pas dans le Player)
 * - Permet plusieurs Beamers dans le jeu (meilleure conception)
 * 
 * @author Clément RUAN
 * @version 06/01/2026
 */
public class Beamer extends Item
{
    /**
     * Pièce mémorisée par le Beamer
     * null = pas de pièce chargée
     */
    private Room aChargedRoom;
    
    /**
     * Indicateur si le Beamer a déjà été utilisé
     * false = peut être utilisé
     * true = déjà utilisé, à ne pas réutiliser
     */
    private boolean aAlreadyFired;
    
    /**
     * Crée un nouveau Beamer
     * 
     * @param pName Nom du Beamer (ex: "beamer", "teleporter")
     * @param pWeight Poids du Beamer en kg (ex: 0.5)
     * @param pPrice Prix du Beamer en Jerries (ex: 50)
     */
    public Beamer(final String pName, final double pWeight, final double pPrice)
    {
        super(pName, "A mysterious beamer device", pWeight, pPrice);
        this.aChargedRoom = null;      // Pas encore chargé
        this.aAlreadyFired = false;    // Pas encore utilisé
    } // Beamer()
    
    /**
     * Charge le Beamer avec la pièce donnée en paramètre
     * 
     * @param pRoom La pièce à mémoriser
     * @return Message de confirmation
     */
    public String chargeBeamer(final Room pRoom)
    {
        // Cas déjà utilisé
        if (this.aAlreadyFired)
        {
            return "This beamer has already been fired. It's now useless.";
        }
        
        if (pRoom == null)
        {
            return "Error: no room to charge.";
        }
        
        this.aChargedRoom = pRoom;
        return "The beamer is charged with this room.";
    } // chargeBeamer()
    
    /**
     * Déclenche le Beamer pour téléporter le joueur
     * 
     * @return La pièce destination, ou null si pas chargé ou déjà utilisé
     */
    public Room fireBeamer()
    {
        // Si déjà utilisé
        if (this.aAlreadyFired)
        {
            return null;
        }
        
        // Si pas chargé
        if (this.aChargedRoom == null)
        {
            return null;
        }
        
        // Marquer comme utilisé et retourner la pièce
        this.aAlreadyFired = true;
        return this.aChargedRoom;
    } // fireBeamer()
    
    /**
     * Vérifie si le Beamer a une pièce chargée
     * 
     * @return true si une pièce est chargée, false sinon
     */
    public boolean hasChargedRoom()
    {
        return this.aChargedRoom != null;
    } // hasChargedRoom()
    
    /**\n     * Vérifie si le Beamer a déjà été utilisé\n     * \n     * @return true si déjà utilisé, false sinon\n     */\n    public boolean hasAlreadyFired()\n    {\n        return this.aAlreadyFired;\n    } // hasAlreadyFired()\n    \n    /**\n     * Retourne la pièce chargée dans le Beamer (info)\n     * \n     * @return La pièce chargée ou null\n     */\n    public Room getChargedRoom()\n    {\n        return this.aChargedRoom;\n    } // getChargedRoom()\n} // Beamer