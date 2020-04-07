package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;


public class ViewAttendance {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ViewAttendance window = new ViewAttendance();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(409, 357);
		shell.setText("SWT Application");

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 10, 373, 255);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION | SWT.READ_ONLY);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setResizable(false);
		tblclmnNewColumn.setWidth(348);
		tblclmnNewColumn.setText("Absent?");
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Button okBtn = new Button(shell, SWT.NONE);
		okBtn.setBounds(157, 283, 75, 25);
		okBtn.setText("OK");
		
		
		///////
		
		String[] students = { "Student1 Student", "Student2 Student", "Student3 Student" };
		
	    for (int i = 0; i < students.length; i++) {
	    	
	        TableItem item = new TableItem(table, SWT.NONE);
	        item.setText(students[i]);
	        
	        
	        //if absent
	        item.setChecked(true);
	        
	        
	      }
	    
	    table.setEnabled(true);
	}

}
