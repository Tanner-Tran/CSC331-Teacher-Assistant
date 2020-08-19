package view.seatingchart;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import controller.DBController;
import view.GUI;

public class SeatClassSelection {

	protected Shell shell;
	private boolean checkCreate = false;
	private boolean checkViewEdit = false;

	public SeatClassSelection(int checkInt)
	{
		if (checkInt == 0)
		{
			checkCreate = true;
		}
		else if (checkInt == 1)
		{
			checkViewEdit = true;
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(308, 178);
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
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button okBtn = new Button(composite, SWT.NONE);
		GridData gd_okBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_okBtn.widthHint = 58;
		okBtn.setLayoutData(gd_okBtn);
		okBtn.setText("OK");
		
		okBtn.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				if (!classDropdown.getText().isEmpty())
				{
					if (checkCreate)
					{
						if (!DBController.checkIfSeatingChartExists(classDropdown.getText(), GUI.getCookie()))
						{
							DimensionSelection window = new DimensionSelection(classDropdown.getText());
							shell.dispose();
							window.open();
						}
						else
						{
							MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
							errorMsg.setText("Error");
							errorMsg.setMessage("A seating chart has already been created for the selected course. Please use the 'View/Edit Seating Chart' option if you wish to edit an existing seating chart.");
							errorMsg.open();
						}
					}
					else if (checkViewEdit)
					{
						if (DBController.checkIfSeatingChartExists(classDropdown.getText(), GUI.getCookie()))
						{
							int rows = DBController.getNumberOfRows(classDropdown.getText(), GUI.getCookie());
							int columns = DBController.getNumberOfColumns(classDropdown.getText(), GUI.getCookie());
							
							ViewSeatChart window = new ViewSeatChart(classDropdown.getText(), rows, columns);
							shell.dispose();
							window.open();
						}
						else
						{
							MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
							errorMsg.setText("Error");
							errorMsg.setMessage("A seating chart has not yet been created for the selected course. Please use the 'Create Seating Chart' to do so first.");
							errorMsg.open();
						}
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
		});
	}

}
