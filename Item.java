
/**
 * Classe Item - Représente un item du jeu qui peut être récupérer.
 * 
 * Cette classe possède des champs pour stocker la description et le poids
 *
 * @author Clément RUAN
 * @version 17/12/2025
 */
public class Item
{
    /**
     * Nom de l'item
     */
    private String aItemName;
    /**
     * Description de l'item
     */
    private String aItemDescription;
    /**
     * Poids de l'item en kg
     */
    private double aWeight;
    /**
     * Prix de l'item en Jerry équivalent à l'euro
     */
    private double aPrice;
    /**
     * Constructeur pour un item du jeu
     * 
     * @param pItemName Nom de l'item
     * @param pItemDescription Description de l'item
     * @param pWeight Poids de l'item en kg
     * @param pPrice Prix de l'item en Jerry
     */
    public Item( final String pItemName, final String pItemDescription, 
    final double pWeight, final double pPrice )
    {
        this.aItemName = pItemName;
        this.aItemDescription = pItemDescription;
        this.aWeight = pWeight;
        this.aPrice = pPrice;
    } // Item()
    
    /**
     * Retrourne le nom de l'item courant
     * 
     * @return Nom de l'item courant
     */
    public String getItemName()
    {
        return this.aItemName;
    } // getItemName()
    
    /**
     * Retourne la description de l'item courant
     * 
     * @return Description de l'item courant
     */
    public String getItemDescription()
    {
        return this.aItemDescription;
    } //getDescription()
    
    /**
     * Retourne le poids de l'item courant
     * 
     * @return Poids de l'item courant en kg
     */
    public double getWeight()
    {
        return this.aWeight;
    } // getWeight()
    
    /**
     * Retourne le prix de l'item courant
     * 
     * @return Prix de l'item courant en Jerry
     */
    public double getPrice()
    {
        return this.aPrice;
    } // getPrice()
}

