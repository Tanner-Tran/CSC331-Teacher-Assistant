package View;

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
import Controller.DBController;

public class AddRemoveClass 
{
	protected Shell shell;
	private static Text classTitleTextbox;
	private static Text classCodeTextbox;
	private Button removeRadioBtn;
	private Button addRadioBtn;
	private Button removeClassBtn;
	private Button addClassButton;
	private CCombo classDropdown;

	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) 
		{
			
			if(removeRadioBtn.getSelection()) {
				removeClassBtn.setEnabled(true);
				
				classTitleTextbox.setEnabled(false);
				classCodeTextbox.setEnabled(false);
				addClassButton.setEnabled(false);
			}
			
			if(addRadioBtn.getSelection()) {
				classTitleTextbox.setEnabled(true);
				classCodeTextbox.setEnabled(true);
				addClassButton.setEnabled(true);
				
				removeClassBtn.setEnabled(false);
			}
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	protected void createContents()
	{	
		shell = new Shell();
		shell.setSize(471, 327);
		shell.setText("Add / Remove Course");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		// This is the code for making the window appear in the center of the screen
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
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		addRadioBtn = new Button(composite, SWT.RADIO);
		addRadioBtn.setSelection(true);
		addRadioBtn.setText("Add");
		new Label(composite, SWT.NONE);
		
		removeRadioBtn = new Button(composite, SWT.RADIO);
		removeRadioBtn.setText("Remove");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 70;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("Course Title");
		
		classTitleTextbox = new Text(composite, SWT.BORDER);
		GridData gd_classTitleTextbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_classTitleTextbox.widthHint = 105;
		classTitleTextbox.setLayoutData(gd_classTitleTextbox);
		
		classDropdown = new CCombo(composite, SWT.READ_ONLY | SWT.BORDER);
		classDropdown.setVisibleItemCount(5);
		classDropdown.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		classDropdown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		classDropdown.setItems(DBController.getCourses(GUI.getCookie()));
		classDropdown.setText("Select a course");
		
		Label lblClassCode = new Label(composite, SWT.NONE);
		lblClassCode.setText("Course Code");
		
		classCodeTextbox = new Text(composite, SWT.BORDER);
		GridData gd_classCodeTextbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_classCodeTextbox.widthHint = 105;
		classCodeTextbox.setLayoutData(gd_classCodeTextbox);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		addClassButton = new Button(composite, SWT.NONE);
		GridData gd_addClassButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_addClassButton.verticalIndent = 15;
		addClassButton.setLayoutData(gd_addClassButton);
		addClassButton.setText("Add Course");
		
		removeClassBtn = new Button(composite, SWT.NONE);
		GridData gd_removeClassBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_removeClassBtn.verticalIndent = 15;
		removeClassBtn.setLayoutData(gd_removeClassBtn);
		removeClassBtn.setText("Remove Course");
		
		// Button functions
		addClassButton.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				if (DBController.checkIfCourseCodeAvailable(classCodeTextbox.getText(), GUI.getCookie()))
				{
					DBController.addCourse(classTitleTextbox.getText(), classCodeTextbox.getText(), GUI.getCookie());
					classDropdown.setItems(DBController.getCourses(GUI.getCookie()));
					classDropdown.setText("Select a course");
					MessageBox successMsg = new MessageBox(shell, SWT.ICON_INFORMATION);
					successMsg.setText("Success");
					successMsg.setMessage("Course successfully added");
					successMsg.open();
				}
				else
				{
					MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
					errorMsg.setText("Error");
					errorMsg.setMessage("The inputted course code is already taken. Please try again.");
					errorMsg.open();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		removeClassBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				if (!classDropdown.getText().isEmpty())
				{
					if (!DBController.checkIfCourseHasStudents(classDropdown.getText(), GUI.getCookie()))
					{							
						DBController.removeCourse(classDropdown.getText(), GUI.getCookie());
						classDropdown.setItems(DBController.getCourses(GUI.getCookie()));
						classDropdown.setText("Select a course");
						MessageBox successMsg = new MessageBox(shell, SWT.ICON_INFORMATION);
						successMsg.setText("Success");
						successMsg.setMessage("Course successfully removed");
						successMsg.open();
					}
					else
					{
						MessageBox errorMsg = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
						errorMsg.setText("Warning");
						errorMsg.setMessage("The selected course currently has enrolled students. Do you still want to remove it?");
						int response = errorMsg.open();
						
						if (response == SWT.YES)
						{
							DBController.removeAllStudentsFromACourse(classDropdown.getText(), GUI.getCookie());
							DBController.removeCourse(classDropdown.getText(), GUI.getCookie());
							classDropdown.setItems(DBController.getCourses(GUI.getCookie()));
							classDropdown.setText("Select a course");
							MessageBox successMsg = new MessageBox(shell, SWT.ICON_INFORMATION);
							successMsg.setText("Success");
							successMsg.setMessage("Course successfully removed");
							successMsg.open();
						}
					}
				}
				else
				{
					MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
					errorMsg.setText("Error");
					errorMsg.setMessage("A course was not selected. Please try again.");
					errorMsg.open();
				}	
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
}
