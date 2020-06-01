import java.awt.*;
import java.awt.event.*;
import java.awt.font.GlyphVector;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Clock extends JPanel
implements ActionListener, ChangeListener
{

	private Timer clock;
	private Time time;

	public Clock()
	{	
		setLayout(new BorderLayout());
		JPanel checkP = new JPanel();
		checkP.setBackground(Color.WHITE);

		JSlider sl = new JSlider();
		sl.setPreferredSize(new Dimension(100,20));
		sl.setValue(0);
		sl.setBackground(Color.WHITE);
		sl.addChangeListener(this);
		JCheckBox cb = new JCheckBox("12 Hour Time");
		checkP.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		cb.addActionListener(this);
		cb.setBackground(Color.WHITE);
		checkP.add(sl);
		checkP.add(cb);
		add(checkP,BorderLayout.NORTH);

		long time2 = System.currentTimeMillis()%86400000;
		int mins = (int)(time2 % 3600000 / 60000);
		int hr = (int)(time2 / 3600000);
		
		// TEST CONSTRUCTOR
		time = new Time(hr,mins);
		clock = new Timer(1000, this); 
		clock.start();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g = g.create();

		int width = getWidth();
		int height = getHeight();

		// TEST COMPARE METHOD
		Color sky;
		if (time.compareTo(new Time(5,0)) < 0) sky = Color.BLACK;
		else if (time.compareTo(new Time(7,0)) < 0) sky = Color.RED;
		else if (time.compareTo(new Time(17,0)) < 0) sky = Color.CYAN;
		else if (time.compareTo(new Time(19,0)) < 0) sky = Color.RED;
		else sky = Color.BLACK;
		g.setColor(sky);
		g.fillRect(0, 0, width, height);


		// TEST ELAPSEDSINCE
		int sinceDawn = time.elapsedSince(new Time(6,0));
		int xdif = (int)(width/3 * Math.cos(Math.PI * sinceDawn / 720));
		int ydif = (int)(height/2 * Math.sin(Math.PI * sinceDawn / 720));
		int r = 20;
		g.setColor(Color.ORANGE);
		g.fillOval(width/2 - xdif - r, height - ydif - r, 2*r, 2*r);
		g.setColor(Color.WHITE);
		g.fillOval(width/2 + xdif - r, height + ydif - r, 2*r, 2*r);
		g.setColor(sky);
		g.fillOval(width/2 + xdif, height + ydif - r, 2*r, 2*r);


		// TEST TOSTRING METHOD
		g.setColor(new Color(255-sky.getRed(),255-sky.getBlue(),255-sky.getGreen()));
		Font f = new Font("Sans Serif",Font.BOLD,55);
		g.setFont(f);
		String timeS = time.toString();
		FontMetrics fm = g.getFontMetrics();
		Graphics2D g2 = (Graphics2D)g;
		GlyphVector gv = f.createGlyphVector(g2.getFontRenderContext(), timeS);
		Shape shape = gv.getOutline();
		g2.setStroke(new BasicStroke(1));
		g2.translate(width/2-fm.stringWidth(timeS)/2, height/2+fm.getAscent()/2);
		g2.setColor(Color.WHITE);
		g2.fill(shape);
		g2.setColor(Color.BLACK);
		g2.draw(shape);

	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();  

		if (e.getSource() instanceof Timer) {

			// TEST INCREMENT METHOD
			time.increment();
		} else {

			// TEST PRINTAMPM METHOD
			boolean AMPM = ((JCheckBox)source).isSelected();
			time.setPrintAMPM(AMPM);
		}

		repaint();
	}


	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			clock.setDelay(10 + (int)((100-source.getValue()) * 9.9));
		}
	}

	public static void main(String[] args)
	{
		JFrame w = new JFrame("Moving Disk: Time Tester");
		w.setSize(800, 200);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.add(new Clock());
		w.setResizable(false);
		w.setVisible(true);
	}


}
