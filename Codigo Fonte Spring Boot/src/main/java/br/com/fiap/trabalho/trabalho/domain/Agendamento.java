package br.com.fiap.trabalho.trabalho.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "agendamento", sequenceName = "SQ_AGENDAMENTO", allocationSize = 1)
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento")
    private int codigo;

    @NotBlank(message = "Nome obrigatório!")
    @Size(max = 100)
    private String nome_cliente;

    @NotBlank(message = "Selecione a origem")
    @Size(max = 500)
    private String local_origem;

    @NotBlank(message = "Selecione o destino")
    @Size(max = 500)
    private String local_destino;

    @NotBlank(message = "Digite a data")
    private String data;

    @NotBlank(message = "Digite o horário")
    private String hora;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getLocal_origem() {
        return local_origem;
    }

    public void setLocal_origem(String local_origem) {
        this.local_origem = local_origem;
    }

    public String getLocal_destino() {
        return local_destino;
    }

    public void setLocal_destino(String local_destino) {
        this.local_destino = local_destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
