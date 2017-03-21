package Controllers;

import Models.ProcesadorDeMapas;

public class ProcesadorDeMapasImpl implements ProcesadorDeMapas{

	@Override
	public int nIslas(int[][] mapa) {
		int numero = 0;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				if(mapa[i][j] == 1){
					numero++;
					borrar(mapa, i, j);
				}
			}
		}
		return numero;
	}
	//i = y, x = j
	public void borrar(int[][] mapa, int i, int j) {
		// TODO Auto-generated method stub
		if ((i>=0) && (i < mapa.length) && (j>=0) && (j<mapa[0].length)) {
			if (mapa[i][j] == 1) {
				mapa[i][j] = -1;
				for (int l = i - 1; l <= i + 1; l++) {
					for (int k = j - 1; k <= j + 1; k++) {
						borrar(mapa,l,k);
					}
				}
			}
			
		}
	}

}
