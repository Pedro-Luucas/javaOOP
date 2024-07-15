public class Lutador {
    private String nome;
    private String nacionalidade;
    private Integer idade;
    private float altura;
    private float peso;
    private String categoria;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;
    private boolean valido;

    // CONSTRUCTOR
    public Lutador(String nome, String nac, Integer idd, float alt, float peso) {
        setNome(nome);
        setNacionalidade(nac);
        setIdade(idd);
        setAltura(alt);
        setPeso(peso);
        setVitorias(0);
        setDerrotas(0);
        setEmpates(0);
    }


    // METODOS
    public void apresentar(){
        String message = String.format("ENTRA O LUTADOR %s, PESANDO %.2f KG E COM %.2f DE ALTURA, DA CATEGORIA %s.\n %s É UM %s DE %d ANOS, COM %d VITORIAS, %d EMPATES E %d DERROTAS.",getNome(),getPeso(),getAltura(),getCategoria(),getNome(),getNacionalidade(),getIdade(),getVitorias(),getEmpates(),getDerrotas());
        System.out.println(message);
    }

    public void status(){
        System.out.println("-------------------------");
        System.out.println("----------STATUS---------");
        System.out.println(getNome());
        System.out.println(getCategoria());
        String msgV = String.format("%d vitorias", getVitorias());
        System.out.println(msgV);
        String msgE = String.format("%d empates", getEmpates());
        System.out.println(msgE);
        String msgD = String.format("%d derrotas", getDerrotas());
        System.out.println(msgD);
        System.out.println("-------------------------");
    }

    public void ganhar(){
        setVitorias(getVitorias() + 1);
    }

    public void perder(){
        setDerrotas(getDerrotas() + 1);
    }

    public void empatar(){
        setEmpates(getEmpates() + 1);
    }


    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        setCategoria(peso);
        setValido(peso);
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria(float peso) {
        if((peso <= 52.1f) || (peso >= 120.3f)){
            this.categoria = "INVALIDO";
        }
        else if((peso >= 52.2f) && (peso <= 77.1f)){
            this.categoria = "PESO LEVE";
        }
        else if((peso >= 77.2f) && (peso <= 89.3f)){
            this.categoria = "PESO MEDIO";
        }
        else if((peso >= 89.4f) && (peso <= 120.2f)){
            this.categoria = "PESO PESADO";
        }

    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public boolean isValido() {
        return valido;
    }

    private void setValido(float peso) {
        this.valido = (!(peso <= 52.1f)) && (!(peso >= 120.3f));
    }
}
