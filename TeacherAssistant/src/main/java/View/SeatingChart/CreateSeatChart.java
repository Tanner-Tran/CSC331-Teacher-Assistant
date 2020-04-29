package View.SeatingChart;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

public class CreateSeatChart {

	JFrame seatChart;
	JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CreateSeatChart window = new CreateSeatChart();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		createContents();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		
		
		int rows = 4;
		int columns = 4;
		
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        double width = screenSize.getWidth();
        double tableWidth = columns * 150;
        double tableHeight = (rows * 27) + 37;
        
		seatChart = new JFrame();
		
		seatChart.setTitle("Seat Chart");
		
		if (tableWidth > width) {
			seatChart.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		else {
			seatChart.setSize((int)tableWidth + 30, (int)tableHeight + 130);
			seatChart.setLocationRelativeTo(null);
		}
		
        
		 
		 Object[] columnsArray = new Object[columns];
		 Object[][] rowsArray = new Object[rows][columns];

        
        DefaultTableModel tableModel = new DefaultTableModel();
        table = new JTable(new DefaultTableModel(rowsArray, columnsArray));
    	table.setRowHeight(27);
    	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    	

        for (int i = 0; i < columns; i++) {
        	TableColumn column = table.getColumnModel().getColumn(i);
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Brandon Nguyen");
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
        

        
        
        if (tableWidth > width) {
        	sp.setBounds(10, 11, (int)width - 15, (int)tableHeight + 1);
        }
        else {
        	sp.setBounds(10, 11, (int)tableWidth, (int)tableHeight + 1);
        }

        
        
        seatChart.getContentPane().add(sp);
        
        seatChart.setVisible(true);
        
        JButton btnNewButton_2 = new JButton("OK");
        btnNewButton_2.setBounds((sp.getWidth()/2 - 44), sp.getHeight() + 50, 89, 23);
        seatChart.getContentPane().add(btnNewButton_2);
        
        
        
	}
	
    
	
	class CheckBoxCellRenderer implements TableCellRenderer {
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
