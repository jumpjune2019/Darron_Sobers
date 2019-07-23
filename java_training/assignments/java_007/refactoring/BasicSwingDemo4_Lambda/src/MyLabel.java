import javax.swing.*;
public class MyLabel {
	private String position;

	MyLabel() {
		
	}
	
	// converted into Lambda expression
	SetLabelInLayInterface setLabelLay = (jF, jl) -> {
		// aligns all JLabels to be in centered horizontally and vertically
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setVerticalAlignment(JLabel.CENTER);
		jF.add(jl, position);
	};
	
	SetLabelInterface setLab = (l, p, jf) -> {
		position = p;
		JLabel lb = new JLabel(l);
		setLabelLay.setLabelInLayout(jf, lb);
		return lb;
	};
	
	
}
