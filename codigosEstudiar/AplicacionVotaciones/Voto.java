package codigosEstudiar.AplicacionVotaciones;

public class Voto {
    private long idVoto;
    private Votante votante;
    private Candidatos candidato;

    public String[] candidatos = {
        "Laura Martínez", "Carlos Gómez", 
        "Ana Torres", "Javier Ríos", "Lucía Herrera"
    };
    public int cantidadCandidatos = candidatos.length;

    public String[] partidos = {
        "Partido Verde", "Partido Azul", 
        "Partido Rojo", "Partido Morado", "Partido Naranja"
    };
    public int cantidadPartidos = partidos.length;

    public Voto(Votante votante, Candidatos candidato) {
        this.idVoto = (long) (Math.random() * 9999999999L);
        this.votante = votante;
        this.candidato = candidato;
    }
    
    public long getIdVoto() {
        return idVoto;
    }

    public Votante getVotante() {
        return votante;
    }

    public Candidatos getCandidato() {
        return candidato;
    }

    public void setIdVoto(long idVoto) {
        this.idVoto = idVoto;
    }
    public void setVotante(Votante votante) {
        this.votante = votante;
    }
    public void setCandidato(Candidatos candidato) {
        this.candidato = candidato;
    }
   
    public String toString() {
        return "- Voto -" +
                "idVoto=" + idVoto +
                "votante=" + votante +
                "candidato=" + candidato;
    }

}
