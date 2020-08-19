package view.seatingchart;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
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

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DimensionSelection {

	protected Shell shell;
	private Text columnsText;
	private Text rowsText;
	private String course;

	public DimensionSelection(String courseIn)
	{
		course = courseIn;
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
		shell.setSize(244, 206);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		shell.setText("Input Info");
		
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
		
		Label lbl1 = new Label(composite, SWT.NONE);
		lbl1.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		lbl1.setText("Rows");
		new Label(composite, SWT.NONE);
		
		rowsText = new Text(composite, SWT.BORDER);
		GridData gd_rowsText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_rowsText.widthHint = 25;
		rowsText.setLayoutData(gd_rowsText);
		
		Label lbl2 = new Label(composite, SWT.NONE);
		lbl2.setText("Columns");
		new Label(composite, SWT.NONE);
		
		columnsText = new Text(composite, SWT.BORDER);
		GridData gd_columnsText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_columnsText.widthHint = 25;
		columnsText.setLayoutData(gd_columnsText);
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
				try
				{
					int numRows = Integer.parseInt(rowsText.getText());
					int numCols = Integer.parseInt(columnsText.getText());
					
					DBController.addSeatingChart(course, GUI.getCookie(), numRows, numCols);
					
					CreateSeatChart window = new CreateSeatChart(course, numRows, numCols);
					shell.dispose();
					window.open();
				}
				catch (NumberFormatException E)
				{
					MessageBox errorMsg = new MessageBox(shell, SWT.ICON_ERROR);
					errorMsg.setText("Error");
					errorMsg.setMessage("Please input integers only");
					errorMsg.open();
				}
			}
		});
	}

}
