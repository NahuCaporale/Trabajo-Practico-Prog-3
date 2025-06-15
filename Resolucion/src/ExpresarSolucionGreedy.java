import java.util.List;

public class ExpresarSolucionGreedy extends Solucion {
    int candidatosConsiderados;

    public ExpresarSolucionGreedy() {
        this.candidatosConsiderados = 0;
    }

    public ExpresarSolucionGreedy(List<String> maquinasUsadas, int piezasProd, int puestas, int candidatos) {
        super(maquinasUsadas, piezasProd, puestas);
        this.candidatosConsiderados = candidatos;
    }

    public int getCandidatosConsiderados() {
        return candidatosConsiderados;
    }

    public void setCandidatosConsiderados(int candidatosConsiderados) {
        this.candidatosConsiderados = candidatosConsiderados;
    }

    public void copiar(List<String> maquinasUsadas, int piezasProd, int puestas, int candidatosConsiderados) {
        super.maquinas.clear();
        super.maquinas.addAll(maquinasUsadas);
        super.setPuestasEnFunc(puestas);
        this.piezasProd = piezasProd;
        this.candidatosConsiderados = candidatosConsiderados;
    }
    @Override
    public String toString() {
        return "Solucion greedy :" +
                "\nMaquinas usadas:" + maquinas +
                ",\nPiezas producidas:" + piezasProd +
                ",\nPuestas en funcionamiento:" + getPuestasEnFunc() +
                "\nCandidatos considerados:" + candidatosConsiderados;

    }
}
