package laskin;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Miinus extends LolKomento {
  public Miinus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus){
    super.Lolkomento(tuloskentta, syotekentta, nollaa, undo, sovellus);
  }

  public void laske(int luku){
    sovellus.miinus(luku);
  }
}