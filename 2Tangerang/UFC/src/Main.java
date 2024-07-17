import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception{
        List<Lutador> lutadores = new ArrayList<>();
        System.out.println("PORRADARIA INTENSA!!! 64 LUTADORES DE DIVERSOS PAISES VAO LUTAR 1024 VEZES ALEATORIAMENTE, O QUE GANHAR MAIS LUTAS GANHA O CINTURAO! ");

        Random rand = new Random();

        String[] nacionalidades = {
                "Brasileiro", "Americano", "Canadense", "Mexicano", "Argentino", "Chileno", "Alemão", "Francês", "Italiano", "Espanhol",
                "Português", "Russo", "Chinês", "Japonês", "Coreano", "Indiano", "Australiano", "Neozelandês", "Sul-Africano", "Egípcio",
                "Marroquino", "Nigeriano", "Senegalês", "Turco", "Grego", "Holandês", "Belga", "Sueco", "Norueguês", "Dinamarquês",
                "Finlandês", "Polonês", "Tcheco", "Húngaro", "Austríaco", "Suíço", "Cubano", "Peruano", "Colombiano", "Venezuelano",
                "Uruguaio", "Paraguaio", "Boliviano", "Equatoriano", "Panamenho", "Costarriquenho", "Salvadorenho", "Hondurenho", "Guatemalteco", "Nicaraguense",
                "Israelense", "Palestino", "Libanês", "Sírio", "Iraquiano", "Iraniano", "Saudita", "Emiradense", "Qatarense", "Kuwaitiano",
                "Filipino", "Tailandês", "Vietnamita", "Malaio"
        };

        String[] nomes = {
                "Carlos", "John", "James", "Luis", "Diego", "Javier", "Hans", "Pierre", "Giovanni", "Miguel",
                "Antonio", "Dmitri", "Li", "Hiroshi", "Min-Jun", "Raj", "Bruce", "Liam", "Nelson", "Ahmed",
                "Youssef", "Chinwe", "Amadou", "Mehmet", "Nikos", "Jan", "Georges", "Sven", "Erik", "Lars",
                "Mika", "Jakub", "Jan", "László", "Franz", "Hans", "Raul", "Pedro", "Carlos", "Jorge",
                "Diego", "Juan", "Santiago", "Miguel", "Francisco", "Luis", "Carlos", "Manuel", "José", "Antonio",
                "David", "Daniel", "Noam", "Omar", "Ali", "Hassan", "Mohammad", "Abdullah", "Khalid", "Yousef",
                "Jose", "Somchai", "Nguyen", "Ali"
        };

        for (int i = 0; i < 64; i++) {
            String nome = nomes[i];
            String nacionalidade = nacionalidades[i];
            int idade = rand.nextInt(18, 41);
            float altura = rand.nextFloat() * (2.0f - 1.5f) + 1.5f;
            float peso = rand.nextFloat() * (120.2f - 52.2f) + 52.2f;
            lutadores.add(new Lutador(nome, nacionalidade, idade, altura, peso));
        }

        for (int i = 0; i < 1024; i++){
            while (true) {
                int l1 = rand.nextInt(64);
                int l2 = rand.nextInt(64);

                if (l1 != l2) {

                    Lutador desafiante = lutadores.get(l1);
                    Lutador desafiado = lutadores.get(l2);

                    Luta porradaria = new Luta();
                    porradaria.marcarLuta(desafiante, desafiado);
                    if (porradaria.isAprovada()) {
                        porradaria.Lutar();
                        break;
                    } else {
                        continue;
                    }

                } else {
                    continue;
                }

            }
        }
        List<Integer> vitorias = new ArrayList<>();
        for(int i = 0; i < 64; i++){
            Lutador l = lutadores.get(i);
            vitorias.add(l.getVitorias());
        }
        Integer maxVal = Collections.max(vitorias);
        Integer maxIdx = vitorias.indexOf(maxVal);

        Lutador vencedor = lutadores.get(maxIdx);
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("E EEEENTRA O VENCEDR");
        vencedor.apresentar();

    }


}
