package CodigoCesar;

import java.util.Scanner;

public class metodos{
    public static String encripitar(int chave, String texto){
        String textoCifrado = " ";
        int tam = texto.length();
        char ascii, x, y;

        if(chave > 26)
            chave = chave - 26;
        
        for(int i = 0; i < tam; i ++){
            if(texto.charAt(i) == 32){
                ascii = (char) texto.charAt(i);
                textoCifrado += ascii;
            }

            if(texto.charAt(i) >= 65 && texto.charAt(i) <= 90){
                if(texto.charAt(i) + chave > 90){
                    x = (char) (texto.charAt(i) + chave);
                    y = (char) (x-90);
                    ascii = (char) (y+64);
                    textoCifrado += ascii;
                }else{
                    ascii = (char) (texto.charAt(i) + chave);
                    textoCifrado += ascii;
                }
            }

            if(texto.charAt(i) >= 97 && texto.charAt(i) <= 122){
                if(texto.charAt(i) + chave > 122){
                    x = (char) (texto.charAt(i) + chave);
                    y = (char) (x-122);
                    ascii = (char) (y+96);
                    textoCifrado += ascii;
                }else{
                    ascii = (char) (texto.charAt(i) + chave);
                    textoCifrado += ascii;
                }
            }
        }


        return textoCifrado;
    }

    public static String descripitar(int chave, String texto){
        String textoDescripitografado = "";
        int tam = texto.length();
        char ascii, x, y;

        if(chave > 26)
        chave = chave - 26;
    
        for(int i = 0; i < tam; i ++){
            if(texto.charAt(i) == 32){
                ascii = (char) texto.charAt(i);
                textoDescripitografado += ascii;
            }

            if(texto.charAt(i) >= 65 && texto.charAt(i) <= 90){
                if(texto.charAt(i) - chave < 65){
                    x = (char) (texto.charAt(i) + chave);
                    // System.out.println("x" + x);
                    y = (char) (65-x);
                    // System.out.println("y"+ y);
                    ascii = (char) (91+y);
                    // System.out.println("ascii" + ascii);
                    textoDescripitografado += ascii;
                }else{
                    ascii = (char) (texto.charAt(i) - chave);
                    textoDescripitografado += ascii;
                }
            }

            if(texto.charAt(i) >= 97 && texto.charAt(i) <= 122){
                if(texto.charAt(i) + chave > 122){
                    x = (char) (texto.charAt(i) + chave);
                    y = (char) (95-x);
                    ascii = (char) (123 + y);
                    textoDescripitografado += ascii;
                }else{
                    ascii = (char) (texto.charAt(i) + chave);
                    textoDescripitografado += ascii;
                }
            }
        }
        return textoDescripitografado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner t= new Scanner(System.in);
        System.out.print("Digite a chave de deslocamento: ");
        int chave = sc.nextInt();
        System.out.print("Digite o texto a ser encripitado: ");
        String texto = t.nextLine();

        String encripitar = encripitar(chave, texto);
        System.out.println(encripitar);
        String d = descripitar(chave, encripitar);
        System.out.println(d);
    }
}