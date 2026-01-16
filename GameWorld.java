
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
        Room vPortusPrima = new Room("at Portus Prima island", "images/island/1-portus-prima.png");
        Room vInsulaTemplum  = new Room("at Insula Templum island", "images/island/2-insula-templum.png");
        Room vCryptaMarina = new Room("at Crypta Marina island", "images/island/3-cripta-marina.png");
        Room vCivitasAntiqua = new Room("at Civitas Antiqua island", "images/island/4-civitas-antiqua.png");
        Room vSilvaMystica = new Room("in the Silva Mystica island", "images/island/5-silva-mystica.png");
        Room vMercatusFlotilla = new Room("at Mercatus Flotilla island", "images/island/6-mercatus-flotilla.png");
        Room vLabyrinthos = new Room("in the Labyrinthos island", "images/island/7-labyrinthos.png");
        Room vSanctumIgnis = new Room("in the Sanctum Ignis cave", "images/island/8-sanctum-ignis.png");
        Room vMonsCaelestis = new Room("at Mons Caelestis mountain", "images/island/9-mons-caelestis.png");
        Room vUltimaSapientia = new Room("in the Ultima Sapientia temple", "images/island/10-ultima-sapientia.png");

        // Création des lieux principaux du jeu
        // 1 - Portus Prima
        Room vLibrary1 = createLibrary();
        Room vTavern1 = createTavern();
        Room vHostel1 = createHostel();
        Room vSanctuaryOfTheOracle1 = createSanctuaryOfTheOracle();
        Room vSeaPort1 = createSeaPort();
        // 2 - Insula Templum
        Room[] vAncientTempleRooms = createAncientTemple();
        Room vTempleEntrance = vAncientTempleRooms[0];
        Room vTreasuryAncientTemple = vAncientTempleRooms[1];
        Room vSeaPort2 = createSeaPort();
        // 3 - Crypta Marina
        Room vSeaPort3 = createSeaPort();
        Room vSanctuaryOfTheOracle3 = createSanctuaryOfTheOracle();
        Room vTavern3 = createTavern();
        // 4 - Civitas Antiqua
        Room vSeaPort4 = createSeaPort();
        Room vRuinedPalaceRooms[] = createRuinedPalace();
        Room vRuinedPalace = vRuinedPalaceRooms[0];
        Room vTreasuryRuinedPalace = vRuinedPalaceRooms[1];
        // 5 - Silva Mystica
        Room vSeaPort5 = createSeaPort();
        Room vSanctuaryOfTheOracle5 = createSanctuaryOfTheOracle();
        Room vTavern5 = createTavern();
        // 6 - Mercatus Flotilla
        Room vSeaPort6 = createSeaPort();
        Room vHostel6 = createHostel();
        Room vTavern6 = createTavern();
        Room vLibrary6 = createLibrary();
        // 7 - Labyrinthos
        Room vSeaPort7 = createSeaPort();
        Room vTavern7 = createTavern();
        Room[] vCaveRooms = createCave();
        Room vCave = vCaveRooms[0];
        Room vNarrowPassage = vCaveRooms[1];
        Room vLostHole = new Room("in the lost hole, you can't go up !", "");
        // 8 - Sanctum Ignis
        Room[] vUndergroundTempleRooms = createUndergroundTemple();
        Room vUndergroundTemple = vUndergroundTempleRooms[0];
        Room vTreasureVaultUndergroundTemple = vUndergroundTempleRooms[1];
        // 9 - Mons Caelestis
        Room vSeaPort9 = createSeaPort();
        Room[] vAncientObservatoryRooms = createAncientObservatory();
        Room vAncientObservatory = vAncientObservatoryRooms[0];
        Room vTelescopeRoom = vAncientObservatoryRooms[1];
        Room[] vSacredMontainRooms = createSacredMontain();
        Room vSacredMontain = vSacredMontainRooms[0];
        Room vWaterfall = vSacredMontainRooms[1];
        // 10 - Ultima Sapientia
        Room vSapientiaTemple = createSapientiaTemple();



        
        Room vGuideStone2 = new Room("at the guide stone of Insula Templum", "images/guide_stone/guide_stone_2.jpg");
        Room vGuideStone2Solved = new Room("in the exit of the guide stone", "images/guide_stone/guide_stone_2_solved.jpg");

        // Les énigmes de la stèle 2
        // Énigme 1
        Room vGuide2Enigme1 = new Room("Enigma 1", "images/guide_stone/enigma_1.jpg");
        Room vGuide2Enigme1Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide2Enigme1Answer2 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_1_solved.jpg");
        Room vGuide2Enigme1Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide2Enigme1Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        // Énigme 2
        Room vGuide2Enigme2 = new Room("Enigma 2", "images/guide_stone/enigma_2.jpg");
        Room vGuide2Enigme2Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide2Enigme2Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide2Enigme2Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_2_solved.jpg");
        Room vGuide2Enigme2Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");

        // Énigme 3
        Room vGuide2Enigme3 = new Room("Enigma 3", "images/guide_stone/enigma_3.jpg");
        Room vGuide2Enigme3Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide2Enigme3Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide2Enigme3Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_3_solved.jpg");
        Room vGuide2Enigme3Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");

        // Énigme 4
        Room vGuide2Enigme4 = new Room("Enigma 4", "images/guide_stone/enigma_4.jpg");
        Room vGuide2Enigme4Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide2Enigme4Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide2Enigme4Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide2Enigme4Answer4 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_4_solved.jpg");

        // Le placement des pièces
        vGuideStone2.setExit("enigma1", vGuide2Enigme1);
        vGuide2Enigme1.setExit("answer1", vGuide2Enigme1Answer1);
        vGuide2Enigme1.setExit("answer2", vGuide2Enigme1Answer2);
        vGuide2Enigme1.setExit("answer3", vGuide2Enigme1Answer3);
        vGuide2Enigme1.setExit("answer4", vGuide2Enigme1Answer4);
        vGuide2Enigme1Answer1.setExit("enigma1", vGuide2Enigme1);
        vGuide2Enigme1Answer3.setExit("enigma1", vGuide2Enigme1);
        vGuide2Enigme1Answer4.setExit("enigma1", vGuide2Enigme1);
        vGuide2Enigme1Answer2.setExit("enigma2", vGuide2Enigme2);

        vGuide2Enigme2.setExit("answer1", vGuide2Enigme2Answer1);
        vGuide2Enigme2.setExit("answer2", vGuide2Enigme2Answer2);
        vGuide2Enigme2.setExit("answer3", vGuide2Enigme2Answer3);
        vGuide2Enigme2.setExit("answer4", vGuide2Enigme2Answer4);
        vGuide2Enigme2Answer1.setExit("enigma2", vGuide2Enigme2);
        vGuide2Enigme2Answer2.setExit("enigma2", vGuide2Enigme2);
        vGuide2Enigme2Answer4.setExit("enigma2", vGuide2Enigme2);
        vGuide2Enigme2Answer3.setExit("enigma3", vGuide2Enigme3);

        vGuide2Enigme3.setExit("answer1", vGuide2Enigme3Answer1);
        vGuide2Enigme3.setExit("answer2", vGuide2Enigme3Answer2);
        vGuide2Enigme3.setExit("answer3", vGuide2Enigme3Answer3);
        vGuide2Enigme3.setExit("answer4", vGuide2Enigme3Answer4);
        vGuide2Enigme3Answer1.setExit("enigma3", vGuide2Enigme3);
        vGuide2Enigme3Answer2.setExit("enigma3", vGuide2Enigme3);
        vGuide2Enigme3Answer4.setExit("enigma3", vGuide2Enigme3);
        vGuide2Enigme3Answer3.setExit("enigma4", vGuide2Enigme4);

        vGuide2Enigme4.setExit("answer1", vGuide2Enigme4Answer1);
        vGuide2Enigme4.setExit("answer2", vGuide2Enigme4Answer2);
        vGuide2Enigme4.setExit("answer3", vGuide2Enigme4Answer3);
        vGuide2Enigme4.setExit("answer4", vGuide2Enigme4Answer4);
        vGuide2Enigme4Answer1.setExit("enigma4", vGuide2Enigme4);
        vGuide2Enigme4Answer2.setExit("enigma4", vGuide2Enigme4);
        vGuide2Enigme4Answer3.setExit("enigma4", vGuide2Enigme4);
        vGuide2Enigme4Answer4.setExit("exit", vGuideStone2Solved);
        // L'item récompense de la stèle
        Item vCryptaMarinaMap = new Item("crypta_marina_map", 
                                    "A map of Crypta Marina island", 0.2, 50);

        vGuideStone2Solved.setItem(vCryptaMarinaMap);


        // Les énigmes de la stèle 3

        Room vFakeGuideStone3 = new Room("at the fake guide stone of Crypta Marina", "images/guide_stone/fake_guide_stone_3.jpg");
        Room vFakeGuideStone3Solved = new Room("in the exit of the fake guide stone - No reward here!", "images/guide_stone/fake_guide_stone_3_solved.jpg");

        // Les énigmes de la stèle
        // Énigme 1
        Room vGuide3Enigme1 = new Room("Enigma 1", "images/guide_stone/enigma_1.jpg");
        Room vGuide3Enigme1Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide3Enigme1Answer2 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_1_solved.jpg");
        Room vGuide3Enigme1Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide3Enigme1Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        // Énigme 2
        Room vGuide3Enigme2 = new Room("Enigma 2", "images/guide_stone/enigma_2.jpg");
        Room vGuide3Enigme2Answer1 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_2_solved.jpg");
        Room vGuide3Enigme2Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide3Enigme2Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide3Enigme2Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");

        // Énigme 3
        Room vGuide3Enigme3 = new Room("Enigma 3", "images/guide_stone/enigma_3.jpg");
        Room vGuide3Enigme3Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide3Enigme3Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide3Enigme3Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide3Enigme3Answer4 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_3_solved.jpg");

        // Énigme 4
        Room vGuide3Enigme4 = new Room("Enigma 4", "images/guide_stone/enigma_4.jpg");
        Room vGuide3Enigme4Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide3Enigme4Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide3Enigme4Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_4_solved.jpg");
        Room vGuide3Enigme4Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");

        // Le placement des pièces
        vFakeGuideStone3.setExit("enigma1", vGuide3Enigme1);
        vGuide3Enigme1.setExit("answer1", vGuide3Enigme1Answer1);
        vGuide3Enigme1.setExit("answer2", vGuide3Enigme1Answer2);
        vGuide3Enigme1.setExit("answer3", vGuide3Enigme1Answer3);
        vGuide3Enigme1.setExit("answer4", vGuide3Enigme1Answer4);
        vGuide3Enigme1Answer1.setExit("enigma1", vGuide3Enigme1);
        vGuide3Enigme1Answer3.setExit("enigma1", vGuide3Enigme1);
        vGuide3Enigme1Answer4.setExit("enigma1", vGuide3Enigme1);
        vGuide3Enigme1Answer2.setExit("enigma2", vGuide3Enigme2);

        vGuide3Enigme2.setExit("answer1", vGuide3Enigme2Answer1);
        vGuide3Enigme2.setExit("answer2", vGuide3Enigme2Answer2);
        vGuide3Enigme2.setExit("answer3", vGuide3Enigme2Answer3);
        vGuide3Enigme2.setExit("answer4", vGuide3Enigme2Answer4);
        vGuide3Enigme2Answer2.setExit("enigma2", vGuide3Enigme2);
        vGuide3Enigme2Answer3.setExit("enigma2", vGuide3Enigme2);
        vGuide3Enigme2Answer4.setExit("enigma2", vGuide3Enigme2);
        vGuide3Enigme2Answer1.setExit("enigma3", vGuide3Enigme3);

        vGuide3Enigme3.setExit("answer1", vGuide3Enigme3Answer1);
        vGuide3Enigme3.setExit("answer2", vGuide3Enigme3Answer2);
        vGuide3Enigme3.setExit("answer3", vGuide3Enigme3Answer3);
        vGuide3Enigme3.setExit("answer4", vGuide3Enigme3Answer4);
        vGuide3Enigme3Answer1.setExit("enigma3", vGuide3Enigme3);
        vGuide3Enigme3Answer2.setExit("enigma3", vGuide3Enigme3);
        vGuide3Enigme3Answer3.setExit("enigma3", vGuide3Enigme3);
        vGuide3Enigme3Answer4.setExit("enigma4", vGuide3Enigme4);

        vGuide3Enigme4.setExit("answer1", vGuide3Enigme4Answer1);
        vGuide3Enigme4.setExit("answer2", vGuide3Enigme4Answer2);
        vGuide3Enigme4.setExit("answer3", vGuide3Enigme4Answer3);
        vGuide3Enigme4.setExit("answer4", vGuide3Enigme4Answer4);
        vGuide3Enigme4Answer1.setExit("enigma4", vGuide3Enigme4);
        vGuide3Enigme4Answer2.setExit("enigma4", vGuide3Enigme4);
        vGuide3Enigme4Answer4.setExit("enigma4", vGuide3Enigme4);
        vGuide3Enigme4Answer3.setExit("exit", vFakeGuideStone3Solved);

        // L'item récompense de la stèle
        Item vCivitasAntiquaMap = new Item("civitas_antiqua_map",
                                    "A map of Civitas Antiqua island", 0.2, 50);

        vFakeGuideStone3Solved.setItem(vCivitasAntiquaMap);


        Room vGuideStone4 = new Room("at the guide stone of Civitas Antiqua", "images/guide_stone/guide_stone_4.jpg");
        Room vGuideStone4Solved = new Room("in the exit of the guide stone - Congratulations!", "images/guide_stone/guide_stone_4_solved.jpg");

        // Les énigmes de la stèle
        // Énigme 1
        Room vGuide4Enigme1 = new Room("Enigma 1", "images/guide_stone/enigma_1.jpg");
        Room vGuide4Enigme1Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide4Enigme1Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide4Enigme1Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide4Enigme1Answer4 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_1_solved.jpg");
        // Énigme 2
        Room vGuide4Enigme2 = new Room("Enigma 2", "images/guide_stone/enigma_2.jpg");
        Room vGuide4Enigme2Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide4Enigme2Answer2 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_2_solved.jpg");
        Room vGuide4Enigme2Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide4Enigme2Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        // Énigme 3
        Room vGuide4Enigme3 = new Room("Enigma 3", "images/guide_stone/enigma_3.jpg");
        Room vGuide4Enigme3Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide4Enigme3Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide4Enigme3Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_3_solved.jpg");
        Room vGuide4Enigme3Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");

        // Énigme 4
        Room vGuide4Enigme4 = new Room("Enigma 4", "images/guide_stone/enigma_4.jpg");
        Room vGuide4Enigme4Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide4Enigme4Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide4Enigme4Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide4Enigme4Answer4 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_4_solved.jpg");

        // Le placement des pièces
        vGuideStone4.setExit("enigma1", vGuide4Enigme1);
        vGuide4Enigme1.setExit("answer1", vGuide4Enigme1Answer1);
        vGuide4Enigme1.setExit("answer2", vGuide4Enigme1Answer2);
        vGuide4Enigme1.setExit("answer3", vGuide4Enigme1Answer3);
        vGuide4Enigme1.setExit("answer4", vGuide4Enigme1Answer4);
        vGuide4Enigme1Answer1.setExit("enigma1", vGuide4Enigme1);
        vGuide4Enigme1Answer2.setExit("enigma1", vGuide4Enigme1);
        vGuide4Enigme1Answer3.setExit("enigma1", vGuide4Enigme1);
        vGuide4Enigme1Answer4.setExit("enigma2", vGuide4Enigme2);

        vGuide4Enigme2.setExit("answer1", vGuide4Enigme2Answer1);
        vGuide4Enigme2.setExit("answer2", vGuide4Enigme2Answer2);
        vGuide4Enigme2.setExit("answer3", vGuide4Enigme2Answer3);
        vGuide4Enigme2.setExit("answer4", vGuide4Enigme2Answer4);
        vGuide4Enigme2Answer1.setExit("enigma2", vGuide4Enigme2);
        vGuide4Enigme2Answer3.setExit("enigma2", vGuide4Enigme2);
        vGuide4Enigme2Answer4.setExit("enigma2", vGuide4Enigme2);
        vGuide4Enigme2Answer2.setExit("enigma3", vGuide4Enigme3);

        vGuide4Enigme3.setExit("answer1", vGuide4Enigme3Answer1);
        vGuide4Enigme3.setExit("answer2", vGuide4Enigme3Answer2);
        vGuide4Enigme3.setExit("answer3", vGuide4Enigme3Answer3);
        vGuide4Enigme3.setExit("answer4", vGuide4Enigme3Answer4);
        vGuide4Enigme3Answer1.setExit("enigma3", vGuide4Enigme3);
        vGuide4Enigme3Answer2.setExit("enigma3", vGuide4Enigme3);
        vGuide4Enigme3Answer4.setExit("enigma3", vGuide4Enigme3);
        vGuide4Enigme3Answer3.setExit("enigma4", vGuide4Enigme4);

        vGuide4Enigme4.setExit("answer1", vGuide4Enigme4Answer1);
        vGuide4Enigme4.setExit("answer2", vGuide4Enigme4Answer2);
        vGuide4Enigme4.setExit("answer3", vGuide4Enigme4Answer3);
        vGuide4Enigme4.setExit("answer4", vGuide4Enigme4Answer4);
        vGuide4Enigme4Answer1.setExit("enigma4", vGuide4Enigme4);
        vGuide4Enigme4Answer2.setExit("enigma4", vGuide4Enigme4);
        vGuide4Enigme4Answer3.setExit("enigma4", vGuide4Enigme4);
        vGuide4Enigme4Answer4.setExit("exit", vGuideStone4Solved);

        // L'item récompense de la stèle
        Item vSilvaMysticaMap = new Item("silva_mystica_map", 
                                    "A map of Silva Mystica island", 0.2, 50);

        vGuideStone4Solved.setItem(vSilvaMysticaMap);


        Room vFakeGuideStone5 = new Room("at the fake guide stone of Silva Mystica", "images/guide_stone/fake_guide_stone_5.jpg");
        Room vFakeGuideStone5Solved = new Room("in the exit of the fake guide stone - Congratulations!", "images/guide_stone/fake_guide_stone_5_solved.jpg");

        // Les énigmes de la stèle
        // Énigme 1
        Room vGuide5Enigme1 = new Room("Enigma 1", "images/guide_stone/enigma_1.jpg");
        Room vGuide5Enigme1Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide5Enigme1Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide5Enigme1Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_1_solved.jpg");
        Room vGuide5Enigme1Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");

        // Énigme 2
        Room vGuide5Enigme2 = new Room("Enigma 2", "images/guide_stone/enigma_2.jpg");
        Room vGuide5Enigme2Answer1 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_2_solved.jpg");
        Room vGuide5Enigme2Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide5Enigme2Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide5Enigme2Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");

        // Énigme 3
        Room vGuide5Enigme3 = new Room("Enigma 3", "images/guide_stone/enigma_3.jpg");
        Room vGuide5Enigme3Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide5Enigme3Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide5Enigme3Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_3_solved.jpg");
        Room vGuide5Enigme3Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");

        // Énigme 4
        Room vGuide5Enigme4 = new Room("Enigma 4", "images/guide_stone/enigma_4.jpg");
        Room vGuide5Enigme4Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide5Enigme4Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide5Enigme4Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide5Enigme4Answer4 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_4_solved.jpg");

        // Le placement des pièces
        vFakeGuideStone5.setExit("enigma1", vGuide5Enigme1);
        vGuide5Enigme1.setExit("answer1", vGuide5Enigme1Answer1);
        vGuide5Enigme1.setExit("answer2", vGuide5Enigme1Answer2);
        vGuide5Enigme1.setExit("answer3", vGuide5Enigme1Answer3);
        vGuide5Enigme1.setExit("answer4", vGuide5Enigme1Answer4);
        vGuide5Enigme1Answer1.setExit("enigma1", vGuide5Enigme1);
        vGuide5Enigme1Answer2.setExit("enigma1", vGuide5Enigme1);
        vGuide5Enigme1Answer3.setExit("enigma1", vGuide5Enigme1);
        vGuide5Enigme1Answer3.setExit("enigma2", vGuide5Enigme2);

        vGuide5Enigme2.setExit("answer1", vGuide5Enigme2Answer1);
        vGuide5Enigme2.setExit("answer2", vGuide5Enigme2Answer2);
        vGuide5Enigme2.setExit("answer3", vGuide5Enigme2Answer3);
        vGuide5Enigme2.setExit("answer4", vGuide5Enigme2Answer4);
        vGuide5Enigme2Answer2.setExit("enigma2", vGuide5Enigme2);
        vGuide5Enigme2Answer3.setExit("enigma2", vGuide5Enigme2);
        vGuide5Enigme2Answer4.setExit("enigma2", vGuide5Enigme2);
        vGuide5Enigme2Answer1.setExit("enigma3", vGuide5Enigme3);

        vGuide5Enigme3.setExit("answer1", vGuide5Enigme3Answer1);
        vGuide5Enigme3.setExit("answer2", vGuide5Enigme3Answer2);
        vGuide5Enigme3.setExit("answer3", vGuide5Enigme3Answer3);
        vGuide5Enigme3.setExit("answer4", vGuide5Enigme3Answer4);
        vGuide5Enigme3Answer1.setExit("enigma3", vGuide5Enigme3);
        vGuide5Enigme3Answer2.setExit("enigma3", vGuide5Enigme3);
        vGuide5Enigme3Answer4.setExit("enigma3", vGuide5Enigme3);
        vGuide5Enigme3Answer3.setExit("enigma4", vGuide5Enigme4);

        vGuide5Enigme4.setExit("answer1", vGuide5Enigme4Answer1);
        vGuide5Enigme4.setExit("answer2", vGuide5Enigme4Answer2);
        vGuide5Enigme4.setExit("answer3", vGuide5Enigme4Answer3);
        vGuide5Enigme4.setExit("answer4", vGuide5Enigme4Answer4);
        vGuide5Enigme4Answer1.setExit("enigma4", vGuide5Enigme4);
        vGuide5Enigme4Answer2.setExit("enigma4", vGuide5Enigme4);
        vGuide5Enigme4Answer3.setExit("enigma4", vGuide5Enigme4);
        vGuide5Enigme4Answer4.setExit("exit", vFakeGuideStone5Solved);

        // Les items récompense de la stèle
        Item vMercatusFlotillaMap = new Item("mercatus_flotilla_map", 
                                        "A map of Mercatus Flotilla island", 0.2, 50);
        Item vLabyrinthosMap = new Item("labyrinthos_map", 
                                    "A map of Labyrinthos island", 0.2, 50);

        vFakeGuideStone5Solved.setItem(vMercatusFlotillaMap);
        vFakeGuideStone5Solved.setItem(vLabyrinthosMap);


        Room vGuideStone8 = new Room("at the guide stone of Sanctum Ignis", "images/guide_stone/guide_stone_8.jpg");
        Room vGuideStone8Solved = new Room("in the exit of the guide stone - Congratulations!", "images/guide_stone/guide_stone_8_solved.jpg");

        // Les énigmes de la stèle
        // Énigme 1
        Room vGuide8Enigme1 = new Room("Enigma 1", "images/guide_stone/enigma_1.jpg");
        Room vGuide8Enigme1Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide8Enigme1Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide8Enigme1Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_1_solved.jpg");
        Room vGuide8Enigme1Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        // Énigme 2
        Room vGuide8Enigme2 = new Room("Enigma 2", "images/guide_stone/enigma_2.jpg");
        Room vGuide8Enigme2Answer1 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_2_solved.jpg");
        Room vGuide8Enigme2Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide8Enigme2Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide8Enigme2Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");

        // Énigme 3
        Room vGuide8Enigme3 = new Room("Enigma 3", "images/guide_stone/enigma_3.jpg");
        Room vGuide8Enigme3Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide8Enigme3Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide8Enigme3Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide8Enigme3Answer4 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_3_solved.jpg");

        // Énigme 4
        Room vGuide8Enigme4 = new Room("Enigma 4", "images/guide_stone/enigma_4.jpg");
        Room vGuide8Enigme4Answer1 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_4_solved.jpg");
        Room vGuide8Enigme4Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide8Enigme4Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide8Enigme4Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");

        // Le placement des pièces
        vGuideStone8.setExit("enigma1", vGuide8Enigme1);
        vGuide8Enigme1.setExit("answer1", vGuide8Enigme1Answer1);
        vGuide8Enigme1.setExit("answer2", vGuide8Enigme1Answer2);
        vGuide8Enigme1.setExit("answer3", vGuide8Enigme1Answer3);
        vGuide8Enigme1.setExit("answer4", vGuide8Enigme1Answer4);
        vGuide8Enigme1Answer1.setExit("enigma1", vGuide8Enigme1);
        vGuide8Enigme1Answer2.setExit("enigma1", vGuide8Enigme1);
        vGuide8Enigme1Answer4.setExit("enigma1", vGuide8Enigme1);
        vGuide8Enigme1Answer3.setExit("enigma2", vGuide8Enigme2);

        vGuide8Enigme2.setExit("answer1", vGuide8Enigme2Answer1);
        vGuide8Enigme2.setExit("answer2", vGuide8Enigme2Answer2);
        vGuide8Enigme2.setExit("answer3", vGuide8Enigme2Answer3);
        vGuide8Enigme2.setExit("answer4", vGuide8Enigme2Answer4);
        vGuide8Enigme2Answer2.setExit("enigma2", vGuide8Enigme2);
        vGuide8Enigme2Answer3.setExit("enigma2", vGuide8Enigme2);
        vGuide8Enigme2Answer4.setExit("enigma2", vGuide8Enigme2);
        vGuide8Enigme2Answer1.setExit("enigma3", vGuide8Enigme3);

        vGuide8Enigme3.setExit("answer1", vGuide8Enigme3Answer1);
        vGuide8Enigme3.setExit("answer2", vGuide8Enigme3Answer2);
        vGuide8Enigme3.setExit("answer1", vGuide8Enigme3Answer1);
        vGuide8Enigme3.setExit("answer2", vGuide8Enigme3Answer2);
        vGuide8Enigme3.setExit("answer3", vGuide8Enigme3Answer3);
        vGuide8Enigme3.setExit("answer4", vGuide8Enigme3Answer4);
        vGuide8Enigme3Answer1.setExit("enigma3", vGuide8Enigme3);
        vGuide8Enigme3Answer2.setExit("enigma3", vGuide8Enigme3);
        vGuide8Enigme3Answer3.setExit("enigma3", vGuide8Enigme3);
        vGuide8Enigme3Answer4.setExit("enigma4", vGuide8Enigme4);

        vGuide8Enigme4.setExit("answer1", vGuide8Enigme4Answer1);
        vGuide8Enigme4.setExit("answer2", vGuide8Enigme4Answer2);
        vGuide8Enigme4.setExit("answer3", vGuide8Enigme4Answer3);
        vGuide8Enigme4.setExit("answer4", vGuide8Enigme4Answer4);
        vGuide8Enigme4Answer2.setExit("enigma4", vGuide8Enigme4);
        vGuide8Enigme4Answer3.setExit("enigma4", vGuide8Enigme4);
        vGuide8Enigme4Answer4.setExit("enigma4", vGuide8Enigme4);
        vGuide8Enigme4Answer1.setExit("exit", vGuideStone8Solved);

        // L'item récompense de la stèle
        Item vMonsCaelestisMap = new Item("mons_caelestis_map", 
                                        "A map of Mons Caelestis mountain", 0.2, 50);

        vGuideStone8Solved.setItem(vMonsCaelestisMap);

        Room vGuideStone9 = new Room("at the guide stone of Mons Caelestis", "images/guide_stone/guide_stone_9.jpg");
        Room vGuideStone9Solved = new Room("in the exit of the guide stone - Congratulations!", "images/guide_stone/guide_stone_9_solved.jpg");

        // Les énigmes de la stèle
        // Énigme 1
        Room vGuide9Enigme1 = new Room("Enigma 1", "images/guide_stone/enigma_1.jpg");
        Room vGuide9Enigme1Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide9Enigme1Answer2 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_1_solved.jpg");
        Room vGuide9Enigme1Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        Room vGuide9Enigme1Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_1_wrong.jpg");
        // Énigme 2
        Room vGuide9Enigme2 = new Room("Enigma 2", "images/guide_stone/enigma_2.jpg");
        Room vGuide9Enigme2Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide9Enigme2Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");
        Room vGuide9Enigme2Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_2_solved.jpg");
        Room vGuide9Enigme2Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_2_wrong.jpg");

        // Énigme 3
        Room vGuide9Enigme3 = new Room("Enigma 3", "images/guide_stone/enigma_3.jpg");
        Room vGuide9Enigme3Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide9Enigme3Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");
        Room vGuide9Enigme3Answer3 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_3_solved.jpg");
        Room vGuide9Enigme3Answer4 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_3_wrong.jpg");

        // Énigme 4
        Room vGuide9Enigme4 = new Room("Enigma 4", "images/guide_stone/enigma_4.jpg");
        Room vGuide9Enigme4Answer1 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide9Enigme4Answer2 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide9Enigme4Answer3 = new Room("Wrong answer! The stone rejects you.", "images/guide_stone/enigma_4_wrong.jpg");
        Room vGuide9Enigme4Answer4 = new Room("Correct! The stone glows with approval.", "images/guide_stone/enigma_4_solved.jpg");

        // Le placement des pièces
        vGuideStone9.setExit("enigma1", vGuide9Enigme1);
        vGuide9Enigme1.setExit("answer1", vGuide9Enigme1Answer1);
        vGuide9Enigme1.setExit("answer2", vGuide9Enigme1Answer2);
        vGuide9Enigme1.setExit("answer3", vGuide9Enigme1Answer3);
        vGuide9Enigme1.setExit("answer4", vGuide9Enigme1Answer4);
        vGuide9Enigme1Answer1.setExit("enigma1", vGuide9Enigme1);
        vGuide9Enigme1Answer3.setExit("enigma1", vGuide9Enigme1);
        vGuide9Enigme1Answer4.setExit("enigma1", vGuide9Enigme1);
        vGuide9Enigme1Answer2.setExit("enigma2", vGuide9Enigme2);

        vGuide9Enigme2.setExit("answer1", vGuide9Enigme2Answer1);
        vGuide9Enigme2.setExit("answer2", vGuide9Enigme2Answer2);
        vGuide9Enigme2.setExit("answer3", vGuide9Enigme2Answer3);
        vGuide9Enigme2.setExit("answer4", vGuide9Enigme2Answer4);
        vGuide9Enigme2Answer1.setExit("enigma2", vGuide9Enigme2);
        vGuide9Enigme2Answer2.setExit("enigma2", vGuide9Enigme2);
        vGuide9Enigme2Answer4.setExit("enigma2", vGuide9Enigme2);
        vGuide9Enigme2Answer3.setExit("enigma3", vGuide9Enigme3);

        vGuide9Enigme3.setExit("answer1", vGuide9Enigme3Answer1);
        vGuide9Enigme3.setExit("answer2", vGuide9Enigme3Answer2);
        vGuide9Enigme3.setExit("answer3", vGuide9Enigme3Answer3);
        vGuide9Enigme3.setExit("answer4", vGuide9Enigme3Answer4);
        vGuide9Enigme3Answer1.setExit("enigma3", vGuide9Enigme3);
        vGuide9Enigme3Answer2.setExit("enigma3", vGuide9Enigme3);
        vGuide9Enigme3Answer4.setExit("enigma3", vGuide9Enigme3);
        vGuide9Enigme3Answer3.setExit("enigma4", vGuide9Enigme4);

        vGuide9Enigme4.setExit("answer1", vGuide9Enigme4Answer1);
        vGuide9Enigme4.setExit("answer2", vGuide9Enigme4Answer2);
        vGuide9Enigme4.setExit("answer3", vGuide9Enigme4Answer3);
        vGuide9Enigme4.setExit("answer4", vGuide9Enigme4Answer4);
        vGuide9Enigme4Answer1.setExit("enigma4", vGuide9Enigme4);
        vGuide9Enigme4Answer2.setExit("enigma4", vGuide9Enigme4);
        vGuide9Enigme4Answer3.setExit("enigma4", vGuide9Enigme4);
        vGuide9Enigme4Answer4.setExit("exit", vGuideStone9Solved);

        // L'item récompense de la stèle
        Item vUltimaSapientiaMap = new Item("ultima_sapientia_map",
                                        "A map of Ultima Sapientia temple", 0.2, 50);

        vGuideStone9Solved.setItem(vUltimaSapientiaMap);




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
        
        // Placement des îles que le bateau peut atteindre
        vBoat.setExit("portus_prima", vPortusPrima);
        vBoat.setExit("insula_templum", vInsulaTemplum);
        vBoat.setExit("crypta_marina", vCryptaMarina);
        vBoat.setExit("civitas_antiqua", vCivitasAntiqua);
        vBoat.setExit("silva_mystica", vSilvaMystica);
        vBoat.setExit("mercatus_flotilla", vMercatusFlotilla);
        vBoat.setExit("labyrinthos", vLabyrinthos);
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
        vLibrary1.setExit("portus_prima", vPortusPrima);
        vTavern1.setExit("portus_prima", vPortusPrima);
        vHostel1.setExit("portus_prima", vPortusPrima);
        vSanctuaryOfTheOracle1.setExit("portus_prima", vPortusPrima);
        vSeaPort1.setExit("portus_prima", vPortusPrima);


        Door vDoorBoatInsulaTemplum = new Door(vInsulaTemplumMap, false);
        vBoat.setDoor("insula_templum", vDoorBoatInsulaTemplum);
        vInsulaTemplum.setDoor("boat", vDoorBoatInsulaTemplum);

        Door vDoorBoatCryptaMarina = new Door(vCryptaMarinaMap, false);
        vBoat.setDoor("crypta_marina", vDoorBoatCryptaMarina);
        vCryptaMarina.setDoor("boat", vDoorBoatCryptaMarina);

        Door vDoorBoatCivitasAntiqua = new Door(vCivitasAntiquaMap, false);
        vBoat.setDoor("civitas_antiqua", vDoorBoatCivitasAntiqua);
        vCivitasAntiqua.setDoor("boat", vDoorBoatCivitasAntiqua);

        Door vDoorBoatSilvaMystica = new Door(vSilvaMysticaMap, false);
        vBoat.setDoor("silva_mystica", vDoorBoatSilvaMystica);
        vSilvaMystica.setDoor("boat", vDoorBoatSilvaMystica);

        Door vDoorBoatMercatusFlotilla = new Door(vMercatusFlotillaMap, false);
        vBoat.setDoor("mercatus_flotilla", vDoorBoatMercatusFlotilla);
        vMercatusFlotilla.setDoor("boat", vDoorBoatMercatusFlotilla);

        Door vDoorBoatLabyrinthos = new Door(vLabyrinthosMap, false);
        vBoat.setDoor("labyrinthos", vDoorBoatLabyrinthos);
        vLabyrinthos.setDoor("boat", vDoorBoatLabyrinthos);

        Door vDoorBoatMonsCaelestis = new Door(vMonsCaelestisMap, false);
        vBoat.setDoor("mons_caelestis", vDoorBoatMonsCaelestis);
        vMonsCaelestis.setDoor("boat", vDoorBoatMonsCaelestis);

        Door vDoorBoatUltimaSapientia = new Door(vUltimaSapientiaMap, false);
        vBoat.setDoor("ultima_sapientia", vDoorBoatUltimaSapientia);
        vUltimaSapientia.setDoor("boat", vDoorBoatUltimaSapientia);



        // 2 - Insula Templum

        vInsulaTemplum.setExit("boat", vBoat);
        vInsulaTemplum.setExit("temple_entrance", vTempleEntrance);
        vInsulaTemplum.setExit("seaport", vSeaPort2);
        vTempleEntrance.setExit("insula_templum", vInsulaTemplum);
        vTreasuryAncientTemple.setExit("guidestone", vGuideStone2);
        vGuideStone2Solved.setExit("treasury", vTreasuryAncientTemple);

        // 3 - Crypta Marina
        
        vCryptaMarina.setExit("boat", vBoat);
        vCryptaMarina.setExit("sanctuary", vSanctuaryOfTheOracle3);
        vCryptaMarina.setExit("tavern", vTavern3);
        vCryptaMarina.setExit("guidestone", vFakeGuideStone3);
        vCryptaMarina.setExit("seaport", vSeaPort3);

        // 4 - Civitas Antiqua

        vCivitasAntiqua.setExit("boat", vBoat);
        vCivitasAntiqua.setExit("ruined_palace", vRuinedPalace);
        vCivitasAntiqua.setExit("seaport", vSeaPort4);
        vTreasuryRuinedPalace.setExit("guidestone", vGuideStone4);
        vGuideStone4Solved.setExit("treasury", vTreasuryRuinedPalace);

        // 5 - Silva Mystica

        vSilvaMystica.setExit("boat", vBoat);
        vSilvaMystica.setExit("sanctuary", vSanctuaryOfTheOracle5);
        vSilvaMystica.setExit("tavern", vTavern5);
        vSilvaMystica.setExit("guidestone", vFakeGuideStone5);
        vSilvaMystica.setExit("seaport", vSeaPort5);

        // 6 - Mercatus Flotilla

        vMercatusFlotilla.setExit("boat", vBoat);
        vMercatusFlotilla.setExit("seaport", vSeaPort6);
        vMercatusFlotilla.setExit("hostel", vHostel6);
        vMercatusFlotilla.setExit("tavern", vTavern6);
        vMercatusFlotilla.setExit("library", vLibrary6);

        // 7 - Labyrinthos

        vLabyrinthos.setExit("boat", vBoat);
        vLabyrinthos.setExit("seaport", vSeaPort7);
        vLabyrinthos.setExit("tavern", vTavern7);
        vLabyrinthos.setExit("cave", vCave);

        // Liaison grotte -> trou perdu -> temple souterrain
        vNarrowPassage.setExit("hole", vLostHole);

        // 8 - Sanctum Ignis

        vLostHole.setExit("underground_temple", vUndergroundTemple);
        vTreasureVaultUndergroundTemple.setExit("guidestone", vGuideStone8);
        vGuideStone8.setExit("treasure_vault", vTreasureVaultUndergroundTemple);
        vGuideStone8Solved.setExit("labyrinthos", vLabyrinthos);


        // 9 - Mons Caelestis

        vMonsCaelestis.setExit("boat", vBoat);
        vMonsCaelestis.setExit("seaport", vSeaPort9);
        vMonsCaelestis.setExit("sacred_mountain", vSacredMontain);
        vWaterfall.setExit("observatory", vAncientObservatory);
        vAncientObservatory.setExit("waterfall", vWaterfall);
        vTelescopeRoom.setExit("guidestone", vGuideStone9);
        vGuideStone9.setExit("telescope", vTelescopeRoom);
        vGuideStone9Solved.setExit("telescope", vTelescopeRoom);

        // 10 - Ultima Sapientia

        vUltimaSapientia.setExit("boat", vBoat);
        vUltimaSapientia.setExit("sapientia_temple", vSapientiaTemple);
        
        // Pièce de départ
        return vBoat;
    } // CreateWorld()


    // Création des lieux principaux du jeu

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
        Room vTerrasse = new Room("on the hostel terrace", "images/hostel/terrace.jpg");

        // Le placement des pièces

        vHostelReception.setExit("common", vCommonRoom);
        vHostelReception.setExit("dormitory", vDormitory);
        vHostelReception.setExit("kitchen", vKitchen);
        vHostelReception.setExit("dining", vDiningRoom);
        vHostelReception.setExit("terrace", vTerrasse);

        vCommonRoom.setExit("reception", vHostelReception);
        vCommonRoom.setExit("terrace", vTerrasse);

        vDormitory.setExit("reception", vHostelReception);

        vKitchen.setExit("reception", vHostelReception);
        vKitchen.setExit("dining", vDiningRoom);

        vDiningRoom.setExit("reception", vHostelReception);
        vDiningRoom.setExit("kitchen", vKitchen);

        vTerrasse.setExit("reception", vHostelReception);
        vTerrasse.setExit("common", vCommonRoom);

        // Créer les items
        Item vBed = new Item("bed", "Comfortable hostel bed", 15, 40);
        Item vMattress = new Item("mattress", "Foam mattress", 5, 20);
        Item vPillow = new Item("pillow", "Soft pillow", 0.5, 5);
        Item vBlanket = new Item("blanket", "Warm blanket", 1, 10);
        Item vSheet = new Item("sheet", "White cotton sheet", 0.3, 5);
        Item vChair = new Item("chair", "Wooden chair", 3, 10);
        Item vTable = new Item("table", "Wooden table", 8, 20);
        Item vSofa = new Item("sofa", "Comfortable sofa", 20, 50);
        Item vFridge = new Item("fridge", "Small refrigerator", 30, 60);
        Item vFork = new Item("fork", "Metal fork", 0.1, 2);
        Item vSpoon = new Item("spoon", "Metal spoon", 0.1, 2);
        Item vKnife = new Item("knife", "Kitchen knife", 0.2, 5);
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
        vKitchen.setItem(vFork);
        vKitchen.setItem(vSpoon);
        vKitchen.setItem(vKnife);

        vDiningRoom.setItem(vTable);
        vDiningRoom.setItem(vChair);

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
        Room vTreasuryOracle = new Room("in the sanctuary treasury", "images/sanctuary/treasury.jpg");
        Room vGarden = new Room("in the sacred garden", "images/sanctuary/garden.jpg");

        // Le placement des pièces

        vSanctuaryEntrance.setExit("hall", vHall);
        vSanctuaryEntrance.setExit("garden", vGarden);

        vHall.setExit("entrance", vSanctuaryEntrance);
        vHall.setExit("prayer", vPrayerRoom);
        vHall.setExit("oracle", vOracleRoom);
        vHall.setExit("library", vLibrary);
        vHall.setExit("treasury", vTreasuryOracle);

        vPrayerRoom.setExit("hall", vHall);

        vOracleRoom.setExit("hall", vHall);

        vLibrary.setExit("hall", vHall);

        vTreasuryOracle.setExit("hall", vHall);

        vGarden.setExit("entrance", vSanctuaryEntrance);

        // Créer les items
        Item vCrystalBall = new Item("crystal_ball", "Mystical crystal ball for divination", 2, 200);
        Item vIncense = new Item("incense", "Sacred incense sticks", 0.1, 10);
        Item vCandle = new Item("candle", "White ceremonial candle", 0.2, 5);
        Item vPrayerBook = new Item("prayer_book", "Ancient book of prayers", 0.8, 50);
        Item vHolyWater = new Item("holy_water", "Blessed water in a vial", 0.3, 30);
        Item vScroll = new Item("prophecy_scroll", "Ancient scroll with prophecies", 0.2, 150);
        Item vTarot = new Item("tarot_cards", "Mystical tarot deck", 0.3, 75);
        Item vStatue = new Item("statue", "Golden statue of a deity", 15, 500);
        Item vGoldCoin = new Item("ancient_coin", "Ancient gold coin, 50 Jerries", 0.05, 50);
        Item vJewel = new Item("jewel", "Precious gemstone", 0.1, 400);
        Item vCrown = new Item("crown", "Sacred crown of the oracle", 2, 1000);
        Item vHerb = new Item("healing_herb", "Rare healing herb", 0.1, 60);
        Item vFlower = new Item("sacred_flower", "Mystical glowing flower", 0.1, 80);
        Item vTreasuryKey = new Item("treasury_key", "Key to the treasury", 0.1, 100);


        // Ajouter les items aux pièces

        vSanctuaryEntrance.setItem(vIncense);
        vSanctuaryEntrance.setItem(vCandle);

        vHall.setItem(vStatue);
        vHall.setItem(vCandle);

        vPrayerRoom.setItem(vPrayerBook);
        vPrayerRoom.setItem(vHolyWater);

        vOracleRoom.setItem(vCrystalBall);
        vOracleRoom.setItem(vScroll);
        vOracleRoom.setItem(vTarot);

        vLibrary.setItem(vPrayerBook);
        vLibrary.setItem(vScroll);
        vLibrary.setItem(vTreasuryKey);


        vTreasuryOracle.setItem(vGoldCoin);
        vTreasuryOracle.setItem(vJewel);
        vTreasuryOracle.setItem(vCrown);

        vGarden.setItem(vHerb);
        vGarden.setItem(vFlower);

        // Les portes verrouillées
        Door vDoorTreasury = new Door(vTreasuryKey, false);
        vHall.setDoor("treasury", vDoorTreasury);
        vTreasuryOracle.setDoor("hall", vDoorTreasury);

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
        vDocks.setExit("shipyard", vShipyard);

        vShipyard.setExit("docks", vDocks);

        vCustomsOffice.setExit("entrance", vPortEntrance);

        vMarket.setExit("entrance", vPortEntrance);

        vLighthouse.setExit("harbor", vHarbor);

        // Créer les items
        Item vRope = new Item("rope", "Strong nautical rope", 2, 15);
        Item vAnchor = new Item("anchor", "Heavy ship anchor", 50, 80);
        Item vNet = new Item("fishing_net", "Large fishing net", 3, 25);
        Item vCompass = new Item("compass", "Navigation compass", 0.3, 50);
        Item vFish = new Item("fish", "Fresh caught fish", 0.5, 5);
        Item vShrimp = new Item("shrimp", "Fresh shrimp", 0.3, 8);
        Item vOyster = new Item("oyster", "Fresh oysters", 0.2, 10);
        Item vCoin = new Item("coin", "20 Jerries", 0.05, 20);
        Item vTool = new Item("hammer", "Shipbuilding hammer", 2, 25);
        Item vNail = new Item("nails", "Iron nails", 1, 10);

        // Ajouter les items aux pièces
        vHarbor.setItem(vRope);
        vHarbor.setItem(vNet);

        vDocks.setItem(vAnchor);

        vShipyard.setItem(vTool);
        vShipyard.setItem(vNail);

        vCustomsOffice.setItem(vCoin);

        vMarket.setItem(vFish);
        vMarket.setItem(vShrimp);
        vMarket.setItem(vOyster);

        vLighthouse.setItem(vCompass);

        // Pièce de départ
        return vPortEntrance;
    } // createSeaPort()

    /**
     * Crée le temple antique
     * 
     * @return Un tableau contenant la pièce d'entrée [0] et la treasury [1]
     */
    public static Room[] createAncientTemple()
    {
        // Les pièces du temple
        Room vTempleEntrance = new Room("at the ancient temple entrance", "images/temple/entrance.jpg");
        Room vHall = new Room("in the temple hall", "images/temple/hall.jpg");
        Room vShrine = new Room("at the temple shrine", "images/temple/shrine.jpg");
        Room vChapel = new Room("in the temple chapel", "images/temple/chapel.jpg");
        Room vTreasuryAncientTemple = new Room("in the temple treasury", "images/temple/treasury.jpg");
        Room vLibrary = new Room("in the temple library", "images/temple/library.jpg");
        Room vPriestChamber = new Room("in the priest's chamber", "images/temple/priest_chamber.jpg");
        Room vGarden = new Room("in the temple garden", "images/temple/garden.jpg");

        // Le placement des pièces
        vTempleEntrance.setExit("hall", vHall);
        vTempleEntrance.setExit("garden", vGarden);

        vHall.setExit("entrance", vTempleEntrance);
        vHall.setExit("shrine", vShrine);
        vHall.setExit("chapel", vChapel);
        vHall.setExit("treasury", vTreasuryAncientTemple);
        vHall.setExit("library", vLibrary);
        vHall.setExit("priest", vPriestChamber);

        vShrine.setExit("hall", vHall);

        vChapel.setExit("hall", vHall);

        vTreasuryAncientTemple.setExit("hall", vHall);

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

        vTreasuryAncientTemple.setItem(vJewel);
        vTreasuryAncientTemple.setItem(vGoldBar);
        vTreasuryAncientTemple.setItem(vDiamonds);
        vTreasuryAncientTemple.setItem(vGoldCoin);

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
        vTreasuryAncientTemple.setDoor("hall", vDoorTreasury);

        // Pièce de départ et accès à la treasury
        return new Room[]{vTempleEntrance, vTreasuryAncientTemple};
    } // createAncientTemple()


    /**
     * Crée le palais en ruines
     * 
     * @return Un tableau contenant la pièce d'entrée [0] et la treasury [1]
     */
    public static Room[] createRuinedPalace() 
    {
        // Les pièces du palais en ruines
        Room vPalaceEntrance = new Room("at the ruined palace entrance", "images/palace/entrance.jpg");
        Room vGreatHall = new Room("in the great hall", "images/palace/great_hall.jpg");
        Room vThroneRoom = new Room("in the throne room", "images/palace/throne_room.jpg");
        Room vBanquetHall = new Room("in the banquet hall", "images/palace/banquet_hall.jpg");
        Room vTreasuryRuinedPalace = new Room("in the palace treasury", "images/palace/treasury.jpg");
        Room vLibrary = new Room("in the palace library", "images/palace/library.jpg");
        Room vRoyalChamber = new Room("in the royal chamber", "images/palace/royal_chamber.jpg");
        Room vCourtyard = new Room("in the palace courtyard", "images/palace/courtyard.jpg");
        Room vDungeon = new Room("in the palace dungeon", "images/palace/dungeon.jpg");

        // Le placement des pièces
        vPalaceEntrance.setExit("hall", vGreatHall);
        vPalaceEntrance.setExit("courtyard", vCourtyard);

        vGreatHall.setExit("entrance", vPalaceEntrance);
        vGreatHall.setExit("throne", vThroneRoom);
        vGreatHall.setExit("banquet", vBanquetHall);
        vGreatHall.setExit("library", vLibrary);
        vGreatHall.setExit("treasury", vTreasuryRuinedPalace);
        vGreatHall.setExit("dungeon", vDungeon);

        vThroneRoom.setExit("hall", vGreatHall);
        vThroneRoom.setExit("royal", vRoyalChamber);

        vBanquetHall.setExit("hall", vGreatHall);

        vTreasuryRuinedPalace.setExit("hall", vGreatHall);

        vLibrary.setExit("hall", vGreatHall);

        vRoyalChamber.setExit("throne", vThroneRoom);

        vCourtyard.setExit("entrance", vPalaceEntrance);

        vDungeon.setExit("hall", vGreatHall);

        // Créer les items
        Item vCrown = new Item("royal_crown", "Ancient royal crown encrusted with jewels", 3, 2000);
        Item vThrone = new Item("throne", "Magnificent golden throne", 100, 5000);
        Item vGoldCoin = new Item("gold_coin", "Ancient gold coins, 200 Jerries", 0.1, 200);
        Item vJewel = new Item("ruby", "Large precious ruby", 0.2, 1000);
        Item vDiamond = new Item("diamond", "Flawless diamond", 0.1, 1500);
        Item vPainting = new Item("painting", "Royal family portrait", 10, 600);
        Item vScroll = new Item("royal_decree", "Ancient royal decree", 0.3, 250);
        Item vBook = new Item("history_book", "Book of palace history", 1, 150);
        Item vManuscript = new Item("manuscript", "Royal manuscript", 0.5, 400);
        Item vBed = new Item("royal_bed", "Luxurious royal bed", 80, 1200);
        Item vMirror = new Item("mirror", "Ornate golden mirror", 15, 500);
        Item vStatue = new Item("statue", "Marble statue of ancient king", 50, 800);
        Item vFountain = new Item("fountain", "Decorative stone fountain", 200, 1000);
        Item vChain = new Item("chain", "Heavy iron chains", 5, 20);

        // Ajouter les items aux pièces
        vGreatHall.setItem(vStatue);

        vThroneRoom.setItem(vThrone);
        vThroneRoom.setItem(vCrown);
        vThroneRoom.setItem(vPainting);

        vBanquetHall.setItem(vPainting);

        vTreasuryRuinedPalace.setItem(vGoldCoin);
        vTreasuryRuinedPalace.setItem(vJewel);
        vTreasuryRuinedPalace.setItem(vDiamond);

        vLibrary.setItem(vScroll);
        vLibrary.setItem(vBook);
        vLibrary.setItem(vManuscript);

        vRoyalChamber.setItem(vBed);
        vRoyalChamber.setItem(vMirror);

        vCourtyard.setItem(vFountain);
        vCourtyard.setItem(vStatue);

        vDungeon.setItem(vChain);

        // Les portes verrouillées
        Item vTreasuryKey = new Item("treasury_key", "Golden key to the treasury", 0.1, 300);
        vRoyalChamber.setItem(vTreasuryKey);
        Door vDoorTreasury = new Door(vTreasuryKey, false);
        vGreatHall.setDoor("treasury", vDoorTreasury);
        vTreasuryRuinedPalace.setDoor("hall", vDoorTreasury);

        // Pièce de départ
        return new Room [] {vPalaceEntrance, vTreasuryRuinedPalace};
    } // createRuinedPalace()


    /**
     * Crée la grotte du jeu
     * 
     * @return Un tableau contenant l'entrée [0] et le passage étroit [1]
     */
    public static Room[] createCave()
    {
        // Les pièces de la grotte
        Room vCaveEntrance = new Room("at the cave entrance", "images/cave/entrance.jpg");
        Room vMainCavern = new Room("in the main cavern", "images/cave/main_cavern.jpg");
        Room vUndergroundLake = new Room("at the underground lake", "images/cave/underground_lake.jpg");
        Room vNarrowPassage = new Room("in a narrow passage", "images/cave/narrow_passage.jpg");
        Room vDarkTunnel = new Room("in a dark tunnel", "images/cave/dark_tunnel.jpg");

        // Le placement des pièces
        vCaveEntrance.setExit("cavern", vMainCavern);
        
        vMainCavern.setExit("entrance", vCaveEntrance);
        vMainCavern.setExit("lake", vUndergroundLake);
        vMainCavern.setExit("passage", vNarrowPassage);
            
        vUndergroundLake.setExit("cavern", vMainCavern);
        vUndergroundLake.setExit("tunnel", vDarkTunnel);
        
        vNarrowPassage.setExit("cavern", vMainCavern);
        
        vDarkTunnel.setExit("lake", vUndergroundLake);

        // Créer les items
        Item vTorch = new Item("torch", "Burning torch for light", 1, 15);
        Item vLantern = new Item("lantern", "Oil lantern", 2, 30);
        Item vMap = new Item("treasure_map", "Old treasure map", 0.2, 80);
        Item vPickaxe = new Item("pickaxe", "Mining pickaxe", 3, 40);
        Item vRope = new Item("rope", "Strong climbing rope", 2, 25);
        Item vWaterBottle = new Item("water_bottle", "Fresh underground water", 0.5, 10);
        Item vFossil = new Item("fossil", "Ancient fossil", 1, 120);

        // Ajouter les items aux pièces
        vCaveEntrance.setItem(vTorch);
        vCaveEntrance.setItem(vRope);
        
        vMainCavern.setItem(vLantern);
        vMainCavern.setItem(vPickaxe);
        vMainCavern.setItem(vMap);
        
        vUndergroundLake.setItem(vWaterBottle);
        vUndergroundLake.setItem(vFossil);
        
        vNarrowPassage.setItem(vTorch);
        
        vDarkTunnel.setItem(vTorch);

        // Pièce de départ + passage étroit pour connexions externes
        return new Room[]{vCaveEntrance, vNarrowPassage};
    } // createCave()


    /**
     * Crée le temple souterrain
     * Le joueur arrive ici après être tombé dans le trou perdu de la grotte
     * 
     * @return Un tableau contenant l'entrée [0] et le trésor [1]
     */
    public static Room[] createUndergroundTemple()
    {
        // Les pièces du temple souterrain
        Room vTempleEntrance = new Room("at the underground temple entrance", "images/underground_temple/entrance.jpg");
        Room vMainHall = new Room("in the main hall of the underground temple", "images/underground_temple/main_hall.jpg");
        Room vAltarRoom = new Room("in the altar room", "images/underground_temple/altar_room.jpg");
        Room vCrypt = new Room("in the ancient crypt", "images/underground_temple/crypt.jpg");
        Room vTreasureVault = new Room("in the treasure vault", "images/underground_temple/treasure_vault.jpg");
        Room vRitualChamber = new Room("in the ritual chamber", "images/underground_temple/ritual_chamber.jpg");
        Room vLibrary = new Room("in the underground library", "images/underground_temple/library.jpg");
        Room vSecretPassage = new Room("in a secret passage", "images/underground_temple/secret_passage.jpg");

        // Le placement des pièces
        vTempleEntrance.setExit("hall", vMainHall);
        
        vMainHall.setExit("entrance", vTempleEntrance);
        vMainHall.setExit("altar", vAltarRoom);
        vMainHall.setExit("crypt", vCrypt);
        vMainHall.setExit("library", vLibrary);
        vMainHall.setExit("ritual", vRitualChamber);
        
        vAltarRoom.setExit("hall", vMainHall);
        vAltarRoom.setExit("secret", vSecretPassage);
        
        vCrypt.setExit("hall", vMainHall);
        
        vTreasureVault.setExit("secret", vSecretPassage);
        
        vRitualChamber.setExit("hall", vMainHall);
        
        vLibrary.setExit("hall", vMainHall);
        
        vSecretPassage.setExit("altar", vAltarRoom);
        vSecretPassage.setExit("vault", vTreasureVault);

        // Créer les items
        Item vTorch = new Item("torch", "Ancient burning torch", 1, 20);
        Item vStatue = new Item("deity_statue", "Large stone statue of an ancient deity", 100, 1500);
        Item vCandle = new Item("ritual_candle", "Black ritual candle", 0.3, 15);
        Item vIncense = new Item("dark_incense", "Mysterious dark incense", 0.2, 25);
        Item vRitualDagger = new Item("ritual_dagger", "Ceremonial dagger with runes", 0.8, 400);
        Item vGoldCoin = new Item("ancient_gold", "Ancient gold coins, 500 Jerries", 0.5, 500);
        Item vCrown = new Item("ancient_crown", "Crown of an ancient priest", 3, 2500);
        Item vAmulet = new Item("mystical_amulet", "Powerful mystical amulet", 0.3, 1200);
        Item vJewel = new Item("sapphire", "Large sapphire gemstone", 0.2, 1000);
        Item vDiamond = new Item("black_diamond", "Rare black diamond", 0.15, 1800);
        Item vScroll = new Item("ancient_prophecy", "Scroll with ancient prophecies", 0.3, 600);
        Item vGrimoire = new Item("dark_grimoire", "Ancient dark grimoire", 2, 1500);
        Item vManuscript = new Item("ritual_manuscript", "Manuscript of dark rituals", 1, 800);
        Item vVaultKey = new Item("vault_key", "Key to the treasure vault", 0.1, 300);

        // Ajouter les items aux pièces
        vTempleEntrance.setItem(vTorch);
        
        vMainHall.setItem(vStatue);
        vMainHall.setItem(vTorch);
        vMainHall.setItem(vCandle);
        
        vAltarRoom.setItem(vRitualDagger);
        vAltarRoom.setItem(vIncense);
        
        vTreasureVault.setItem(vGoldCoin);
        vTreasureVault.setItem(vCrown);
        vTreasureVault.setItem(vAmulet);
        vTreasureVault.setItem(vJewel);
        vTreasureVault.setItem(vDiamond);
        
        vRitualChamber.setItem(vCandle);
        vRitualChamber.setItem(vIncense);
        vRitualChamber.setItem(vVaultKey);
        
        vLibrary.setItem(vScroll);
        vLibrary.setItem(vGrimoire);
        vLibrary.setItem(vManuscript);
        
        vSecretPassage.setItem(vTorch);

        // Les portes verrouillées
        Door vDoorVault = new Door(vVaultKey, false);
        vSecretPassage.setDoor("vault", vDoorVault);
        vTreasureVault.setDoor("secret", vDoorVault);

        // Pièce de départ + trésor pour connexions externes
        return new Room[]{vTempleEntrance, vTreasureVault};
    } // createUndergroundTemple()


    /**
     * Crée l'observatoire antique
     * 
     * @return La pièce d'entrée de l'observatoire antique
     */
    public static Room[] createAncientObservatory()
    {
        // Les pièces de l'observatoire
        Room vObservatoryEntrance = new Room("at the ancient observatory entrance", "images/observatory/entrance.jpg");
        Room vMainHall = new Room("in the main hall of the observatory", "images/observatory/main_hall.jpg");
        Room vTelescopeRoom = new Room("in the telescope room", "images/observatory/telescope_room.jpg");
        Room vPlanetarium = new Room("in the planetarium", "images/observatory/planetarium.jpg");
        Room vLibrary = new Room("in the astronomy library", "images/observatory/library.jpg");
        Room vStarCharts = new Room("in the star charts room", "images/observatory/star_charts.jpg");
        Room vRoofDeck = new Room("on the observatory roof deck", "images/observatory/roof_deck.jpg");
        Room vInstrumentRoom = new Room("in the instrument room", "images/observatory/instrument_room.jpg");

        // Le placement des pièces
        vObservatoryEntrance.setExit("hall", vMainHall);
        
        vMainHall.setExit("entrance", vObservatoryEntrance);
        vMainHall.setExit("telescope", vTelescopeRoom);
        vMainHall.setExit("planetarium", vPlanetarium);
        vMainHall.setExit("library", vLibrary);
        vMainHall.setExit("charts", vStarCharts);
        vMainHall.setExit("instruments", vInstrumentRoom);
        
        vTelescopeRoom.setExit("hall", vMainHall);
        vTelescopeRoom.setExit("roof", vRoofDeck);
        
        vPlanetarium.setExit("hall", vMainHall);
        
        vLibrary.setExit("hall", vMainHall);
        
        vStarCharts.setExit("hall", vMainHall);
        
        vRoofDeck.setExit("telescope", vTelescopeRoom);
        
        vInstrumentRoom.setExit("hall", vMainHall);

        // Créer les items
        Item vTelescope = new Item("telescope", "Ancient astronomical telescope", 50, 2000);
        Item vCompass = new Item("astral_compass", "Mystical astral compass", 0.5, 500);
        Item vSextant = new Item("sextant", "Navigation sextant", 1, 300);
        Item vAstrolabe = new Item("astrolabe", "Ancient astrolabe", 2, 800);
        Item vStarMap = new Item("star_map", "Detailed star map", 0.3, 250);
        Item vCelestialGlobe = new Item("celestial_globe", "Ancient celestial globe", 15, 1200);
        Item vLens = new Item("crystal_lens", "Polished crystal lens", 0.2, 400);
        Item vScrolls = new Item("astronomy_scrolls", "Ancient astronomy scrolls", 0.5, 350);
        Item vBook = new Item("astronomy_book", "Book of celestial mechanics", 1, 200);
        Item vManuscript = new Item("star_manuscript", "Manuscript on stars", 0.8, 450);
        Item vMeteor = new Item("meteorite", "Fragment of a meteorite", 3, 600);
        Item vCrystal = new Item("star_crystal", "Glowing star crystal", 0.3, 1000);
        Item vSundial = new Item("sundial", "Ancient sundial", 5, 150);
        Item vQuadrant = new Item("quadrant", "Measuring quadrant", 2, 250);
        Item vRoofKey = new Item("roof_key", "Key to the roof deck", 0.1, 100);

        // Ajouter les items aux pièces
        vObservatoryEntrance.setItem(vCompass);
        
        vMainHall.setItem(vCelestialGlobe);
        vMainHall.setItem(vSundial);
        
        vTelescopeRoom.setItem(vTelescope);
        vTelescopeRoom.setItem(vLens);
        
        vPlanetarium.setItem(vStarMap);
        vPlanetarium.setItem(vCrystal);
        
        vLibrary.setItem(vScrolls);
        vLibrary.setItem(vBook);
        vLibrary.setItem(vManuscript);
        vLibrary.setItem(vRoofKey);
        
        vStarCharts.setItem(vStarMap);
        
        vRoofDeck.setItem(vMeteor);
        
        vInstrumentRoom.setItem(vSextant);
        vInstrumentRoom.setItem(vAstrolabe);
        vInstrumentRoom.setItem(vQuadrant);

        // Les portes verrouillées
        Door vDoorRoof = new Door(vRoofKey, false);
        vTelescopeRoom.setDoor("roof", vDoorRoof);
        vRoofDeck.setDoor("telescope", vDoorRoof);

        // Pièce de départ + telescope room pour connexions externes
        return new Room[]{vObservatoryEntrance, vTelescopeRoom};
    } // createAncientObservatory()

    /**
     * Crée la montagne sacrée
     * 
     * @return La pièce d'entrée de la montagne sacrée
     */
    public static Room[] createSacredMontain()
    {
        // Les pièces de la montagne sacrée
        Room vMountainBase = new Room("at the base of the sacred mountain", "images/mountain/base.jpg");
        Room vForestPath = new Room("on a forest path", "images/mountain/forest_path.jpg");
        Room vRockyTrail = new Room("on the rocky trail", "images/mountain/rocky_trail.jpg");
        Room vCavern = new Room("in a mountain cavern", "images/mountain/cavern.jpg");
        Room vWaterfall = new Room("near a sacred waterfall", "images/mountain/waterfall.jpg");
        Room vMeditation = new Room("in the meditation clearing", "images/mountain/meditation.jpg");
        Room vSummit = new Room("at the mountain summit", "images/mountain/summit.jpg");
        Room vShrine = new Room("in the mountain shrine", "images/mountain/shrine.jpg");

        // Le placement des pièces
        vMountainBase.setExit("forest", vForestPath);
        vMountainBase.setExit("trail", vRockyTrail);
        
        vForestPath.setExit("base", vMountainBase);
        vForestPath.setExit("waterfall", vWaterfall);
        vForestPath.setExit("meditation", vMeditation);
        
        vRockyTrail.setExit("base", vMountainBase);
        vRockyTrail.setExit("cavern", vCavern);
        vRockyTrail.setExit("summit", vSummit);
        
        vCavern.setExit("trail", vRockyTrail);
        
        vWaterfall.setExit("forest", vForestPath);
        
        vMeditation.setExit("forest", vForestPath);
        
        vSummit.setExit("trail", vRockyTrail);
        vSummit.setExit("shrine", vShrine);
        
        vShrine.setExit("summit", vSummit);

        // Créer les items
        Item vRope = new Item("climbing_rope", "Strong climbing rope", 3, 50);
        Item vPickaxe = new Item("ice_pickaxe", "Ice climbing pickaxe", 4, 80);
        Item vTorch = new Item("torch", "Burning torch", 1, 15);
        Item vWaterBottle = new Item("holy_water", "Sacred mountain water", 0.5, 30);
        Item vHerb = new Item("mountain_herb", "Rare healing mountain herb", 0.2, 150);
        Item vFlower = new Item("sacred_flower", "Sacred mountain flower", 0.1, 200);
        Item vCrystal = new Item("mountain_crystal", "Pure mountain crystal", 0.5, 500);
        Item vStatue = new Item("stone_statue", "Ancient stone statue", 30, 800);
        Item vIncense = new Item("incense", "Sacred mountain incense", 0.2, 40);
        Item vCandle = new Item("prayer_candle", "Prayer candle", 0.3, 20);
        Item vBell = new Item("meditation_bell", "Sacred meditation bell", 1, 250);
        Item vScroll = new Item("wisdom_scroll", "Scroll of ancient wisdom", 0.3, 400);
        Item vAmulet = new Item("mountain_amulet", "Protective mountain amulet", 0.2, 600);
        Item vGem = new Item("sapphire", "Blue mountain sapphire", 0.15, 1000);
        Item vShrineKey = new Item("shrine_key", "Key to the mountain shrine", 0.1, 300);

        // Ajouter les items aux pièces
        vMountainBase.setItem(vRope);
        vMountainBase.setItem(vPickaxe);
        
        vForestPath.setItem(vHerb);
        vForestPath.setItem(vFlower);
        
        vRockyTrail.setItem(vTorch);
        
        vCavern.setItem(vCrystal);
        vCavern.setItem(vGem);
        vCavern.setItem(vShrineKey);
        
        vWaterfall.setItem(vWaterBottle);
        
        vMeditation.setItem(vBell);
        vMeditation.setItem(vIncense);
        
        vSummit.setItem(vScroll);
        
        vShrine.setItem(vStatue);
        vShrine.setItem(vCandle);
        vShrine.setItem(vAmulet);

        // Les portes verrouillées
        Door vDoorShrine = new Door(vShrineKey, false);
        vSummit.setDoor("shrine", vDoorShrine);
        vShrine.setDoor("summit", vDoorShrine);

        // Pièce de départ + waterfall pour connexions externes
        return new Room[]{vMountainBase, vWaterfall};
    } // createSacredMontain()

    /**
     * Crée le temple de la sagesse ultime (Ultima Sapientia)
     * C'est la dernière île du jeu où le joueur découvre la vérité
     * 
     * @return La pièce d'entrée du temple Sapientia
     */
    public static Room createSapientiaTemple()
    {
        // Les pièces du temple Sapientia
        Room vTempleGate = new Room("at the gate of Ultima Sapientia temple", "images/sapientia_temple/gate.jpg");
        Room vMainHall = new Room("in the grand hall of wisdom", "images/sapientia_temple/main_hall.jpg");
        Room vHallOfTruth = new Room("in the hall of truth", "images/sapientia_temple/hall_of_truth.jpg");
        Room vHallOfKnowledge = new Room("in the hall of knowledge", "images/sapientia_temple/hall_of_knowledge.jpg");
        Room vSacredLibrary = new Room("in the sacred library of ancients", "images/sapientia_temple/sacred_library.jpg");
        Room vChamberOfSecrets = new Room("in the chamber of secrets", "images/sapientia_temple/chamber_of_secrets.jpg");
        Room vInnerSanctum = new Room("in the inner sanctum", "images/sapientia_temple/inner_sanctum.jpg");
        Room vTreasureVault = new Room("in the vault of eternal treasures", "images/sapientia_temple/treasure_vault.jpg");
        Room vEnd = new Room("You have discovered the truth! YOU WIN!", "images/sapientia_temple/victory.jpg");

        // Le placement des pièces
        vTempleGate.setExit("hall", vMainHall);
        
        vMainHall.setExit("gate", vTempleGate);
        vMainHall.setExit("truth", vHallOfTruth);
        vMainHall.setExit("knowledge", vHallOfKnowledge);
        vMainHall.setExit("library", vSacredLibrary);
        vMainHall.setExit("inner", vInnerSanctum);
        
        vHallOfTruth.setExit("hall", vMainHall);
        
        vHallOfKnowledge.setExit("hall", vMainHall);
        vHallOfKnowledge.setExit("chamber", vChamberOfSecrets);
        
        vSacredLibrary.setExit("hall", vMainHall);
        vSacredLibrary.setExit("vault", vTreasureVault);
        
        vChamberOfSecrets.setExit("knowledge", vHallOfKnowledge);
        
        vInnerSanctum.setExit("hall", vMainHall);
        vInnerSanctum.setExit("end", vEnd);
        
        vTreasureVault.setExit("library", vSacredLibrary);
        
        vEnd.setExit("nowhere", vEnd);

        // Créer les items
        Item vTorch = new Item("eternal_torch", "Torch that burns eternally", 1, 100);
        Item vStatue = new Item("wisdom_statue", "Majestic statue of the goddess of wisdom", 150, 5000);
        Item vCandle = new Item("sacred_candle", "Sacred candle of enlightenment", 0.3, 50);
        Item vIncense = new Item("mystic_incense", "Incense of clarity", 0.2, 80);
        Item vAncientScroll1 = new Item("scroll_of_creation", "Scroll describing the creation of this world", 0.4, 1000);
        Item vAncientScroll2 = new Item("scroll_of_destiny", "Scroll of ancient destinies", 0.4, 1200);
        Item vAncientScroll3 = new Item("scroll_of_time", "Scroll revealing the secrets of time", 0.4, 1500);
        Item vSecret = new Item("the_truth", "The ultimate truth about this world", 0.1, 0);
        Item vVaultKey = new Item("vault_key", "Key to the treasure vault", 0.1, 500);
        Item vChamberKey = new Item("chamber_key", "Key to the chamber of secrets", 0.1, 800);

        // Ajouter les items aux pièces
        vTempleGate.setItem(vTorch);
        vTempleGate.setItem(vCandle);
        
        vMainHall.setItem(vStatue);
        vMainHall.setItem(vIncense);
        vMainHall.setItem(vTorch);
        
        vHallOfTruth.setItem(vAncientScroll1);
        
        vHallOfKnowledge.setItem(vChamberKey);
        
        vSacredLibrary.setItem(vAncientScroll2);
        vSacredLibrary.setItem(vAncientScroll3);
        vSacredLibrary.setItem(vVaultKey);
        
        vChamberOfSecrets.setItem(vSecret);
        
        vInnerSanctum.setItem(vStatue);

        // Les portes verrouillées
        
        Door vDoorChamber = new Door(vChamberKey, false);
        vHallOfKnowledge.setDoor("chamber", vDoorChamber);
        vChamberOfSecrets.setDoor("knowledge", vDoorChamber);
        
        // La porte finale - nécessite l'item "vSecret" pour gagner
        Door vDoorEnd = new Door(vSecret, false);
        vInnerSanctum.setDoor("end", vDoorEnd);
        vEnd.setDoor("nowhere", vDoorEnd);

        // Pièce de départ
        return vTempleGate;
    } // createSapientiaTemple()


} // GameWorld.java