//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner ;




public class Main {


    public static void main(String[] args) {
        System.out.println("****=====Menu para el zoologico====****");



     {

        Scanner imprime = new Scanner(System.in);



        System.out.println("Ingrese el la especie de un animal");
        String espesie = imprime.next();
        switch (espesie) {
            case "mamifero":
                System.out.println("elegiste un mamifero");
                break;
            case "ave":
                System.out.println("elegiste un ave");
                break;
            case "reptil":
                System.out.println("elegiste un reptil");
                break;
            default:
                System.out.println("Opcion no valida");
        }
                animal a = new animal();
                a.pedirDatos(imprime, espesie);
        }

    } static class animal{
        String especie;
        double peso;
        String tipoDeComida;
        double cantidadDeComida;
        public void pedirDatos (Scanner imprime, String espesieIngresada){
            especie = espesieIngresada;

            System.out.println("Ingresa el peso:");
            peso = imprime.nextDouble();
            System.out.println("Ingresa el tipo de comida:");
            tipoDeComida = imprime.next();
            System.out.println("Ingresa la cantidad de comida:");
            cantidadDeComida = imprime.nextDouble();

            System.out.println("la especie es:"+ especie);
            System.out.println("El peso ingresado es:"+ peso);
            System.out.println("El tipo de comida es:"+
            tipoDeComida);
            System.out.println("Cantidad de comida"+ cantidadDeComida);

        }
     }}
