package IF_Gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class PjPanel extends JPanel {

	/** {@link SpringLayout} the best whey to arrange components*/
	private SpringLayout layout = new SpringLayout();

	/** BackgroundImage: store original image */
	private BufferedImage bg_image = null;
	
	/** BackgroundImage: store resized/displayed image */
	private BufferedImage resized_image = null;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
	public PjPanel(){ super(); setLayout( this.layout ); }

	public PjPanel( String name ){ super(); setName( name ); setLayout( this.layout ); }

	public PjPanel( int width, int height ) {
		super(); setLayout( this.layout );
		setSize( width, height );
	}
	
	public PjPanel( int width, int height, File image ) throws IOException { 
		super(); setLayout( this.layout ); 
		setSize( width, height ); 
		setBackgroundImage( ImageIO.read( image ) );
	}
	
	public PjPanel( BufferedImage image ){
		super(); setLayout( this.layout );
		setBackgroundImage( image );
	}
	
	public boolean setBackgroundImage( BufferedImage bg_image ){ 
		boolean ret_val = false;
		/* Only add image panels that have a size grater than 0 */
		if( (getSize().width > 0) && (getSize().height > 0) ) { /* Only add image in fix size panels */
			this.bg_image = bg_image; 
			this.resized_image = bg_image; 
			resizeImage( getSize().width, getSize().height ); 
			ret_val = true;
		}
		return ret_val;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is

	/** <b>SpringLayout:</b> Puts the constraints and creates the panel at the requested size<br />
	*  <b>BackgroundImage:</b> Resize the image to the new dimensions.</b>
	*/
	@Override public void setSize( Dimension size ){		
		super.setSize( size );
		layout.putConstraint( SpringLayout.EAST, this, size.width, SpringLayout.WEST, this );
		layout.putConstraint( SpringLayout.SOUTH, this, size.height, SpringLayout.NORTH, this );
	} 
	/** <b>SpringLayout:</b> Puts the constraints and creates the panel at the requested size<br />
	*  <b>BackgroundImage:</b> Resize the image to the new dimensions.</b>
	*/
	@Override public void setSize( int width, int height ) {		
		super.setSize( width, height );
		layout.putConstraint( SpringLayout.EAST, this, width, SpringLayout.WEST, this );
		layout.putConstraint( SpringLayout.SOUTH, this, height, SpringLayout.NORTH, this );
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	addComponent																				//
	
	/** <b>SpringLayout:</b> Add a single component to the panel and put it at its location.
	* 
	*/
	public Component add( Component component ){
		if( component != null ) {
			super.add( component );
			layout.putConstraint( SpringLayout.WEST, component, component.getLocation().x, SpringLayout.WEST, this );
			layout.putConstraint( SpringLayout.NORTH, component, component.getLocation().y, SpringLayout.NORTH, this );
		}
		return this;
	} 
	/** <b>SpringLayout:</b> Add an array of components to the panel and put them at their location.
	* 
	*/
	public Component add( Component[] comp ){
		for( Component C: comp ){ add( C ); }
		return this;
	} 
	/** <b>SpringLayout:</b> Add an {@link ArrayList} of components to the panel and put them at their location.
	* 
	*/
	public Component add( ArrayList<Component> comp ){
		for( Component C: comp ){ add( C ); }
		return this;
	} 
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - S T A T I C

	private void resizeImage( int panel_width, int panel_height ){
		if( bg_image != null ){
			resized_image = calculateNewImageSize( getSize(), new Dimension( bg_image.getWidth(), bg_image.getHeight() ) );
			Graphics2D g = resized_image.createGraphics();
			g.drawImage( bg_image, 0, 0, resized_image.getWidth(), resized_image.getHeight(), null);
			g.dispose();
		}
	}
	
	private BufferedImage calculateNewImageSize( Dimension panel_size, Dimension image_size ) {
		
		int width = panel_size.width;
		int height = panel_size.height;
		double scale_width = 1.00, scale_height = 1.00, scale;
		
		/* calculate the scale between if the image width and panel width */
		if( panel_size.width < image_size.width ) {
			scale_width = (double)panel_size.width/(double)image_size.width;
		}
		
		/* calculate the scale between if the image height and panel height */
		if( panel_size.width < image_size.width ) {
			scale_height = (double)panel_size.height/(double)image_size.height;
		}
		
		/* use the smaller scale */
		scale = ( scale_width < scale_height )?(scale_width):(scale_height);
		
		width  = (int)(image_size.width*scale);
		height = (int)(image_size.height*scale);
		
		return new BufferedImage( width, height, 1 );
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
} /* End-of File! */
