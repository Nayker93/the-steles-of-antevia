
/**
 * Classe GameWorld - Créer le monde du jeu
 * 
 * Création des pièces, items, trapdoor, lockdoor
 *
 * @author CLEMENT RUAN
 * @version 2026
 */
public class GameWorld
{
    
    private GameWorld(){}
    
    /**
     * Construit le monde du jeu
     * Retourne la pièce de départ
     * 
     * @return La pièce de départ
     */
    public static Room createWorld()
    {
        // Les pièces du bateau
        Room vBoat = new Room("in the boat", "images/boat/boat.jpg");
        Room vDeck = new Room("on the deck", "images/boat/deck.jpg");
        Room vGalley = new Room("in the galley", "images/boat/galley.jpg");
        Room vCockpit = new Room("in the cockpit", "images/boat/cockpit.jpg");
        Room vCabin = new Room("in the cabin", "images/boat/cabin.jpg");
        Room vCabinFloor1 = new Room("in the first floor of the cabin", "images/boat/cabin_floor_1.jpg");
        // Trap Doors
        Room vSlide = new Room("in the slide (trapdoor), you can't go up !", "");
        Room vEmergencyExit = new Room("in an emergency path (trapdoor)", "");

        // Le placement des pièces
        // Boat
        vBoat.setExit("deck", vDeck);
        vBoat.setExit("cockpit", vCockpit);
        vBoat.setExit("galley", vGalley);
        // Deck
        vDeck.setExit("boat", vBoat);
        // Galley
        vGalley.setExit("boat", vBoat);
        // Cockpit
        vCockpit.setExit("boat", vBoat);
        vCockpit.setExit("cabin", vCabin);
        vCockpit.setExit("emergency", vEmergencyExit);
        // Cabin
        vCabin.setExit("cockpit", vCockpit);
        vCabin.setExit("floor1", vCabinFloor1);
        // Cabin - etage1
        vCabinFloor1.setExit("cabin", vCabin);
        vCabinFloor1.setExit("slide", vSlide);
        // Slide
        vSlide.setExit("down", vCabin);
        // Emergency Exit
        vEmergencyExit.setExit("exit", vBoat);
        
        // Créer les items
        Item vKeyCabin = new Item("key_cabin", "This key can unlock the cabin", 0.1, 10);
        Item vBed = new Item("bed", "A comfortable bed", 100, 500);
        Item vBooks = new Item("book", "Captain's book", 0.5, 15);
        Item vChair1 = new Item("chair1", "A chair", 4, 20);
        Item vChair2 = new Item("chair2", "A chair", 4.5, 25);
        Item vChair3 = new Item("chair3", "A chair", 9, 45);
        Item vCoin = new Item("coin", "3 Jerries", 0.1, 3);
        Item vCookie = new Item("cookie", 
                               "A magic cookie that increases your strength", 0.1, 5);
        Beamer vBeamer = new Beamer();
        
        // Ajouter les items aux pièces
        vBoat.setItem(vCoin);
        vBoat.setItem(vCookie);
        vBoat.setItem(vKeyCabin);
        
        vDeck.setItem(vBeamer);
        
        vGalley.setItem(vChair3);
        vGalley.setItem(vChair2);
        vGalley.setItem(vChair1);
        
        vCabin.setItem(vBooks);
        
        vCabinFloor1.setItem(vBed);
        
        // Les portes
        Door vDoorCockpitCabin = new Door(vKeyCabin, false);
        vCockpit.setDoor("cabin", vDoorCockpitCabin);
        vCabin.setDoor("cockpit", vDoorCockpitCabin);
        
        // Pièce de départ
        return vBoat; 
    } // CreateWorld()
} // GameWorld()