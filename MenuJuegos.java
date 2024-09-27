import javax.swing.JOptionPane;
public class MenuJuegos {
    public static void main(String[] args) {
        // Mostramos el panel con las opciones de juegos
        String[] opciones = { "Ahorcado", "Conecta4", "Número Secreto"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "¿Qué juego deseas mi rey/reina?",
                "Selección de Juego",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);
        // Si el usuario selecciona una opción, ejecutamos el juego correspondiente
        if (seleccion != null) {
            switch (seleccion) {
                case "Ahorcado":
                    Ahorcado.main(null);
                    break;
                case "Conecta4":
                    Conecta4.main(null);
                    break;
                case "AdivinaNumero":
                    AdivinaNumero.main(null);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, escoge bien .I. ");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado ningún juego, ¿ a caso no quieres jugar?");
        }
    }
}
