import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
/**
 * Classe Room - un lieu du jeu d'aventure Anthevia.
 *
 * Une Room est un lieu dans le jeu.
 * Chaque pièce a une description, une image et des sorties vers d'autres pièces.
 *
 * @author CLEMENT RUAN
 * @version 17/12/2025
 */
public class Room
{
    /**
     * Description de la pièce
     */
    private String aRoomDescription;
    /**
     * HashMap des différentes sorties des pièces
     */
    private HashMap<String, Room> aExits;
    /**
     * HashMap des différentes portes
     */
    private HashMap<String, Door> aDoors;
    /**
     * Liste des items disponible dans la pièce
     */
    private ItemList aItems;
    /**
     * Nom des images des différentes sorties des pièces
     */
    private String aImageName;
    
    /**
     *  Créer la description de la pièce et initialise la HashMap pour 
     *  les sorties
     *  
     *  @param pRoomDescription La description de la pièce
     *  @param pImageName L'image de la pièce
     */
    public Room(final String pRoomDescription, final String pImageName)
    {
        this.aRoomDescription = pRoomDescription;
        this.aImageName = pImageName;
        this.aExits = new HashMap<String, Room>();
        this.aDoors = new HashMap<String, Door>();
        this.aItems = new ItemList();
    } // Room()
    
    /**
     * Retourne le nom du fichier de l'image de la pièce actuelle.
     * 
     * @return Le nom du fichier de l'image
     */
    public String getImageName()
    {
        return this.aImageName;
    } // getImageName()
    
    /**
     * Retourne la description de la pièce actuelle.
     * 
     * @return La description de la pièce actuelle
     */
    public String getRoomDescription()
    {
        return this.aRoomDescription;
    } // getRoomDescription()
    
    /**
     * Definis les sorties possibles de la pièce actuelle. Chaque direction
     * dirige vers une autre pièce ou amène nulle part.
     * 
     * @param pDirection Direction de la sortie
     * @param pNeighbor Pièce voisine vers cette direction
     */
    public void setExit(final String pDirection, final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    } // setExits()

    /**
     * Retourne la pièce choisie en allant vers la direction choisie.
     * S'il n'y a pas de sortie vers cette direction, cela retourne null.
     * 
     * @param pDirection Direction vers où on veut aller
     * @return La pièce de la direction choisie ou null s'il n'y en a pas.
     */
    public Room getExit(final String pDirection)
    {
        return this.aExits.get(pDirection);
    } // getExit()
    
    /**
     * Retourne la description des sorties de la pièce actuelle.
     * Retourne aussi toutes les directions possibles.
     * Utilisation de StringBuilder
     * @return Les sorties possibles
     */
    public String getExitString()
    {
        // String returnString = "Exits:";
        // Set<String> keys = this.exits.keySet();
        // for (String exit : keys) {
            // returnString += " " + exit; // Crée une nouvelle string
        // }
        
        // return returnString;
        
        // Avec StringBuilder :
        
        StringBuilder returnString = new StringBuilder("Exits:");
        Set<String> vKeys = this.aExits.keySet();
        for (String vExit : vKeys) {
            returnString.append(" ").append(vExit);
        }
        return returnString.toString();
    } // getExitString()
    
    /**
     * Retourne une longue description de la pièce, sous cette forme :
     *      Your are in the kichen.
     *      Exits : north west
     * @return Une description de la pièce, incluant les sorties
     */
    public String getLongDescription()
    {
        return "You are " + this.aRoomDescription + ".\n" + 
        this.getExitString() + "\n" + this.getItemString();
    } // getLongDescription()
    
    /**
     * Attribue un Item à cette pièce
     * 
     * @param pItem L'item dans la pièce
     */
    public void setItem( final Item pItem )
    {
        this.aItems.setItem(pItem);
    } // setItem()
    
    /**
     * Retire un item de la pièce actuelle
     * 
     * @param pItem L'item à retirer
     * @return L'item retiré, ou null s'il n'y en a pas
     */
    public Item removeItem( final Item pItem )
    {
        return this.aItems.removeItem(pItem);
    } // removeItem()
    
    /**
     * Retourne l'Item de la pièce courante
     * 
     * @param pName Le nom de l'item
     * @return L'item de la pièce, ou null s'il n'y en a pas
     */
    public Item getItem( final String pName )
    {
        return this.aItems.getItem(pName);
    } // getItem()
    
    /**
     * Retourne tous les items de la pièce courante
     * 
     * @return Tous les items de la pièce courante
     */
    public Collection<Item> getItems()
    {
        return this.aItems.getItems();
    } // getItems()
    
    /**
     * Retourne une description des items de la pièce courante
     * 
     * @return La description des items, s'il n'y en a pas alors retourne 
     * une String
     */
    private String getItemString()
    {
        return this.aItems.getItemListDescription();
    } // getItemString()
    
    /**
     * Vérifie si la pièce donnée est une sortie accessible depuis cette pièce
     * 
     * @param pRoom La pièce à vérifier
     * @return true si pRoom est accessible, sinon false
     */
    public boolean isExit( final Room pRoom )
    {
        for ( Room vExit : this.aExits.values() )
        {
            if (vExit == pRoom)
            {
                return true;
            }
        }
        return false;
    } // isExit()
    
    /**
     * Ajoute une porte dans une direction
     * 
     * @param pDirection La direction
     * @param pDoor la porte
     */
    public void setDoor( final String pDirection, final Door pDoor )
    {
        this.aDoors.put(pDirection, pDoor);
    } // setDoor()
    
    /**
     * Retourne la direction de la porte
     * 
     * @param pDirection La direction
     * @return La porte
     */
    public Door getDoor( final String pDirection )
    {
        return this.aDoors.get(pDirection);
    } // getDoor()
    
    /**
     * Vérifie si le joueur passe par une TrapDoor
     * 
     * @return true s'il y'a une TrapDoor, false sinon
     */
    public boolean isTrapDoor()
    {
        return this.aRoomDescription.contains("trapdoor");
    } // isTrapDoor()
} // Room()

