package br.com.controller;

import br.com.model.DAO.HibernateDAO;
import br.com.model.DAO.InterfaceDAO;
import br.com.model.entities.Conta;
import br.com.model.entities.Pessoa;
import br.com.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.RequestScoped;


@ManagedBean (name = "mbConta")
@RequestScoped
public class MbConta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Conta conta = new Conta();
    private List<Conta> contas;
    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;
    
   
    
     private InterfaceDAO<Conta> contaDAO(){
        InterfaceDAO<Conta> contaDAO = new HibernateDAO<Conta>(Conta.class, FacesContextUtil.getRequestSession());
        return contaDAO;  
    }
     
         private InterfaceDAO<Pessoa> pessoaDAO() {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
         }
    
      public String deleteConta() {
        contaDAO().remove(conta);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        return null;
    }   
      
       public String limpConta() {
        conta = new Conta();
       return "/restrict/cadastrarcontas.faces";
          }
       
        private void insertConta(){ 
            contaDAO().save(conta);
            conta.setDataDeCadastro(new Date());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        }
    
      
      public String addConta() {
        if (conta.getIdGastos() == null || conta.getIdGastos() == 0 ) {
            insertConta();
        } else {
            updateConta();
        }
        limpConta();
        return null;
    }
      
       private void updateConta() {
        contaDAO().update(conta);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
      
}
