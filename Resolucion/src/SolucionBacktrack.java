import java.util.List;

public class SolucionBacktrack extends Solucion {
    private int estadosGenerados;

    public SolucionBacktrack() {
        this.estadosGenerados = 0;
    }

    public SolucionBacktrack(List<String> maquinasUsadas, int piezasProd, int puestas, int estados) {
        super(maquinasUsadas, piezasProd, puestas);
        this.estadosGenerados = estados;
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public void setEstadosGenerados(int estadosGenerados) {
        this.estadosGenerados = estadosGenerados;
    }

    public void copiar(List<String> maquinasUsadas, int piezasProd, int puestas, int estadosGenerados) {
        super.maquinas.clear();
        super.maquinas.addAll(maquinasUsadas);
        super.setPuestasEnFunc(puestas);
        this.piezasProd = piezasProd;
        this.estadosGenerados = estadosGenerados;
    }

    @Override
    public String toString() {
        return "SolucionBacktrack :" +
                "\nMaquinas usadas:" + maquinas +
                ",\nPiezas producidas:" + piezasProd +
                "\nPuestas en funcionamiento:" + getPuestasEnFunc() +
                "\nEstados generados:" + estadosGenerados + "\n" ;

    }
}
