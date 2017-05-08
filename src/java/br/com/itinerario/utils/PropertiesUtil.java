package br.com.itinerario.utils;

import java.util.ResourceBundle;

public class PropertiesUtil {

    private static final ResourceBundle RESOURCE_MSG
            = ResourceBundle.getBundle("strings");

    private static final ResourceBundle RESOURCE_CONF
            = ResourceBundle.getBundle("conf");

    private static final ResourceBundle RESOURCE_FORM
            = ResourceBundle.getBundle("forms");
    
    private static final ResourceBundle RESOURCE_SETTINGS
            = ResourceBundle.getBundle("settings");

    public static final String STRINGS_ERRO_SALVAR = "msg_erro_salvar";
    public static final String STRINGS_ERRO_LISTAR = "msg_erro_listar";
    public static final String STRINGS_ERRO_ALTERAR = "msg_erro_alterar";
    public static final String STRINGS_ERRO_EXCLUIR = "msg_erro_excluir";
    public static final String STRINGS_ERRO_BUSCAR = "msg_erro_buscar";

    public static final String STRINGS_SUCESSO_SALVAR = "msg_sucesso_salvar";
    public static final String STRINGS_SUCESSO_LISTAR = "msg_sucesso_listar";
    public static final String STRINGS_SUCESSO_ALTERAR = "msg_sucesso_alterar";
    public static final String STRINGS_SUCESSO_BUSCAR = "msg_sucesso_buscar";
    public static final String STRINGS_SUCESSO_EXCLUIR = "msg_sucesso_remover";

    public static final String INF_NOME = "inf_nome";
    public static final String INF_ESTADO = "inf_estado";

    public static final String CONF_JDBC_URL = "jdbc_url";
    public static final String CONF_JDBC_USER = "jdbc_user";
    public static final String CONF_JDBC_PASSWORD = "jdbc_password";
    
    public static final String SETTINGS_UP_NAME = "unidade_persistencia";

    public static String getMsg(String key) {
        return RESOURCE_MSG.getString(key);
    }

    public static String getConf(String key) {
        return RESOURCE_CONF.getString(key);
    }

    public static String getForm(String key) {
        return RESOURCE_FORM.getString(key);
    }
    
    public static String getSettings(String key) {
        return RESOURCE_SETTINGS.getString(key);
    }

}
