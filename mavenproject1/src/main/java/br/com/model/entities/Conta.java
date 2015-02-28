package br.com.model.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;
import static org.hibernate.type.TypeFactory.serializable;

@Entity
@Table(name="conta")
public class Conta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdGastos", nullable=false)
    private Integer idGastos;
    
    @Column(name="Observacao", nullable=false, length = 40)
    private String observacao;
    @Column(name="conta", length=8)
    private double conta;
    @Column (name="DataDeCadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;

    @ManyToOne(optional=false)
    @ForeignKey(name = "PessoaNome") 
    @JoinColumn(name="IdPessoa", referencedColumnName = "idPessoa")
    private Pessoa nome;

    public Conta() {
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }
    
    
    public Integer getIdGastos() {
        return idGastos;
    }

    public void setIdGastos(Integer idGastos) {
        this.idGastos = idGastos;
    }

    public double getConta() {
        return conta;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.idGastos != null ? this.idGastos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (this.idGastos != other.idGastos && (this.idGastos == null || !this.idGastos.equals(other.idGastos))) {
            return false;
        }
        return true;
    }
    
    
}
