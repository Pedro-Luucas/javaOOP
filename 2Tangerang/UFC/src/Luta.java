import java.util.Objects;
import java.util.Random;

public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private boolean aprovada;

    Random rand = new Random();

    // METODOS
    public void marcarLuta(Lutador l1, Lutador l2){
        if((Objects.equals(l1.getCategoria(), l2.getCategoria())) && (l1 != l2) && (l1.isValido()) && (l2.isValido())){
            setAprovada(true);
            setDesafiante(l1);
            setDesafiado(l2);
        }
        else{
            setAprovada(false);
        }
    }

    public void Lutar(){

        desafiado = getDesafiado();
        desafiante = getDesafiante();
        System.out.println("APRESENTANDO O DESAFIANTE! :");
        desafiante.apresentar();
        System.out.println("-------------------------");
        System.out.println("APRESENTANDO O DESAFIADO! :");
        desafiado.apresentar();
        System.out.println("-------------------------");

        Integer vencedor = rand.nextInt(101);
        if (vencedor < 20){
            desafiante.empatar();
            desafiado.empatar();
            System.out.println("A LUTA EMPATOU!");
        }
        else if(vencedor < 60){
            desafiante.ganhar();
            desafiado.perder();
            String msg = String.format("O DESAFIANTE %s GANHOU A LUTA!", desafiante.getNome());
            System.out.println(msg);
        }
        else{
            desafiante.perder();
            desafiado.ganhar();
            String msg = String.format("O DESAFIADO %s GANHOU A LUTA!", desafiado.getNome());
            System.out.println(msg);
        }
    }

    // GETTERS E SETTERS
    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
}
