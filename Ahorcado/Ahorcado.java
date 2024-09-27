package Ahorcado;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Ahorcado {
    public static void main(String[] args) {
        //creamos una lista de arrays para contener las palabras
        ArrayList<String> palabrasposibl = new ArrayList<>();
        palabrasposibl.add("java");
        palabrasposibl.add("camello");
        palabrasposibl.add("paranguaticuarimicuaro");
        palabrasposibl.add("pentagono");
        palabrasposibl.add("gato");
        palabrasposibl.add("Horreo");
        palabrasposibl.add("sidra");
        //creamos un array para contener al dibujo
        String[] ahorcado = {
            "    ___________",
            "    |         |",
            "   _0_        |",
            "  ! | !       |",
            "    |         |",
            "   ! !       _|_"
        };
        Random aleatorio = new Random();
        // un entero que almacena el indice de la palabra aleatoria , cada numero representa
        // una posicion en la lista de arrays
        int indice = aleatorio.nextInt(palabrasposibl.size());
        // se asigna el indice a una variable de tipo string "palabraOculta"
        String palabraOculta = palabrasposibl.get(indice);
        int intentos = 6;
        // se crea una nueva variable que va a tener tantos guiones como letras tenga la palabra escogida
        StringBuilder palabraAdivinada = new StringBuilder(palabraOculta.length());
        for (int i = 0; i < palabraOculta.length(); i++) {
            // este for te reemplaza el numero de letras de la palabra por "_" y te lo asigna a la otra variable
            palabraAdivinada.append('_');
        }
        Scanner scanner = new Scanner(System.in);
        // mientras que todavía haya "_" en la palabra adivinada, el programa se va a ejecutar
        while (intentos > 0 && palabraAdivinada.toString().contains("_")) {
            System.out.println("Palabra a adivinar: " + palabraAdivinada);
            //imprime una retroalimentacion visual de cuantos errores llevas
            for (int i = 0; i < 6 - intentos; i++) {
                System.out.println(ahorcado[i]);
            }
            
            System.out.print("Ingresa una letra: ");
            // lee la letra ingresada por el usuario
            char letra = scanner.next().charAt(0);
            // establece que la letra ingresada sea falsa para que la condicion se cumpla
            boolean letraEncontrada = false;
            // recorre los caracteres de la palabra segun su longitud
            for (int i = 0; i < palabraOculta.length(); i++) {
                // si la letra coincide se reemplaza el guion por la letra
                if (palabraOculta.charAt(i) == letra) {
                    palabraAdivinada.setCharAt(i, letra);
                    // se mantiene en true para que no se cumpla la condicion de abajo
                    letraEncontrada = true;
                }
            } // en caso de que la letra sea incorrecta se restan intentos
            if (!letraEncontrada) {
                intentos--;
                System.out.println("Incorrecto. Intentos restantes: " + intentos);
            }
        }
        // Este es para mostrar tu estado final del juego
        for (int i = 0; i < 6 - intentos; i++) {
            System.out.println(ahorcado[i]);
        }

        if (palabraAdivinada.toString().equals(palabraOculta)) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraOculta);
        } else {
            System.out.println("¡Has perdido! La palabra era: " + palabraOculta);
        }
        scanner.close();
    }
}