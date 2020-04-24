package View;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import Controller.DBController;

import org.eclipse.swt.widgets.Button;

public class TakeAttendance {

	protected Shell shell;
	private Table table;
	private String course;
	private java.sql.Date date;
	
	public TakeAttendance(String courseIn, java.sql.Date dateIn)
	{
		course = courseIn;
		date = dateIn;
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
	
	protected void createContents() 
	{
		shell = new Shell();
		shell.setSize(409, 357);
		shell.setText("Absent Selection");
		
		org.eclipse.swt.graphics.Rectangle bds = shell.getMonitor().getBounds();
		Point p = shell.getSize();
		int nLeft = (bds.width - p.x) / 2;
		int nTop = (bds.height - p.y) / 2;
		shell.setBounds(nLeft, nTop, p.x, p.y);

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 10, 373, 255);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION);
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
		
		
		String[] students = DBController.getStudents(course, GUI.getCookie());
		
	    for (String e : students) 
	    {    	
	        TableItem item = new TableItem(table, SWT.NONE);
	        item.setText(e);
	    }
		
	    okBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				for (TableItem E: table.getItems())
				{
					if (E.getChecked())
					{
						String dirtyString = E.getText();
						String parsed = StringUtils.substringBetween(dirtyString, "(", ")");
						
						DBController.addAbsent(course, GUI.getCookie(), date, parsed);
					}
				}
				
				MessageBox successMsg = new MessageBox(shell, SWT.ICON_INFORMATION);
				successMsg.setText("Success");
				successMsg.setMessage("Attendance successfully taken");
				successMsg.open();
				shell.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
