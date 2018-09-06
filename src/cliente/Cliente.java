package cliente;

import java.rmi.Naming;

import interfaz.TDAManejoDatos;
import vistas.MainView;;

public class Cliente {
	private static TDAManejoDatos manejoDatos;

	public static void main(String[] args) {
		new Cliente();
	}

	public boolean getStub() {

		try {
			manejoDatos = (TDAManejoDatos) Naming
					.lookup("//127.0.0.1/clasificados");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Cliente() {
		if (getStub()) {
			MainView menu = new MainView();
			menu.setVisible(true);
		}
	}

	public static TDAManejoDatos getInstancia() {
		return manejoDatos;
	}
}
