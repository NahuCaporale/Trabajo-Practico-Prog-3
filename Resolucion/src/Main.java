import java.io.BufferedReader;
import java.io.FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();
        String archivo = "Resolucion/config.txt";
        int piezasTotales = 0;
        try (BufferedReader texto = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = texto.readLine()) != null) {
                if (linea.startsWith("PiezasTotales")) {
                    String[] partes = linea.split(":");//partes[0] "PiezasTotales"
                    piezasTotales = Integer.parseInt(partes[1].trim());//int
                }
                else if (linea.startsWith("M")) {
                    String[] partes = linea.split(",");

                    String id = (partes[0]);//por ej: "m1"
                    int piezas = Integer.parseInt(partes[1]);//lo que produce
                    fabrica.addMaquina(new Maquina(id, piezas, false));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo de configuracion", e);
        }
        //RESULTADO DEL BACKTRACKING
        SolucionBacktracking backtrack = new SolucionBacktracking(fabrica);
        Solucion sol = backtrack.generarSolucionBacktracking(piezasTotales);
        if (sol != null) {
            System.out.println(sol.toString());
        } else {
            System.out.println("Solucion backtrack : No se encontro una solucion viable para producir " + piezasTotales + " piezas");
        }
        //RESULTADO DEL GREEDY
        SolucionPorGreedy greedy = new SolucionPorGreedy(fabrica);
        Solucion gree = greedy.generarSolucionGreedy(piezasTotales);
        if (gree != null) {
            System.out.println(gree.toString());
        } else {
            System.out.println("Solucion greedy : No se encontro una solucion viable para producir " + piezasTotales + " piezas");
        }

    }

}


