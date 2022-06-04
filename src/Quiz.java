import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Quiz {
    private String usuario;
    private static int acertos;
    private static int erros;
    private LinkedList<Pergunta> perguntas = new LinkedList<>();

    /**
     * Construtor da classe
     * @param usuario
     * @throws Exception
     */
    public Quiz(String usuario) throws Exception {
        this.usuario = usuario;
        criarPerguntas("perguntas");
    }


    /**
     * Adiciona uma pergunta na lista do quiz
     * @param pergunta
     */
    public void addPerguntas(Pergunta pergunta) {
        this.perguntas.add(pergunta);
    }

    public LinkedList<Pergunta> getPerguntas() {
        return perguntas;
    }

    /**
     * Vai rerificar qual alternativa esta correta.
     * @param pergunta
     * @param resp
     * @return Vai retorna true ou false com base na resposta
     */
    public boolean alternativaCorreta(Pergunta pergunta, char resp) {
        if (pergunta.getRespota() == resp) {
            System.out.println("Acertou!!");
            contagemPontos(true);
            return true;
        } else {
            System.out.println("Errou!!");
            contagemPontos(false);
            return false;
        }
    }

    /**
     * Com base no restono da alternativaCorreta() vai realizar a soma dos acertos e erros
     * @param ponto
     */
    public void contagemPontos(boolean ponto) {
        if(ponto == true){
            this.acertos++;
        }else{
            this.erros++;
        }
    }


    public String toString() {
        return "Usuario(a): " + this.usuario + "\n" +
                "Acertos: " + acertos + "\n" +
                "Erros: " + erros;
    }

    /**
     * Metodo para realizar a criação da pergunta com suas alternativas e resposta atraves de uma arquivo.
     * @param arquivo
     * @throws Exception caso nao acha o arquivo
     */
    public void criarPerguntas(String arquivo) throws Exception {
        try {
            Scanner leitor = new Scanner(new File(arquivo), "UTF-8");
            String linha = leitor.nextLine();

            while (!linha.isEmpty()) {
                Scanner scannerLinha = new Scanner(linha);
                scannerLinha.useDelimiter(";");
                String perguntar = scannerLinha.next();
                char responter = scannerLinha.next().charAt(0);

                Pergunta pergunta = new Pergunta(perguntar, responter);

                for (int i = 0; i < 5; i++) {
                    String alternativa = leitor.nextLine();
                    pergunta.addAltenativas(alternativa);
                }
                addPerguntas(pergunta);
                linha = leitor.nextLine();
            }

        } catch (IOException e) {
            System.out.println("Erro, arquivo nao encontrado." + e.getMessage());
        } catch (NoSuchElementException nse) {
            System.out.println("------------ Iniciar Quiz ------------ \n");
        }

    }
}
