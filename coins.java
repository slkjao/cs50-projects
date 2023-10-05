import java.util.Scanner;

public class Coins {
    static int[][] arr = new int [4][2];

    public static void main(String[] args) {
        arr[0][0] = 25;
        arr[1][0] = 10;
        arr[2][0] = 5;
        arr[3][0] = 1;

        float valor_total, valor_cliente, troco;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Digite o valor total:");
            valor_total = sc.nextFloat();
            System.out.println("Digite o valor pago pelo cliente:");
            valor_cliente = sc.nextFloat();
        } while(valor_cliente < valor_total);

        troco = valor_cliente - valor_total;
        calcular_troco(troco * 100);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][0] + ": " + arr[i][1] +"\n");
        }
    }
    static void calcular_troco(float troco){
        int referencia = 1;
        if(troco >= arr[0][0]){
            referencia = 0;
        } else if (troco >= arr[1][0]){
            referencia = 1;
        } else if (troco >= arr[2][0]){
            referencia = 2;
        } else {
            arr[3][1] = 1;
            referencia = 3;
        }
        arr[referencia][1] += (int) troco / arr[referencia][0];
        troco = troco % arr[referencia][0];
        if(troco >= 1){
            calcular_troco(troco);
        }
    }
}
