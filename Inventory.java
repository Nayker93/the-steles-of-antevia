import java.util.Collection;

/**
 * Classe Inventory - L'inventaire du joueur
 * 
 * Gère les items, poids, et argent que le joueur peut transporter sur lui
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class Inventory
{
    /**
     * Poids max transportable par le joueur en kg
     */
    private static final double MAX_WEIGHT = 50.0;
    /**
     * Poids max de l'item que le joueur peut prendre
     */
    private static final double MAX_WEIGHT_ITEM = 20.0;
    /**
     * Somme d'argent max transportable par le joueur en Jerry
     */
    private static final double MAX_PRICE = 1000.0;
    /**
     * Les items du joueur
     */
    private ItemList aItems;
    /**
     * Le poids max du joueur
     */
    private double aMaxWeight = MAX_WEIGHT;
    /**
     * Le poids actuelle du joueur
     */
    private double aCurrentWeight;
    /**
     * Somme d'argent actuelle du joueur
     */
    private double aCurrentPrice;

    /**
     * Crée l'inventaire du joueur
     */
    public Inventory()
    {
        this.aItems = new ItemList();
        this.aCurrentWeight = 0.0;
        this.aCurrentPrice = 0.0;
        this.aMaxWeight = MAX_WEIGHT;
    } // Inventory()

    /**
     * Ajoute un item dans l'inventaire du joueur
     * 
     * @param pItem L'item à ajouter
     * @return true si ajouté, false sinon
     */
    public boolean addItem(final Item pItem) 
    {
        // Vérifie s'il y'a un item
        if (pItem == null) 
        {
            return false;
        }

        // Vérifie si l'item est trop lourd pour être porté
        if (pItem.getWeight() >= MAX_WEIGHT_ITEM) 
        {
            return false;
        }

        // Vérifie si le joueur ne dépasse pas sa limite de poids
        if (this.aCurrentWeight + pItem.getWeight() > this.aMaxWeight) 
        {
            return false;
        }

        // Vérifie si le joueur ne dépasse pas la somme d'argent transportable
        if (this.aCurrentPrice + pItem.getPrice() > MAX_PRICE) 
        {
            return false;
        }

        // Ajoute l'item
        this.aItems.setItem(pItem);
        this.aCurrentWeight += pItem.getWeight();
        this.aCurrentPrice += pItem.getPrice();
        return true;
    } // addItem()

    /**
     * Retire un item de l'inventaire
     * 
     * @param pItem L'item à retirer
     * @return L'item retiré
     */
    public Item removeItem(final String pItem) {
        Item vItem = this.aItems.getItem(pItem);
        if (vItem != null) {
            this.aItems.removeItem(pItem);
            this.aCurrentWeight -= vItem.getWeight();
            this.aCurrentPrice -= vItem.getPrice();
            return vItem;
        }
        return null;
    } // removeItem()

    /**
     * Augmente le poids maximal (magic cookie)
     * 
     * @param pIncrease Augmentation du poids
     */
    public void increaseMaxWeight(final double pIncrease)
    {
        this.aMaxWeight += pIncrease;
    }

    /**
     * Retourne un item
     * 
     * @param pItem Le nom de l'item
     * @return L'item
     */
    public Item getItem(final String pItem) {
        return this.aItems.getItem(pItem);
    } // getItem

    /**
     * Retourne tous les items
     * 
     * @return Tous les items
     */
    public Collection<Item> getItems() {
        return this.aItems.getItems();
    } // getItems()

    /**
     * Retourne la description des items
     * 
     * @return La description des items
     */
    public String getItemListDescription() {
        return this.aItems.getItemListDescription();
    } // getItemListDescription()

    /**
     * Vérifie si l'inventaire est vide
     * 
     * @return true si vide, false sinon
     */
    public boolean isEmpty() {
        return this.aItems.isEmpty();
    } // isEmpty()

    /**
     * Retourne le poids max transportable par le joueur en kg
     * 
     * @return le poids max transportable par le joueur en kg
     */
    public double getMaxWeight()
    { 
        return this.aMaxWeight; 
    } // getMaxWeight()

    /**
     * Retourne le poids actuelle du joueur en kg
     * 
     * @return le poids actuelle du joueur en kg
     */
    public double getCurrentWeight() 
    { 
        return this.aCurrentWeight; 
    } // getCurrentWeight()

    /**
     * Retourne la somme d'argent max transportable par le joueur en Jerry
     * 
     * @return la somme d'argent max transportable par le joueur en Jerry
     */
    public double getMaxPrice() 
    { 
        return MAX_PRICE; 
    } // getMaxPrice()

    /**
     * Retourne la somme d'argent actuelle du joueur en Jerry
     * 
     * @return la somme d'argent actuelle du joueur en Jerry
     */
    public double getCurrentPrice() 
    { 
        return this.aCurrentPrice; 
    } // getCurrentPrice()

    /**
     * Retourne la description de tous les items de l'inventaire
     * 
     * @return La description de tous les items de l'inventaire
     */
    @Override
    public String toString()
    {
        return this.getItemListDescription();
    } // toString()

    /**
     * Retourne la description de l'inventaire
     * 
     * @return La description de l'inventaire
     */
    public String getInventoryDescription()
    {
        StringBuilder vInventory = new StringBuilder();
        String vCurrentPrice = (this.aCurrentPrice <= 1.0) ? " Jerry" : " Jerries";

        // Items
        vInventory.append( this.getItemListDescription() );

        // Poids
        vInventory.append("\n\nWeight: ")
                  .append( this.aCurrentWeight )
                  .append(" kg / ")
                  .append( this.aMaxWeight )
                  .append(" kg");

        // Argent
        vInventory.append("\nMoney: ")
                  .append( this.aCurrentPrice )
                  .append( vCurrentPrice )
                  .append( " / " )
                  .append( MAX_PRICE )
                  .append( " Jerries" );

        return vInventory.toString();
    } // getInventoryDescription()
} // Inventory