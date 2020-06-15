package org.acme.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Id do produto")
    public Long id;
    @ApiModelProperty(value = "Nome do produto")
    public String nome;

    public BigDecimal valor;

    @UpdateTimestamp
    public Date dataCriacao;
    @UpdateTimestamp
    public Date dataAtualizada;

}
