import javax.swing.*;
public class MyLabel {
	private String position;

	MyLabel() {
		
	}

	SetLabelinLayoutInterface setInLayout = (JFrame jF, JLabel jl) -> {
		jF.add(jl, position);
	};
	
	SetLabelInterface setLab = (String l, String p, JFrame jf) -> {
		position = p;
		JLabel lb = new JLabel(l);
		// calling lambda expression
		setInLayout.setLabelInLayout(jf, lb);
		return lb;
	};
	
}
