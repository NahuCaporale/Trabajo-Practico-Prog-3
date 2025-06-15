import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolucionPorGreedy {
    ExpresarSolucionGreedy solucion;
    int candidatosCon;
    Fabrica fabrica;

    /*
     * Los candidatos son todas las maquinas que tenemos en la fabrica.
     * - Ordenamos por la mayor cantidad de piezas que puede producir cada una.
     * - Si no encuentra solucion retorna null.
     * - etc.>>
     */
    public SolucionPorGreedy(Fabrica fabrica) {
        this.fabrica = fabrica;
        this.candidatosCon = 0;
        this.solucion = null;
    }

    public Solucion generarSolucionGreedy(int piezas) {

        List<Maquina> candidatos = fabrica.getMaquinas();
        Collections.sort(candidatos);
        int cantidadProducida = 0;
        List<String> solucionP = new ArrayList<>();
        int i = 0;
        int puestas = 0;
        while (i < candidatos.size() && !esSolucion(piezas, cantidadProducida) && piezas >= 0) {
            Maquina c = seleccionarCandidato(candidatos, i);
            if (c != null) {
                candidatosCon++;
                if (Factibilidad(c, piezas, cantidadProducida)) {
                    solucionP.add(c.getMaquinaId());
                    cantidadProducida += c.getMaxPiezas();
                    puestas++;
                    i = 0;
                } else {
                    i++;
                }
            }


        }
        if (esSolucion(piezas, cantidadProducida)) {
            solucion = new ExpresarSolucionGreedy();
            solucion.copiar(solucionP, cantidadProducida, puestas, candidatosCon);
            return solucion;
        }
        return null;
    }

    private boolean Factibilidad(Maquina c, int piezas, int cant) {
        return cant + c.maxPiezas <= piezas;
    }

    private boolean esSolucion(int piezas, int cantidadProducida) {
        return piezas == cantidadProducida;
    }

    private Maquina seleccionarCandidato(List<Maquina> candidatos, int indice) {
        if (indice < candidatos.size()) {
            return candidatos.get(indice);
        }
        return null;

    }


}
