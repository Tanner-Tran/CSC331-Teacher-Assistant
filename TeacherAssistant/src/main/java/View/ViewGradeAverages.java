package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ViewGradeAverages {

	JFrame frmAverageGrades;
	JTable table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ViewGradeAverages window = new ViewGradeAverages();
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
		frmAverageGrades = new JFrame();
		frmAverageGrades.setTitle("Grade Averages");
		
        String[][] data = { 
                { "Kundan Kumar Jha", "4031"},
                { "Kundan Kumar Jha", "4031"},
                { "Anand Jha", "6014"} 
            };
        
        // Column Names 
        String[] columnNames = { "Grade Type", "Grade Weight"};
        frmAverageGrades.getContentPane().setLayout(null);
        
        // Initializing the JTable
              
        table = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{"Kundan Kumar Jha", "100"},
        		{"Kundan Kumar Jha", "90"},
        		{"Anand Jha", "80"},
        		{null, null},
        		{null, null},
        	},
        	new String[] {
        		"Student", "Grade"
        	}
        ));
        table.setBounds(20, 20, 240, 300);
        table.getTableHeader().setReorderingAllowed(false);
        
        TableColumn column1 = table.getColumnModel().getColumn(0);
        column1.setMinWidth(120);
        column1.setMaxWidth(120);
        column1.setPreferredWidth(120);
        
        TableColumn column2 = table.getColumnModel().getColumn(1);
        column2.setMinWidth(120);
        column2.setMaxWidth(120);
        column2.setPreferredWidth(120);  
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        column2.setCellRenderer(centerRenderer);
  
        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(46, 23, 240, 293);
        frmAverageGrades.getContentPane().add(sp);
        
        // Frame Size 
        frmAverageGrades.setSize(346, 432); 
        // Frame Visible = true 
        frmAverageGrades.setVisible(true); 
              
        
        
        JButton btnNewButton_2 = new JButton("OK");
        btnNewButton_2.setBounds(121, 332, 89, 23);
        frmAverageGrades.getContentPane().add(btnNewButton_2);
              


	}

}
