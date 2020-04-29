package View.UserData;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.apache.commons.lang3.StringUtils;

import Controller.DBController;
import View.GUI;

public class AddRemoveStudent 
{
	protected Shell shell;
	private static Text firstNameTb;
	private static Text lastNameTb;
	private static Text studentID;
	private Button addRadioBtn;
	private Button removeRadioBtn;
	private Button removeStudentBtn;
	private Button addStudentButton;
	private CCombo classesDropdown;
	private CCombo classesDropdown2;
	private CCombo studentsDropdown;

	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) 
		{
			
			if(removeRadioBtn.getSelection()) {
				removeStudentBtn.setEnabled(true);			
				studentID.setEnabled(false);
				firstNameTb.setEnabled(false);
				lastNameTb.setEnabled(false);
				addStudentButton.setEnabled(false);
			}
			
			if(addRadioBtn.getSelection()) {
				studentID.setEnabled(true);
				firstNameTb.setEnabled(true);
				lastNameTb.setEnabled(true);
				addStudentButton.setEnabled(true);			
				removeStudentBtn.setEnabled(false);
			}
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	protected void createContents()
	{
		shell = new Shell();
		shell.setSize(541, 367);
		shell.setText("Add / Remove Student");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		org.eclipse.swt.graphics.Rectangle bds = shell.getMonitor().getBounds();
		Point p = shell.getSize();
		int nLeft = (bds.width - p.x) / 2;
		int nTop = (bds.height - p.y) / 2;
		shell.setBounds(nLeft, nTop, p.x, p.y);
		
		Composite composite = new Composite(shell, SWT.BORDER);
		GridLayout gl_composite = new GridLayout(3, false);
		gl_composite.horizontalSpacing = 10;
		gl_composite.marginLeft = 25;
		gl_composite.marginRight = 30;
		gl_composite.marginTop = 25;
		gl_composite.verticalSpacing = 15;
		composite.setLayout(gl_composite);
		
		addRadioBtn = new Button(composite, SWT.RADIO);
		addRadioBtn.setSelection(true);
		addRadioBtn.setText("Add");
		new Label(composite, SWT.NONE);
		
		removeRadioBtn = new Button(composite, SWT.RADIO);
		removeRadioBtn.setText("Remove");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		classesDropdown = new CCombo(composite, SWT.BORDER | SWT.READ_ONLY);
		classesDropdown.setVisibleItemCount(5);
		GridData gd_classesDropdown = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_classesDropdown.widthHint = 136;
		classesDropdown.setLayoutData(gd_classesDropdown);
		classesDropdown.setItems(DBController.getCourses(GUI.getCookie()));
		classesDropdown.setText("Select a class");

		classesDropdown2 = new CCombo(composite, SWT.READ_ONLY | SWT.BORDER);
		classesDropdown2.setVisibleItemCount(5);
		classesDropdown2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		classesDropdown2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		classesDropdown2.setItems(DBController.getCourses(GUI.getCookie()));
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
		
		studentsDropdown = new CCombo(composite, SWT.READ_ONLY | SWT.BORDER);
		studentsDropdown.setVisibleItemCount(5);
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
		
		addStudentButton = new Button(composite, SWT.NONE);
		GridData gd_addClassButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_addClassButton.verticalIndent = 15;
		addStudentButton.setLayoutData(gd_addClassButton);
		addStudentButton.setText("Add Student");
		
		removeStudentBtn = new Button(composite, SWT.NONE);
		GridData gd_removeClassBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_removeClassBtn.verticalIndent = 15;
		removeStudentBtn.setLayoutData(gd_removeClassBtn);
		removeStudentBtn.setText("Remove Student");

		shell.open();
		shell.layout();
		
		// Button functions
		addStudentButton.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				if (!DBController.checkIfStudentAlreadyAdded(classesDropdown.getText(), studentID.getText(), GUI.getCookie()))
				{
					DBController.addStudent(lastNameTb.getText(), firstNameTb.getText(), studentID.getText(), classesDropdown.getText(), GUI.getCookie());
					
					lastNameTb.setText("");
					firstNameTb.setText("");
					studentID.setText("");
					classesDropdown.setText("Select a class");
					
					MessageBox successMsg = new MessageBox(shell, SWT.ICON_INFORMATION);
					successMsg.setText("Success");
					successMsg.setMessage("Student successfully added");
					successMsg.open();
				}
				else
				{
					MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
					errorMsg.setText("Error");
					errorMsg.setMessage("The inputted student already exists in the selected course. Please try again.");
					errorMsg.open();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		removeStudentBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				if (classesDropdown2.getText().isEmpty() || studentsDropdown.getText().isEmpty() || classesDropdown2.getText().equals("Select a class") || studentsDropdown.getText().contentEquals("Select a student") )
				{
					MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
					errorMsg.setText("Error");
					errorMsg.setMessage("A course and/or a student were not selected. Please try again.");
					errorMsg.open();
				}
				
				else
				{
					MessageBox errorMsg = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
					errorMsg.setText("Warning");
					errorMsg.setMessage("You will lose all of the selected student's associated data if you proceed. Do you still wish to continue?");
					int response = errorMsg.open();
					
					if (response == SWT.YES)
					{
						String dirtyString = studentsDropdown.getText();
						String parsed = StringUtils.substringBetween(dirtyString, "(", ")");
						DBController.removeStudent(parsed, classesDropdown2.getText(), GUI.getCookie());
						studentsDropdown.setItems(DBController.getStudents(classesDropdown2.getText(), GUI.getCookie()));
						MessageBox successMsg = new MessageBox(shell, SWT.ICON_INFORMATION);
						successMsg.setText("Success");
						successMsg.setMessage("Student successfully removed");
						successMsg.open();
					}
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		// Combo box function
		classesDropdown2.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				studentsDropdown.setItems(DBController.getStudents(classesDropdown2.getText(), GUI.getCookie()));
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
}
