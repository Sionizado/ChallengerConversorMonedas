import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreadorArchivo {
    public void generarJson(List<String> lista){
        try{
            FileWriter fileWriter = new FileWriter("consultas.txt");
            for (String resultado : lista) {
                fileWriter.write(resultado);
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Conversion guardada en 'consultas.txt'");
        }catch (IOException e){
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }
}
