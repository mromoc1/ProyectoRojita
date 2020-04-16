package Controlador;
	
	import java.awt.BorderLayout;
	import java.sql.*;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.*;

	public class controlador_graficos {
		
		public controlador_graficos() {
			
		}
	    
	    
	    /*public static void graficoPie(String titulo, int numero){
	        
	        DefaultPieDataset grafico = new DefaultPieDataset();
	        try{
	        OutputStream out = OutputStream.nullOutputStream();
	
	        grafico.setValue("Vendedor "+String.valueOf(4), 1);
	        grafico.setValue("Reponedor "+String.valueOf(6), 1);
	        grafico.setValue("Limpieza "+String.valueOf(6), 1);
	        
	        JFreeChart cha = ChartFactory.createPieChart3D("Cargos", grafico, true, true, true);
	        ChartPanel cp = new ChartPanel(cha);
	        JFrame frame = new JFrame("Grafico");
	        JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());
	        panel.add(cp);
	        frame.add(panel);
	        frame.pack();
	        frame.setVisible(true);
	        }
	        catch(Exception ex){
	        
	        }
	    }*/
	    public static void graficoBarra(ResultSet rs, String id){
	        
	        DefaultCategoryDataset dcs = new DefaultCategoryDataset();
	        
	        if(id == "Beneficios") {
	        	int i = 0;
		        try{
		        	while(rs.next()) {
		        		
		        		dcs.addValue(rs.getInt("beneficios"),"beneficios",rs.getString("mes").substring(0, 7));
		        		dcs.addValue(rs.getInt("ingresos"),"ingresos",rs.getString("mes").substring(0, 7));
		        		dcs.addValue(rs.getInt("costos"),"costos",rs.getString("mes").substring(0, 7));
		        		i++;
		        		System.out.println(i);
		        	}   

		        //OutputStream out = OutputStream.nullOutputStream();
		        
		        JFreeChart cha = ChartFactory.createBarChart3D("Beneficios: ID"+id, "Mes", "Beneficios $",dcs,PlotOrientation.VERTICAL, true, true ,true);
		        ChartPanel cp = new ChartPanel(cha);
		        JFrame frame = new JFrame("Grafico");
		        JPanel panel = new JPanel();
		        panel.setLayout(new BorderLayout());
		        panel.add(cp);
		        frame.add(panel);
		        frame.pack();
		        frame.setVisible(true);

		        }
		        catch(Exception ex){
		        	System.out.println("NO se grafica");
		        }
	        }
	        else {
	        int i = 0;
	        try{
	        	while(rs.next()) {
	        		System.out.println(rs.getObject("total"));
	        		dcs.addValue(rs.getInt("total"),rs.getString("mes").substring(0, 9),rs.getString("mes").substring(0, 9));
	        		i++;
	        		System.out.println(i);
	        	}   

	        //OutputStream out = OutputStream.nullOutputStream();
	        
	        JFreeChart cha = ChartFactory.createBarChart3D("Ventas producto: ID"+id, "Mes", "Ingresos $",dcs,PlotOrientation.VERTICAL, true, true ,true);
	        ChartPanel cp = new ChartPanel(cha);
	        JFrame frame = new JFrame("Grafico");
	        JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());
	        panel.add(cp);
	        frame.add(panel);
	        frame.pack();
	        frame.setVisible(true);

	        }
	        catch(Exception ex){
	        	System.out.println("NO se grafica");
	        }
	    
	        }
	    }
	}

