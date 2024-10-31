package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor>desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){
        if (this.vagas > desenvolvedores.size()){
            this.desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            this.desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Double getTotalSalarios() {
        Double total = 0.0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor desenvolvedorDaVez = desenvolvedores.get(i);
            total += desenvolvedorDaVez.calcularSalario();

        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer total = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor instanceof DesenvolvedorMobile){
                total++;
            }
        }
        return total;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedoresSalario = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor.calcularSalario() >= salario){
                desenvolvedoresSalario.add(desenvolvedor);
            }
        }
        return desenvolvedoresSalario;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.size() <= 0){
            return null;
        }
            Desenvolvedor menor = desenvolvedores.get(0);
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if (desenvolvedor.calcularSalario() < menor.calcularSalario()){
                    menor= desenvolvedor;
                }
            }
        return menor;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedoresTecnologia = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) desenvolvedor).getLinguagem().equalsIgnoreCase(tecnologia) || ((DesenvolvedorMobile) desenvolvedor).getPlataforma().equalsIgnoreCase(tecnologia)) {
                    desenvolvedoresTecnologia.add(desenvolvedor);

                }
            }
            if (desenvolvedor instanceof DesenvolvedorWeb)
                if (((DesenvolvedorWeb) desenvolvedor).getBackend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) desenvolvedor).getFrontend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) desenvolvedor).getSgbd().equalsIgnoreCase(tecnologia)) {
                    desenvolvedoresTecnologia.add(desenvolvedor);
        }}
        return desenvolvedoresTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedoresTecnologia = buscarPorTecnologia(tecnologia);
        double total = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedoresTecnologia) {
            total += desenvolvedor.calcularSalario();
        }
        return total;
    }
}
