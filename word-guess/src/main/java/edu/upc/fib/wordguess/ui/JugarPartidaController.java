package edu.upc.fib.wordguess.ui;


public class JugarPartidaController {
	
	private JugarPartidaView jpv = null;
	//private CtrlDominio ctrlDominio;

	
	public JugarPartidaController () {
		//ctrlDominio = new CtrlDominio();
		if(jpv==null) {
			jpv = new JugarPartidaView();
		}
		
	}
	
	public void inicialitza () {
		//Inicialitzar Controlador domini
		jpv.setVisible(true);	
	}
				
	public void PrLogin(){
		
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
		jpv.tancar();
	}

}
