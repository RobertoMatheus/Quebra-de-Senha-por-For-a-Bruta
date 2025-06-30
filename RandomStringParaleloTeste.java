package projectofinal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomStringParaleloTeste {

    static String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
    static String senha;

    static AtomicInteger contador = new AtomicInteger(0);
    static AtomicBoolean encontrada = new AtomicBoolean(false);

    static String[] senhasTeste = {
        "a1b1",
        "12abc",
        "a1b2c3",
        "a1b2c34",
    };

    static int base = caracteres.length();

    public static String numeroParaSenha(long numero, int comprimento) {
        char[] senha = new char[comprimento];
        for (int i = comprimento - 1; i >= 0; i--) {
            senha[i] = caracteres.charAt((int)(numero % base));
            numero /= base;
        }
        return new String(senha);
    }

    static class TentativaThread extends Thread {
        private final long inicio;
        private final long fim;
        private final int comprimento;

        TentativaThread(long inicio, long fim, int comprimento) {
            this.inicio = inicio;
            this.fim = fim;
            this.comprimento = comprimento;
        }

        @Override
        public void run() {
            for (long i = inicio; i < fim && !encontrada.get(); i++) {
                String tentativa = numeroParaSenha(i, comprimento);
                contador.incrementAndGet();
                if (tentativa.equals(senha)) {
                    encontrada.set(true);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int numThreads = Runtime.getRuntime().availableProcessors();

        for (String senhaTeste : senhasTeste) {
            senha = senhaTeste;
            int comprimento = senha.length();
            encontrada.set(false);
            contador.set(0);

            System.out.println("Senha de " + comprimento + " dígitos alvo: " + senha);

            long totalCombinacoes = (long) Math.pow(base, comprimento);
            long faixa = totalCombinacoes / numThreads;

            Thread[] threads = new Thread[numThreads];

            long inicio = System.currentTimeMillis();

            for (int i = 0; i < numThreads; i++) {
                long inicioFaixa = i * faixa;
                long fimFaixa = (i == numThreads - 1) ? totalCombinacoes : (i + 1) * faixa;
                threads[i] = new TentativaThread(inicioFaixa, fimFaixa, comprimento);
                threads[i].start();
            }

            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long fim = System.currentTimeMillis();
            long tempo = fim - inicio;

            System.out.println("Senha encontrada: " + senha);
            System.out.println("Tentativas: " + contador);
            System.out.println("Tempo de execução: " + tempo + " ms");
            System.out.println("--------------------------------------");
        }
    }
}
