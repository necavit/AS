package edu.upc.fib.wordguess.ui;


public class JugarPartidaController {
	
	private JugarPartidaView jpv;
	//private CtrlDominio ctrlDominio;

	
	public JugarPartidaController () {
		//ctrlDominio = new CtrlDominio();
			jpv = new JugarPartidaView(this);		
	}
	
	public void inicialitza () {
		//Inicialitzar Controlador domini
		jpv.setVisible(true);	
	}
				
	public boolean PrLogin(){
		return true;
	}
	
	public void PrLogout(){
		
	}
	
	public void PrJugar(){
		
	}
	
	public void PrAturarPartida(){
		
	}
	
	public void PrComprovar(){
		
	}
	
	public void PrTancarPartida(){
		
	}

}
