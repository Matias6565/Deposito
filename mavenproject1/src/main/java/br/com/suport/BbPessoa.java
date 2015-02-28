package br.com.suport;

import br.com.model.DAO.HibernateDAO;
import br.com.model.DAO.InterfaceDAO;
import br.com.model.entities.*;
import br.com.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbPessoa")
@RequestScoped
public class BbPessoa  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public List<Pessoa>getPessoa() {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO.getEntities();
    }	
}