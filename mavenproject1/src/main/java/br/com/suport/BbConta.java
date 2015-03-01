package br.com.suport;
import br.com.model.DAO.HibernateDAO;
import br.com.model.DAO.InterfaceDAO;
import br.com.model.entities.Conta;
import br.com.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="bbConta")
@RequestScoped
public class BbConta  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Conta> contas;

    public List<Conta> getCidades() {
        InterfaceDAO<Conta> contaDAO = new HibernateDAO<Conta>(Conta.class, FacesContextUtil.getRequestSession());
        return contaDAO.getEntities();
    }
}