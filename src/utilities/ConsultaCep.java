package utilities;

import com.google.gson.Gson;
    import utilities.Endereco;

import javax.swing.*;
import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;

    public class ConsultaCep {

        public Endereco buscaEndereco(String cep) {

            URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

            if (!cep.matches("\\d{8}")) {
                JOptionPane.showMessageDialog(null,"Formato de CEP inválido. Digite um CEP válido com 8 dígitos.");
            }

            try {
                HttpResponse<String> response = HttpClient
                        .newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Endereco.class);
            } catch (Exception e) {
                throw new RuntimeException("Não foi possível consultar o endereço a partir desse CEP.");

            }
        }
    }
