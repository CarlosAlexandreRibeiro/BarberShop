package Servico;

import Model.Agendamento;

public class Correio {
    
    public void NotificarPorEmail(Agendamento agendamento){
        
        String emailFormatado = formatarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();  
        
        Email email = new Email("Agendamento BarberShop", emailFormatado, destinatario);
        email.enviar();
    }

    private String formatarEmail(Agendamento agendamento) {
        
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        float valor = agendamento.getValor();
        
        return "Olá, " + nomeCliente + 
                ". Seu agendamento está marcado para o dia " + dataAgendamento + 
                " às " + horaAgendamento + ". No valor de: R$" + valor + " Abraço!";
        
    }
    
}
