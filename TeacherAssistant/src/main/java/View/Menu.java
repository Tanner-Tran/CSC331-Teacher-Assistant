package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class Menu {

	protected Shell shlTeacherAssistant;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Menu window = new Menu();
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
		shlTeacherAssistant.open();
		shlTeacherAssistant.layout();
		while (!shlTeacherAssistant.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTeacherAssistant = new Shell();
		shlTeacherAssistant.setSize(553, 345);
		shlTeacherAssistant.setText("Teacher Assistant");
		shlTeacherAssistant.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shlTeacherAssistant, SWT.NONE);
		GridLayout gl_composite = new GridLayout(3, true);
		gl_composite.verticalSpacing = 20;
		gl_composite.marginHeight = 40;
		gl_composite.marginRight = 40;
		gl_composite.marginLeft = 40;
		composite.setLayout(gl_composite);
		new Label(composite, SWT.NONE);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblNewLabel.setText("Teacher Assistant");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 134;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("Add / Remove Class");
		
		Button btnA = new Button(composite, SWT.NONE);
		GridData gd_btnA = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnA.widthHint = 134;
		btnA.setLayoutData(gd_btnA);
		btnA.setText("Add / Remove Student");
		
		Button btnAttendance = new Button(composite, SWT.NONE);
		GridData gd_btnAttendance = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnAttendance.widthHint = 134;
		btnAttendance.setLayoutData(gd_btnAttendance);
		btnAttendance.setText("Attendance");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		GridData gd_btnNewButton_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 134;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.setText("Grades");
		
		Button btnNewButton_2 = new Button(composite, SWT.NONE);
		GridData gd_btnNewButton_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_2.widthHint = 134;
		btnNewButton_2.setLayoutData(gd_btnNewButton_2);
		btnNewButton_2.setText("Seating Chart");
		
		Button btnNewButton_3 = new Button(composite, SWT.NONE);
		GridData gd_btnNewButton_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_3.widthHint = 134;
		btnNewButton_3.setLayoutData(gd_btnNewButton_3);
		btnNewButton_3.setText("Log Behavior");
		new Label(composite, SWT.NONE);
		
		Button btnNewButton_4 = new Button(composite, SWT.NONE);
		GridData gd_btnNewButton_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_4.widthHint = 134;
		btnNewButton_4.setLayoutData(gd_btnNewButton_4);
		btnNewButton_4.setText("Logout");
		new Label(composite, SWT.NONE);
		

	}

}
