import java.util.Scanner;

public class Conecta4 {
    //Clasificamos en private (no public), static (valor que no va cambiar en todo el juego) final (no modificar)
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private char[][] tablero = new char[FILAS][COLUMNAS];
    private char jugadorActual = 'X';
    
    // void (no introduce valor solo realizar acción )
    public void inicializarTablero() {
        // Verifica por filas y columnas y crea los espacios 
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public void mostrarTablero() {
        // Para imprimir la primera fila con un espacio delante)
        System.out.println("  1 2 3 4 5 6 7");
        for (int i = 0; i < FILAS; i++) {
            System.out.print("|");
            // Para imprimir la primera columna con un espacio delante y separado por |)
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            System.out.println();
        }
    }
    
    public boolean colocarFicha(int columna) {
        //Este bucle for recorre las filas del tablero de abajo hacia arriba para colocar la ficha
        for (int i = FILAS - 1; i >= 0; i--) {
            //Verifica si la casilla contiene un espacio en blanco
            if (tablero[i][columna] == ' ') {
            // Si la ficha está vacia se añade el id del jugador
                tablero[i][columna] = jugadorActual;
                return true;
            }
        }
        return false; // Columna llena
    }

    public boolean hayGanador() {
        // Verificar horizontales
        //Verifica por cada Fila
        for (int i = 0; i < FILAS; i++) {
            
            for (int j = 0; j <= COLUMNAS - ; j++) {
                // verifica si la casilla actual del tablero no está vacía, si vacia = no hay 4 iguales  
                if (tablero[i][j] != ' ' &&
                    //Verifica si la 1 es igual que 2 y 3 entonces la 4 tb
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
    
        // Verificar diagonales  positivas en asegurar que siempre haya al menos 4 filas
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                // verifica si la casilla actual del tablero no está vacía, si vacia = no hay 4 iguales
                if (tablero[i][j] != ' ' &&
                    //Verifica si la 1 es igual que 2 y 3 entonces la 4 tb
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
    public void jugar() {
        inicializarTablero();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarTablero();
            System.out.print("Jugador " + jugadorActual + ", elige una columna: ");
            int columna = scanner.nextInt() - 1;

            if (colocarFicha(columna)) {
                if (hayGanador()) {
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    break;
                }
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Columna llena. Intenta otra vez.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Conecta4 juego = new Conecta4();
        juego.jugar();
    }
}