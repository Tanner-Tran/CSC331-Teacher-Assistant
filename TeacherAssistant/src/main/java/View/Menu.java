package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.wb.swt.SWTResourceManager;

import View.Account.Login;
import View.Attendance.ViewTakeAttendance;
import View.Behavior.ClassStudentSelection;
import View.UserData.AddRemoveClass;
import View.UserData.AddRemoveStudent;

public class Menu 
{
	private Shell loginShell;
	protected Shell shlTeacherAssistant;
	
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

	protected void createContents() 
	{
		shlTeacherAssistant = new Shell();
		shlTeacherAssistant.setSize(557, 346);
		shlTeacherAssistant.setText("Teacher Assistant");
		shlTeacherAssistant.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		shlTeacherAssistant.addListener(SWT.Close, new Listener()
		{
			public void handleEvent(Event event)
			{
				System.exit(0);
			}
		});
		
		org.eclipse.swt.graphics.Rectangle bds = shlTeacherAssistant.getMonitor().getBounds();
		Point p = shlTeacherAssistant.getSize();
		int nLeft = (bds.width - p.x) / 2;
		int nTop = (bds.height - p.y) / 2;
		shlTeacherAssistant.setBounds(nLeft, nTop, p.x, p.y);
		
		Composite composite = new Composite(shlTeacherAssistant, SWT.NONE);
		GridLayout gl_composite = new GridLayout(3, true);
		gl_composite.verticalSpacing = 20;
		gl_composite.marginHeight = 40;
		gl_composite.marginRight = 40;
		gl_composite.marginLeft = 40;
		composite.setLayout(gl_composite);
		new Label(composite, SWT.NONE);
		
		Label teacherAssistantLbl = new Label(composite, SWT.NONE);
		teacherAssistantLbl.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		teacherAssistantLbl.setText("Teacher Assistant");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button addRmvClassBtn = new Button(composite, SWT.NONE);
		GridData gd_addRmvClassBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_addRmvClassBtn.widthHint = 134;
		addRmvClassBtn.setLayoutData(gd_addRmvClassBtn);
		addRmvClassBtn.setText("Add / Remove Course");
		
		Button addRmvStudentBtn = new Button(composite, SWT.NONE);
		GridData gd_addRmvStudentBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_addRmvStudentBtn.widthHint = 134;
		addRmvStudentBtn.setLayoutData(gd_addRmvStudentBtn);
		addRmvStudentBtn.setText("Add / Remove Student");
		
		Button attendanceBtn = new Button(composite, SWT.NONE);
		GridData gd_attendanceBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_attendanceBtn.widthHint = 134;
		attendanceBtn.setLayoutData(gd_attendanceBtn);
		attendanceBtn.setText("Attendance");
		
		Button gradesBtn = new Button(composite, SWT.NONE);
		GridData gd_gradesBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_gradesBtn.widthHint = 134;
		gradesBtn.setLayoutData(gd_gradesBtn);
		gradesBtn.setText("Grades");
		
		Button seatingChartBtn = new Button(composite, SWT.NONE);
		GridData gd_seatingChartBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_seatingChartBtn.widthHint = 134;
		seatingChartBtn.setLayoutData(gd_seatingChartBtn);
		seatingChartBtn.setText("Seating Chart");
		
		Button logBehaviorBtn = new Button(composite, SWT.NONE);
		GridData gd_logBehaviorBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_logBehaviorBtn.widthHint = 134;
		logBehaviorBtn.setLayoutData(gd_logBehaviorBtn);
		logBehaviorBtn.setText("Log Behavior");
		new Label(composite, SWT.NONE);
		
		Button logoutBtn = new Button(composite, SWT.NONE);
		GridData gd_logoutBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_logoutBtn.widthHint = 134;
		logoutBtn.setLayoutData(gd_logoutBtn);
		logoutBtn.setText("Logout");
		new Label(composite, SWT.NONE);
		
		// Button functions
		addRmvClassBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				AddRemoveClass window = new AddRemoveClass();
				window.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		addRmvStudentBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				AddRemoveStudent window = new AddRemoveStudent();
				window.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		attendanceBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				ViewTakeAttendance window = new ViewTakeAttendance();
				window.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		logBehaviorBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				ClassStudentSelection window = new ClassStudentSelection();
				window.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		logoutBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				shlTeacherAssistant.dispose();
				Login window = new Login();
				window.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
}
