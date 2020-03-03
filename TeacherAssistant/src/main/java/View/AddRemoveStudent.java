package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;

public class AddRemoveStudent {
	private static Text firstNameTb;
	private static Text lastNameTb;
	private static Text studentID;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(541, 367);
		shell.setText("Add / Remove Student");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.BORDER);
		GridLayout gl_composite = new GridLayout(3, false);
		gl_composite.horizontalSpacing = 10;
		gl_composite.marginLeft = 25;
		gl_composite.marginRight = 30;
		gl_composite.marginTop = 25;
		gl_composite.verticalSpacing = 15;
		composite.setLayout(gl_composite);
		
		Button addRadioBtn = new Button(composite, SWT.RADIO);
		addRadioBtn.setSelection(true);
		addRadioBtn.setText("Add");
		new Label(composite, SWT.NONE);
		
		Button removeRadioBtn = new Button(composite, SWT.RADIO);
		removeRadioBtn.setText("Remove");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Combo classesDropdown = new Combo(composite, SWT.NONE);
		classesDropdown.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		GridData gd_classesDropdown = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_classesDropdown.widthHint = 115;
		classesDropdown.setLayoutData(gd_classesDropdown);
		classesDropdown.setText("Select a class");
		
		Combo classesDropdown2 = new Combo(composite, SWT.NONE);
		classesDropdown2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		classesDropdown2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		classesDropdown2.add("Class 1");
		classesDropdown2.setText("Select a class");
		
		Label lblFirstName = new Label(composite, SWT.NONE);
		GridData gd_lblFirstName = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblFirstName.widthHint = 100;
		lblFirstName.setLayoutData(gd_lblFirstName);
		lblFirstName.setText("First Name");
		
		firstNameTb = new Text(composite, SWT.BORDER);
		GridData gd_firstNameTb = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_firstNameTb.widthHint = 128;
		firstNameTb.setLayoutData(gd_firstNameTb);
		
		Combo studentsDropdown = new Combo(composite, SWT.NONE);
		studentsDropdown.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		studentsDropdown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		studentsDropdown.setText("Select a student");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 99;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("Last Name");
		
		lastNameTb = new Text(composite, SWT.BORDER);
		GridData gd_lastNameTb = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lastNameTb.widthHint = 128;
		lastNameTb.setLayoutData(gd_lastNameTb);
		new Label(composite, SWT.NONE);
		
		Label lblClassCode = new Label(composite, SWT.NONE);
		GridData gd_lblClassCode = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblClassCode.widthHint = 90;
		lblClassCode.setLayoutData(gd_lblClassCode);
		lblClassCode.setText("Student ID");
		
		studentID = new Text(composite, SWT.BORDER);
		GridData gd_studentID = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_studentID.widthHint = 128;
		studentID.setLayoutData(gd_studentID);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button addClassButton = new Button(composite, SWT.NONE);
		GridData gd_addClassButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_addClassButton.verticalIndent = 15;
		addClassButton.setLayoutData(gd_addClassButton);
		addClassButton.setText("Add Student");
		
		Button removeClassBtn = new Button(composite, SWT.NONE);
		GridData gd_removeClassBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_removeClassBtn.verticalIndent = 15;
		removeClassBtn.setLayoutData(gd_removeClassBtn);
		removeClassBtn.setText("Remove Student");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			
			if(removeRadioBtn.getSelection()) {
				classesDropdown2.setEnabled(true);
				removeClassBtn.setEnabled(true);
				studentsDropdown.setEnabled(true);
				
				studentID.setEnabled(false);
				classesDropdown.setEnabled(false);
				firstNameTb.setEnabled(false);
				lastNameTb.setEnabled(false);
				addClassButton.setEnabled(false);
			}
			
			if(addRadioBtn.getSelection()) {
				studentID.setEnabled(true);
				classesDropdown.setEnabled(true);
				firstNameTb.setEnabled(true);
				lastNameTb.setEnabled(true);
				addClassButton.setEnabled(true);
				
				studentsDropdown.setEnabled(false);
				classesDropdown2.setEnabled(false);
				removeClassBtn.setEnabled(false);
			}
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
