import java.util.Scanner;

public class Principal {

    /**
     * metodo principal
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner d = new Scanner(System.in);
        System.out.print("              TORRE");
        System.out.print("\n****************************************");
        int dis = 0;
        System.out.print("\nIngrese el numero de Discos\n");
        dis = d.nextInt();
        Principal torre = new Principal();
        torre.Torre(dis, 1, 2, 3);


    }

    public void Torre(int cantidad, int TorreInicial, int TorreAuxiliar, int TorreFinal) {
        if (cantidad == 1) {

            System.out.print("\n Se mueve disco de la torre "+ TorreInicial + " Torre "+ TorreFinal);
        }else{
            Torre(cantidad-1, TorreInicial, TorreFinal, TorreAuxiliar);
            System.out.print("\n Se mueve disco de la torre "+ TorreInicial+ " Torre "+ TorreFinal);
            Torre(cantidad-1, TorreAuxiliar, TorreInicial, TorreFinal);

        } 


    }

}
