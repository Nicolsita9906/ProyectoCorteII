package excepciones;
import javax.swing.JFrame;
public class NotificarExito extends RuntimeException {
	public NotificarExito (JFrame ventana) {
		super ();
	}
}
