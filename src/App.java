import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual é o seu nome? ");
        String usuario = sc.nextLine();
        Quiz quiz = new Quiz(usuario);

            for (Pergunta pergunta : quiz.getPerguntas()) {
                System.out.println(pergunta);
                System.out.println("Qual é a resposta?");
                char resp = sc.next().toLowerCase().charAt(0);
                quiz.alternativaCorreta(pergunta, resp);
                System.out.println("\r\n\n\n");
                System.out.flush();
            }
            System.out.println(quiz.toString());
    }
}
