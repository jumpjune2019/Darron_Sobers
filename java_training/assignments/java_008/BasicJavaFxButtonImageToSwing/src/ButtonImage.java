import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonImage extends JPanel{

	JButton button;
	ImageIcon image;
	JLabel label;
	
	
	public ButtonImage(String imageFile, String input, JLabel inputLabel) {
		
		image = new ImageIcon(imageFile);
		image.setImage(getScaledImage(image.getImage(), 28, 28));
		//label = new JLabel(image);
		button = new JButton(input, image);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener((ae) -> {
			
			inputLabel.setText(input);
			
			
		}); 

		//this.add(label);
		this.add(button);
		
	}
	
	
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
}//end ButtonImage class