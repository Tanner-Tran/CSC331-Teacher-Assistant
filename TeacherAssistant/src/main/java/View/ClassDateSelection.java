package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import Controller.DBController;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

public class ClassDateSelection {

	protected Shell shell;
	private boolean checkTake = false;
	private boolean checkView = false;
	
	public ClassDateSelection(int checkInt)
	{
		if (checkInt == 0)
		{
			checkTake = true;
		}
		else if (checkInt == 1)
		{
			checkView = true;
		}
	}

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

	protected void createContents() {
		shell = new Shell();
		shell.setSize(308, 224);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		shell.setText("Input Information");
		
		org.eclipse.swt.graphics.Rectangle bds = shell.getMonitor().getBounds();
		Point p = shell.getSize();
		int nLeft = (bds.width - p.x) / 2;
		int nTop = (bds.height - p.y) / 2;
		shell.setBounds(nLeft, nTop, p.x, p.y);
		
		Composite composite = new Composite(shell, SWT.NONE);
		GridLayout gl_composite = new GridLayout(3, false);
		gl_composite.marginLeft = 25;
		gl_composite.verticalSpacing = 20;
		gl_composite.marginTop = 30;
		composite.setLayout(gl_composite);
		
		Label lblClass = new Label(composite, SWT.NONE);
		lblClass.setText("Class:");
		new Label(composite, SWT.NONE);
		
		CCombo classDropdown = new CCombo(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_classDropdown = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_classDropdown.widthHint = 138;
		classDropdown.setLayoutData(gd_classDropdown);
		classDropdown.setItems(DBController.getCourses(GUI.getCookie()));
		
		Label lblDate = new Label(composite, SWT.NONE);
		lblDate.setText("Date:");
		new Label(composite, SWT.NONE);
		
		DateTime date = new DateTime(composite, SWT.BORDER);
		GridData gd_date = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_date.widthHint = 91;
		date.setLayoutData(gd_date);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button okBtn = new Button(composite, SWT.NONE);
		GridData gd_okBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_okBtn.widthHint = 58;
		okBtn.setLayoutData(gd_okBtn);
		okBtn.setText("OK");
		
		okBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				java.sql.Date inDate = new java.sql.Date(date.getYear() - 1900, date.getMonth(), date.getDay());
				
				if (!classDropdown.getText().isEmpty())
				{
					if (DBController.checkIfCourseHasStudents(classDropdown.getText(), GUI.getCookie()))
					{
						if (checkTake)
						{								
							if (!DBController.checkIfAttendanceDateAlreadyAdded(classDropdown.getText(), GUI.getCookie(), inDate))
							{
								DBController.addAttendanceDate(classDropdown.getText(), GUI.getCookie(), inDate);
								TakeAttendance window = new TakeAttendance(classDropdown.getText(), inDate);
								shell.dispose();
								window.open();
							}
							else
							{
								MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
								errorMsg.setText("Error");
								errorMsg.setMessage("Attendance has already been taken for the selected course and date. Please use the 'View/Update Attendance' option if you wish to update existing attendance.");
								errorMsg.open();
							}
						}
						else if (checkView)
						{
							if (DBController.checkIfAttendanceDateAlreadyAdded(classDropdown.getText(), GUI.getCookie(), inDate))
							{
								ViewAttendance window = new ViewAttendance(classDropdown.getText(), inDate);
								shell.dispose();
								window.open();
							}
							else
							{
								MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
								errorMsg.setText("Error");
								errorMsg.setMessage("Attendance has not yet been taken for the selected course and date. Please use the 'Take Attendance' option to do so first.");
								errorMsg.open();
							}
						}
					}
					else
					{
						MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
						errorMsg.setText("Error");
						errorMsg.setMessage("The selected course has no students. Please add students to the course and try again.");
						errorMsg.open();
					}
				}
				else 
				{
					MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
					errorMsg.setText("Error");
					errorMsg.setMessage("A class was not selected. Please try again.");
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
