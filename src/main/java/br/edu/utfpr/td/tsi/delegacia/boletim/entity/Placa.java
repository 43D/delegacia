package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Emplacamento")
public class Placa implements Serializable{

    @Id
    @Column(name = "placa")
    private String placa;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cidade")
    private String cidade;

    public Placa(String placa, String estado, String cidade) {
        this.placa = placa;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Placa() {
    }
    
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    @Override
    public String toString() {
        return "{placa: " + placa + ", estado: " + estado + ", cidade: " + cidade + "}";
    }

}
