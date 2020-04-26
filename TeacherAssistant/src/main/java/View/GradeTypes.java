package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GradeTypes {

	JFrame frmGradeTypes;
	JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GradeTypes window = new GradeTypes();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		//Display display = Display.getDefault();
		createContents();

	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		frmGradeTypes = new JFrame();
		frmGradeTypes.setTitle("Grade Types");
	
        
        // Column Names 
        frmGradeTypes.getContentPane().setLayout(null);
        
        // Initializing the JTable
              
        table = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{"Tests", "60"},
        		{"Homework", "10"},
        		{"Quizzes", "20"},
        		{null, null},
        		{null, null},
        	},
        	new String[] {
        		"Grade Type", "Grade Weight"
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
  
        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(46, 23, 240, 293);
        frmGradeTypes.getContentPane().add(sp);
        
        // Frame Size 
        frmGradeTypes.setSize(351, 457); 
        // Frame Visible = true 
        frmGradeTypes.setVisible(true); 
        
        
        
        // Buttons
        JButton btnNewButton = new JButton("Add");
        btnNewButton.setBounds(66, 327, 89, 23);
        frmGradeTypes.getContentPane().add(btnNewButton);
              
        JButton btnNewButton_1 = new JButton("Remove");
        btnNewButton_1.setBounds(180, 327, 89, 23);
        frmGradeTypes.getContentPane().add(btnNewButton_1);
              
        JButton btnNewButton_2 = new JButton("OK");
        btnNewButton_2.setBounds(125, 373, 89, 23);
        frmGradeTypes.getContentPane().add(btnNewButton_2);

        
        
	}

}
