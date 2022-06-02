import java.util.LinkedList;

public class Pergunta {
    private String pergunta;
    private LinkedList<String> alternativas;
    private char respota;


    public Pergunta(String pergunta, char respota) {
        this.pergunta = pergunta;
        this.respota = respota;
        this.alternativas = new LinkedList<>();

    }

    /**
     * Vai add uma alternativa dentro de uma pergunta
     * @param alternativa
     */
    public void addAltenativas(String alternativa) {
            this.alternativas.add(alternativa);
    }

    public char getRespota() {
        return respota;
    }

    /**
     * Vai percorrer uma lista de alternativas que uma pergunta tem.
     * @return vai imprimir cada alternativas de uma pergunta
     */
    public  String mostrarAlternativas() {
        StringBuilder sb = new StringBuilder();
        for (String alternativa : alternativas) {
            sb.append(alternativa + "\n");
        }
        return sb.toString();
    }

    public String toString() {
        return this.pergunta + "\n" +
                mostrarAlternativas();
    }


}
