package br.com.itinerario.factory;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Sandersoon
 */
public class ParentFactory {

    private final String PARENT_TELA_PRINCIPAL = "resources/Principal.fxml";
    private final String PARENT_TELA_LOGIN = "resources/TelaLogin.fxml";
    private final String PARENT_TELA_CADASTRO_PASSAGEIRO = "resources/CadastroPassageiro.fxml";

    public Parent parentTelaPrincipal() throws Exception {
        try {
            return FXMLLoader.load(getClass().getClassLoader().getResource(PARENT_TELA_PRINCIPAL));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Parent parentTelaLogin() throws Exception {
        try {
            return FXMLLoader.load(getClass().getClassLoader().getResource(PARENT_TELA_LOGIN));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Parent parentTelaCadastroPassageiro() throws Exception {
        try {
            return FXMLLoader.load(getClass().getClassLoader().getResource(PARENT_TELA_CADASTRO_PASSAGEIRO));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
