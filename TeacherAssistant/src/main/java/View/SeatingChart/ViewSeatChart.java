package View.SeatingChart;

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
import org.eclipse.swt.widgets.MessageBox;

import Controller.DBController;
import View.GUI;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

public class ViewSeatChart {

	private JFrame seatChart;
	private JTable table;
	private DefaultTableModel model;
	private String course;
	private int rows;
	private int columns;
	private boolean confirmChange = false;
	private boolean firstCheck = false;
	private boolean detectChange = false;
	
	public ViewSeatChart(String courseIn, int rowsIn, int columnsIn)
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
		
		seatChart.setTitle("Seat Chart");
		
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
    	
    	for (int i = 0; i < columns; ++i)
    	{
    		for (int j = 0; j < rows; ++j)
    		{
    			if (DBController.checkIfSeatTaken(course, GUI.getCookie(), j, i))
    			{
    				String studentID = DBController.getStudentIDInSeat(course, GUI.getCookie(), j, i);
    				String parsed = DBController.getStudent(course, GUI.getCookie(), studentID);
    				table.setValueAt(parsed, j, i);
    			}
    		}
    	}
    	
        for (int i = 0; i < columns; i++) 
        {
        	TableColumn column = table.getColumnModel().getColumn(i);
            JComboBox comboBox = new JComboBox();
            String[] students = DBController.getStudents(course, GUI.getCookie());
            comboBox.getModel().setSelectedItem(0);
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
	        	  for (int i = 0; i < columns; ++i) // Second iteration checks for changes
	        	  {
	        		  for (int j = 0; j < rows; ++j)
	        		  {
	        			  try
	        			  {
	        				if (!table.getValueAt(j, i).toString().isEmpty())
	        				{
	        					if ( (!DBController.checkIfSeatTaken(course, GUI.getCookie(), j, i)) || (!table.getValueAt(j, i).toString().equals(DBController.getStudent(course, GUI.getCookie(), DBController.getStudentIDInSeat(course, GUI.getCookie(), j, i)))) )
	        					{
	        						if (!firstCheck)
	        						{        							
	    								detectChange = true;
	    								
	    								int test = JOptionPane.showConfirmDialog(seatChart, "Changes were detected. Are you sure you wish to overwrite the previous seating chart?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
	    								
	    								if (test == JOptionPane.OK_OPTION) // OK
	    								{
	    					        		DBController.removeAllSeatingEntriesFromACourse(course, GUI.getCookie());
	    									firstCheck = true;
	    									confirmChange = true;
	    								}
	    								else if (test == JOptionPane.CANCEL_OPTION) // CANCEL
	    								{
	    									firstCheck = true;
	    								}
	        						}
	        					}
	        				}
	        				else
	        				{
	        					if (DBController.checkIfSeatTaken(course, GUI.getCookie(), j, i))
	        					{
	        						if (!firstCheck)
	        						{        							
	    								detectChange = true;
	    								
	    								int test = JOptionPane.showConfirmDialog(seatChart, "Changes were detected. Are you sure you wish to overwrite the previous seating chart?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
	    								
	    								if (test == JOptionPane.OK_OPTION) // OK
	    								{
	    					        		DBController.removeAllSeatingEntriesFromACourse(course, GUI.getCookie());
	    									firstCheck = true;
	    									confirmChange = true;
	    								}
	    								else if (test == JOptionPane.CANCEL_OPTION) // CANCEL
	    								{
	    									firstCheck = true;
	    								}
	        						}
	        					}
	        				}
	        			  }
	        			  catch (NullPointerException E)
	        			  {
	        				  
	        			  }
	        		  }
	        	  }
	        	  
        	  	if (confirmChange)
        	  	{
        	  		for (int i = 0; i < columns; ++i) // Third iteration constructs new seating chart
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
        	  		JOptionPane.showMessageDialog(seatChart, "Seating chart successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        	  	}
        	  	
				if ((detectChange && confirmChange) || (!detectChange))
				{
					seatChart.dispose();
				}
          	}
        	  
			confirmChange = false;
			firstCheck = false;
			detectChange = false;
          }
        }); // A healthier approach would be to make individual changes as needed to SEATING_ENTRY rather than wiping the previous seating chart and constructing a new one       
	}  
	
	class CheckBoxCellRenderer implements TableCellRenderer 
	{
	    JComboBox combo;
	    
	    public CheckBoxCellRenderer(JComboBox comboBox) 
	    {
		    this.combo = new JComboBox();
		    for (int i=0; i < comboBox.getItemCount(); i++)
		    {
		        combo.addItem(comboBox.getItemAt(i));
		    }
	    }
	    public Component getTableCellRendererComponent(JTable jtable, 
	                           Object value, 
	                           boolean isSelected, 
	                           boolean hasFocus, 
	                           int row, int column) 
	    {
		    combo.setSelectedItem(value);
		    return combo;
	    }
	}
}
