import utilities.ConsultaCep;
import utilities.Endereco;
import utilities.GeradorDeArquivo;
import view.Interface;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Interface userInterface = new Interface();
        ConsultaCep consultaCep = new ConsultaCep();

        try {
            String cep = userInterface.obterCep();
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);

            userInterface.mostrarMensagem("Endereço encontrado:\n" + novoEndereco);

            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.geraJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("A aplicação falhou e foi finalizada.");
        }
    }
}
