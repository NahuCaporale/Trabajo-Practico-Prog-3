import java.util.*;

public class SolucionPorBacktracking {
    Fabrica fabrica;
    private List<String> solucion;
    private Integer puestasEnFunc;
    private int estadosGenerados;

    /*
     * <<Breve explicación de la estrategia de resolución. Por ejemplo:
     * - El arbol de exploracion se genera a partir de la primera maquina que fue insertada, prueba con esa sola si se completa
     * con la cantidad que esa maquina puede producir termina, sino sigue explorando con otras opciones.
     * - Un estado final es aquella suma parcial de piezas producidas en cada llamado recursivo
     *    es igual a la cantidad total que se quiere producir.
     *  El estado solucion es aquel que cumple con el estado final y ademas utiliza menos cantidad de maquinas.
     * - Una poda que implementamos es cuando el parcial de piezas que se viene produciendo se pasa de la cantidad total que se
     * producir(no queremso producir mas de lo que necesitamos).
     * -Otra poda que implementamos es la de checkear en cada iteracion si la cantidad de el arreglo en cada llamado recursivo
     * es mayor a la mejor solucion que tenemos, siempre y cuando tengamos ya una solucion.
     */
    public SolucionPorBacktracking() {
        fabrica = new Fabrica();
        estadosGenerados = 0;
        puestasEnFunc = 0;
        solucion = new ArrayList<>();
    }

    //cada maquina produce M piezas, no se puede detener una maquina una vez empezo. Solo 1 a la vez puede funcionar
    //se puede usar la misma maquina
    public List<String> generarSolucionBacktracking(int cantPiezas) {
        List<Maquina> maquinas = fabrica.getMaquinas();


        backtracking(null, maquinas, new ArrayList<>(), 0, cantPiezas, 0);
        Map<List<String>, Integer> solucionA = new HashMap<>();
        return solucion;
    }

    private void backtracking(Maquina actual, List<Maquina> maquinas, List<String> solucionParcial, int parcialCompletado, int total, int puestas) {
        if (parcialCompletado == total) {
            if (solucion.isEmpty() || solucionParcial.size() <= solucion.size()) {
                solucion.clear();
                solucion.addAll(solucionParcial);
                puestasEnFunc = puestas;
            }
            return;
        }
        if (!solucion.isEmpty() && solucionParcial.size() >= solucion.size()) {
            return;
        }
        if (parcialCompletado > total) {
            return;
        }

        Iterator<Maquina> totalMaquinas = maquinas.iterator();
        while (totalMaquinas.hasNext()) {
            actual = totalMaquinas.next();
            estadosGenerados++;
            //asigno
            asignarMaquina(actual, actual.getMaxPiezas(), total, solucionParcial);
            parcialCompletado += actual.getMaxPiezas();
            puestas += 1;
            //recursividad
            backtracking(actual, maquinas, solucionParcial, parcialCompletado, total, puestas);
            puestas -= 1;
            //desasigno
            desasignarMaquina(actual, actual.getMaxPiezas());
            solucionParcial.remove(actual.getMaquinaId());
            parcialCompletado -= actual.getMaxPiezas();
        }
    }

    private void desasignarMaquina(Maquina actual, int producido) {
        actual.desasignarPiezas(producido);
    }

    public void asignarMaquina(Maquina actual, int producido, int total, List<String> listaParcial) {
        actual.asignarPiezas(producido);
        listaParcial.add(actual.getMaquinaId());
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public void setEstadosGenerados(int estadosGenerados) {
        this.estadosGenerados = estadosGenerados;
    }

    public Integer getPuestasEnFunc() {
        return puestasEnFunc;
    }

    public void setPuestasEnFunc(Integer puestasEnFunc) {
        this.puestasEnFunc = puestasEnFunc;
    }

    @Override
    public String toString() {
        return "Tecnica: Backtracking" + "\n" + "Solucion Obtenida: " + solucion + "\n" + "Puestas en funcionamiento: "
                + getPuestasEnFunc() + "\nEstados generados " + getEstadosGenerados();
    }
}
