import java.util.Scanner;

public class Calculo {
    private String monedaBase;
    private String monedaDestino;
    private double monto;

    Scanner teclado = new Scanner(System.in);
    Consultas consultas;

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getMonto() {
        return monto;
    }

    public Calculo(Consultas consultas){
        this.consultas = consultas;
    }
    public void valoresAlmacenados(String monedaBase, String monedaDestino){
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;

        System.out.println("Ingrese el monto que desea convertir");

        this.monto = Double.parseDouble(teclado.nextLine());
    }

    public String mensajeDeRespuesta(){
        String mensaje = getMonedaBase().toUpperCase() + " " + getMonto() +
                " son equivalentes a " + getMonedaDestino().toUpperCase() + " "
                + consultas.Conversion(getMonedaBase(), getMonedaDestino(),getMonto());
        System.out.println(mensaje);
        return mensaje;

    }
}
