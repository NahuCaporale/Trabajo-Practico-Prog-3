import java.util.ArrayList;
import java.util.List;

public abstract class Solucion {
    protected List<String> maquinas;
    private int puestasEnFunc;
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
        this.piezasProd = 0;
    }

    public Solucion(List<String> maquinasUsadas, int piezasProd, int puestas) {
        maquinas = new ArrayList<>();
        this.puestasEnFunc = 0;
        this.piezasProd = 0;
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
}
