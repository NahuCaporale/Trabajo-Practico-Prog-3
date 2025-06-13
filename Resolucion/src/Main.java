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
                // Ejemplo: Extraer PiezasTotales
                if (linea.startsWith("PiezasTotales")) {
                    String[] partes = linea.split(":");
                    piezasTotales = Integer.parseInt(partes[1].trim());
                }
                // Ejemplo: Extraer datos de las máquinas
                else if (linea.startsWith("M")) {
                    // Formato esperado: Maquina 1,7
                    String[] partes = linea.split(",");

                    String id = (partes[0]);
                    int piezas = Integer.parseInt(partes[1]);
                    fabrica.addMaquina(new Maquina(id, piezas, false));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo de configuracion", e);
        }


        SolucionPorBacktracking solucionador = new SolucionPorBacktracking();
        solucionador.fabrica = fabrica; // Establecer la fábrica en el solucionador

        // Supongamos que queremos producir exactamente 12 piezas
        int piezasRequeridas = 100;
       List<String> mejorConfiguracion = solucionador.generarSolucionBacktracking(piezasTotales);

        // Imprimir la solución
        if (!mejorConfiguracion.isEmpty()) {
            System.out.printf(solucionador.toString());
        } else {
            System.out.printf("No fue posible producir " + piezasRequeridas + " piezas con las máquinas disponibles");
        }

    }
}

