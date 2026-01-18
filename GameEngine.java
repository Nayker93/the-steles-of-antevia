import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.Collection;

/**
 *  Classe GameEngine - le moteur du jeu d'aventure The Steles of Antevia.
 *  
 *  Cette classe gère toute la logique du jeu :
 *  - création des pièces et leurs sorties
 *  - affichage des messages
 *  - interprétation et exécution des commandes du joueur
 * 
 * @author CLEMENT RUAN
 * @version 2026
 */
public class GameEngine
{
    /**
     * Le parser pour analyser les commandes utilisées par le joueur
     */
    private Parser aParser;
    /**
     * Le joueur 
     */
    private Player aPlayer;
    /**
     * La pièce de départ
     */
    private Room aStartingRoom;
    /**
     * L'interface du joueur
     */
    private UserInterface aGui;

    /**
     * Initialise le moteur du jeu
     * Crée le Parser et toutes les pièces du jeu
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.createRooms();
        this.aPlayer = new Player("Player");
        this.aPlayer.setCurrentRoom(this.aStartingRoom);
    } // GameEngine()

    /**
     * Définit l'interface de l'utilisateur et affiche le message de bienvenue
     * 
     * @param pUserInterface L'interface utilisateur
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    } // setGUI()

    /**
     * Affiche la description de la pièce actuelle du joueur
     */
    private void printRoomDescription()
    {
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    } // printRoomDescription()
    
    /**
     * Affiche le message de bienvenue en lançant le jeu et affiche la 
     * description de la pièce de départ.
     */
    private void printWelcome()
    {
        this.aGui.print("\n");
        this.aGui.println("Welcome to The Steles of Antevia!");
        this.aGui.println("Type 'help' if you need help.");
        this.aGui.print("\n");
        this.printRoomDescription();
    } // printWelcome()

    /**
     * Affiche la description de la pièce actuelle du joueur avec l'image associée
     */
    private void printLocationInfo()
    {
        this.printRoomDescription();
        this.aGui.println( "\nCommand used : " + this.aPlayer.getCommandCount() + "/" + Player.getCommandLimit() );
    } // printLocationInfo()

    /**
     * Crée toutes les pièces du jeu, définit les sorties possibles et la 
     * pièce de départ.
     */
    private void createRooms()
    {
        this.aStartingRoom = GameWorld.createWorld();
    } // createRooms()

    /**
     * Étant donné une commande, traitez (c'est-à-dire exécutez) cette commande.
     * Si cette commande met fin à la partie, la valeur « vrai » 
     * est renvoyée sinon, la valeur « faux » est renvoyée.
     * 
     * @param pCommandLine La ligne de commande saisie par l'utilisateur
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.parseCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }

        // Limite de temps
        this.aPlayer.increaseCommandCount();
        if (this.aPlayer.isTimeLimitReached())
        {
            this.aGui.println( "\n" );
            this.aGui.println( "Time limit reached !\n" );
            this.aGui.println( "You lost...\n" );
            this.aGui.println( "Command used : " + this.aPlayer.getCommandCount() + "/" + Player.getCommandLimit());
            this.aGui.println( "\n" );
            this.aGui.println( "Restart the game !\n" );
            this.endGame();
            return;
        }

        // Commandes utilisable par le joueur
        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "help" ) )
            this.printHelp();
        else if ( vCommandWord.equals( "go" ) )
            this.goRoom( vCommand );
        else if ( vCommandWord.equals( "look" ) )
            this.look( vCommand );
        else if ( vCommandWord.equals( "eat" ) ) 
            this.eat( vCommand );
        else if ( vCommandWord.equals( "take" ) ) 
            this.take( vCommand );
        else if ( vCommandWord.equals( "drop" ) )
            this.drop( vCommand );
        else if ( vCommandWord.equals( "sleep" ) ) 
            this.sleep( vCommand );
        else if ( vCommandWord.equals( "inventory" ) ) 
            this.inventory( vCommand );
        else if ( vCommandWord.equals( "back" ) )
            this.back( vCommand );
        else if ( vCommandWord.equals( "charge" ) )
            this.chargeBeamer( vCommand );
        else if ( vCommandWord.equals( "fire" ) ) 
            this.fireBeamer( vCommand );
        else if (vCommandWord.equals( "unlock" ) )
            this.unlockDoor(vCommand);
        else if (vCommandWord.equals( "lock" ) )
            this.lockDoor(vCommand);
        else if ( vCommandWord.equals( "test" ) ) 
        {
            if (vCommand.getSecondWord() == null) 
            {
                System.out.println("Test what? Specify a filename.");
            } 
            else 
            {
                testFile(vCommand.getSecondWord());
            }
            return; 
        }
        else if ( vCommandWord.equals( "quit" ) ) {
            if ( vCommand.hasSecondWord() )
                this.aGui.println( "Quit what?" );
            else
                this.endGame();
        }
    } // interpretCommand()

    // Implémentation des commandes du joueur

    /**
     * Affiche la description d'aide et les commandes disponibles.
     */
    private void printHelp() 
    {
        this.aGui.println( "You are lost. You are alone. You wander" );
        this.aGui.println( "around one of the isle of Antevia." + "\n" );
        this.aGui.println( "Your command words are: " + this.aParser.getCommandList() );
    } // printHelp()
    
    /**
     * Affiche la description de la pièce actuelle ou de l'item si second mot
     * 
     * @param pCommand La commande contient un second mot ou pas
     */
    private void look(final Command pCommand)
    {  
        if (!pCommand.hasSecondWord()) {
            this.printLocationInfo();
            return;
        }

        String vItemName = pCommand.getSecondWord();
        Item vItem = this.aPlayer.getItemByName(vItemName);

        // Si le joueur n'a pas l'item dans son inventaire
        if (vItem == null) {
            this.aGui.println("You don't have that item!");
            return;
        }

        // Cas spécial pour Beamer
        if (vItem instanceof Beamer) {
            Beamer vBeamer = (Beamer) vItem;
            this.aGui.println(vBeamer.getBeamerCondition());

            // Affiche la pièce stockée par le Beamer
            Room vBeamerRoom = vBeamer.getBeamerRoom();
            if (vBeamerRoom != null)
            {
                this.aGui.println("Room charged into the Beamer : " + vBeamerRoom.getRoomDescription());
            }
            else
            {
                this.aGui.println("Room charged into the Beamer : none.");
            }
            return;
        }

        // Cas général
        this.aGui.println(vItem.getItemDescription());
    } // look()

    /**
     * Traite la commande "eat" avec un paramètre pour choisir un item à consommer
     * 
     * @param pCommand La commande contient un second mot ou pas
     */
    private void eat(final Command pCommand)
    {
        if (!pCommand.hasSecondWord()) {
            this.aGui.println("You have eaten now and you are not hungry any more.");
            return;
        }
        String vItemName = pCommand.getSecondWord();
        Item vItem = this.aPlayer.getItemByName(vItemName);

        // Si l'item est dans l'inventaire
        if (vItem == null)
        {
            this.aGui.println("You don't find that item...");
            return;
        }

        // Si l'item est le cookie magique ou autre
        if (vItem.getItemName().equals("cookie"))
        {
            double vPreviousMaxWeight = this.aPlayer.getMaxWeight();
            this.aPlayer.increaseMaxWeight(5);
            this.aPlayer.dropItem(vItemName);
            this.aGui.println("You ate the magic cookie !");
            this.aGui.println("Your maximum weight just increased from "+
                vPreviousMaxWeight + " kg to " + this.aPlayer.getMaxWeight()
                + " kg\n");
        }
        else
        {
            this.aGui.println("You just ate " + vItemName);
            this.aPlayer.dropItem(vItemName);
        }
    } // eat()

    /**
     * Traite la commande "sleep".
     * 
     * @param pCommand La commande contient un second mot ou pas
     */
    private void sleep(final Command pCommand)
    {
        if (pCommand.hasSecondWord()) {
            this.aGui.println("Sleep where? I don't know how to sleep here.");
        } else {
            this.aGui.println("You have slept now and you are not tired any more.");
        }
    } // sleep()

    /**
     * Ramène le joueur dans la pièce précédente
     * 
     * @param pCommand La commande contient un second mot ou pas
     */
    private void back( final Command pCommand ) // pas de hasSecondWord()
    {
        // Vérifie s'il y'a un second mot
        if (pCommand.hasSecondWord())
        {
            this.aGui.println("Back what ??");
            return;
        }
        // Pas de pièce précédente
        if (!this.aPlayer.canGoBack()) 
        {
            this.aGui.println("You can't go backwards !");
            return;
        }

        // Trap Door
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        Room vPreviousRoom = this.aPlayer.getPreviousRoom();

        if (vCurrentRoom.isExit(vPreviousRoom))
        {
            // Pièce précédente 
            this.aPlayer.goBack();
            // Description de la pièce précédente + image
            printLocationInfo();
        }
        else
        {
            // Trap Door
            this.aGui.println("You can't go back !");
        }
    } // back()

    /**
     * Affiche l'inventaire du joueur
     *
     * @param pCommand La commande contient un second mot ou pas
     */
    private void inventory( final Command pCommand )
    {
        if (pCommand.hasSecondWord()) {
            this.aGui.println("Your inventory doesn't have a name !");
            return;
        }
        this.aGui.println(this.aPlayer.getItemsPlayer());
        int vRemainingCommand = Player.getCommandLimit() - this.aPlayer.getCommandCount();
        this.aGui.println( "\nCommands remaining : " + vRemainingCommand );
    } // inventory()

    /**
     * Récupère un item
     * 
     * @param pCommand L'item à récupérer
     */
    private void take( final Command pCommand )
    {
        if (!pCommand.hasSecondWord()) 
        {
            this.aGui.println("Take what?");
            return;
        }
        String vItemName = pCommand.getSecondWord();
        String vMessage = this.aPlayer.takeItem(vItemName);
        this.aGui.println(vMessage);
    } // take()

    /**
     * Lâche un item
     * 
     * @param pCommand L'item à lacher
     */
    private void drop( final Command pCommand )
    {
        if (!pCommand.hasSecondWord()) 
        {
            this.aGui.println( "Drop what?" );
            return;
        }
        String vItemName = pCommand.getSecondWord();
        String vMessage = this.aPlayer.dropItem( vItemName );
        this.aGui.println( vMessage );
    } // drop()

    /**
     * Charge le Beamer 
     * Stocke la pièce actuelle
     * 
     * @param pCommand La commande (charge beamer)
     */
    private void chargeBeamer(final Command pCommand)
    {
        if (!pCommand.hasSecondWord()) 
        {
            this.aGui.println("Charge what? (syntax: charge beamer)");
            return;
        }

        String vItemName = pCommand.getSecondWord();

        Item vItem = this.aPlayer.getItemByName(vItemName);

        // Vérifie si le joueur a un Beamer dans son inventaire
        if (vItem == null)
        {
            this.aGui.println("You don't have that item.");
            return;
        }

        // Vérifie si l'item est bien un Beamer
        if (!(vItem instanceof Beamer))
        {
            this.aGui.println("You can't charge " + vItemName + ".");
            return;
        }

        // Cast l'item en Beamer
        Beamer vBeamer = (Beamer) vItem;

        // Vérifie si le Beamer est endommagé
        if (vBeamer.isDamaged())
        {
            this.aGui.println("This beamer is too damaged to use.");
            return;
        }

        // Charge le Beamer avec la pièce actuelle
        String vMessage = vBeamer.chargeBeamer(this.aPlayer.getCurrentRoom());
        this.aGui.println(vMessage);
    } // chargeBeamer()

    /**
     * Déclenche le Beamer et téléporte le joueur
     * Détruit si le joueur passe par une Trapdoor
     * 
     * @param pCommand La commande (fire beamer)
     */
    private void fireBeamer(final Command pCommand)
    {
        if (!pCommand.hasSecondWord()) 
        {
            this.aGui.println("Fire what? (syntax: fire beamer)");
            return;
        }

        String vItemName = pCommand.getSecondWord();
        Item vItem = this.aPlayer.getItemByName(vItemName);

        // Vérifie si le joueur a un Beamer dans son inventaire
        if (vItem == null)
        {
            this.aGui.println("You don't have that item.");
            return;
        }

        // Vérifie si l'item est bien un Beamer
        if (!(vItem instanceof Beamer))
        {
            this.aGui.println("You can't charge " + vItemName + ".");
            return;
        }

        Beamer vBeamer = (Beamer) vItem;

        // Vérifie si le Beamer est endommagé
        if (vBeamer.isDamaged())
        {
            this.aGui.println("This beamer is too damaged to use.");
            return;
        }

        Room vBeamerRoom = vBeamer.fireBeamer();
        
        // Vérifie si le Beamer a été chargé
        if (vBeamerRoom == null)
        {
            this.aGui.println("The beamer has no room stored in ! You must charge it.");
            return;
        }

        // Téléporte le joueur
        this.aGui.println("The beamer is teleporting you...");
        this.aPlayer.goToRoom(vBeamerRoom);
        this.aGui.println(vBeamer.getBeamerCondition());
        this.printLocationInfo();
    } // fireBeamer()

    /**
     * Déverrouille une porte
     * Commande à utiliser : unlock 'direction'
     * 
     * @param pCommand La commande
     */
    private void unlockDoor( final Command pCommand )
    {
        // S'il n'y a pas de second mot
        if (!pCommand.hasSecondWord())
        {
            this.aGui.println("Unlock what ? (unlock 'direction')");
            return;
        }

        String vDirection = pCommand.getSecondWord();
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();

        // Cherche la porte à déverrouiller
        Door vDoor = vCurrentRoom.getDoor(vDirection);
        if (vDoor ==null)
        {
            this.aGui.println("There is no door in that direction.");
            return;
        }

        // Vérifie si la porte est déjà déverrouillée
        if (vDoor.isUnlocked())
        {
            this.aGui.println("The door is already unlocked.");
            return;
        }

        // Vérifie si la porte n'est pas verrouillée
        if (!vDoor.isLocked())
        {
            vDoor.tryUnlocking(null);
            this.aGui.println("You unlocked the door.");
            return;
        }

        // Vérifie si c'est la bonne clé
        Item vKeyDoor = vDoor.getKeyDoor();
        Item vKeyPlayer = this.aPlayer.getItemByName(vKeyDoor.getItemName());

        // Si le joueur n'a pas de clés
        if (vKeyPlayer == null)
        {
            this.aGui.println("You don't have the key for this door !");
            return;
        }

        // Si le joueur a une clé
        if (vDoor.tryUnlocking(vKeyPlayer))
        {
            this.aGui.println("You unlocked the door with the key.");
            this.aGui.println(vDoor.getDoorDescription());
        }
        else
        {
            this.aGui.println("The key doesn't fit in.");
        }
    } // unlockDoor()

    /**
     * Verrouille une porte 
     * Commande : lock 'direction'
     * 
     * @param pCommand La commande
     */
    private void lockDoor( final Command pCommand )
    {
        // S'il n'y a pas de second mot
        if (!pCommand.hasSecondWord())
        {
            this.aGui.println("Lock what? (lock 'direction')");
            return;
        }

        String vDirection = pCommand.getSecondWord();
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();

        // Vérifie qu'il y'a une porte dans cette direction
        Door vDoor = vCurrentRoom.getDoor(vDirection);
        if (vDoor == null)
        {
            this.aGui.println("There is no door in that direction.");
            return;
        }

        // Vérifie si la porte est déjà verrouillée
        if (!vDoor.isLocked())
        {
            this.aGui.println("This door is already locked.");
            return;
        }

        vDoor.closeDoor();
        this.aGui.println("You locked the door.");
        this.aGui.println(vDoor.getDoorDescription());
    } // lockDoor()

    /**
     * Déplace le joueur dans la direction choisie par le joueur.
     * Affiche un message d'erreur si la direction choisie n'est pas connue
     * ou s'il n'y a pas de sortie vers cette direction.
     * 
     * @param pCommand La commande de direction
     */
    private void goRoom( final Command pCommand ) 
    {
        if (!pCommand.hasSecondWord()) 
        {
            this.aGui.println( "Go where?" );
            return;
        }

        String vDirection = pCommand.getSecondWord();
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        Room vNextRoom = vCurrentRoom.getExit(vDirection);

        // Vérifie s'il existe une sortie
        if ( vNextRoom == null )
        {
            this.aGui.println( "Nothing to find here!" );
            return;
        }

        // Vérifie s'il y'a une porte verrouillée
        Door vDoor = vCurrentRoom.getDoor(vDirection);
        if (vDoor != null && !vDoor.isUnlocked())
        {
            if (vDoor.isLocked())
            {
                this.aGui.println("The door is locked. You need a key.");
                this.aGui.println(vDoor.getDoorDescription());
            }
            else
            {
                this.aGui.println("The door is closed.");
            }
            return;
        }

        // Vérifie si c'est une TrapDoor
        boolean vIsTrapDoor = isTrapDoor(vNextRoom);
        if (vIsTrapDoor)
        {
            destroyAllBeamer();
        }

        // Le joueur accède à la pièce de la direction
        this.aPlayer.goToRoom(vNextRoom);

        // La porte se referme automatiquement
        if (vDoor != null && vDoor.autoLock())
        {
            vDoor.closeDoor();
        }

        this.printLocationInfo();
    } // goRoom()

    /**
     * Execute les commandes d'un fichier test
     * 
     * @param pFileName Nom du fichier
     */
    private void testFile( final String pFileName )
    {
        Scanner vSc = null; // Scanner vide
        int nbLigne = 0; // Nombre de lignes
        try
        {
            vSc = new Scanner(new File(pFileName + ".txt"));
            System.out.println("Starting test file : " + pFileName);

            while (vSc.hasNextLine()) // Tant qu'il y'a encore des lignes
            {
                String vLigne = vSc.nextLine().trim(); // Lire la ligne et enlève les espaces au début et à la fin avec trim()
                nbLigne++; // Compteur de lignes
                if (vLigne.isEmpty() || vLigne.startsWith("#")) // Ligne vide ou est un commentaire
                {
                    continue; // passer à ligne suivante
                }
                System.out.println("Line " + nbLigne + " : " + vLigne);
                this.interpretCommand(vLigne); // execute la commande de la ligne courante
            }
            System.out.println("Test completed");
        } 
        catch ( final FileNotFoundException pErreur )
        {
            System.out.println(pFileName + ".txt not found");
        } 
        finally 
        {
            if (vSc != null) // Vérifie si vSc existe ou pas 
            {
                vSc.close(); // Ferme le fichier
            }
        }
    } // testFile()

    /**
     * Vérifie si la pièce suivante est une TrapDoor
     * 
     * @param pNextRoom La pièce de la direction
     * @return true si c'est une TrapDoor, false sinon
     */
    private boolean isTrapDoor( final Room pNextRoom )
    {
        return pNextRoom.isTrapDoor();
    } // isTrapDoor

    /**
     * Détruit tous les Beamer de l'inventaire du joueur
     */
    private void destroyAllBeamer()
    {
        // Récupère l'inventaire du joueur
        Collection<Item> vInventory = this.aPlayer.getInventory();
        boolean vBeamerDestroyed = false;

        // Cherche les Beamer dans l'inventaire
        for (Item vItem : vInventory)
        {
            if (vItem instanceof Beamer)
            {
                Beamer vBeamer = (Beamer) vItem;
                // Vérifie si le Beamer fonctionne
                if (!vBeamer.isDamaged())
                {
                    vBeamer.destroyBeamer();
                    vBeamerDestroyed = true;
                }
            }
        }
        
        if (vBeamerDestroyed)
        {
            this.aGui.println("Your Beamer was destroyed by the trapdoor and is now unusable.");
        }
    } // destroyAllBeamer()

    /**
     * Met fin au jeu en affichant un message d'au revoir et désactive 
     * l'interface du joueur.
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing ! Good bye ! " );
        this.aGui.enable( false );
    } // endGame()
} // GameEngine

