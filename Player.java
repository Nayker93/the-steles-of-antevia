import java.util.Stack;

/**
 * Classe Player - Le/Les joueurs du jeu
 * Cette classe stocke les champs et définis les méthodes qui vérifie notamment 
 * la contrainte de poids, les objets que le joueur possède ou encore sa pièce courante.
 *
 * @author Clément RUAN
 * @version 17/12/2025
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
     * Items du joueur
     */
    private ItemList aItems;
    /**
     * Poids max du joueur
     */
    private double aMaxWeight;
    /**
     * Poids actuelle du joueur
     */
    private double aCurrentWeight;
    /**
     * Prix max du joueur (budget max)
     */
    private double aMaxPrice;
    /**
     * Prix total actuel du joueur
     */
    private double aCurrentPrice;
    /**
     * Stack des pièces précédentes
     */
    private Stack<Room> aPreviousRooms;

    /**
     * Compteur de commandes utilisées
     */
    private int aCommandCount;
    /**
     * Limite de commandes disponible
     */
    private static final int COMMAND_LIMIT = 10;
    /**
     * Limite de commandes atteinte
     */
    private boolean aTimeLimitReached;
    
    /**
     * Crée un nouveau joueur avec son nom
     * 
     * @param pName Nom du joueur
     */
    public Player( final String pName )
    {
        this.aName = pName;
        this.aCurrentRoom = null; // Initialisé dans GameEngine
        this.aItems = new ItemList();
        this.aMaxWeight = 10.0; // Poids maximum que le joueur peut porté (en kg)
        this.aCurrentWeight = 0.0;
        this.aMaxPrice = 100.0; // Somme d'argent maximum que le joueur peut porté sur lui (100 Jerries)
        this.aCommandCount = 0; // Compteur de commandes utilisées
        this.aTimeLimitReached = false; // Si vrai alors le joueur perd
        this.aCurrentPrice = 0.0;
        this.aPreviousRooms = new Stack<>();
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
     * Retourne la pièce précédente du joueur
     * 
     * @return La pièce précédente du joueur
     */
    public Room getPreviousRoom()
    {
        if (this.aPreviousRooms.isEmpty())
        {
            return null;
        }
        return this.aPreviousRooms.peek();
    } // getPreviousRoom()
    
    /**
     * Retourne le poids maximum du joueur
     * 
     * @return Le poids maximum du joueur
     */
    public double getMaxWeight()
    {
        return this.aMaxWeight;
    } // getMaxWeight()

    /**
     * Retourne le poids actuel du joueur
     * 
     * @return Le poids actuel du joueur
     */
    public double getCurrentWeight()
    {
        return this.aCurrentWeight;
    } // getCurrentWeight()
    
    /**
     * Retourne le prix maximum du joueur
     * 
     * @return Le prix maximum du joueur en Jerry
     */
    public double getMaxPrice()
    {
        return this.aMaxPrice;
    } // getMaxPrice()

    /**
     * Retourne le budget actuel du joueur
     * 
     * @return Le budget actuel du joueur en Jerry
     */
    public double getCurrentPrice()
    {
        return this.aCurrentPrice;
    } // getCurrentPrice()

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
     * Le joueur se déplace dans une pièce spécifiée et sauvegarde
     * la pièce actuelle dans la stack.
     * 
     * @param pRoom Pièce de destination
     * @return true si le déplacement a réussi, false sinon
     */
    public boolean goToRoom(final Room pRoom)
    {
        if (pRoom == null) {
            return false;
        }

        if (this.aCurrentRoom != null)
        {
            this.aPreviousRooms.push(this.aCurrentRoom);
        }

        this.aCurrentRoom = pRoom;
        return true;
    } // goToRoom()

    /**
     * Vérifie s'il y a une pièce précédente dans la stack.
     * 
     * @return true s'il y a une pièce précédente, false sinon
     */
    public boolean canGoBack()
    {
        return !this.aPreviousRooms.isEmpty();
    } // canGoBack()

    /**
     * Le joueur revient à la pièce précédente.
     * 
     * @return La pièce précédente, ou null s'il n'y en a pas
     */
    public Room goBack()
    {
        if (this.aPreviousRooms.isEmpty()) 
        {
            return null;
        }
        this.aCurrentRoom = this.aPreviousRooms.pop();
        return this.aCurrentRoom;
    } // goBack()

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

        Item vItem = this.aCurrentRoom.getItem(pItemName);

        // Si l'item existe dans la pièce ou pas
        if (vItem == null)
        {
            return "You can't find what you're looking for...";
        }

        // Si l'item existe dans cette pièce :
        // Si l'item est trop lourd pour être pris
        if (vItem.getWeight() >= 10.0)
        {
            return "It's too heavy to pick up !";
        }

        // Si le joueur a le poids disponible pour le prendre
        if (this.aCurrentWeight + vItem.getWeight() > this.aMaxWeight)
        {
            return "You carry too much to pick up more things !";
        }

        // Si le joueur ne dépasse pas la somme d'argent
        if (this.aCurrentPrice + vItem.getPrice() > this.aMaxPrice)
        {
            return "This item is too valuable, it's too risky !";
        }
        
        // L'item est récupéré
        this.aCurrentRoom.removeItem(vItem);
        this.aItems.addItem(vItem);
        this.aCurrentWeight += vItem.getWeight();
        this.aCurrentPrice += vItem.getPrice();
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

        Item vItem = this.aItems.getItem(pItemName);

        // Si le joueur possède l'item ou pas
        if (vItem == null)
        {
            return "You don't have that item !";
        }

        // L'item est laché
        this.aItems.removeItem(pItemName);
        this.aCurrentWeight -= vItem.getWeight();
        this.aCurrentPrice -= vItem.getPrice();
        this.aCurrentRoom.addItem(vItem);
        return "You dropped the " + pItemName + ".";
    } // dropItem()

    /**
     * Retourne la liste des items que possède le joueur
     * 
     * @return les items du joueur
     */
    public String getItemsPlayer()
    {
        // Condition singulier/pluriel pour Jerry/Jerries
        String vCurrentPrice = (this.aCurrentPrice <= 1.0) ? " Jerry" : " Jerries";
        
        // Si le joueur ne possède aucun item sur lui
        if (this.aItems.isEmpty())
        {
            return "You have nothing in your pocket.\nWeight : " 
            + this.aCurrentWeight 
            + " kg / " 
            + this.aMaxWeight 
            + " kg\n"
            + "Value : "
            + this.aCurrentPrice
            + vCurrentPrice
            + " / "
            + this.aMaxPrice
            + " Jerries\n";
        }
        
        // Si le joueur possède des items
        StringBuilder vItems = new StringBuilder
        ( "You are carrying : \n" + "Weight : "
                                  + this.aCurrentWeight 
                                  + "kg / " 
                                  + this.aMaxWeight 
                                  + " kg\n"
                                  + "Value : "
                                  + this.aCurrentPrice
                                  + vCurrentPrice
                                  + " / "
                                  + this.aMaxPrice
                                  + " Jerries\n");
        vItems.append("\n").append(this.aItems.getItemListDescription());
        return vItems.toString();
    } // getItemsPlayer()
    
    /**
     * Retourne un item de l'inventaire du joueur avec son nom
     * 
     * @param pItemName Nom de l'item
     * @return L'item de l'inventaire ou null s'il n'est pas trouvé
     */
    public Item getItemByName( final String pItemName )
    {
        return this.aItems.getItem(pItemName);
    } // getItemName()
    
    /**
     * Augmente la capacité maximale transportable par le joueur
     * 
     * @param pWeight Le poids en plus à ajouter
     */
    public void increaseMaxWeight( final double pWeight )
    {
        this.aMaxWeight += pWeight;
    } // increaseMaxWeight()
    
    /**
     * Retourne le nombre de commandes effectuées
     * 
     * @return nombre de commandes
     */
    public int getCommandCount()
    {
        return this.aCommandCount;
    } // getCommandCount()
    
    /**
     * Retourne la limite de commandes
     * 
     * @return limite (COMMAND_LIMIT)
     */
    public static int getCommandLimit()
    {
        return COMMAND_LIMIT;
    } // getCommandLimit()
    
    /**
     * Marque que la limite de commandes est atteinte
     */
    public void setTimeLimitReached()
    {
        this.aTimeLimitReached = true;
    } // setTimeLimitReached()
    
    /**
     * Incrémente le compteur de commandes utilisées du joueur
     */
    public void increaseCommandCount()
    {
        this.aCommandCount++;

        if (this.aCommandCount >= COMMAND_LIMIT)
        {
            this.aTimeLimitReached = true;
        }
    } // increaseCommandCount()
    
    /**
     * Vérifie si la limite de temps est atteinte et si le nombre de commandes est supérieur à la limite
     * 
     * @return true si la limite de temps est atteinte ou si le nombre de commandes a atteint la limite, false sinon
     */
    public boolean isTimeLimitReached()
    {
        return this.aTimeLimitReached || (this.aCommandCount >= COMMAND_LIMIT);
    } // isTimeLimitReached()
} // Player

