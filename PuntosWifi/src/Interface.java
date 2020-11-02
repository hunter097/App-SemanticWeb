import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.util.ArrayList;

public class Interface extends JFrame implements ActionListener {

    private JLabel texto;   
    private JLabel texto2;  
    private JLabel textoFiltro1; 
    private JLabel textoFiltro2;
    private JLabel textoFiltro3
    ;
    private JTextField box;        
    private JButton boton; 
    private JButton boton2; 
    private JButton boton3; 
    private int cont;
    
    private JComboBox select;
    private JComboBox select2;
    private JComboBox select3;
    private JComboBox select4;

    private ImageIcon image = new ImageIcon("/Users/usuario/eclipse-workspace/PuntosWifi/src/portada.png");
    private ImageIcon image2 = new ImageIcon("/Users/usuario/eclipse-workspace/PuntosWifi/src/ventana2.png");

    private JLabel imageLabel;
    
        
    public Interface(String titulo,int x, int y) {
        super();                    
        setFrame(titulo,x,y); 
        cont = 0;
    }

    private void setFrame(String titulo, int x, int y) {
        this.setTitle(titulo);              
        this.setSize(x,y);                                 
        this.setLocationRelativeTo(null);                       
        //this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    public void init(ArrayList<String> list1, ArrayList<String> list2) {
    	
    
    	//interface components
        texto = new JLabel();
        boton = new JButton();								
        select = new JComboBox();						
        imageLabel = new JLabel(image);		
        

        texto2 = new JLabel();
        textoFiltro1 = new JLabel();
        textoFiltro2 = new JLabel();
        textoFiltro3 = new JLabel();

        boton2 = new JButton();								
        select2 = new JComboBox();	
        
        select3 = new JComboBox();	
        select4 = new JComboBox();	
        boton3 = new JButton();	
        //interface attributes 
        texto.setText("Seleccionar Punto Wifi");    
        texto.setBounds(400, 300, 200, 60);   
        boton.setText("Mostrar Informacion");   
        boton.setBounds(490, 350, 200, 26);  
        boton.addActionListener(this);      
        select.setBounds(270, 350, 200, 25);
        imageLabel.setBounds(-10 ,0, 950, 650);
        
        fillList1(list1);
        
        
        texto2.setText("Búsqueda por Localizacion"); 
        texto2.setBounds(385, 400, 200, 60);  
        
        textoFiltro1.setText("Seleccionar Distrito:"); 
        textoFiltro1.setBounds(140, 440, 200, 60); 
        
        textoFiltro2.setText("Seleccionar Barrio:"); 
        textoFiltro2.setBounds(360, 440, 200, 60); 
        
        textoFiltro3.setText("Seleccionar Biblioteca:"); 
        textoFiltro3.setBounds(580, 440, 200, 60); 
        
        boton2.setText("Aplicar");   
        boton2.setBounds(470, 520, 200, 30);  
        boton2.addActionListener(this);     
        boton3.setText("Reset");  
        boton3.setBounds(250, 520, 200, 30);
        boton3.addActionListener(this);     

        select2.setBounds(140, 480, 200, 25);

        fillList2(list2);
        
        
        select3.setBounds(360, 480, 200, 25);
        select4.setBounds(580, 480, 200, 25);
        

   
        //add components
        this.add(texto);
        this.add(boton);
        this.add(select);
        
  
        this.add(texto2);
        
        this.add(textoFiltro1);
        this.add(textoFiltro2);
        this.add(textoFiltro3);
        
        this.add(boton2);
        this.add(boton3);
        this.add(select2);
        
        
        this.add(select3);
        this.add(select4);

        
        this.add(imageLabel);

        select2.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    		
    			
    			cont = 1;
    			Location loc = new Location();
    			String seleccion2 = select2.getSelectedItem().toString();
    	        
    	        ArrayList<String> list3 = loc.getListNeighborhood(seleccion2);
    			fillList3(list3);
    			 

    		}

    	});
        
        
        select3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (cont == 2){
					Space edificios = new Space();
					String seleccion3 = select3.getSelectedItem().toString();
			        System.out.println(seleccion3);
			        ArrayList<String> list4 = edificios.getListSpace(seleccion3);
					fillList4(list4);
					
				}
				
				cont = 2;
			}

		});

   


    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String seleccion = select.getSelectedItem().toString();                              
        
        String seleccion2 = select2.getSelectedItem().toString();
        
     

        
        
        Space edificio = new Space();
        
        Location localizacion = new Location();
        
        
        //Button 1 action
        if (e.getActionCommand().equals("Mostrar Informacion")) {
        	
        	createWindow2(edificio,localizacion, seleccion);
    		
  
        	
        }
        
        //Button 2 action
        if (e.getActionCommand().equals("Aplicar")) {
        	if(cont == 2) {
        		
        		
            	createWindow2(edificio,localizacion, seleccion);

        		
        	}



            //JOptionPane.showMessageDialog(this, "Hello " + resultado + ".");    					//print message with the text from the selection box
           
        	
        	
        }
        
        //Button 3 action
        if (e.getActionCommand().equals("Reset")) {
        	cont = 0;
        	select3.removeAllItems();
        	select4.removeAllItems();
 
        	
        }
 
        
    }
    
    
    private void fillList1(ArrayList<String> list1) {
    	for (int i=0;i<list1.size();i++) {
			select.addItem(list1.get(i));
    	}
	}

    private void fillList2(ArrayList<String> list2) {
    	for (int i=0;i<list2.size();i++) {
			select2.addItem(list2.get(i));
    	}
	}

    private void fillList3(ArrayList<String> list3) {
    	select3.removeAllItems();
    	for (int i=0;i<list3.size();i++) {
			select3.addItem(list3.get(i));
    	}    	
    	
	}
    
    private void fillList4(ArrayList<String> list4) {
    	select4.removeAllItems();
    	for (int i=0;i<list4.size();i++) {
			select4.addItem(list4.get(i));
    	}    	
    	
	}
    
    private void createWindow2(Space edificio, Location localizacion, String seleccion) {
    	
    	
    	Interface ventana2 = new Interface(seleccion,500,500);
    	JLabel hasName = new JLabel("Nombre: ");
    	JLabel hasNameD = new JLabel(edificio.getHasName());
    	JLabel hasShedule = new JLabel(edificio.getHasSchedule());
    	JLabel hasEquipment = new JLabel(edificio.getHasEquipment());
  
    	
 
        imageLabel = new JLabel(image2);
        
        hasName.setBounds(50, 50, 200, 60);   
        hasNameD.setBounds(150, 50, 200, 60);   
         
        imageLabel.setBounds(-10 ,0, 500, 500);
        
        
        
        ventana2.setResizable(false);
        ventana2.setVisible(true); 
        
        
        ventana2.add(hasName);
        ventana2.add(hasNameD);
        ventana2.add(imageLabel);
    	
    	
    	
    }
 
}