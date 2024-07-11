public class ContaBanco {
    public int contaID;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void ContaBanco(){
        saldo = 0f;
        status = false;
    }

    // METODOS
    public void abrirConta(String t, String dono, int contaID) {
        setTipo(t);
        setStatus(true);
        if("c".equals(t)){
            setSaldo(getSaldo() + 50.0f);
        }
        else if ("p".equals(t)){
            setSaldo(getSaldo() + 150.0f);
        }
        setDono(dono);
        setContaID(contaID);
        String mensagem = String.format("Parabens %s ! voce abriu sua conta. seu ID é %d e voce tem %.2f de saldo.", getDono(), getContaID(), getSaldo());
        System.out.println(mensagem);

    }

    public boolean fecharConta() {
        if (saldo < 0) {
            String mensagem = String.format("Voce esta com saldo negativo de %.2f entao nao pode fechar sua conta.", saldo);
            System.out.println(mensagem);
            return false;
        }
        else{
            String mensagem = String.format("Você fechou a conta com saldo de %.2f o saldo vai ficar pro bancokkkkkkkkk", saldo);
            System.out.println(mensagem);
            setStatus(false);
            return true;
        }
        
    }

    public void depositar(float dinheiro) {
        if(getStatus()){
            setSaldo(getSaldo() + dinheiro);
            String mensagem = String.format("Voce depositou %.2f agora tem %.2f na conta.", dinheiro, getSaldo());
            System.out.println(mensagem);
        }
        else{
            System.out.println("Sua conta não está aberta! ");
        }
        
    }

    public void sacar(float dinheiro) {
        if(getStatus()){
            setSaldo(getSaldo() - dinheiro);
            String mensagem = String.format("Voce sacou %.2f agora tem %.2f na conta.", dinheiro, getSaldo());
            System.out.println(mensagem);
        }
        else{
            System.out.println("Sua conta não está aberta! ");
        }
    }

    public void pagarMensal(){
        if(getStatus()){
            if("c".equals(getTipo())){
                setSaldo(getSaldo() - 12.0f);
            }
            else if("p".equals(getTipo())){
                setSaldo(getSaldo() - 20.0f);
            }
        }
        else{
            System.out.println("Sua conta não está aberta! ");
        }
    }

    // GETTERS E SETTERS
    // get e set contaID
    public int getContaID() {
        return this.contaID;
    }
    private void setContaID(int id) {
        this.contaID = id;
    }

    // get e set tipo
    public String getTipo() {
        return this.tipo;
    }
    private void setTipo(String tipo) {
        if(tipo != "c" && tipo != "p"){
            System.out.println("Escolha um tipo valido! ( c Para conta corrente OU p Para conta poupanca ) ");
        }
        else{
            this.tipo = tipo;
        }
    }

    // get e set dono
    public String getDono() {
        return this.dono;
    }
    private void setDono(String dono) {
        this.dono = dono;
    }

    // get e set saldo
    public float getSaldo() {
        return this.saldo;
    }
    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    // get e set status
    public boolean getStatus() {
        return this.status;
    }
    private void setStatus(boolean status) {
        this.status = status;
    }

}
