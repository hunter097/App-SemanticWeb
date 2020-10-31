import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Interface extends JFrame implements ActionListener {

    private JLabel texto;   
    private JLabel texto2;  
    private JTextField box;        
    private JButton boton; 
    private JButton boton2; 
    
    
    private JComboBox select;
    private JComboBox select2;
    private ImageIcon image = new ImageIcon("/Users/usuario/eclipse-workspace/PuntosWifi/src/portada.png");
    private JLabel imageLabel;
    
        
    public Interface() {
        super();                    
        setFrame();           
    }

    private void setFrame() {
        this.setTitle("Puntos Wifi Públicos");              
        this.setSize(950, 650);                                 
        this.setLocationRelativeTo(null);                       // center location
        this.setLayout(null);                                   // no layouts so we can put positions to components 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    public void init(String [] listaEdificios , String [] listaDistritos) {
    	
    	
        // ----1ºBUSQUEDA----
        texto = new JLabel();
        //box = new JTextField();
        boton = new JButton();									//button to search
        select = new JComboBox(listaEdificios);							//selection box
        imageLabel = new JLabel(image);							//Madrid City map image
        
        
        
        //----2º COLUMNA----
        texto2 = new JLabel();
        //box = new JTextField();
        boton2 = new JButton();								
        select2 = new JComboBox(listaDistritos);	
        
        
        // configuramos los componentes
        texto.setText("Seleccionar Punto Wifi");    
        texto.setBounds(230, 400, 200, 60);   
        //caja.setBounds(150, 50, 100, 25);   
        boton.setText("Mostrar Informacion");   
        boton.setBounds(200, 500, 200, 30);  
        boton.addActionListener(this);      
        select.setBounds(200, 450, 200, 25);
        imageLabel.setBounds(-10 ,0, 950, 650);
      
        
   						
   
        
        texto2.setText("Busqueda por Distrito"); 
        texto2.setBounds(530, 400, 200, 60);  
        boton2.setText("Mostrar Puntos Wifi");   
        boton2.setBounds(500, 500, 200, 30);  
        boton2.addActionListener(this);      
        select2.setBounds(500, 450, 200, 25);

        
        //we add components to the window
        this.add(texto);
        //this.add(box);
        this.add(boton);
        this.add(select);
        
        //we add components to the window
        this.add(texto2);
        //this.add(box);
        this.add(boton2);
        this.add(select2);
        
        this.add(imageLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String seleccion = select.getSelectedItem().toString();                              
        
        Edificios edificios = new Edificios();
        
        //Accion para Boton 1
        if (e.getActionCommand().equals("Mostrar Informacion")) {
        	
        	
            String resultado = edificios.getInfoEdificios(seleccion)[0];

        	JOptionPane.showMessageDialog(this, "Hello " +resultado + ".");
        	
        	
        	
        	
        }
        
        //Accion para Boton 2
        if (e.getActionCommand().equals("Mostrar Puntos Wifi")) {
        	
        	
        	

            String resultado = edificios.getListaEdificios(seleccion)[0];
            JOptionPane.showMessageDialog(this, "Hello " + resultado + ".");    					//print message with the text from the selection box
              
        	
        	
        	
        }
        System.out.println(e.getActionCommand());
        
    
        
        
        
        
        
    }
    
    

    

}