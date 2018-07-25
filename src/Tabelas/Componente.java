/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author cemancini
 */

@Entity
@Table(name="Componente")
public class Componente implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn
    private Produto modelo;
    
    @Column(nullable=false)
    private Produto componente; 
    
    @Column(nullable=false)
    private Double quantidade;

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
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the modelo
     */
    public Produto getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Produto modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the componente
     */
    public Produto getComponente() {
        return componente;
    }

    /**
     * @param componente the componente to set
     */
    public void setComponente(Produto componente) {
        this.componente = componente;
    }
}
