package Controller;

import Controller.Helper.AgendaHelper;
import java.util.ArrayList;
import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import View.Agenda;

public class AgendaController {

    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela() {
        
        // busca lista com agendamentos do BD
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        // exibir esta lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaCliente() {
        
        // busca clientes no BD
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        // exibir clientes no Combox cliente
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServico() {
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
    }
    
    public void atualizaValor() {
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void agendar() {
        // busacar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        
        // salva objeto no BD
        new AgendamentoDAO().insert(agendamento);
        
        // inserir elemento na tela
        atualizaTabela();
        helper.limparTela();
    }
}
