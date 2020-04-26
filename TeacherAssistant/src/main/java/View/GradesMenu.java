package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GradesMenu {

	protected Shell shlGradesMenu;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GradesMenu window = new GradesMenu();
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
		shlGradesMenu.open();
		shlGradesMenu.layout();
		while (!shlGradesMenu.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlGradesMenu = new Shell();
		shlGradesMenu.setSize(284, 334);
		shlGradesMenu.setText("Grades Menu");
		FillLayout fl_shlGradesMenu = new FillLayout(SWT.VERTICAL);
		fl_shlGradesMenu.marginWidth = 20;
		fl_shlGradesMenu.spacing = 15;
		fl_shlGradesMenu.marginHeight = 15;
		shlGradesMenu.setLayout(fl_shlGradesMenu);
		
		Button btnNewButton_1 = new Button(shlGradesMenu, SWT.NONE);
		btnNewButton_1.setText("Add / Edit Grade Types / Grade Weights");
		
		Button btnNewButton_3 = new Button(shlGradesMenu, SWT.NONE);
		btnNewButton_3.setText("Record Assignments");
		
		Button btnNewButton_2 = new Button(shlGradesMenu, SWT.NONE);
		btnNewButton_2.setText("View / Edit Assignments");
		
		Button btnNewButton = new Button(shlGradesMenu, SWT.NONE);
		btnNewButton.setText("View Grades");


	}

}
