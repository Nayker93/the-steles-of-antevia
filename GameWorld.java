
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
    /**
     * Constructeur privé pour empêcher l'instanciation
     */
    private GameWorld(){}
    
    /**
     * Construit le monde du jeu
     * Retourne la pièce de départ
     * 
     * @return La pièce de départ
     */
    public static Room createWorld()
    {
        // Création des îles du jeu
        Room vPortusPrima = new Room("at Portus Prima island", "images/islands/portus_prima.jpg");
        Room vInsulaTemplum  = new Room("at Insula Templum island", "images/islands/insula_templum.jpg");
        Room vCryptaMarina = new Room("at Crypta Marina island", "images/islands/crypta_marina.jpg");
        Room vCivitasAntiqua = new Room("at Civitas Antiqua island", "images/islands/civitas_antiqua.jpg");
        Room vSilvaMystica = new Room("in the Silva Mystica island", "images/islands/silva_mystica.jpg");
        Room vMercatusFlotilla = new Room("at Mercatus Flotilla island", "images/islands/mercatus_flotilla.jpg");
        Room vLabyrinthos = new Room("in the Labyrinthos island", "images/islands/labyrinthos.jpg");
        Room vSanctumIgnis = new Room("in the Sanctum Ignis cave", "images/islands/sanctum_ignis.jpg");
        Room vMonsCaelestis = new Room("at Mons Caelestis mountain", "images/islands/mons_caelestis.jpg");
        Room vUltimaSapientia = new Room("in the Ultima Sapientia temple", "images/islands/ultima_sapientia.jpg");

        // Création des lieux principaux du jeu
        // 1 - Portus Prima
        Room vBoat = createBoat();
        Room vLibrary1 = createLibrary();
        Room vTavern1 = createTavern();
        Room vHostel1 = createHostel();
        Room vSanctuaryOfTheOracle1 = createSanctuaryOfTheOracle();
        Room vSeaPort1 = createSeaPort();
        // 2 - Insula Templum
        Room vAncientTemple = createAncientTemple();
        Room vSeaPort2 = createSeaPort();
        Room vGuideStone2 = createGuideStone2();
        // 3 - Crypta Marina
        Room vSeaPort3 = createSeaPort();
        Room vSanctuaryOfTheOracle3 = createSanctuaryOfTheOracle();
        Room vTavern2 = createTavern();
        Room vFakeGuideStone3 = createFakeGuideStone3();
        // 4 - Civitas Antiqua
        Room vSeaPort4 = createSeaPort();
        Room vRuinedPalace = createRuinedPalace();
        Room vGuideStone4 = createGuideStone4();
        // 5 - Silva Mystica
        Room vSeaPort5 = createSeaPort();
        Room vSanctuaryOfTheOracle5 = createSanctuaryOfTheOracle();
        Room vTavern5 = createTavern();
        Room vFakeGuideStone5 = createFakeGuideStone5();
        // 6 - Mercatus Flotilla
        Room vSeaPort6 = createSeaPort();
        Room vHostel6 = createHostel();
        Room vTavern6 = createTavern();
        Room vLibrary6 = createLibrary();
        // 7 - Labyrinthos
        Room vSeaPort7 = createSeaPort();
        Room vTavern7 = createTavern();
        Room vCave = createCave();
        Room vLostHole = createLostHole();
        // 8 - Sanctum Ignis
        Room vUndergroundTemple = createUndergroundTemple();
        Room vGuideStone8 = createGuideStone8();
        // 9 - Mons Caelestis
        Room vSeaPort9 = createSeaPort();
        Room vAncientObservatory = createAncientObservatory();
        Room vSacredMontain = createSacredMontain();
        Room vGuideStone9 = createGuideStone9();
        // 10 - Ultima Sapientia
        Room vSapientiaTemple = createSapientiaTemple();


        
        // Placement des îles que le bateau peut atteindre
        vBoat.setExit("portus_prima", vPortusPrima);
        vBoat.setExit("insula_templum", vInsulaTemplum);
        vBoat.setExit("crypta_marina", vCryptaMarina);
        vBoat.setExit("civitas_antiqua", vCivitasAntiqua);
        vBoat.setExit("silva_mystica", vSilvaMystica);
        vBoat.setExit("mercatus_flotilla", vMercatusFlotilla);
        vBoat.setExit("labyrinthos", vLabyrinthos);
        vBoat.setExit("sanctum_ignis", vSanctumIgnis);
        vBoat.setExit("mons_caelestis", vMonsCaelestis);
        vBoat.setExit("ultima_sapientia", vUltimaSapientia);

        // Ajout des lieux principaux aux îles
        // 1 - Portus Prima

        vPortusPrima.setExit("boat", vBoat);
        vPortusPrima.setExit("library", vLibrary1);
        vPortusPrima.setExit("tavern", vTavern1);
        vPortusPrima.setExit("hostel", vHostel1);
        vPortusPrima.setExit("sanctuary", vSanctuaryOfTheOracle1);
        vPortusPrima.setExit("seaport", vSeaPort1);

        // 2 - Insula Templum

        vInsulaTemplum.setExit("boat", vBoat);
        vInsulaTemplum.setExit("ancient_temple", vAncientTemple);


        Item vInsulaTemplumMap = new Item("insula_templum_map", 
                                       "A map of Insula Templum island", 0.2, 50);

        Door vDoorBoatInsulaTemplum = new Door(vInsulaTemplumMap, false);
        vBoat.setDoor("boat", vDoorBoatInsulaTemplum);
        vInsulaTemplum.setDoor("insula_templum", vDoorBoatInsulaTemplum);

        // 3 - Crypta Marina
        
        vCryptaMarina.setExit("boat", vBoat);

        Item vCryptaMarinaMap = new Item("crypta_marina_map", 
                                       "A map of Crypta Marina island", 0.2, 50);

        Door vDoorBoatCryptaMarina = new Door(vCryptaMarinaMap, false);
        vBoat.setDoor("crypta_marina", vDoorBoatCryptaMarina);
        vCryptaMarina.setDoor("boat", vDoorBoatCryptaMarina);

        // 4 - Civitas Antiqua

        vCivitasAntiqua.setExit("boat", vBoat);

        Item vCivitasAntiquaMap = new Item("civitas_antiqua_map", 
                                       "A map of Civitas Antiqua island", 0.2, 50);

        Door vDoorBoatCivitasAntiqua = new Door(vCivitasAntiquaMap, false);
        vBoat.setDoor("civitas_antiqua", vDoorBoatCivitasAntiqua);
        vCivitasAntiqua.setDoor("boat", vDoorBoatCivitasAntiqua);

        // 5 - Silva Mystica

        vSilvaMystica.setExit("boat", vBoat);

        Item vSilvaMysticaMap = new Item("silva_mystica_map", 
                                       "A map of Silva Mystica island", 0.2, 50);

        Door vDoorBoatSilvaMystica = new Door(vSilvaMysticaMap, false);
        vBoat.setDoor("silva_mystica", vDoorBoatSilvaMystica);
        vSilvaMystica.setDoor("boat", vDoorBoatSilvaMystica);

        // 6 - Mercatus Flotilla

        vMercatusFlotilla.setExit("boat", vBoat);

        Item vMercatusFlotillaMap = new Item("mercatus_flotilla_map", 
                                       "A map of Mercatus Flotilla island", 0.2, 50);

        Door vDoorBoatMercatusFlotilla = new Door(vMercatusFlotillaMap, false);
        vBoat.setDoor("mercatus_flotilla", vDoorBoatMercatusFlotilla);
        vMercatusFlotilla.setDoor("boat", vDoorBoatMercatusFlotilla);

        // 7 - Labyrinthos

        vLabyrinthos.setExit("boat", vBoat);

        Item vLabyrinthosMap = new Item("labyrinthos_map", 
                                       "A map of Labyrinthos island", 0.2, 50);

        Door vDoorBoatLabyrinthos = new Door(vLabyrinthosMap, false);
        vBoat.setDoor("labyrinthos", vDoorBoatLabyrinthos);
        vLabyrinthos.setDoor("boat", vDoorBoatLabyrinthos);


        // 8 - Sanctum Ignis



        // 9 - Mons Caelestis

        vMonsCaelestis.setExit("boat", vBoat);

        Item vMonsCaelestisMap = new Item("mons_caelestis_map", 
                                       "A map of Mons Caelestis island", 0.2, 50);

        Door vDoorBoatMonsCaelestis = new Door(vMonsCaelestisMap, false);
        vBoat.setDoor("mons_caelestis", vDoorBoatMonsCaelestis);
        vMonsCaelestis.setDoor("boat", vDoorBoatMonsCaelestis);

        // 10 - Ultima Sapientia

        


        
        // Pièce de départ
        return vBoat;
    } // CreateWorld()


    // Création des lieux principaux du jeu

    /**
     * Crée le bateau du jeu
     * 
     * @return La pièce du bateau
     */
    public static Room createBoat()
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

        vBoat.setExit("deck", vDeck);
        vBoat.setExit("cockpit", vCockpit);
        vBoat.setExit("galley", vGalley);
        vDeck.setExit("boat", vBoat);

        vGalley.setExit("boat", vBoat);

        vCockpit.setExit("boat", vBoat);
        vCockpit.setExit("cabin", vCabin);
        vCockpit.setExit("emergency", vEmergencyExit);

        vCabin.setExit("cockpit", vCockpit);
        vCabin.setExit("floor1", vCabinFloor1);

        vCabinFloor1.setExit("cabin", vCabin);
        vCabinFloor1.setExit("slide", vSlide);

        vSlide.setExit("down", vCabin);

        vEmergencyExit.setExit("exit", vBoat);
        
        // Créer les items
        Item vKeyCabin = new Item("key_cabin", "This key can unlock the cabin", 0.1, 10);
        Item vBed = new Item("bed", "A comfortable bed", 100, 500);
        Item vBooks = new Item("book", "Captain's book", 0.5, 15);
        Item vChair1 = new Item("chair1", "A chair", 4, 20);
        Item vChair2 = new Item("chair2", "A chair", 4.5, 25);
        Item vChair3 = new Item("chair3", "A chair", 9, 45);
        Item vCoin = new Item("silver_coin", "3 Jerries", 0.1, 3);
        Item vCookie = new Item("cookie", 
                               "A magic cookie that increases your strength", 0.1, 5);
        Item vInsulaTemplumMap = new Item("insula_templum_map", 
                                       "A map of Insula Templum island", 0.2, 50);

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

        vSlide.setItem(vInsulaTemplumMap);
        
        // Les portes
        Door vDoorCockpitCabin = new Door(vKeyCabin, false);
        vCockpit.setDoor("cabin", vDoorCockpitCabin);
        vCabin.setDoor("cockpit", vDoorCockpitCabin);
        
        // Pièce de départ
        return vBoat; 
    } // createBoat()

    /**
     * Crée la bibliothèque du jeu
     * 
     * @return La pièce de la bibliothèque
     */
    public static Room createLibrary()
    {
        // Les pièces de la bibliothèque
        Room vLibrary = new Room("in the library", "images/library/library.jpg");
        Room vCheckoutDesk = new Room("at the checkout desk", "images/library/checkout_desk.jpg");
        Room vReadingRoom = new Room("in the reading room", "images/library/reading_room.jpg");
        Room vPrivateStudyRoom = new Room("in the private study room", "images/library/private_study_room.jpg");
        Room vComputerLab = new Room("in the computer lab", "images/library/computer_lab.jpg");
        Room vRestRoom = new Room("in the rest room", "images/library/rest_room.jpg");
        Room vConferenceRoom = new Room("in the conference room", "images/library/conference_room.jpg");

        // Le placement des pièces

        vLibrary.setExit("checkout", vCheckoutDesk);

        vCheckoutDesk.setExit("library", vLibrary);
        vCheckoutDesk.setExit("restroom", vRestRoom);
        vCheckoutDesk.setExit("reading", vReadingRoom);

        vReadingRoom.setExit("checkout", vCheckoutDesk);
        vReadingRoom.setExit("privatestudy", vPrivateStudyRoom);
        vReadingRoom.setExit("computerlab", vComputerLab);
        vReadingRoom.setExit("conferenceroom", vConferenceRoom);

        vPrivateStudyRoom.setExit("reading", vReadingRoom);

        vComputerLab.setExit("reading", vReadingRoom);

        vRestRoom.setExit("checkout", vCheckoutDesk);

        vConferenceRoom.setExit("reading", vReadingRoom);

        // Créer les items
        Item vLibraryCard = new Item("library_card", "This card gives you access to the library", 0.1, 5);
        Item vLaptop = new Item("laptop", "A powerful laptop", 2, 1500);
        Item vNotebook = new Item("notebook", "A notebook for taking notes", 0.5, 20);
        Item vPen = new Item("pen", "A blue ink pen", 0.1, 2);
        Item vChair = new Item("chair", "A comfortable chair", 5, 50);
        Item vTable = new Item("table", "A wooden table", 20, 200);
        Item vProjector = new Item("projector", "A high-definition projector", 3, 800);
        Item vWhiteboard = new Item("whiteboard", "A whiteboard with markers", 10, 100);
        Item vPrinter = new Item("printer", "A color printer", 8, 300);
        Item vHeadphones = new Item("headphones", "Noise-cancelling headphones", 0.5, 150);
        Item vBook = new Item("book", "A fascinating book", 1, 30);
        Item vToilet = new Item("toilet", "A clean toilet", 50, 100);
        Item vSink = new Item("sink", "A sink with running water", 30, 80);

        // Ajouter les items aux pièces

        vLibrary.setItem(vLibraryCard);

        vComputerLab.setItem(vLaptop);
        vComputerLab.setItem(vPrinter);
        vComputerLab.setItem(vHeadphones);

        vReadingRoom.setItem(vNotebook);
        vReadingRoom.setItem(vPen);
        vReadingRoom.setItem(vChair);
        vReadingRoom.setItem(vTable);

        vConferenceRoom.setItem(vProjector);
        vConferenceRoom.setItem(vWhiteboard);

        vRestRoom.setItem(vToilet);
        vRestRoom.setItem(vSink);

        vPrivateStudyRoom.setItem(vBook);
        vPrivateStudyRoom.setItem(vChair);

        Door vDoorLibrearyCheckoutDesk = new Door(vLibraryCard, false);
        vLibrary.setDoor("checkout", vDoorLibrearyCheckoutDesk);
        vCheckoutDesk.setDoor("library", vDoorLibrearyCheckoutDesk);
        // Pièce de départ
        return vLibrary;
    } // createLibrary()

    /**
     * Crée la taverne des aventuriers
     * 
     * @return La pièce principale de la taverne
     */
    public static Room createTavern()
    {
        // Les pièces de la taverne
        Room vTavern = new Room("in the main tavern hall", "images/tavern/main_hall.jpg");
        Room vKitchen = new Room("in the tavern kitchen", "images/tavern/kitchen.jpg");
        Room vCellar = new Room("in the tavern cellar", "images/tavern/cellar.jpg");
        Room vRoom = new Room("in the tavern rooms", "images/tavern/rooms.jpg");
        Room vBackRoom = new Room("in the tavern back room", "images/tavern/back_room.jpg");
        Room vStables = new Room("in the stables", "images/tavern/stables.jpg");

        // Le placement des pièces

        vTavern.setExit("kitchen", vKitchen);
        vTavern.setExit("cellar", vCellar);
        vTavern.setExit("room", vRoom);
        vTavern.setExit("back", vBackRoom);
        vTavern.setExit("stables", vStables);

        vKitchen.setExit("main", vTavern);

        vCellar.setExit("main", vTavern);

        vRoom.setExit("main", vTavern);

        vBackRoom.setExit("main", vTavern);

        vStables.setExit("main", vTavern);

        // Créer les items
        Item vWine = new Item("wine", "A bottle of fine red wine", 0.8, 15);
        Item vWhiskey = new Item("whiskey", "A bottle of strong whiskey", 0.7, 20);
        Item vBread = new Item("bread", "Fresh bread from the tavern kitchen", 0.3, 2);
        Item vMeat = new Item("meat", "Roasted meat, hearty meal", 0.6, 8);
        Item vCheese = new Item("cheese", "Wheel of aged cheese", 1.5, 12);
        Item vTable = new Item("table", "Wooden tavern table", 8, 30);
        Item vChair = new Item("chair", "Wooden tavern chair", 3, 10);
        Item vBarrel = new Item("barrel", "Wooden barrel of ale", 20, 50);
        Item vKey = new Item("key", "Key to the back room", 0.1, 50);
        Item vCoin = new Item("gold_coin", "10 Jerries", 0.05, 10);

        // Ajouter les items aux pièces

        vTavern.setItem(vBread);
        vTavern.setItem(vChair);

        vKitchen.setItem(vMeat);
        vKitchen.setItem(vCheese);
        vKitchen.setItem(vBread);
        vKitchen.setItem(vKey);

        vCellar.setItem(vWine);
        vCellar.setItem(vWhiskey);
        vCellar.setItem(vBarrel);

        vRoom.setItem(vTable);
        vBackRoom.setItem(vCoin);

        // Les portes verrouillées
        Item vBackRoomKey = new Item("back_room_key", "Key to the back room", 0.1, 50);
        Door vDoorBackRoom = new Door(vBackRoomKey, false);
        vTavern.setDoor("back", vDoorBackRoom);
        vBackRoom.setDoor("main", vDoorBackRoom);

        // Pièce de départ
        return vTavern;
    } // createTavern()
    /**
     * Crée l'auberge du jeu
     * 
     * @return La pièce de l'auberge
     */
    public static Room createHostel()
    {
        // Les pièces de l'auberge
        Room vHostelReception = new Room("at the hostel reception", "images/hostel/reception.jpg");
        Room vCommonRoom = new Room("in the hostel common room", "images/hostel/common_room.jpg");
        Room vDormitory = new Room("in the hostel dormitory", "images/hostel/dormitory.jpg");
        Room vKitchen = new Room("in the hostel kitchen", "images/hostel/kitchen.jpg");
        Room vDiningRoom = new Room("in the hostel dining room", "images/hostel/dining_room.jpg");
        Room vLaundry = new Room("in the hostel laundry room", "images/hostel/laundry.jpg");
        Room vTerrasse = new Room("on the hostel terrace", "images/hostel/terrace.jpg");

        // Le placement des pièces

        vHostelReception.setExit("common", vCommonRoom);
        vHostelReception.setExit("dormitory", vDormitory);
        vHostelReception.setExit("kitchen", vKitchen);
        vHostelReception.setExit("dining", vDiningRoom);
        vHostelReception.setExit("laundry", vLaundry);
        vHostelReception.setExit("terrace", vTerrasse);

        vCommonRoom.setExit("reception", vHostelReception);
        vCommonRoom.setExit("terrace", vTerrasse);

        vDormitory.setExit("reception", vHostelReception);

        vKitchen.setExit("reception", vHostelReception);
        vKitchen.setExit("dining", vDiningRoom);

        vDiningRoom.setExit("reception", vHostelReception);
        vDiningRoom.setExit("kitchen", vKitchen);

        vLaundry.setExit("reception", vHostelReception);

        vTerrasse.setExit("reception", vHostelReception);
        vTerrasse.setExit("common", vCommonRoom);

        // Créer les items
        Item vBed = new Item("bed", "Comfortable hostel bed", 15, 40);
        Item vMattress = new Item("mattress", "Foam mattress", 5, 20);
        Item vPillow = new Item("pillow", "Soft pillow", 0.5, 5);
        Item vBlanket = new Item("blanket", "Warm blanket", 1, 10);
        Item vSheet = new Item("sheet", "White cotton sheet", 0.3, 5);
        Item vTowel = new Item("towel", "Fluffy towel", 0.4, 5);
        Item vChair = new Item("chair", "Wooden chair", 3, 10);
        Item vTable = new Item("table", "Wooden table", 8, 20);
        Item vSofa = new Item("sofa", "Comfortable sofa", 20, 50);
        Item vFridge = new Item("fridge", "Small refrigerator", 30, 60);
        Item vDishes = new Item("dishes", "Set of ceramic dishes", 2, 15);
        Item vFork = new Item("fork", "Metal fork", 0.1, 2);
        Item vSpoon = new Item("spoon", "Metal spoon", 0.1, 2);
        Item vKnife = new Item("knife", "Kitchen knife", 0.2, 5);
        Item vSoap = new Item("soap", "Bar of soap", 0.1, 3);
        Item vShampoo = new Item("shampoo", "Bottle of shampoo", 0.3, 5);
        Item vToothbrush = new Item("toothbrush", "Toothbrush", 0.05, 2);
        Item vGuestBook = new Item("guest_book", "Hostel guest book", 0.5, 15);
        Item vMap = new Item("city_map", "Map of the city", 0.2, 10);
        Item vKey = new Item("room_key", "Room key", 0.05, 1);

        // Ajouter les items aux pièces

        vHostelReception.setItem(vGuestBook);
        vHostelReception.setItem(vMap);
        vHostelReception.setItem(vKey);

        vCommonRoom.setItem(vSofa);
        vCommonRoom.setItem(vChair);
        vCommonRoom.setItem(vTable);

        vDormitory.setItem(vBed);
        vDormitory.setItem(vMattress);
        vDormitory.setItem(vPillow);
        vDormitory.setItem(vBlanket);
        vDormitory.setItem(vSheet);

        vKitchen.setItem(vFridge);
        vKitchen.setItem(vDishes);
        vKitchen.setItem(vFork);
        vKitchen.setItem(vSpoon);
        vKitchen.setItem(vKnife);

        vDiningRoom.setItem(vTable);
        vDiningRoom.setItem(vChair);

        vLaundry.setItem(vTowel);
        vLaundry.setItem(vSoap);
        vLaundry.setItem(vShampoo);
        vLaundry.setItem(vToothbrush);

        vTerrasse.setItem(vChair);
        vTerrasse.setItem(vTable);

        // Pièce de départ
        return vHostelReception;
    } // createHostel()

    /**
     * Crée le sanctuaire de l'oracle du jeu
     * 
     * @return La pièce d'entrée du sanctuaire
     */
    public static Room createSanctuaryOfTheOracle()
    {
        // Les pièces du sanctuaire
        Room vSanctuaryEntrance = new Room("at the sanctuary entrance", "images/sanctuary/entrance.jpg");
        Room vHall = new Room("in the sanctuary hall", "images/sanctuary/hall.jpg");
        Room vPrayerRoom = new Room("in the prayer room", "images/sanctuary/prayer_room.jpg");
        Room vOracleRoom = new Room("in the oracle's chamber", "images/sanctuary/oracle_room.jpg");
        Room vLibrary = new Room("in the sanctuary library", "images/sanctuary/library.jpg");
        Room vTreasury = new Room("in the sanctuary treasury", "images/sanctuary/treasury.jpg");
        Room vGarden = new Room("in the sacred garden", "images/sanctuary/garden.jpg");

        // Le placement des pièces

        vSanctuaryEntrance.setExit("hall", vHall);
        vSanctuaryEntrance.setExit("garden", vGarden);

        vHall.setExit("entrance", vSanctuaryEntrance);
        vHall.setExit("prayer", vPrayerRoom);
        vHall.setExit("oracle", vOracleRoom);
        vHall.setExit("library", vLibrary);
        vHall.setExit("treasury", vTreasury);

        vPrayerRoom.setExit("hall", vHall);

        vOracleRoom.setExit("hall", vHall);

        vLibrary.setExit("hall", vHall);

        vTreasury.setExit("hall", vHall);

        vGarden.setExit("entrance", vSanctuaryEntrance);

        // Créer les items
        Item vCrystalBall = new Item("crystal_ball", "Mystical crystal ball for divination", 2, 200);
        Item vIncense = new Item("incense", "Sacred incense sticks", 0.1, 10);
        Item vCandle = new Item("candle", "White ceremonial candle", 0.2, 5);
        Item vPrayerBook = new Item("prayer_book", "Ancient book of prayers", 0.8, 50);
        Item vHolyWater = new Item("holy_water", "Blessed water in a vial", 0.3, 30);
        Item vRobe = new Item("oracle_robe", "White oracle's ceremonial robe", 1.5, 100);
        Item vScroll = new Item("prophecy_scroll", "Ancient scroll with prophecies", 0.2, 150);
        Item vGrimoire = new Item("grimoire", "Dark magic grimoire", 1, 300);
        Item vTarot = new Item("tarot_cards", "Mystical tarot deck", 0.3, 75);
        Item vStatue = new Item("statue", "Golden statue of a deity", 15, 500);
        Item vGoldCoin = new Item("ancient_coin", "Ancient gold coin, 50 Jerries", 0.05, 50);
        Item vJewel = new Item("jewel", "Precious gemstone", 0.1, 400);
        Item vCrown = new Item("crown", "Sacred crown of the oracle", 2, 1000);
        Item vHerb = new Item("healing_herb", "Rare healing herb", 0.1, 60);
        Item vFlower = new Item("sacred_flower", "Mystical glowing flower", 0.1, 80);

        // Ajouter les items aux pièces

        vSanctuaryEntrance.setItem(vIncense);
        vSanctuaryEntrance.setItem(vCandle);

        vHall.setItem(vStatue);
        vHall.setItem(vCandle);

        vPrayerRoom.setItem(vPrayerBook);
        vPrayerRoom.setItem(vHolyWater);

        vOracleRoom.setItem(vCrystalBall);
        vOracleRoom.setItem(vRobe);
        vOracleRoom.setItem(vScroll);
        vOracleRoom.setItem(vTarot);

        vLibrary.setItem(vGrimoire);
        vLibrary.setItem(vPrayerBook);
        vLibrary.setItem(vScroll);

        vTreasury.setItem(vGoldCoin);
        vTreasury.setItem(vJewel);
        vTreasury.setItem(vCrown);

        vGarden.setItem(vHerb);
        vGarden.setItem(vFlower);

        // Les portes verrouillées
        Item vTreasuryKey = new Item("treasury_key", "Key to the treasury", 0.1, 100);
        vLibrary.setItem(vTreasuryKey);
        Door vDoorTreasury = new Door(vTreasuryKey, false);
        vHall.setDoor("treasury", vDoorTreasury);
        vTreasury.setDoor("hall", vDoorTreasury);

        // Pièce de départ
        return vSanctuaryEntrance;
    } // createSanctuaryOfTheOraclel()

    /**
     * Crée le port maritime
     * 
     * @return La pièce d'entrée du port
     */
    public static Room createSeaPort()
    {
        // Les pièces du port
        Room vPortEntrance = new Room("at the port entrance", "images/port/entrance.jpg");
        Room vHarbor = new Room("at the harbor", "images/port/harbor.jpg");
        Room vDocks = new Room("on the docks", "images/port/docks.jpg");
        Room vWarehouse = new Room("in the warehouse", "images/port/warehouse.jpg");
        Room vShipyard = new Room("in the shipyard", "images/port/shipyard.jpg");
        Room vCustomsOffice = new Room("in the customs office", "images/port/customs.jpg");
        Room vMarket = new Room("at the fish market", "images/port/market.jpg");
        Room vLighthouse = new Room("in the lighthouse", "images/port/lighthouse.jpg");

        // Le placement des pièces
        vPortEntrance.setExit("harbor", vHarbor);
        vPortEntrance.setExit("market", vMarket);
        vPortEntrance.setExit("customs", vCustomsOffice);

        vHarbor.setExit("entrance", vPortEntrance);
        vHarbor.setExit("docks", vDocks);
        vHarbor.setExit("lighthouse", vLighthouse);

        vDocks.setExit("harbor", vHarbor);
        vDocks.setExit("warehouse", vWarehouse);
        vDocks.setExit("shipyard", vShipyard);

        vWarehouse.setExit("docks", vDocks);

        vShipyard.setExit("docks", vDocks);

        vCustomsOffice.setExit("entrance", vPortEntrance);

        vMarket.setExit("entrance", vPortEntrance);

        vLighthouse.setExit("harbor", vHarbor);

        // Créer les items
        Item vRope = new Item("rope", "Strong nautical rope", 2, 15);
        Item vAnchor = new Item("anchor", "Heavy ship anchor", 50, 80);
        Item vNet = new Item("fishing_net", "Large fishing net", 3, 25);
        Item vCompass = new Item("compass", "Navigation compass", 0.3, 50);
        Item vMap = new Item("sea_map", "Maritime navigation map", 0.2, 40);
        Item vFish = new Item("fish", "Fresh caught fish", 0.5, 5);
        Item vShrimp = new Item("shrimp", "Fresh shrimp", 0.3, 8);
        Item vOyster = new Item("oyster", "Fresh oysters", 0.2, 10);
        Item vCoin = new Item("coin", "20 Jerries", 0.05, 20);
        Item vGold = new Item("gold_bar", "Small gold bar", 1, 500);
        Item vSpice = new Item("spice", "Exotic spices", 0.5, 60);
        Item vSilk = new Item("silk", "Fine silk fabric", 1, 150);
        Item vTool = new Item("hammer", "Shipbuilding hammer", 2, 25);
        Item vNail = new Item("nails", "Iron nails", 1, 10);
        Item vKey = new Item("warehouse_key", "Key to the warehouse", 0.1, 50);

        // Ajouter les items aux pièces
        vHarbor.setItem(vRope);
        vHarbor.setItem(vNet);

        vDocks.setItem(vAnchor);

        vWarehouse.setItem(vSpice);
        vWarehouse.setItem(vSilk);
        vWarehouse.setItem(vGold);

        vShipyard.setItem(vTool);
        vShipyard.setItem(vNail);

        vCustomsOffice.setItem(vMap);
        vCustomsOffice.setItem(vCoin);
        vCustomsOffice.setItem(vKey);

        vMarket.setItem(vFish);
        vMarket.setItem(vShrimp);
        vMarket.setItem(vOyster);

        vLighthouse.setItem(vCompass);

        // Les portes verrouillées
        Item vWarehouseKey = new Item("warehouse_key", "Key to the warehouse", 0.1, 50);
        vCustomsOffice.setItem(vWarehouseKey);
        Door vDoorWarehouse = new Door(vWarehouseKey, false);
        vDocks.setDoor("warehouse", vDoorWarehouse);
        vWarehouse.setDoor("docks", vDoorWarehouse);

        // Pièce de départ
        return vPortEntrance;
    } // createSeaPort()

    /**
     * Crée le temple antique
     * 
     * @return La pièce d'entrée du temple antique
     */
    public static Room createAncientTemple()
    {
        // Les pièces du temple
        Room vTempleEntrance = new Room("at the ancient temple entrance", "images/temple/entrance.jpg");
        Room vHall = new Room("in the temple hall", "images/temple/hall.jpg");
        Room vShrine = new Room("at the temple shrine", "images/temple/shrine.jpg");
        Room vChapel = new Room("in the temple chapel", "images/temple/chapel.jpg");
        Room vTreasury = new Room("in the temple treasury", "images/temple/treasury.jpg");
        Room vLibrary = new Room("in the temple library", "images/temple/library.jpg");
        Room vPriestChamber = new Room("in the priest's chamber", "images/temple/priest_chamber.jpg");
        Room vGarden = new Room("in the temple garden", "images/temple/garden.jpg");

        // Le placement des pièces
        vTempleEntrance.setExit("hall", vHall);
        vTempleEntrance.setExit("garden", vGarden);

        vHall.setExit("entrance", vTempleEntrance);
        vHall.setExit("shrine", vShrine);
        vHall.setExit("chapel", vChapel);
        vHall.setExit("treasury", vTreasury);
        vHall.setExit("library", vLibrary);
        vHall.setExit("priest", vPriestChamber);

        vShrine.setExit("hall", vHall);

        vChapel.setExit("hall", vHall);

        vTreasury.setExit("hall", vHall);

        vLibrary.setExit("hall", vHall);

        vPriestChamber.setExit("hall", vHall);

        vGarden.setExit("entrance", vTempleEntrance);

        // Créer les items
        Item vStatue = new Item("stone_statue", "Ancient statue of a deity", 30, 300);
        Item vCandle = new Item("candle", "Ceremonial candle", 0.2, 5);
        Item vIncense = new Item("incense", "Sacred temple incense", 0.1, 10);
        Item vHolyBook = new Item("holy_book", "Ancient holy scripture", 1, 150);
        Item vScroll = new Item("ancient_scroll", "Ancient sacred scroll", 0.2, 200);
        Item vCross = new Item("cross", "Silver temple cross", 0.5, 250);
        Item vAmulet = new Item("amulet", "Protective temple amulet", 0.1, 300);
        Item vJewel = new Item("jewel", "Precious temple jewel", 0.15, 500);
        Item vGoldCoin = new Item("gold_coin", "Ancient gold coin, 100 Jerries", 0.05, 100);
        Item vGoldBar = new Item("gold_bar", "Temple gold bar", 2, 1000);
        Item vDiamonds = new Item("diamonds", "Ancient diamonds", 0.2, 800);
        Item vGrimoire = new Item("grimoire", "Sacred grimoire", 1.5, 400);
        Item vManuscript = new Item("manuscript", "Ancient manuscript", 0.5, 250);
        Item vLotusFlower = new Item("lotus_flower", "Sacred lotus flower", 0.1, 120);
        Item vSacredHerb = new Item("sacred_herb", "Mystical healing herb", 0.1, 100);

        // Ajouter les items aux pièces
        vTempleEntrance.setItem(vCandle);
        vTempleEntrance.setItem(vIncense);

        vHall.setItem(vStatue);
        vHall.setItem(vCandle);

        vShrine.setItem(vCross);
        vChapel.setItem(vHolyBook);
        vChapel.setItem(vCandle);
        vChapel.setItem(vAmulet);

        vTreasury.setItem(vJewel);
        vTreasury.setItem(vGoldBar);
        vTreasury.setItem(vDiamonds);
        vTreasury.setItem(vGoldCoin);

        vLibrary.setItem(vScroll);
        vLibrary.setItem(vGrimoire);
        vLibrary.setItem(vManuscript);

        vPriestChamber.setItem(vHolyBook);

        vGarden.setItem(vLotusFlower);
        vGarden.setItem(vSacredHerb);

        // Les portes verrouillées
        Item vTreasuryKey = new Item("treasury_key", "Key to the temple treasury", 0.1, 200);
        vLibrary.setItem(vTreasuryKey);
        Door vDoorTreasury = new Door(vTreasuryKey, false);
        vHall.setDoor("treasury", vDoorTreasury);
        vTreasury.setDoor("hall", vDoorTreasury);

        // Pièce de départ
        return vTempleEntrance;
    } // createAncientTemple()













    // Création des vraies/fausses stèles directrices

    /**
     * Crée la stèle directrice de Insula Templum (1er énigme)
     * Permet de débloquer la carte de l'île de Crypta Marina (vCryptaMarinaMap)
     * 
     * @return La stèle directrice
     */
    public static Room createGuideStone2()
    {
        Room vGuideStone2 = new Room("at the guide stone of Insula Templum", "images/guide_stone/guide_stone_2.jpg");
        Room vGuideStone2Solved = new Room("in the exit of the guide stone", "images/guide_stone/guide_stone_2_solved.jpg");

        // Les énigmes de la stèle
        Room vEnigme1 = new Room("at the first enigma of the guide stone", "images/guide_stone/enigma_1.jpg");
        Room vEnigme1Answer1 = new Room("having solved the first enigma of the guide stone", "images/guide_stone/enigma_1_solved.jpg");
        Room vEnigme1Answer2 = new Room("having solved the second enigma of the guide stone", "images/guide_stone/enigma_2_solved.jpg");
        Room vEnigme1Answer3 = new Room("having solved the third enigma of the guide stone", "images/guide_stone/enigma_3_solved.jpg");
        Room vEnigme1Answer4 = new Room("having solved the fourth enigma of the guide stone", "images/guide_stone/enigma_4_solved.jpg");

        Room vEnigme2 = new Room("at the second enigma of the guide stone", "images/guide_stone/enigma_2.jpg");
        Room vEnigme2Answer1 = new Room("having solved the first enigma of the guide stone", "images/guide_stone/enigma_1_solved.jpg");
        Room vEnigme2Answer2 = new Room("having solved the second enigma of the guide stone", "images/guide_stone/enigma_2_solved.jpg");
        Room vEnigme2Answer3 = new Room("having solved the third enigma of the guide stone", "images/guide_stone/enigma_3_solved.jpg");
        Room vEnigme2Answer4 = new Room("having solved the fourth enigma of the guide stone", "images/guide_stone/enigma_4_solved.jpg");

        Room vEnigme3 = new Room("at the third enigma of the guide stone", "images/guide_stone/enigma_3.jpg");
        Room vEnigme3Answer1 = new Room("having solved the first enigma of the guide stone", "images/guide_stone/enigma_1_solved.jpg");
        Room vEnigme3Answer2 = new Room("having solved the second enigma of the guide stone", "images/guide_stone/enigma_2_solved.jpg");
        Room vEnigme3Answer3 = new Room("having solved the third enigma of the guide stone", "images/guide_stone/enigma_3_solved.jpg");
        Room vEnigme3Answer4 = new Room("having solved the fourth enigma of the guide stone", "images/guide_stone/enigma_4_solved.jpg");

        Room vEnigme4 = new Room("at the fourth enigma of the guide stone", "images/guide_stone/enigma_4.jpg");
        Room vEnigme4Answer1 = new Room("having solved the first enigma of the guide stone", "images/guide_stone/enigma_1_solved.jpg");
        Room vEnigme4Answer2 = new Room("having solved the second enigma of the guide stone", "images/guide_stone/enigma_2_solved.jpg");
        Room vEnigme4Answer3 = new Room("having solved the third enigma of the guide stone", "images/guide_stone/enigma_3_solved.jpg");
        Room vEnigme4Answer4 = new Room("having solved the fourth enigma of the guide stone", "images/guide_stone/enigma_4_solved.jpg");


        // Le placement des pièces

        vGuideStone2.setExit("enigma1", vEnigme1);
        vEnigme1.setExit("answer1", vEnigme1Answer1);
        vEnigme1.setExit("answer2", vEnigme1Answer2);
        vEnigme1.setExit("answer3", vEnigme1Answer3); 
        vEnigme1.setExit("answer4", vEnigme1Answer4);
        vEnigme1Answer2.setExit("enigma2", vEnigme2);

        vEnigme2.setExit("answer1", vEnigme2Answer1);
        vEnigme2.setExit("answer2", vEnigme2Answer2);
        vEnigme2.setExit("answer3", vEnigme2Answer3);
        vEnigme2.setExit("answer4", vEnigme2Answer4);
        vEnigme2Answer3.setExit("enigma3", vEnigme3);

        vEnigme3.setExit("answer1", vEnigme3Answer1);
        vEnigme3.setExit("answer2", vEnigme3Answer2);
        vEnigme3.setExit("answer3", vEnigme3Answer3);
        vEnigme3.setExit("answer4", vEnigme3Answer4);
        vEnigme3Answer3.setExit("enigma4", vEnigme4);

        vEnigme4.setExit("answer1", vEnigme4Answer1);
        vEnigme4.setExit("answer2", vEnigme4Answer2);
        vEnigme4.setExit("answer3", vEnigme4Answer3);
        vEnigme4.setExit("answer4", vEnigme4Answer4);
        vEnigme4Answer4.setExit("exit", vGuideStone2Solved);

        // L'item récompense de la stèle
        Item vCryptaMarinaMap = new Item("crypta_marina_map", 
                                       "A map of Crypta Marina island", 0.2, 50);

        vGuideStone2.setItem(vCryptaMarinaMap);

        // Pièce de départ
        return vGuideStone2;
    }

} // GameWorld.java