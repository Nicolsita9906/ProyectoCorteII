package excepciones;
import javax.swing.JFrame;
public class StockBajo extends RuntimeException {
    public StockBajo(JFrame ventana)  {
        super();
    }
}