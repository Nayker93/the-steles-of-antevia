 

/**
 * Classe CommandWords - Tableau des commandes valides du jeu
 * go : déplacement vers une direction
 * quit : quitte le jeu
 * help : affiche les commandes disponibles
 * back : reviens à la pièce précédente
 * look : affiche la description de la pièce actuelle
 * eat : action du joueur (test)
 * sleep : action du joueur (test)
 * test : exécute un fichier de test
 * take : ramasse un item dans la pièce
 * drop : lâche un item de l'inventaire
 * inventory" : affiche l'inventaire et les contraintes du joueur (poids et prix)
 *
 * @author  Clément RUAN
 * @version 17/12/2025
 */
public class CommandWords
{
    /**
     * Commandes valides du jeu
     */
    private static final String[] sValidCommands = { 
        "go", "quit", "help", "back","look", "eat", "sleep", "test", 
        "take", "drop", "inventory"
    };
    // static : pour que ce tableau n'existe qu'en un seul exemplaire dans cette classe (même si on l'instancie plusieurs fois)
    // final : pour qu'on ne puisse pas modifier ce tableau
    // [] : pour indiquer qu'on ne veut pas une seule String mais plusieurs
    // { , , } : pour indiquer quelles sont les 3 String à stocker dans ce tableau

    /**
     * Constructeur par défaut
     */
    public CommandWords() {}
    
    /**
     * Vérifie si pString est une commande valide.
     * 
     * @param pString La chaîne à vérifier
     * @return true si pString est une commande valide, sinon false
     */
    public boolean isCommand( final String pString )
    {
        for ( int vI=0; vI<sValidCommands.length; vI++ ) {
            // sValidCommands.length : vaut le nombre de cases du tableau, ici 3
            // vI++ est strictement équivalent à vI = vI+1 (exécuté à la fin de chaque tour de boucle)
            // donc, POUR vI prenant les valeurs 0, 1, 2, FAIRE :

            if ( sValidCommands[vI].equals( pString ) ) // [vI] pour indiquer qu'on veut accéder à la case n°vI du tableau
                return true; // termine la méthode et retourne vrai puisqu'on a trouvé le mot parmi les commandes valides

        } // fin de la boucle POUR
        return false; // retourne faux puisqu'on n'a pas trouvé le mot parmi les commandes valides
    } // isCommand(.)
    
    /**
     * Retourne toutes les commandes valides.
     * 
     * @return Une chaîne ayant toutes les commandes valides
     */
    public String getCommandList()
    {
        String vCommandList = "";
        for (String command : sValidCommands) {
            vCommandList += command + " ";
        }
        return vCommandList;
    } // getCommandList()
} // CommandWords

