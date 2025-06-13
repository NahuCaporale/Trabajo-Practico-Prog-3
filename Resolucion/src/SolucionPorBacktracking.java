import java.util.*;

public class SolucionPorBacktracking {
    Fabrica fabrica;
    //Dado un número determinado de piezas a producir se desea encontrar, de existir, la secuencia de
    //máquinas que se deben usar para minimizar la cantidad de puestas en funcionamiento totales
    //requeridas para completar la producción.
    //Por ejemplo, suponiendo las siguientes máquinas con la cantidad de piezas que produce cada una:
    //(M1, 7), (M2, 3), (M3, 4), (M4, 1)
    //Si necesitamos producir 12 piezas una configuración óptima posible sería [M1 - M3 - M4]. También se
    //podría haber propuesto una secuencia [M3 - M3 - M3]
    private List<String> solucion;
    private Integer puestasEnFunc;

    public SolucionPorBacktracking() {
        fabrica = new Fabrica();
        puestasEnFunc = 0;
        solucion = new ArrayList<>();
    }

    //cada maquina produce M piezas, no se puede detener una maquina una vez empezo. Solo 1 a la vez puede funcionar
    //se puede usar la misma maquina
    public List<String> generarSolucionBacktracking(int cantPiezas) {
        List<Maquina> maquinas = fabrica.getMaquinas();


        backtracking(null, maquinas, new ArrayList<>(), 0, cantPiezas);
        Map<List<String>, Integer> solucionA = new HashMap<>();
        return solucion;
    }

    private void backtracking(Maquina actual, List<Maquina> maquinas, List<String> solucionParcial, int parcialCompletado, int total) {
        if (parcialCompletado == total) {
            if (solucion.isEmpty() || solucionParcial.size() <= solucion.size()) {
                solucion.clear();
                solucion.addAll(solucionParcial);
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

            //asigno
            asignarMaquina(actual, actual.getMaxPiezas(), total, solucionParcial);
            parcialCompletado += actual.getMaxPiezas();
            //recursividad
            backtracking(actual, maquinas, solucionParcial, parcialCompletado, total);

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

    @Override
    public String toString() {
        return "Tecnica: Backtracking" + "\n" + "Solucion Obtenida: " + solucion + "\n" + "Puestas en funcionamiento: "
                + puestasEnFunc;
    }
}
