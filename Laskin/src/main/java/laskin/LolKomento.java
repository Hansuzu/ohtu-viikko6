package laskin;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public abstract class LolKomento implements Komento{
  private TextField tuloskentta; 
  private TextField syotekentta; 
  private Button nollaa;
  private Button undo;
  private Sovelluslogiikka sovellus;
  public LolKomento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus){
    this.tuloskentta=tuloskentta;
    this.syotekentta=syotekentta;
    this.nollaa=nollaa;
    this.undo=undo;
    this.sovellus=sovellus;
  }

  public int hommaaSyotekentanLuku(){
    try {
      return Integer.parseInt(syotekentta.getText());
    } catch (Exception e) {
      return 0;
    }
  }

  public void paivitaLaskinTila(){
    syotekentta.setText("");
    tuloskentta.setText("" + laskunTulos);
    
    if ( laskunTulos==0 ) {
        nollaa.disableProperty().set(true);
    } else {
        nollaa.disableProperty().set(false);
    }
    undo.disableProperty().set(false);
  }
  
  public void suorita(){
    laske(hommaaSyotekentanLuku());
    paivitaLaskinTila();
  }

  protected abstract int laske(int luku);
}