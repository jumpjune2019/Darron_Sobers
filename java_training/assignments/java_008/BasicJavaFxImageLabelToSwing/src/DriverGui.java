import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class DriverGui {

	JFrame frm;
	JPanel panel;
	JLabel description;
	JLabel labelImage;
	ImageIcon image;
	BufferedImage resizedImage;
	Graphics g2;
	
	public DriverGui() {
		
		prepareGui();
		
	}
	
	
	private void prepareGui() {
		
		frm = new JFrame("Fungi is Hilarious!");
		frm.setSize(320, 80);
		
		panel = new JPanel(new FlowLayout());
		
		
		image = new ImageIcon("C:/java_training/JavaFXtoSwing/BasicJavaFxImageLabelToSwing/src/fungi.png");
		image.setImage(getScaledImage(image.getImage(), 28, 28));
		
		labelImage = new JLabel(image);
		description = new JLabel("Fungi");		
		
		
		panel.add(description);
		panel.add(labelImage);
		frm.add(panel);
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end prepareGui
	
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
	
}//end DriverGui