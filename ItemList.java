import java.util.Collection;
import java.util.TreeMap;

/**
 * Classe ItemList - Gère la liste d'items
 * Organise la gestion des items pour les classes Room et Player
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class ItemList
{
    /**
     * Collection d''items
     */
    private java.util.TreeMap<String, Item> aItems;
    /**
     * Créer une liste d'items vide
     */
    public ItemList()
    {
        this.aItems = new TreeMap<>();;
    } // ItemList()

    /**
     * Ajoute un item dans la liste courante
     * 
     * @param pItem L'item à ajouter
     */
    public void setItem( final Item pItem )
    {
        if (pItem != null)
        {
            this.aItems.put(pItem.getItemName(), pItem);
        }
    } // setItem()

    /**
     * Retourne l'item à partir de son nom.
     * 
     * @param pName Nom de l'item
     * @return L'item
     */
    public Item getItem( final String pName )
    {
        return this.aItems.get(pName);
    } // getItem()

    /**
     * Retire un item de la liste courante selon sa référence
     * 
     * @param pItem Item à retirer
     * @return L'item retiré ou null
     */
    public Item removeItem( final Item pItem )
    {
        if (pItem == null)
        {
            return null;
        }
        return this.aItems.remove(pItem.getItemName());
    } // removeItem()

    /**
     * Retire un item de la liste courante à partir de son nom
     * 
     * @param pName Nom de l'item
     * @return L'item retiré ou null
     */
    public Item removeItem( final String pName )
    {
        return this.aItems.remove(pName);
    } // removeItem()

    /**
     * Vérifie si la liste contient des items ou pas
     * 
     * @return true si la liste ne contient aucun item, false sinon
     */
    public boolean isEmpty()
    {
        return this.aItems.isEmpty();
    } // isEmpty()

    /**
     * Retourne tous les items de la liste courante
     * 
     * @return Tous les items de la liste courante
     */
    public Collection<Item> getItems()
    {
        return this.aItems.values();
    } // getItems()

    /**
     * Retourne une description de tous les items.
     * 
     * @return Description des items
     */
    public String getItemListDescription()
    {
        if ( this.aItems.isEmpty() ) {
            return "No item here.";
        }

        StringBuilder vItemsDescription = new StringBuilder( "Items : " );
        for ( Item vItem : this.aItems.values() ) 
        {
            String vCurrentPrice = (vItem.getPrice() <= 1.0) ? " Jerry" : " Jerries";
            vItemsDescription.append( "\n  - " )
                             .append( vItem.getItemName() )
                             .append( ", " )
                             .append( vItem.getItemDescription() )
                             .append( ", " )
                             .append( vItem.getWeight() )
                             .append( " kg, " )
                             .append( vItem.getPrice() )
                             .append( vCurrentPrice );
        }
        return vItemsDescription.toString();
    } // getItemListDescription()
}