import java.util.Scanner;
import java.io.File;
import java.io.*;

/**
 *  Classe GameEngine - le moteur du jeu d'aventure The Steles of Antevia.
 *  
 *  Cette classe gère toute la logique du jeu :
 *  - création des pièces et leurs sorties
 *  - affichage des messages
 *  - interprétation et exécution des commandes du joueur
 * 
 * @author Clément RUAN
 * @version 17/12/2025
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
     * Initialise l'interface du joueur et affiche le message de bienvenue.
     * 
     * @param pGui L'interface du joueur
     */
    public void setGUI(final UserInterface pGui)
    {
        this.aGui = pGui;
        this.printWelcome();
    } // setGUI()

    /**
     * Affiche le message de bienvenue en lançant le jeu et affiche la 
     * description de la pièce de départ.
     */
    private void printWelcome()
    {
        this.aGui.print("\n");
        this.aGui.println("Welcome to The Steles of Antevia!");
        this.aGui.println("The Steles of Antevia is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help.");
        this.aGui.print("\n");
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    } // printWelcome()

    /**
     * Affiche la description de la pièce actuelle du joueur avec l'image associée
     */
    private void printLocationInfo()
    {
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
        this.aGui.println( "\nCommand used : " + this.aPlayer.getCommandCount() + "/" + Player.getCommandLimit() );
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
    } // printLocationInfo()

    /**
     * Crée toutes les pièces du jeu, définit les sorties possibles et la 
     * pièce de départ.
     */
    private void createRooms()
    {
        // Les pièces du bateau
        Room vBoat = new Room("You just entered the boat", "images/boat/boat.jpg");
        Room vDeck = new Room("on the deck", "images/boat/deck.jpg");
        Room vGalley = new Room("in the galley", "images/boat/galley.jpg");
        Room vCockpit = new Room("in the cockpit", "images/boat/cockpit.jpg");
        Room vCabin = new Room("in the cabin", "images/boat/cabin.jpg");
        Room vCabin_floor_1 = new Room("in the first floor of the cabin", "images/boat/cabin_floor_1.jpg");
        
        // Trap Doors
        Room vSlide = new Room("You entered the slide, you can't go up !", "");
        Room vEmergencyExit = new Room("in an emergency path", "");
        
        // Les items du bateau
        Item vBed = new Item("bed", "A comfortable bed", 100, 500);
        Item vBooks = new Item("book", "Captain's book", 0.5, 15);
        Item vChair1 = new Item("chair1", "A chair", 4, 20);
        Item vChair2 = new Item("chair2", "A chair", 4.5, 25);
        Item vChair3 = new Item("chair3", "A chair", 9, 45);
        Item vCoin = new Item("coin", "3 Jerries", 0.1, 3);
        Item vCookie = new Item("cookie", "A magic cookie that increases your strength", 0.1, 5);

        // Initialise les sorties de pièces et d'items
        // Boat
        vBoat.setExit("east", vDeck);
        vBoat.setExit("south", vCockpit);
        vBoat.setExit("west", vGalley);
        vBoat.addItem(vCoin);
        vBoat.addItem(vCookie);
        // Deck
        vDeck.setExit("west", vBoat);
        // Galley
        vGalley.setExit("east", vBoat);
        vGalley.addItem(vChair3);
        vGalley.addItem(vChair2);
        vGalley.addItem(vChair1);
        // Cockpit
        vCockpit.setExit("north", vBoat);
        vCockpit.setExit("east", vCabin);
        vCockpit.setExit("emergency", vEmergencyExit); // trapdoor
        // Cabin
        vCabin.setExit("west", vCockpit);
        vCabin.setExit("up", vCabin_floor_1);
        vCabin.addItem(vBooks);
        // Cabin - etage1
        vCabin_floor_1.setExit("down", vCabin);
        vCabin_floor_1.setExit("slide", vSlide); // trapdoor
        vCabin_floor_1.addItem(vBed);
        // Slide
        vSlide.setExit("down", vCabin);
        // Emergency Exit
        vEmergencyExit.setExit("exit", vBoat);

        this.aStartingRoom = vBoat; // Pièce de départ
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
            this.aPlayer.setTimeLimitReached();
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
        else if (vCommandWord.equals("test")) 
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

    // implementations of user commands:

    /**
     * Affiche la description de la pièce actuelle.
     * 
     * @param pCommand La commande contient un second mot ou pas
     */
    private void look(final Command pCommand)
    {
        if (pCommand.hasSecondWord()) {
            this.aGui.println("Look at what? I don't know how to look at something in particular yet.");
        } else {
            this.printLocationInfo();
        }
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
     * Affiche la description d'aide et les commandes disponibles.
     */
    private void printHelp() 
    {
        this.aGui.println( "You are lost. You are alone. You wander" );
        this.aGui.println( "around one of the isle of Antevia." + "\n" );
        this.aGui.println( "Your command words are: " + this.aParser.getCommandList() );
    } // printHelp()

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
        if (!pCommand.hasSecondWord()) {
            this.aGui.println( "Drop what?" );
            return;
        }
        String vItemName = pCommand.getSecondWord();
        String vMessage = this.aPlayer.dropItem( vItemName );
        this.aGui.println( vMessage );
    } // drop()

    /**
     * Déplace le joueur dans la direction choisie par le joueur.
     * Affiche un message d'erreur si la direction choisie n'est pas connue
     * ou s'il n'y a pas de sortie vers cette direction.
     * 
     * @param pCommand La commande de direction
     */
    private void goRoom( final Command pCommand ) 
    {
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "Go where?" );
            return;
        }

        String vDirection = pCommand.getSecondWord();

        // Try to leave current room.
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit( vDirection );

        if ( vNextRoom == null )
        {
            this.aGui.println( "Nothing to find here!" );
        }
        else 
        {
            boolean vRoom = this.aPlayer.goToRoom(vNextRoom);
            if (vRoom)
            {
                printLocationInfo();
            }
        }
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
     * Met fin au jeu en affichant un message d'au revoir et désactive 
     * l'interface du joueur.
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing ! Good bye ! " );
        this.aGui.enable( false );
    } // endGame()
} // GameEngine

