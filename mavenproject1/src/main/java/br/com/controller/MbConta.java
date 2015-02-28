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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.RequestScoped;


@ManagedBean (name = "mbConta")
@RequestScoped
public class MbConta implements Serializable {
    private static final long serialVersionUID = 1L;
    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;
    private Conta conta = new Conta();
    private List<Conta> contas;

    public MbConta() {
    }
    
     private InterfaceDAO<Conta> contaDAO() {
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
      
      public void salvarConta(Conta conta){
          conta.setDataDeCadastro(new Date());
          this.contaDAO().save(conta);
      }
      private void insertConta() {
        contaDAO().save(conta);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }
}
