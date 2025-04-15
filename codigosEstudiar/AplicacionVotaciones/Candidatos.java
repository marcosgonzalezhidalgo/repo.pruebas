package codigosEstudiar.AplicacionVotaciones;

public class Candidatos {
    private String nombreCandidato;
    private String partidoCandidato;

    public Candidatos(String nombreCandidato, String partidoCandidato) {
        this.nombreCandidato = nombreCandidato;
        this.partidoCandidato = partidoCandidato;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }
    public String getPartidoCandidato() {
        return partidoCandidato;
    }
    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }
    public void setPartidoCandidato(String partidoCandidato) {
        this.partidoCandidato = partidoCandidato;
    }

    public String toStringCandidato() {
        return "- Candidatos -" +
                "nombreCandidato='" + nombreCandidato + '\'' +
                "partidoCandidato='" + partidoCandidato + '\'';
    }

}
