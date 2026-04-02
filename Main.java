//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner ;
import java.util.ArrayList;




public class Main {


    public static void main(String[] args) {
        Scanner procesa = new Scanner(System.in);
        ArrayList<animal> lista = new ArrayList<>();
        

        int opciones;

       do {
           System.out.println("****=====Menu para el zoologico====****");
           System.out.println("Ingrese una de las opciones:");
           System.out.println("1.Registrar animales");
           System.out.println("2.Ver lista de animales");
           System.out.println("3.Alimentar animales");
           System.out.println("4.Calcular alimento");
           System.out.println("5 salir del programa");
           opciones = procesa.nextInt();
           procesa.nextLine();
           System.out.println("Elegista la opcion:"+opciones);

           switch (opciones) {
               case 1:
                   registrarAnimales(procesa, lista);
                   break;
               case 2:
                   System.out.println("opcion 2 ver lista de animales");
                   VerLista(procesa, lista);

                   break;
               case 3:
                   System.out.println("opcion 3 alimentar animales");
                   AlimentarAnimales(lista);
                   break;
               case 4:
                   System.out.println("opcion 4 calcular alimento");
                   CalcularComida(procesa, lista);
                   break;
               case 5:
                   System.out.println("salir del programa");
                   break;
               default:
                   System.out.println("opcion no valida");

           }
       }while (opciones != 5) ;
           procesa.close();

       }
public static void registrarAnimales(Scanner procesa, ArrayList<animal> lista) {
    System.out.println("Ingresa el nombre de un animal:");
    String nombre = procesa.nextLine();
    animal a = null;
    lista.add(a);


    System.out.println("Ingrese el la especie de un animal");
    String espesie = procesa.next();

    switch (espesie) {
        case "mamifero":
            System.out.println("elegiste un mamifero");
            break;
        case "ave":
            System.out.println("elegiste un ave");
            break;
        case "reptil":
            a = new Reptil ();
            System.out.println("elegiste un reptil");
            break;
        default:
            System.out.println("Opcion no valid a");
    }
    a = new animal();
    a.pedirDatos(procesa, espesie);
    System.out.println("Animal registrado" + nombre);
} public static void VerLista(Scanner procesa, ArrayList<animal> lista){
        if(lista.isEmpty()){
            System.out.println("No hay animales registrados");}else{
            for(animal a: lista) {
                System.out.println("Especie:" + a.especie);
                System.out.println("peso:" + a.peso);
                System.out.println("comida" + a.tipoDeComida);
                System.out.println("contidad:" + a.cantidadDeComida);
            }
        }
    }
    public static void AlimentarAnimales(ArrayList<animal> procesa){
        System.out.println("Alimentado");
    }
    public static class Reptil extends animal {

    }
    
    public static void CalcularComida(Scanner procesa, ArrayList<animal> lista){
        System.out.println("calculando");
    }

} class animal {
    String especie;
    double peso;
    String tipoDeComida;
    double cantidadDeComida;

    public void pedirDatos(Scanner imprime, String espesieIngresada) {
        especie = espesieIngresada;

        System.out.println("Ingresa el peso:");
        peso = imprime.nextDouble();
        System.out.println("Ingresa el tipo de comida:");
        tipoDeComida = imprime.next();
        System.out.println("Ingresa la cantidad de comida:");
        cantidadDeComida = imprime.nextDouble();
        System.out.println("la especie es:" + especie);
        System.out.println("El peso ingresado es:" + peso);
        System.out.println("El tipo de comida es:" +
                tipoDeComida);
        System.out.println("Cantidad de comida" + cantidadDeComida);





    }

}
