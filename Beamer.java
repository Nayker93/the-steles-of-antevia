
/**
 * Classe Beamer - Item permettant au joueur de se téléporter
 * 
 * Le Beamer peut sauvegarder la pièce actuelle du joueur en chargeant la pièce
 * Il pourra ensuite être déclenché pour téléporter le joueur vers la pièce sauvegardé.
 * Il ne pourrra être utilisé que 3 fois maximum, il sera progressivement endommagé.
 * Si le joueur passe par une trap door alors le Beamer est endommager et ne peut plus être utilisé.
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class Beamer extends Item
{
    /**
     * Le nombre d'utilisations restantes du Beamer (jusqu'à 3 fois)
     */
    private int aUsesRemaining;
    /**
     * La pièce stockée par le Beamer
     */
    private Room aBeamerRoom;
    
    /**
     * Crée un Beamer vide
     */
    public Beamer()
    {
        super("beamer", "A device that can charge and fire to teleport", 1, 100);
        this.aBeamerRoom = null;
        this.aUsesRemaining = 3;
    } // Beamer()
    
    /**
     * Charge le Beamer
     * Stocke la pièce actuelle dans la perle de téléportation insérée
     * 
     * @param pCurrentRoom La pièce à sauvegarder
     * @return Message de confirmation
     */
    public String chargeBeamer( final Room pCurrentRoom )
    {
        // Vérifie si le Beamer est inutilisable
        if (this.aUsesRemaining <= 0)
        {
            return "The beamer is too damaged to function.";
        }
        
        if (pCurrentRoom == null)
        {
            return "Error: no current room.";
        }
        
        // Stockage de la pièce dans le Beamer
        this.aBeamerRoom = pCurrentRoom;
        
        // Condition du Beamer
        String vCondition = this.getBeamerCondition();
        
        return "The beamer stores this room ! " + vCondition;
    } // chargeBeamer()
    
    /**
     * Déclenche le Beamer et téléporte le joueur dans la pièce stockée par le Beamer
     * Réduit le nombre d'utilisation du Beamer de 1
     * 
     * @return La pièce stockée
     */
    public Room fireBeamer()
    {
        // Vérifie si le Beamer est encore utilisable
        if (this.aUsesRemaining <= 0)
        {
            return null;
        }
        
        // Vérifie s'il y'a une pièce stockée dans le Beamer
        if (this.aBeamerRoom == null)
        {
            return null;
        }
        
        this.aUsesRemaining--;
        return this.aBeamerRoom;
    } // fireBeamer()
    
    /**
     * Retourne la pièce stockée par le Beamer
     * 
     * @return La pièce stockée par le Beamer
     */
    public Room getBeamerRoom()
    {
        return this.aBeamerRoom;
    } // getBeamerRoom()
    
    /**
     * Détruit le Beamer si le joueur passe par une TrapDoor
     */
    public void destroyBeamer()
    {
        if (this.aUsesRemaining > 0)
        {
            this.aUsesRemaining = 0;
        }
    } // destroyBeamer()
    
    /**
     * Vérifie si Beamer est inutilisable
     * 
     * @return true si le Beamer est inutilisable, false sinon
     */
    public boolean isDamaged()
    {
        return this.aUsesRemaining <= 0;
    } // isDisintegrated()
    
    /**
     * Retourne le nombre d'utilisations d'un Beamer
     * 
     * @return le nombre d'utilisations d'un Beamer
     */
    public int getUsesRemaining()
    {
        return this.aUsesRemaining;
    } // getUsesRemaining()
    
    /**
     * L'état du Beamer
     * 
     * @return Description du Beamer
     */
    public String getBeamerCondition()
    {
        String vBeamerRoom = (this.aBeamerRoom != null) ? this.aBeamerRoom.getRoomDescription() : "none";
        
        if (this.aUsesRemaining == 3)
        {
            return "( Condition : perfect, " + this.aUsesRemaining + " uses remaining, Room : " + vBeamerRoom + " )";
        }
        else if (this.aUsesRemaining == 2)
        {
            return "( Condition : slightly worn, " + this.aUsesRemaining + " uses remaining, Room : " + vBeamerRoom + " )";
        }
        else if (this.aUsesRemaining == 1)
        {
            return "( Condition : heavily damaged, " + this.aUsesRemaining + " uses remaining, Room : " + vBeamerRoom + " )";
        }
        else
        {
            return "( Condition : unusable, " + this.aUsesRemaining + " uses remaining )";
        }
    } // getBeamerCondition()
}