package br.com.model.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="conta")
public class Conta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdGastos", nullable=false)
    private Integer IdGastos;
    
    @Column(name="Observacao", nullable=false, length = 40)
    private String observacao;
    
    @Column(name="conta", length=8)
    private double conta;
   
    @Column (name="DataDeCadastro")
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
        return IdGastos;
    }

    public void setIdGastos(Integer idGastos) {
        this.IdGastos = idGastos;
    }

    public Pessoa getNome() {
        return nome;
    }

    public void setNome(Pessoa nome) {
        this.nome = nome;
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
        hash = 61 * hash + (this.IdGastos != null ? this.IdGastos.hashCode() : 0);
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
        if (this.IdGastos != other.IdGastos && (this.IdGastos == null || !this.IdGastos.equals(other.IdGastos))) {
            return false;
        }
        return true;
    }
    
    
}
