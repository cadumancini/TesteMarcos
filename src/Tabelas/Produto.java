/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author cemancini
 */
@Entity
@Table(name="Produto")
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(length=14, nullable=false)
    private String codigo;
    
    @Column(length=40, nullable=false)
    private String descricao;
    
    @OneToMany (mappedBy = "modelo", targetEntity = Componente.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Componente> componentes;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the componentes
     */
    public List<Componente> getComponentes() {
        return componentes;
    }

    /**
     * @param componentes the componentes to set
     */
    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
}
