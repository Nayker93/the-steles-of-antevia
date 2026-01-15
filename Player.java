import java.util.Collection;


/**
 * Classe Player - Le/Les joueurs du jeu
 * Cette classe stocke les champs et définis les méthodes qui vérifie notamment 
 * la contrainte de poids, les objets que le joueur possède ou encore sa pièce courante.
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class Player
{
    /**
     * Nom du joueur
     */
    private String aName;
    /**
     * Pièce courante du joueur
     */
    private Room aCurrentRoom;
    /**
     * Inventaire du joueur
     */
    private Inventory aInventory;
    /**
     * Historique des pièces du joueur
     */
    private RoomHistory aRoomHistory;
    /**
     * Nombre de commandes utilisées par le joueur
     */
    private CommandCount aCommandCount;
    
    /**
     * Crée un nouveau joueur avec son nom
     * 
     * @param pName Nom du joueur
     */
    public Player( final String pName )
    {
        this.aName = pName;
        this.aCurrentRoom = null; // Initialisé dans GameEngine
        this.aInventory = new Inventory();
        this.aRoomHistory = new RoomHistory();
        this.aCommandCount = new CommandCount();
    } // Player()

    /**
     * Retourne le nom du joueur
     * 
     * @return Le nom du joueur
     */
    public String getName()
    {
        return this.aName;
    } // getName()

    /**
     * Retourne la pièce courante du joueur
     * 
     * @return La pièce courante du joueur
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    } // getCurrentRoom()

    /**
     * Définit la pièce courante du joueur.
     * 
     * @param pRoom La pièce
     */
    public void setCurrentRoom(final Room pRoom)
    {
        this.aCurrentRoom = pRoom;
    } // setCurrentRoom()

    /**
     * Déplace le joueur dans une pièce et l'ajoute dans l'historique
     * 
     * @param pRoom Pièce de destination
     */
    public void goToRoom( final Room pRoom )
    {
        if (pRoom == null) 
        {
            return;
        }

        if (this.aCurrentRoom != null)
        {
            this.aRoomHistory.storeRoom(this.aCurrentRoom);
        }

        this.aCurrentRoom = pRoom;
    } // goToRoom()

    /**
     * Vérifie s'il y a une pièce précédente dans la stack.
     * 
     * @return true s'il y a une pièce précédente, false sinon
     */
    public boolean canGoBack()
    {
        return this.aRoomHistory.canGoBack();
    } // canGoBack()

    /**
     * Le joueur revient à la pièce précédente.
     */
    public void goBack()
    {
        Room vPreviousRoom = this.aRoomHistory.goBack();
        if (vPreviousRoom != null)
        {
            this.aCurrentRoom = vPreviousRoom;
        }
    } // goBack()

    /**
     * Retourne la pièce précédente
     * 
     * @return La pièce précédente
     */
    public Room getPreviousRoom()
    {
        return this.aRoomHistory.getPreviousRoom();
    } // getPreviousRoom()
    
    /**
     * Le joueur récupère un item dans la pièce actuelle s'il a 
     * le poids disponible et si l'item n'est pas trop lourd
     * 
     * @param pItemName Nom de l'item
     * @return Message du résultat de la récupération de l'item
     */
    public String takeItem( final String pItemName )
    {
        // Si l'item n'existe pas
        if (pItemName == null || pItemName.isEmpty())
        {
            return "Take what ?";
        }

        Room vCurrentRoom = this.aCurrentRoom;
        Item vItem = this.aCurrentRoom.getItem(pItemName);

        // Si l'item existe dans la pièce ou pas
        if (vItem == null)
        {
            return "You can't find what you're looking for...";
        }

        if (!(this.aInventory.addItem(vItem)))
        {
            return "You can't carry that.";
        }
        
        // L'item est récupéré
        vCurrentRoom.removeItem(vItem);
        return "You picked up the " + pItemName + ".";
    } // takeItem()

    /**
     * Le joueur dépose un item dans la pièce actuelle
     * 
     * @param pItemName Nom de l'item
     * @return Message du résultat du dépôt de l'item
     */
    public String dropItem( final String pItemName )
    {
        // Si l'item n'existe pas
        if (pItemName == null || pItemName.isEmpty())
        {
            return "Drop what ?";
        }

        Item vItem = this.aInventory.removeItem(pItemName);

        // Si le joueur possède l'item ou pas
        if (vItem == null)
        {
            return "You don't have that item !";
        }

        // L'item est laché
        if (this.aCurrentRoom != null)
        {
            this.aCurrentRoom.setItem(vItem);
        }
        return "You dropped the " + pItemName + ".";
    } // dropItem()

    /**
     * Retourne la liste des items que possède le joueur
     * 
     * @return les items du joueur
     */
    public String getItemsPlayer()
    {
        if (this.aInventory.getItems().isEmpty())
        {
            return "You don't have any items.";
        }
        return this.aInventory.getInventoryDescription();
    } // getItemsPlayer()
    
    /**
     * Retourne un item de l'inventaire du joueur avec son nom
     * 
     * @param pItemName Nom de l'item
     * @return L'item de l'inventaire ou null s'il n'est pas trouvé
     */
    public Item getItemByName( final String pItemName )
    {
        return this.aInventory.getItem(pItemName);
    } // getItemName()
    
    /**
     * Retourne tous les items de l'inventaire du joueur
     * 
     * @return L'inventaire du joueur
     */
    public Collection<Item> getInventory()
    {
        return this.aInventory.getItems();
    } // getInventory()
    
    /**
     * Retourne le compteur de commandes
     * 
     * @return Le compteur de commandes
     */
    public int getCommandCount()
    {
        return this.aCommandCount.getCommandCount();
    } // getCommandCount()
    
    /**
     * Retourne le nombre de commandes utilisables
     * 
     * @return Le nombre de commandes utilisables
     */
    public static int getCommandLimit()
    {
        return CommandCount.getCommandLimit();
    } // getCommandLimit()
    
    /**
     * Incrémente le nombre de commandes utilisées
     */
    public void increaseCommandCount() 
    {
        this.aCommandCount.increaseCommandCount();
    } // increaseCommandCount() 
    
    /**
     * Vérifie si le compteur a atteint la limite de commandes utilisable
     * 
     * @return true si atteint, false sinon
     */
    public boolean isTimeLimitReached() 
    {
        return this.aCommandCount.isTimeLimitReached();
    } // isTimeLimitReached()
    
    /**
     * Augmente le poids porté par le joueur
     * 
     * @param pIncrease Le poids augmenté
     */
    public void increaseMaxWeight(final double pIncrease)
    {
        this.aInventory.increaseMaxWeight(pIncrease);
    } // increaseMaxWeight()
    
    /**
     * Retourne le poids max de l'item que le joueur peut prendre
     * 
     * @return Le poids max de l'item que le joueur peut prendre
     */
    public double getMaxWeight()
    {
        return this.aInventory.getMaxWeight();
    } // getMaxWeight()
} // Player

