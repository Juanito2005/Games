// import un objeto Random para generar números aleatorios
import java.util.Random;
// import un objeto Scanner
import java.util.Scanner;
public class AdivinaNumero {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner Scanner = new Scanner(System.in);
        // True = miesntras sea verdadero se juega una y otra vez
        boolean juegaDenuevo = true;
        
        while (juegaDenuevo) {
            //crear un numero secreto entre 1 y 100
            int numeroSecreto = random.nextInt(101);
            // Contador con intentos
            int intentos = 0;
            int numeroIngresado = 0;
            System.out.println("Adivina el número!");
            System.out.println("Escribe un número: ");
            // se ejecuta mientras jugarDeNuevo sea true y quiere seguir jugando
            do {
                intentos++;
                try {
                // lee el numero ingresado y la convierte a un número entero
                numeroIngresado= Integer.parseInt(Scanner.nextLine());
                if (numeroIngresado < 0 || numeroIngresado > 100) {
                    System.out.println("Por favor, ingresa un número entre 0 y 100.");
                } else if (numeroIngresado < numeroSecreto) {
                    System.out.println("El número es mayor ;)");
                } else if (numeroIngresado > numeroSecreto) {
                    System.out.println("El número es menor :(");
                } else {
                    System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
                }
            //detecta la entrada del user en caso que no se número
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            }
        } while (numeroIngresado != numeroSecreto);
        System.out.println("¿Quieres jugar de nuevo? (indica un si o un no)");
        String respuesta = Scanner.nextLine().toLowerCase();
        if (juegaDenuevo = respuesta.equals("si")) {
            juegaDenuevo = true;
        } else if (juegaDenuevo = respuesta.equals("no")) {
            juegaDenuevo = false;
            System.out.println("Gracias por jugar!");
        }
    }
    // Cierra Scanner  para liberar recursos
    Scanner.close();
}
}