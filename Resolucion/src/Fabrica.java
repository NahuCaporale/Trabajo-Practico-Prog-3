import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Fabrica {
    //En una fábrica de construcción de autopartes se dispone de un conjunto de máquinas capaces de
    //producir un número determinado de piezas.
    //Cada máquina produce un número establecido de piezas una vez que se pone en funcionamiento,
    // esta cantidad de piezas se conoce de antemano y la
    //máquina no puede detener su funcionamiento hasta completar esa cantidad.
    //Por una cuestión de ahorro energético sólo una máquina puede estar funcionando a la vez. Por otro
    //lado, no hay restricciones respecto a volver a poner en funcionamiento una máquina que ya ha estado
    //en funcionamiento anteriormente.
    //El trabajo práctico de cursada propone resolver un problema, dentro de este contexto, mediante dos
    //técnicas de programación: Backtracking y Greedy.


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
