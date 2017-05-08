package br.com.itinerario.utils;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Classe Utilitária que contém métodos para envio de Email através de conta do
 * Gmail
 */
public class JavaMailApp {

    Session session = null;
    private static final String EMAIL_REMETENTE = "goitinerario@gmail.com";
    private static final String SENHA_REMETENTE = "go123456";

    /**
     * Construtor sem parametros, ao ser chamado já instancia as configuraççoes
     * de email do Gmail na JVM
     *
     */
    public JavaMailApp() {

        ajustaParametros();

    }

    /**
     * Metodo para envio de mensagem com texto simples
     */
    public void enviarEmail(String destinatario, String assunto, String conteudo) {

        try {

            Message message = new MimeMessage(session);

            //Configura o Remetente da mensagem
            message.setFrom(new InternetAddress(this.EMAIL_REMETENTE));

            //Configura o Destinatário da mensagem
            Address[] toUser = InternetAddress.parse(destinatario);

            //Configura o Assunto da mensagem
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);

            //Configura o Conteudo da mensagem
            message.setText(conteudo);

            /**
             * Envia a mensagem criada
             */
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo para envio de mensagem padrao HTML ja formatado
     */
    public void enviarEmailHtml(String destinatarios, String assunto, String conteudoHtml) {

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.EMAIL_REMETENTE));

            Address[] toUser = InternetAddress.parse(destinatarios);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);

            Multipart multipart = new MimeMultipart("related");
            BodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(conteudoHtml, "text/html");

            multipart.addBodyPart(htmlPart);

            message.setContent(multipart);

            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * Configura aa propriedades da JVM com parametros do servidor Gmail
     *
     * Modificador de acesso 'private' pois não é necessário que este método
     * seja chamado de outras classes
     */
    private void ajustaParametros() {

        Properties props = new Properties();

        /**
         * Conexão com servidor Gmail
         */
        props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);

        /**
         * Associa autenticação a sessao de correio
         */
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(JavaMailApp.EMAIL_REMETENTE, JavaMailApp.SENHA_REMETENTE);
            }
        });

    }

}
