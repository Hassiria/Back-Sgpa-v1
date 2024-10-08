package br.edu.ufape.poo.sgpa.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import br.edu.ufape.poo.sgpa.model.enums.Segmento;


@Entity
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "contato")
    private String contato;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<SlotHorario> horarioDeFuncionamento;

    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Instrutor> instrutores;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Plano> planos;

    @Enumerated(EnumType.STRING)
    private Segmento segmento;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Membro membro;

    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Administrador administrador;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Turma> turmas;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Sala> salas;

    public Unidade(){

    }

    public Unidade(String nome, String cnpj, String contato, List<SlotHorario> horarioDeFuncionamento, String email, List<Instrutor> instrutores, List<Plano> planos, Segmento segmento, Endereco endereco, Membro membro, Administrador administrador, List<Turma> turmas, List<Sala> salas) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.email = email;
        this.instrutores = instrutores;
        this.planos = planos;
        this.segmento = segmento;
        this.endereco = endereco;
        this.membro = membro;
        this.administrador = administrador;
        this.turmas = turmas;
        this.salas = salas;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getContato(){
        return contato;
    }
    public void setContato(String contato){
        this.contato = contato;
    }

    public List<SlotHorario> getHorarioDeFuncionamento() {
        return horarioDeFuncionamento;
    }

    public void setHorarioDeFuncionamento(List<SlotHorario> horarioDeFuncionamento) {
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

    public List<Sala> getSalas() {
        return salas;
    }
    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(List<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }

    public List<Plano> getPlanos(){
        return planos;
    }
    public void setPlanos(List<Plano> planos){
        this.planos = planos;
    }

    public Endereco getEndereco(){
        return endereco;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public Segmento getSegmento(){
        return segmento;
    }
    public void setSegmento(Segmento segmento){
        this.segmento = segmento;
    }

    public Membro getMembro(){
        return membro;
    }
    public void setMembro(Membro membro){
        this.membro = membro;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Administrador getAdministrador(){
      return administrador;
    }
    public void setAdministrador(Administrador administrador){
     this.administrador = administrador;
     }

     public List<Sala> getSala(){
        return salas;
     }
     public void setSala(List<Sala> salas){
        this.salas = salas;
     }

    @Override
    public String toString() {
        return "Unidade{" +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", contato='" + contato + '\'' +
                ", horarioDeFuncionamento='" + horarioDeFuncionamento + '\'' +
                ", email='" + email + '\'' +
                ", instrutor=" + instrutores +
                ", plano=" + planos +
                ", segmentos=" + segmento +
                ", endereco=" + endereco +
                ", membros=" + membro +
                ", turmas=" + turmas +
                ", administrador=" + administrador +
                ", salas=" + salas +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unidade)) return false;
        Unidade unidade = (Unidade) o;
        return id == unidade.id &&
                Objects.equals(nome, unidade.nome) &&
                Objects.equals(cnpj, unidade.cnpj) &&
                Objects.equals(contato, unidade.contato) &&
                Objects.equals(horarioDeFuncionamento, unidade.horarioDeFuncionamento) &&
                Objects.equals(email, unidade.email) &&
                Objects.equals(instrutores, unidade.instrutores) &&
                Objects.equals(planos, unidade.planos) &&
                Objects.equals(segmento, unidade.segmento) &&
                Objects.equals(endereco, unidade.endereco) &&
                Objects.equals(turmas, unidade.turmas) &&
                Objects.equals(salas, unidade.salas);
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cnpj, contato, horarioDeFuncionamento, email, instrutores, planos, segmento, endereco, turmas, salas);
    }
}
