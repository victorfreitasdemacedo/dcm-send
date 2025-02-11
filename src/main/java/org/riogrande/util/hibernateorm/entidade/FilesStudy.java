package org.riogrande.util.hibernateorm.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "files_study") // Nome da tabela no banco de dados
public class FilesStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento para idFilesStudy
    @Column(name = "id_files_study")
    private Integer idFilesStudy;

    @ManyToOne
    @JoinColumn(name = "fk_study", referencedColumnName = "id_study") // FK referenciando id_study na tabela study
    private Study study; // Relacionamento com a entidade Study

    @Column(name = "uuid_files_study")
    private String uuidFilesStudy;

    @Column(name = "origem")
    private String origem;

    @Column(name = "destino")
    private String destino;

    @Column(name = "status")
    private String status;

    // Getters e Setters

    public Integer getIdFilesStudy() {
        return idFilesStudy;
    }

    public void setIdFilesStudy(Integer idFilesStudy) {
        this.idFilesStudy = idFilesStudy;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public String getUuidFilesStudy() {
        return uuidFilesStudy;
    }

    public void setUuidFilesStudy(String uuidFilesStudy) {
        this.uuidFilesStudy = uuidFilesStudy;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
