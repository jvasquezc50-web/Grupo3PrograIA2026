//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner procesa = new Scanner(System.in);
        int opcionPrincipal;

        do {
            System.out.println("======== MENU PRINCIPAL ========");
            System.out.println("1. Zoo");
            System.out.println("2. Fase 2");
            System.out.println("3. Fase 3");
            System.out.println("4. Salir");

            opcionPrincipal = procesa.nextInt();
            procesa.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    menuZoo(procesa);
                    break;
                case 2:
                    System.out.println("Fase 2 en construccion...");
                    break;
                case 3:
                    System.out.println("Fase 3 en construccion...");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcionPrincipal != 4);

        procesa.close();
    }

    // ================= MENU ZOO =================
    public static void menuZoo(Scanner procesa) {
        ArrayList<Animal> lista = new ArrayList<>();
        int opcion;

        do {
            System.out.println("****===== MENU ZOO =====****");
            System.out.println("1. Registrar animales");
            System.out.println("2. Ver lista de animales");
            System.out.println("3. Alimentar animales");
            System.out.println("4. Calcular alimento");
            System.out.println("5. Guardar en archivo");
            System.out.println("6. Volver al menu principal");

            opcion = procesa.nextInt();
            procesa.nextLine();

            switch (opcion) {
                case 1:
                    registrarAnimales(procesa, lista);
                    break;
                case 2:
                    verLista(lista);
                    break;
                case 3:
                    alimentarAnimales(lista);
                    break;
                case 4:
                    calcularComida(lista);
                    break;
                case 5:
                    guardarArchivo(lista);
                    break;
                case 6:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 6);
    }

    // ================= REGISTRAR =================
    public static void registrarAnimales(Scanner sc, ArrayList<Animal> lista) {
        System.out.println("Ingrese la especie (mamifero / ave / reptil):");
        String especie = sc.nextLine().toLowerCase();

        Animal a;

        switch (especie) {
            case "mamifero":
                a = new Mamifero();
                break;
            case "ave":
                a = new Ave();
                break;
            case "reptil":
                a = new Reptil();
                break;
            default:
                System.out.println("Especie no valida");
                return;
        }

        a.pedirDatos(sc);
        lista.add(a);

        System.out.println("Animal registrado correctamente.");
    }

    // ================= VER LISTA =================
    public static void verLista(ArrayList<Animal> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay animales registrados");
        } else {
            for (Animal a : lista) {
                System.out.println(a);
            }
        }
    }

    // ================= ALIMENTAR =================
    public static void alimentarAnimales(ArrayList<Animal> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay animales");
        } else {
            for (Animal a : lista) {
                System.out.println("Alimentando a: " + a.especie);
            }
        }
    }

    // ================= CALCULAR =================
    public static void calcularComida(ArrayList<Animal> lista) {
        for (Animal a : lista) {
            a.calcularComida();
            System.out.println("Comida calculada para " + a.especie + ": " + a.cantidadDeComida);
        }
    }

    // ================= GUARDAR =================
    public static void guardarArchivo(ArrayList<Animal> lista) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("animales.txt"));

            for (Animal a : lista) {
                writer.println(a);
                writer.println("-----------");
            }

            writer.close();
            System.out.println("Datos guardados en archivo");

        } catch (IOException e) {
            System.out.println("Error al guardar archivo");
        }
    }
}

// ================= CLASE BASE =================
abstract class Animal {
    String especie;
    double peso;
    String tipoDeComida;
    double cantidadDeComida;

    public void pedirDatos(Scanner sc) {
        System.out.println("Ingrese peso:");
        peso = sc.nextDouble();
        sc.nextLine();

        System.out.println("Tipo de comida:");
        tipoDeComida = sc.nextLine();

        System.out.println("Cantidad de comida:");
        cantidadDeComida = sc.nextDouble();
        sc.nextLine();
    }

    public abstract void calcularComida();

    public String toString() {
        return "Especie: " + especie +
                ", Peso: " + peso +
                ", Comida: " + tipoDeComida +
                ", Cantidad: " + cantidadDeComida;
    }
}

// ================= MAMIFERO =================
class Mamifero extends Animal {
    public Mamifero() {
        especie = "Mamifero";
    }

    public void calcularComida() {
        cantidadDeComida = peso * 0.10;
    }
}

// ================= AVE =================
class Ave extends Animal {
    public Ave() {
        especie = "Ave";
    }

    public void calcularComida() {
        cantidadDeComida = peso * 0.05;
    }
}

// ================= REPTIL =================
class Reptil extends Animal {
    public Reptil() {
        especie = "Reptil";
    }

    public void calcularComida() {
        cantidadDeComida = peso * 0.03;
    }
}