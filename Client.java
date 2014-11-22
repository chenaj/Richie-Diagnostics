
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Client extends JFrame implements ActionListener
{

	public JButton startButton;
	public JButton close;
	public JButton filePathButton;
	public JTextField filePath;

//------------------------------Client Constructor------------------------//
	public Client()
	{
		super("Richie Supersystem Diagnostics");			//Creation of GUI
		filePath = new JTextField(21);
		filePathButton = new JButton("Choose File");
		filePathButton.setName("fileButton");
		startButton = new JButton("Test");
		startButton.setName("startButton");
		close = new JButton("Exit");
		close.setName("exitButton");
		JPanel pane = new JPanel();
		JLabel description = new JLabel();
		description.setText("Please enter the file path of or browse for the configuration file.");
		JLabel configLabel = new JLabel();
		configLabel.setText("Configuration File Path: ");
		
		pane.add(description);
		pane.add(configLabel);
		pane.add(filePath);
		pane.add(filePathButton);
		pane.add(startButton);
		pane.add(close);

		filePathButton.addActionListener(this);
		startButton.addActionListener(this);
		close.addActionListener(this);

		setContentPane(pane);	
	}
	
//------------------------Run Diagnostic Test-----------------------//
	public void RundDiagnostics()
	{
		String generation = "";
		try
		{
			generation = getComputerBuild();
			AbstractRichieFactory factory;
			factory = AbstractRichieFactory.Factory(generation.trim());
			AbstractCPU cpu = factory.getCPU();
			AbstractMMU mmu = factory.getMMU();
			AbstractMotherboard mobo = factory.getMotherboard();

			warning(cpu.test()+ "\n" + mmu.test() + "\n" + mobo.test());	//get testing of components
		}
		catch (IOException e)
		{
			warning("There are errors opening the configuration file.");
		}
		catch (NoFactoryException ex)
		{
			warning("There is no diagnostic program available for this particular build.");
		}
	}
	public String getComputerBuild() throws IOException
	{
		FileReader input = new FileReader(filePath.getText());
		BufferedReader bufRead = new BufferedReader(input);
		String line = bufRead.readLine();
		bufRead.close();
		return line;
	}

	
//------------------------userErrorMessage------------------------//
	public void warning(String s)
	{
		JOptionPane.showMessageDialog(this, s);
	}


//---------------------------evenListenerHandler-----------------//
	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		if (source instanceof Component)
		{
			Component comp = (Component)source;
			if (comp.getName().equals("startButton"))
			{
				if (filePath.getText().length() <= 0)		//If no file entered
					warning("Please specify the path of the configuration file.");
				else
					RundDiagnostics();
			}
			else if (comp.getName().equals("fileButton"))
			{
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(this);
				if (returnVal == JFileChooser.APPROVE_OPTION)
					filePath.setText(chooser.getSelectedFile().getAbsolutePath());
			}
			else if (comp.getName().equals("exitButton"))
			{
		    		System.exit(0);
		    }
		}
	}
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) { }
		Client client = new Client();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		client.setSize(400, 150);
		client.setLocation((screen.width - client.getSize().width) / 2,(screen.height - client.getSize().height) / 2);
		client.setResizable(false);
		client.setVisible(true);
	}
}

