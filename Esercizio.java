import java.util.Scanner;

public class Program {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, pos, x, i, scelta, indice;

        System.out.println("Inserire la grandezza del vettore: ");
        n = input.nextInt();
        int[] v = new int[n * 10];

        for (i = 0; i <= n - 1; i++) {
            v[i] = 0;
        }
        do {
            scelta = leggiComando();
            if (scelta == 1) {
                do {
                    System.out.println("Inserire la posizione: ");
                    pos = input.nextInt();
                } while (pos < 0 || pos > n - 1);
                System.out.println("Inserire il valore: ");
                x = input.nextInt();
                n = inserisciElemento(v, n, pos, x);
            }
            if (scelta == 2) {
                do {
                    System.out.println("Inserire la posizione: ");
                    pos = input.nextInt();
                } while (pos < 0 || pos > n - 1);
                n = eliminaElemento(v, n, pos);
            }
            if (scelta == 3) {
                System.out.println("Inserire il valore: ");
                x = input.nextInt();
                indice = ricercaElemento(v, n, x);
                if (indice >= 0) {
                    System.out.println("Elemento: " + x + ", trovato in posizione: " + indice);
                } else {
                    System.out.println("Elemento: " + x + " non trovato.");
                }
            }
            if (scelta == 4) {
                n = eliminaDuplicati(v, n);
            }
            if (scelta == 5) {
                visualizzaVettore(v, n);
            }
            if (scelta == 6) {
                System.out.println("Fine del programma.");
            }
        } while (scelta != 6);
    }
    
    public static int eliminaDuplicati(int[] v, int n) {
        int i, n2, j;

        i = 0;
        while (i <= n - 2) {
            j = i + 1;
            while (j <= n - 1) {
                if (v[i] == v[j]) {
                    n = eliminaElemento(v, n, j);
                } else {
                    j = j + 1;
                }
            }
            i = i + 1;
        }
        n2 = n;
        
        return n2;
    }
    
    public static int eliminaElemento(int[] v, int n, int posizione) {
        int i, n2;

        n2 = n - 1;
        for (i = posizione; i <= n2 - 1; i++) {
            v[i] = v[i + 1];
        }
        
        return n2;
    }
    
    public static int inserisciElemento(int[] v, int n, int posizione, int valore) {
        int i, n2;

        n2 = n + 1;
        for (i = n; i >= posizione + 1; i--) {
            v[i] = v[i - 1];
        }
        v[posizione] = valore;
        
        return n2;
    }
    
    public static int leggiComando() {
        int scelta;

        do {
            System.out.println("------ MENU' VETTORI ------");
            System.out.println("1. Inserisci elemento");
            System.out.println("2. Elimina elemento");
            System.out.println("3. Ricerca elemento");
            System.out.println("4. Elimina duplicati");
            System.out.println("5. Visualizza vettore");
            System.out.println("6. Esci");
            scelta = input.nextInt();
        } while (scelta < 1 || scelta > 6);
        
        return scelta;
    }
    
    public static int ricercaElemento(int[] v, int n, int valore) {
        int i, indice;

        indice = -1;
        for (i = 0; i <= n - 1; i++) {
            if (v[i] == valore) {
                indice = i;
            }
        }
        
        return indice;
    }
    
    public static void visualizzaVettore(int[] v, int n) {
        int i;

        for (i = 0; i <= n - 1; i++) {
            System.out.println("Elemento: " + i + " = " + v[i]);
        }
    }
}