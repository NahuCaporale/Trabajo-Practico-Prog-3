import java.util.ArrayList;
import java.util.List;

public class Maquina {
    int maxPiezas;
    List<Integer> piezas;
    String maquinaId;

    public String getMaquinaId() {
        return maquinaId;
    }

    public void setMaquinaId(String maquinaId) {
        this.maquinaId = maquinaId;
    }

    public Maquina(String maquinaId, int maxPiezas, boolean estado) {
        this.maquinaId = maquinaId;
        this.maxPiezas = maxPiezas;
        this.estado = estado;
        this.piezas = new ArrayList<>();
    }

    public void activarMaquina() {
        this.estado = true;
    }

    public void desactivarMaquina() {
        this.estado = false;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getMaxPiezas() {
        return maxPiezas;
    }

    public void setMaxPiezas(int maxPiezas) {
        this.maxPiezas = maxPiezas;
    }

    boolean estado;

    public void asignarPiezas(int cantPiezas) {
        piezas.add(cantPiezas);
    }

    public void desasignarPiezas(int total) {
        piezas.remove(this.piezas.size() - 1);
    }


}
