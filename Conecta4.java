import java.util.Scanner;

public class Conecta4 {
    //Clasificamos en private (no public), static (valor que no va cambiar en todo el juego) final (no modificar)
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private char[][] tablero = new char[FILAS][COLUMNAS];
    private char jugadorActual = 'X';
    

    public void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("  1 2 3 4 5 6 7");
        for (int i = 0; i < FILAS; i++) {
            System.out.print("|");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            System.out.println();
        }
    }

    public boolean colocarFicha(int columna) {
        for (int i = FILAS - 1; i >= 0; i--) {
            if (tablero[i][columna] == ' ') {
                tablero[i][columna] = jugadorActual;
                return true;
            }
        }
        return false; // Columna llena
    }

    public boolean hayGanador() {
        // Verificar horizontales
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] != ' ' &&
                        tablero[i][j] == tablero[i][j+1] &&
                        tablero[i][j] == tablero[i][j+2] &&
                        tablero[i][j] == tablero[i][j+3]) {
                    return true;
                }
            }
        }
    
        // Verificar  verticales
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j] != ' ' &&
                        tablero[i][j] == tablero[i+1][j] &&
                        tablero[i][j] == tablero[i+2][j] &&
                        tablero[i][j] == tablero[i+3][j]) {
                    return true;
                }
            }
        }
    
        // Verificar diagonales  positivas
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] != ' ' &&
                        tablero[i][j] == tablero[i+1][j+1] &&
                        tablero[i][j] == tablero[i+2][j+2] &&
                        tablero[i][j] == tablero[i+3][j+3]) {
                    return true;
                }
            }
        }
    
        // Verificar diagonales  negativas
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 3; j < COLUMNAS; j++) {
                if (tablero[i][j] != ' ' &&
                        tablero[i][j] == tablero[i+1][j-1] &&
                        tablero[i][j] == tablero[i+2][j-2] &&
                        tablero[i][j] == tablero[i+3][j-3]) {
                    return true;
                }
            }
        }
    
        return false;
    
    }
    public void jugar1() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
    
        while (playAgain) {
            inicializarTablero();
            boolean juegoTerminado = false;
    
            while (!juegoTerminado) {
                mostrarTablero();
                System.out.print("Jugador " + jugadorActual + ", elige una columna (1-7): ");
                int columna = scanner.nextInt() - 1;
    
                if (columna >= 0 && columna < COLUMNAS) {
                    if (colocarFicha(columna)) {
                        if (hayGanador()) {
                            mostrarTablero();
                            System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                            juegoTerminado = true;
                        } else if (tableroLleno()) {
                            mostrarTablero();
                            System.out.println("¡El juego ha terminado en empate!");
                            juegoTerminado = true;
                        } else {
                            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                        }
                    } else {
                        System.out.println("Columna llena. Intenta otra vez.");
                    }
                } else {
                    System.out.println("Columna inválida. Por favor, elige un número entre 1 y 7.");
                }
            }
    
            System.out.print("¿Quieres jugar de nuevo? (si o no): ");
            String respuesta = scanner.next().toLowerCase();
            playAgain = respuesta.equals("si");
            if (playAgain) {
                jugadorActual = 'X'; // Reiniciar el jugador actual
            }
        }
    
        System.out.println("Gracias por jugar!");
        scanner.close();
    }
    
    // Método auxiliar para verificar si el tablero está lleno
    private boolean tableroLleno() {
        for (int j = 0; j < COLUMNAS; j++) {
            if (tablero[0][j] == ' ') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Conecta4 juego = new Conecta4();
        juego.jugar1();
    }
}
