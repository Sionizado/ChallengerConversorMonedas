import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcionSeleccionada = 0;

        Consultas consultas = new Consultas();

        Calculo calculo = new Calculo(consultas);

        CreadorArchivo creadorArchivo = new CreadorArchivo();

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n******************************************
                    Sea bienvenid@ al conversor de monedas
                   \s
                    1)Peso Argentino => DOLAR Estadounidense
                    2)Peso Argentino => EURO              \s
                    3)Peso Argentino => YENES
                    4)DOLAR Estadounidense => Peso Argentino
                    5)EURO => Peso Argentino
                    6)YENES => Peso Argenino
                   \s
                    7)Salir
                   \s
                    Elija una opción válida:
                ******************************************
               \s""";

        while(opcionSeleccionada != 7){
            try{
                System.out.println(menu);
                opcionSeleccionada = Integer.parseInt(teclado.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (opcionSeleccionada){
                    case 1:
                        calculo.valoresAlmacenados("ARS", "USD");
                        respuestas.add(formattedDate + "---" + calculo.mensajeDeRespuesta());
                        break;
                    case 2:
                        calculo.valoresAlmacenados("ARS", "EUR");
                        respuestas.add(formattedDate + "---" + calculo.mensajeDeRespuesta());
                        break;
                    case 3:
                        calculo.valoresAlmacenados("ARS", "JPY");
                        respuestas.add(formattedDate + "---" + calculo.mensajeDeRespuesta());
                        break;
                    case 4:
                        calculo.valoresAlmacenados("USD", "ARS");
                        respuestas.add(formattedDate + "---" + calculo.mensajeDeRespuesta());
                        break;
                    case 5:
                        calculo.valoresAlmacenados("EUR", "ARS");
                        respuestas.add(formattedDate + "---" + calculo.mensajeDeRespuesta());
                        break;
                    case 6:
                        calculo.valoresAlmacenados("JPY", "ARS");
                        respuestas.add(formattedDate + "---" + calculo.mensajeDeRespuesta());
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                }
            }catch (NumberFormatException | InputMismatchException | JsonSyntaxException | NullPointerException e){
                System.out.println("Error, ingrese una opción válida.");
            }
            creadorArchivo.generarJson(respuestas);

            System.out.println("Finalizando programa");
        }

    }
}
