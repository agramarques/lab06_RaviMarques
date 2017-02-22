package centralDeGames;

import java.util.HashMap;

public class Usuario {

	private String nome;
	private String login;
	private HashMap<String, Jogo> comprados;
	private double creditos;
	private int x2p;
	private TipoDeUsuario status;

	public Usuario(String nome, String login) throws Exception{
		if (nome == null || nome.trim().equals("") || login == null || login.trim().equals("")){
			throw new Exception("nome invalido");
		}
		this.nome = nome;
		this.login = login;
		comprados = new HashMap<>();
		creditos = 0;
		x2p = 0; //comeca como noob
		status = new Noob();
	}
	
	/**
	 * inclui jogo informado na conta do usuario, se este possuir creditos suficientes para compra-lo
	 * @param novo - Jogo a ser incluido
	 * @throws Exception
	 */
	public void comprarJogo(Jogo novo) throws Exception{
		double precoComDesconto = status.getPrecoComDesconto(novo); 
		if(precoComDesconto > this.getCreditos()){
			throw new Exception("voce nao tem credito para comprar esse jogo");
		}
		else{
			this.setCreditos(this.getCreditos() - precoComDesconto);
			this.getComprados().put(novo.getNome(), novo);
			this.x2p += status.getAddX2p(novo);
		}	
	}
	
	/**
	 * credita valor informado na conta do usuario
	 * @param valor espera um valor não-negativo (Reais)
	 * @throws Exception
	 */
	public void colocarCredito(double valor) throws Exception{
		if (valor < 0){
			throw new Exception("valor invalido");
		}
		else{
			creditos += valor;	
		}
	}
	
	public void punir(String nomeJogo, int scoreObtido, boolean zerou){
		Jogo jogo = comprados.get(nomeJogo);
		int deducao = status.punir(jogo, scoreObtido, zerou);
		this.x2p += deducao;
	}
	
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou){
		Jogo jogo = comprados.get(nomeJogo);
		int acrescimo = status.recompensar(jogo, scoreObtido, zerou);
		this.x2p += acrescimo;
	}
	
	/**
	 * delega registraJogada de Jogo (se o usuario pertencer o jogo em questao)
	 * @param nomeDoJogo
	 * @param score
	 * @param zerou
	 * @throws Exception
	 */
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception{
		if(!comprados.containsKey(nomeDoJogo)){
			throw new Exception("usuario nao possui jogo informado");
		}
		else{
			int acrescimoX2p = comprados.get(nomeDoJogo).registraJogada(score, zerou);
			this.x2p += acrescimoX2p;	//pontua pela jogada
			this.punir(nomeDoJogo, score, zerou);	//pune pela jogada
			this.recompensar(nomeDoJogo, score, zerou);	//recompensa pela jogada
		}
	}

	public double calculaPrecoTotalJogos(){	//retorna valor total que o usuario possui em jogos comprados
		double total = 0;
		for(Jogo j:comprados.values()){
			total += j.getPreco();
		}
		return total;
	}
	
	public void copiarUsuario(Usuario old){
		this.comprados = old.getComprados();
		this.setCreditos(old.getCreditos());
		this.setX2p(old.getX2p());
		this.setLogin(old.getLogin());
	}
	
	public void upgrade(){
		this.status = new Veterano();
	}
	
	public void downgrade(){
		this.status = new Noob();
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public HashMap<String, Jogo> getComprados() {
		return comprados;
	}

	public double getCreditos() {
		return creditos;
	}

	protected void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public int getX2p() {
		return x2p;
	}

	protected void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public TipoDeUsuario getStatus() {
		return status;
	}

	public void setStatus(TipoDeUsuario status) {
		this.status = status;
	}

	//ajustar o toString para o Usuario geral ou incluir na interface TipoDeUsuario
	@Override
	public String toString(){
		return this.getLogin() + '\n' + this.getNome() + " - Jogador Veterano\n" + "Lista de Jogos:\n" + this.getComprados() + "\n\n" + "Total de preco dos jogos: R$" + this.calculaPrecoTotalJogos();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	
	
}
