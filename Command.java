/**
 * Classe Command - Représente une commande du jeu Zuul.
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class Command
{
    /**
     * Première commande du joueur
     */
    private String aCommandWord;
    /**
     * Commande optionnel
     */
    private String aSecondWord;

    /**
     * Constructeur : crée une commande avec mot-clé et paramètre optionnel.
     * 
     * @param pCommandWord Le mot-clé de la commande peut être null pour commande inconnue
     * @param pSecondWord Le paramètre optionnel 
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    } // Command(final String pCommandWord, final String pSecondWord)

    /**
     * Retourne le mot-clé de la commande.
     * 
     * @return Le mot-clé de la commande ou null si commande inconnue
     */
    public String getCommandWord()
    {
        return this.aCommandWord;
    } // getCommandWord()

    /**
     * Retourne le paramètre de la commande.
     * 
     * @return Le paramètre ou null s'il n'existe pas
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    } // getSecondWord()

    /**
     * Vérifie s'il existe un second mot (paramètre).
     * 
     * @return true s'il existe un second mot, sinon false
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    } // hasSecondWord()

    /**
     * Vérifie si la commande est inconnue.
     * 
     * @return true si le mot-clé est null (commande inconnue), sinon false
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == null;
    } // isUnknown()

} // Command

