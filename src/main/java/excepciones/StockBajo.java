package excepciones;

public class StockBajo extends RuntimeException {
    public StockBajo(String mensaje)  {
        super(mensaje);
    }
}