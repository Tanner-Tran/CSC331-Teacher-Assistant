package view.seatingchart;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MessageBox;

import controller.DBController;
import view.GUI;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

public class CreateSeatChart 
{
	private JFrame seatChart;
	private JTable table;
	private DefaultTableModel model;
	private String course;
	private int rows;
	private int columns;

	public CreateSeatChart(String courseIn, int rowsIn, int columnsIn)
	{
		course = courseIn;
		rows = rowsIn;
		columns = columnsIn;
	}
	
	public void open() 
	{
		createContents();
	}

	protected void createContents() 
	{
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        double width = screenSize.getWidth();
        double tableWidth = columns * 150;
        double tableHeight = (rows * 27) + 37;
        
		seatChart = new JFrame();
		
		seatChart.setTitle("Seating Chart");
		
		if (tableWidth > width) 
		{
			seatChart.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		else 
		{
			seatChart.setSize((int)tableWidth + 30, (int)tableHeight + 130);
			seatChart.setLocationRelativeTo(null);
		}	
        	 
		 Object[] columnsArray = new Object[columns];
		 Object[][] rowsArray = new Object[rows][columns];

        
        DefaultTableModel tableModel = new DefaultTableModel();
        table = new JTable(new DefaultTableModel(rowsArray, columnsArray));
    	table.setRowHeight(27);
    	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  	

        for (int i = 0; i < columns; i++) 
        {
        	TableColumn column = table.getColumnModel().getColumn(i);
            JComboBox comboBox = new JComboBox();
            String[] students = DBController.getStudents(course, GUI.getCookie());
            for (String e : students)
            {
            	comboBox.addItem(e);
            }
            comboBox.insertItemAt("", 0);
            column.setCellEditor(new DefaultCellEditor(comboBox));
            column.setMinWidth(150);
            column.setMaxWidth(150);
            
            column.setCellRenderer(new CheckBoxCellRenderer(comboBox));
            table.repaint();
            
        }   
        
        table.setBounds(20, 20, 240, 300);
        table.getTableHeader().setReorderingAllowed(false);
        seatChart.getContentPane().setLayout(null);
        
        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(table);
        //sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        

        
        
        if (tableWidth > width) 
        {
        	sp.setBounds(10, 11, (int)width - 15, (int)tableHeight + 1);
        }
        else 
        {
        	sp.setBounds(10, 11, (int)tableWidth, (int)tableHeight + 1);
        }
        
        seatChart.getContentPane().add(sp);        
        seatChart.setVisible(true);
        
        JButton btnNewButton_2 = new JButton("OK");
        btnNewButton_2.setBounds((sp.getWidth()/2 - 44), sp.getHeight() + 50, 89, 23);
        seatChart.getContentPane().add(btnNewButton_2);        
        
        btnNewButton_2.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		boolean noDuplicates = true;
        		ArrayList<String> compareList = new ArrayList<String>();
        	  
	        	outerloop:
	        	for (int i = 0; i < columns; ++i) // First iteration checks for duplicates
	        	  {
	        		  for (int j = 0; j < rows; ++j)
	        		  {
	        			  try
	        			  {
	        				  if (!table.getValueAt(j, i).toString().isEmpty())
	        				  {
		            			  if (compareList.contains(table.getValueAt(j, i).toString()))
		            			  {
		            				  JOptionPane.showMessageDialog(seatChart, "A student was placed in two seats. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
		            				  noDuplicates = false;
		            				  break outerloop;
		            			  }
		            			  else
		            			  {
		            				  compareList.add(table.getValueAt(j, i).toString());
		            			  }
	        				  }
	        			  }
	        			  catch (NullPointerException E)
	        			  {
	        				  
	        			  }
	        		  }
	        	  }
        	 
        	  if (noDuplicates)
        	  {       		      	  
	        	  for (int i = 0; i < columns; ++i) // Second iteration adds entries; it is guaranteed that there won't be duplicates
	        	  {
	        		  for (int j = 0; j < rows; ++j)
	        		  {
	        			  try
	        			  {
	        				if (!table.getValueAt(j, i).toString().isEmpty())
	        				{
		  						String dirtyString = table.getValueAt(j, i).toString();
		  						String parsed = StringUtils.substringBetween(dirtyString, "(", ")");
		  						DBController.addSeatingEntry(course, GUI.getCookie(), parsed, j, i);
	        				}
	        			  }
	        			  catch (NullPointerException E)
	        			  {
	        				  
	        			  }
	        		  }
	        	  }
	        	  seatChart.dispose();
	        	  JOptionPane.showMessageDialog(seatChart, "Seating chart successfully created", "Success", JOptionPane.INFORMATION_MESSAGE);
          	}
          }
        });
	}
    
	class CheckBoxCellRenderer implements TableCellRenderer 
	{	
	    JComboBox combo;
	    public CheckBoxCellRenderer(JComboBox comboBox) {
	    this.combo = new JComboBox();
	    for (int i=0; i<comboBox.getItemCount(); i++){
	        combo.addItem(comboBox.getItemAt(i));
	    }
	    }
	    public Component getTableCellRendererComponent(JTable jtable, 
	                           Object value, 
	                           boolean isSelected, 
	                           boolean hasFocus, 
	                           int row, int column) {
	    combo.setSelectedItem(value);
	    return combo;
	    }
	}
}
