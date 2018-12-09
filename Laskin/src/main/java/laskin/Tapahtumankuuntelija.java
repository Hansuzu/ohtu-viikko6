package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private TextField tuloskentta; 
    private TextField syotekentta; 
    private Button plus;
    private Button miinus;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Map<Button, Komento> komennot;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        komennot.put(plus, new Plus(tuloskentta, syotekentta,  nollaa, undo, sovellus));
        komennot.put(miinus, new Miinus(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta,  nollaa, undo, sovellus));
    }
    
    @Override
    public void handle(Event event) {
 
        if (event.getTarget() == plus) {
            sovellus.plus(arvo);
        } else if (event.getTarget() == miinus) {
            sovellus.miinus(arvo);
        } else if (event.getTarget() == nollaa) {
            sovellus.nollaa();
        } else {
            System.out.println("undo pressed");
        }
        
    }

}
