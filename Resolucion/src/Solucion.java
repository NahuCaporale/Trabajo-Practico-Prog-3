import java.util.ArrayList;
import java.util.List;

public class Solucion {
    private List<String> maquinas;
    private int puestasEnFunc;
    private int estadosGenerados;
    int piezasProd;

    public int getPiezasProd() {
        return piezasProd;
    }

    public void setPiezasProd(int piezasProd) {
        this.piezasProd = piezasProd;
    }

    public Solucion() {
        maquinas = new ArrayList<>();
        this.puestasEnFunc = 0;
        this.estadosGenerados = 0;
        this.piezasProd = 0;
    }

    public Solucion(List<String> maquinasUsadas, int piezasProd, int puestas, int estados) {
        maquinas = new ArrayList<>();
        this.puestasEnFunc = 0;
        this.estadosGenerados = 0;
        this.piezasProd = 0;
    }

    public void copiar(List<String> maquinasUsadas, int piezasProd, int puestas, int estados) {
        this.maquinas.clear();
        this.maquinas.addAll(maquinasUsadas);
        this.piezasProd = piezasProd;
        this.puestasEnFunc = puestas;
        this.estadosGenerados = estados;

    }

    public List<String> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<String> maquinas) {
        this.maquinas = new ArrayList<>(maquinas);
    }

    public Integer getPuestasEnFunc() {
        return puestasEnFunc;
    }

    public void setPuestasEnFunc(Integer puestasEnFunc) {
        this.puestasEnFunc = puestasEnFunc;
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public void setEstadosGenerados(int estadosGenerados) {
        this.estadosGenerados = estadosGenerados;
    }

    @Override
    public String toString() {
        return "Tecnica: Backtracking" +
                "\nMaquinas utilizadas:" + getMaquinas() +
                "\nPiezas producidad:" + getPiezasProd() +
                "\nPuestas en funcionamiento:" + getPuestasEnFunc() +
                "\nEstados generados:" + getEstadosGenerados();

    }
}
