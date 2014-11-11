import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Card 
{
    private Suit suit;
    private Value value;
    private String filePath;
    private BufferedImage image; 

    public Card(Value value, Suit suit, String filePath) 
    {
	try
	{
	    this.value = value;
	    this.suit = suit;
	    this.filePath = filePath;

	    image = ImageIO.read(new File(filePath));
	}
	catch(Exception e)
	{
	    System.err.println(e.getMessage());
	}
    }

    public Suit getSuit() 
    {
	return suit;
    }

    public Value getValue() 
    {
	return value;
    }

    public BufferedImage getImage()
    {
	return image;
    }
}