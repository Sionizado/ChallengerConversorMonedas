import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consultas {
    public String Conversion(String monedaBase, String monedaDestino, double monto){
        try {
            //url de la api con la apikey
            URI  direccionApi = URI.create("https://v6.exchangerate-api.com/v6/87422771af69a6c20a597be5/pair/"+
                    monedaBase + "/" + monedaDestino + "/" + monto);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccionApi)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            return jsonObject.get("conversion_result").getAsString();

        } catch (NumberFormatException | IOException | InterruptedException e){
            System.out.println("Hubo un error: ");
            throw new RuntimeException("Error" + e.getMessage());
        }
    }
}
