package view;

import javax.swing.*;

public class Interface {
    public String obterCep() {
        return JOptionPane.showInputDialog("Digite um CEP para consulta: ");
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

}
