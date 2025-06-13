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
    private int estadosGenerados;

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
