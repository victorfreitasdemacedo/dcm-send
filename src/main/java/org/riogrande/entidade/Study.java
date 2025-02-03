package org.riogrande.entidade;

import java.util.Date;

public class Study {

    private Integer idStudy;
    private String nomePaciente;
    private String idPaciente;
    private Date dthStudy;
    private String uuidStudy;
    private String status;

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

}
