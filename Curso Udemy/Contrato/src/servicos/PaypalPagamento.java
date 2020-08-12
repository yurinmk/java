package servicos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entidade.Contrato;
import entidade.Parcelas;


public class PaypalPagamento implements Taxa{
	
	@Override
	public List<Parcelas> tax() {
		Contrato contrato = new Contrato();
		Calendar cal = Calendar.getInstance();
		List<Parcelas> lista = new ArrayList<>();
		
		Date dataContrato = contrato.getData();
		double valorParcela = contrato.getValor()/contrato.getQntParcelas();
		for(int i = 0; i < contrato.getQntParcelas(); i++) {
			cal.setTime(dataContrato);
			cal.add(Calendar.MONTH, 1);
			dataContrato = cal.getTime();
			double valorPagamento = (valorParcela * 0.01 * i) * 0.02 + valorParcela;
			lista.add(new Parcelas(cal.getTime(), valorPagamento));
			
		}
		return lista;
		
	}

}
