package projectofinal;

public class RandomStringSequencialTeste {

    //Variavel com todos os caracteres disponiveis para gerar senha e tentativa
    static String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";

    static String senha;
    static int contador = 0;
    static boolean encontrada = false;

    static String[] senhasTeste = {
        "a1b1",
        "12abc",
        "a1b2c3",
        "a1b2c34",};

    public static void gerarTentativas(String atual, int maxLength) {
        if (encontrada) {
            return;
        }

        if (atual.length() == maxLength) {
            contador++;
            if (atual.equals(senha)) {
                encontrada = true;
                return;
            }
            return;
        }

        for (int i = 0; i < caracteres.length(); i++) {
            gerarTentativas(atual + caracteres.charAt(i), maxLength);
            if (encontrada) {
                return; //Parar se a senha for encontrada
            }
        }
    }

    public static void main(String[] args) {

        //Laço trabalhando com o de senhas criado
        for (String senhaTeste : senhasTeste) {
            senha = senhaTeste;
            contador = 0;
            encontrada = false;
            int comprimentoDaString = senha.length();

            System.out.println("Leitura de senha de " + comprimentoDaString + " digitos iniciada");

            long inicio = System.currentTimeMillis();

            gerarTentativas("", comprimentoDaString);

            long fim = System.currentTimeMillis();
            long total = fim - inicio;

            System.out.println("Senha de " + comprimentoDaString + " encontrada: " + senha);
            System.out.println("Tentativas: " + contador);
            System.out.println("Tempo de execução: " + total + " ms");
            System.out.println("-------------------------------------");

        }

    }
}
