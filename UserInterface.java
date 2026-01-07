import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 * Cette classe implémente une interface utilisateur graphique simple avec 
 * une zone de saisie de texte, une zone de sortie de texte et une image 
 * optionnelle.
 * 
 * @author Clément RUAN
 * @version 17/12/2025
 */
public class UserInterface implements ActionListener
{
    /**
     * Moteur du jeu
     */
    private GameEngine aEngine;
    /**
     * Fenêtre principal du jeu
     */
    private JFrame aMyFrame;
    /**
     * Champ de saisie de texte
     */
    private JTextField aEntryField;
    /**
     * Zone d'affichage du texte ou historique du jeu
     */
    private JTextArea aLog;
    /**
     * Affichage de l'image
     */
    private JLabel aImage;
    /**
     * Bouton pour afficher les commandes disponible
     */
    private JButton aHelpButton;
    /**
     * Bouton pour afficher les différentes descriptions de la pièce actuelle
     */
    private JButton aLookButton;
    /**
     * Bouton pour quitter le jeu
     */
    private JButton aQuitButton;
    /**
     * Bouton pour revenir à la pièce précédente
     */
    private JButton aBackButton;
    /**
     * Bouton pour regarder à l'inventaire du joueur
     */
    private JButton aInventoryButton;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     * 
     * @param pText Le texte affiché
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     * 
     * @param pText Le texte affiché
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.
     * 
     * @param pImageName Chemin du ficher de l'image
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the entry field.
     * 
     * @param pOnOff True active les entrées, False désactive
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff );// enable/disable
        this.aHelpButton.setEnabled( pOnOff );
        this.aLookButton.setEnabled( pOnOff );
        this.aBackButton.setEnabled( pOnOff );
        this.aInventoryButton.setEnabled( pOnOff );
        this.aQuitButton.setEnabled( pOnOff );
        if ( pOnOff ) { // enable
            this.aEntryField.getCaret().setBlinkRate( 500 ); // cursor blink
            this.aEntryField.addActionListener( this ); // reacts to entry
        }
        else { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); // cursor won't blink
            this.aEntryField.removeActionListener( this ); // won't react to entry
        }
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "The Steles of Antevia" ); // change the title !
        this.aEntryField = new JTextField( 34 );

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(100, 100) );
        vListScroller.setMinimumSize( new Dimension(50,50) );
        
        // Ajouts des boutons
        this.aImage = new JLabel();
        this.aHelpButton = new JButton("Help");
        this.aBackButton = new JButton("Back");
        this.aLookButton = new JButton("Look");
        this.aQuitButton = new JButton("Quit");
        this.aInventoryButton = new JButton("Inventory");
        
        // Écouteurs sur les boutons
        this.aHelpButton.addActionListener( this );
        this.aBackButton.addActionListener( this );
        this.aLookButton.addActionListener( this );
        this.aQuitButton.addActionListener( this );
        this.aInventoryButton.addActionListener( this );
        
        // Pour organiser les boutons
        JPanel vButtonPanel = new JPanel();
        vButtonPanel.setLayout(new GridLayout(3,2));
        vButtonPanel.add(this.aHelpButton);
        vButtonPanel.add(this.aBackButton);
        vButtonPanel.add(this.aLookButton);
        vButtonPanel.add(this.aInventoryButton);
        vButtonPanel.add(this.aQuitButton);

        JPanel vPanel = new JPanel();
        vPanel.setLayout( new BorderLayout() ); // ==> only five places
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add( vButtonPanel, BorderLayout.EAST ); // Place les boutons à droite 

        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aEntryField.addActionListener( this );

        // to end program when window is closed
        this.aMyFrame.addWindowListener(
            new WindowAdapter() { // anonymous class
                @Override public void windowClosing(final WindowEvent pE)
                {
                    System.exit(0);
                }
        } );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     */
    @Override public void actionPerformed( final ActionEvent pE ) 
    {
        // no need to check the type of action at the moment
        // because there is only one possible action (text input) :
        String vCommand = pE.getActionCommand();
        
        if (vCommand.equals("Help"))
        {
            this.aEngine.interpretCommand("help");
        } 
        else if (vCommand.equals("Back"))
        {
            this.aEngine.interpretCommand("back");
        } 
        else if (vCommand.equals("Look"))
        {
            this.aEngine.interpretCommand("look");
        } 
        else if (vCommand.equals("Inventory"))
        {
            this.aEngine.interpretCommand("inventory");
        } 
        else if (vCommand.equals("Quit"))
        {
            this.aEngine.interpretCommand("quit");
        } 
        else 
        {
            this.processCommand(); // never suppress this line
        }
    } // actionPerformed(.)

    /**
     * A command has been entered in the entry field.  
     * Read the command and do whatever is necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
} // UserInterface 

