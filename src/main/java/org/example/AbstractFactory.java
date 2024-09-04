package org.example;

public class ExemploAbstractFactory {

    public static String enviarNotificacao(String tipo, String mensagem) {
        FabricaNotificacao fabrica;
        switch (tipo.toLowerCase()) {
            case "email":
                fabrica = new FabricaNotificacaoEmail();
                break;
            case "sms":
                fabrica = new FabricaNotificacaoSMS();
                break;
            case "push":
                fabrica = new FabricaNotificacaoPush();
                break;
            default:
                return "Tipo de notificação desconhecido: " + tipo;
        }

        Notificacao notificacao = fabrica.criarNotificacao();
        return notificacao.enviar(mensagem);
    }
}
