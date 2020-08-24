package dialog;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ListaModel  implements ListModel<String>{
	
	private ArrayList<String> studenti;
	
	
	public ListaModel(ArrayList<String> s) {
		studenti=s;
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return studenti.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return studenti.size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	

}
