
package DirectorioDeClases;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Luis E. Leonor
 */
public class LuisErnestoMerinoLeonor {
    public static void main(String[] args) {
        try{
            BufferedReader leer = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("La duracion de la llamada (min) ");
            int duracion = Integer.parseInt(leer.readLine());
            System.out.println("--------------------------------------");
            calcularLlamada(duracion);
        }catch(Exception e){System.out.println(e.getMessage());}
    }
    
    //Metodo para calcular el costo por minuto de una llamada
    public static double costoPminuto(int duracion)
    {
        double perMinuto1 = 0.0;
        double perMinuto2 = 0.0;
        double total;
        if (duracion <=3) {
            perMinuto1 = duracion * 0.6;
        }else if(duracion >3)
        {
            perMinuto2 = duracion * (0.6 + 0.05);
        }
        total = perMinuto1 + perMinuto2;
        return total;
    }
    
    //metodo para calcular los billetes
    public static void calcularLlamada(int duracion)
    {
        double metod = costoPminuto(duracion);
        //Este array sirve para contar las monedas existentes
        double []monedas = {20,15,10,5,1, 0.25, 0.10, 0.5, 0.01};
        double []devolver = {0,0,0,0,0,0,0,0,0};
        //Usamos un for para recorrer las monedas
        for (int i = 0; i < monedas.length; i++) {
            if (metod>=monedas[i]) {
                devolver[i] = Math.floor(metod/monedas[i]);
                metod = metod-(devolver[i] * monedas[i]);
            }
        }
        //Resultado
        for (int i = 0; i < monedas.length; i++) {
            if (devolver[i] > 0) {
             if(monedas[i]>=1)
             {
                 //Indicamos pago con billete
                 System.out.println("Los " + devolver[i] + "billetes de: " + monedas[i] + "Dolares");
             }else//Aqui si es con moneda
             {System.out.println("Las " + devolver[i] + "monedas de: " + monedas[i] + "ctvs");}
            }
        }
    }
}

