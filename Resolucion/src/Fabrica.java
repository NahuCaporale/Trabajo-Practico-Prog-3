import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Fabrica {
    List<Maquina> maquinas;

    public Fabrica() {
        this.maquinas = new ArrayList<>();
    }

    public void addMaquina(Maquina m) {
        maquinas.add(m);
    }

    public void removeMaquina(Maquina m) {
        if (maquinas.contains(m)) {
            maquinas.remove(m);
        }
    }

    public List<Maquina> getMaquinas() {
        return new ArrayList<>(maquinas);
    }
}
