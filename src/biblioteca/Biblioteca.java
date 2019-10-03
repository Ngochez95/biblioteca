package biblioteca;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Biblioteca {

    public static void main(String[] args) {
        Object biblioteca[][] = new Object[25][5];
        boolean estado = true, busqueda = false;
        int opcion, contadorlibros = 0, posicion = 0;
        String salida = "", codigolibro, nombreLibro, autor, cliente, buscar;
        JTextArea hoja = new JTextArea();

        for (int fila = 0; fila < 25; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                if (biblioteca[fila][columna] == null) {
                    biblioteca[fila][0] = "sin asignar";
                    biblioteca[fila][1] = "sin nombre";
                    biblioteca[fila][2] = "sin autor";
                    biblioteca[fila][3] = "sin asignar";
                    biblioteca[fila][4] = "sin registro";
                }
            }
        }
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Opciones\n1-ver libros\n2-crear libro\n3-prestar libros\n4-Devolver libro\n5-salir"));
            salida += "códido\tnombre\tautor\tprestado\tcliente\n";
            switch (opcion) {
                case 1:
                    for (int fila = 0; fila < 25; fila++) {
                        for (int columna = 0; columna < 5; columna++) {
                            salida += biblioteca[fila][columna] + "\t";
                        }
                        salida += "\n";
                    }
                    hoja.setText(salida);
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 2:
                    codigolibro = JOptionPane.showInputDialog("ingrese código del libro");
                    nombreLibro = JOptionPane.showInputDialog("ingrese nombre del libro");
                    autor = JOptionPane.showInputDialog("nombre del autor");
                    if (codigolibro.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "campo requerido, ingrese codigo libro");
                    } else if (nombreLibro.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "campo requerido, ingrese nombre libro");
                    } else if (autor.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "campo requerido, ingrese autor libro");
                    } else {
                        biblioteca[contadorlibros][0] = codigolibro;
                        biblioteca[contadorlibros][1] = nombreLibro;
                        biblioteca[contadorlibros][2] = autor;
                        biblioteca[contadorlibros][3] = "disponible";
                        contadorlibros++;

                        JOptionPane.showMessageDialog(null, "Creación con éxito!");
                    }

                    break;

                case 3:
                    buscar = JOptionPane.showInputDialog("Ingrese nombre o código del libro");
                    for (int fila = 0; fila < 25; fila++) {
                        if (String.valueOf(biblioteca[fila][0]).equals(buscar) || String.valueOf(biblioteca[fila][1]).equals(buscar)) {
                            busqueda = true;
                            posicion = fila;
                        }
                    }
                    if (busqueda) {
                        if (String.valueOf(biblioteca[posicion][3]).equals("reservado")) {
                            JOptionPane.showMessageDialog(null, "El libro ya se encuentra en prestamo");
                        } else {
                            cliente = JOptionPane.showInputDialog("ingrese nombre del cliente");
                            biblioteca[posicion][3] = "reservado";
                            biblioteca[posicion][4] = cliente;
                        }
                    }
                    break;
                case 4:
                    buscar = JOptionPane.showInputDialog("Ingrese nombre o código del libro");
                    for (int fila = 0; fila < 25; fila++) {
                        if (String.valueOf(biblioteca[fila][0]).equals(buscar) || String.valueOf(biblioteca[fila][1]).equals(buscar)) {
                            busqueda = true;
                            posicion = fila;
                        }
                    }
                    if (busqueda) {
                        if (String.valueOf(biblioteca[posicion][3]).equals("disponible")) {
                            JOptionPane.showMessageDialog(null, "El libro ya se encuentra en almacenado");
                        } else {
                            biblioteca[posicion][3] = "disponible";
                            biblioteca[posicion][4] = "sin registro";
                        }
                    }else{
                    JOptionPane.showMessageDialog(null, "no se encontraron registro, ingrese datos de nuevo");
                    }
                    break;
                case 5:
                    estado = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opción no permitida");

            }
            busqueda = false;
            salida = "";
            hoja.setText(salida);
        } while (estado);

    }

}
