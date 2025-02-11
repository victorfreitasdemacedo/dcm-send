package org.riogrande.util.hibernateorm.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "study") // Nome da tabela no banco de dados
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento para idStudy
    @Column(name = "id_study")
    private Integer idStudy;

    @Column(name = "nome_paciente")
    private String nomePaciente;

    @Column(name = "id_paciente")
    private String idPaciente;

    @Column(name = "dth_study")
    private Date dthStudy;

    @Column(name = "uuid_study")
    private String uuidStudy;

    @Column(name = "status")
    private String status;

    // Relacionamento OneToMany com a entidade FilesStudy
    @OneToMany(mappedBy = "study", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FilesStudy> filesStudies;

    // Getters e Setters

    public Integer getIdStudy() {
        return idStudy;
    }

    public void setIdStudy(Integer idStudy) {
        this.idStudy = idStudy;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getDthStudy() {
        return dthStudy;
    }

    public void setDthStudy(Date dthStudy) {
        this.dthStudy = dthStudy;
    }

    public String getUuidStudy() {
        return uuidStudy;
    }

    public void setUuidStudy(String uuidStudy) {
        this.uuidStudy = uuidStudy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FilesStudy> getFilesStudies() {
        return filesStudies;
    }

    public void setFilesStudies(List<FilesStudy> filesStudies) {
        this.filesStudies = filesStudies;
    }
}
