package view.seatingchart;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;

public class CreateEditSeatSelection {

	protected Shell shell;
	
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
		shell.setSize(245, 186);
		shell.setText("Seating");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		org.eclipse.swt.graphics.Rectangle bds = shell.getMonitor().getBounds();
		Point p = shell.getSize();
		int nLeft = (bds.width - p.x) / 2;
		int nTop = (bds.height - p.y) / 2;
		shell.setBounds(nLeft, nTop, p.x, p.y);
		
		Composite composite = new Composite(shell, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.verticalSpacing = 10;
		gl_composite.marginTop = 25;
		gl_composite.marginLeft = 25;
		composite.setLayout(gl_composite);
		
		Button takeBtn = new Button(composite, SWT.RADIO);
		takeBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		takeBtn.setText("Create Seating Chart");
		
		Button viewBtn = new Button(composite, SWT.RADIO);
		viewBtn.setText("View/Edit Seating Chart");
		new Label(composite, SWT.NONE);
		
		Button okBtn = new Button(composite, SWT.NONE);
		GridData gd_okBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_okBtn.widthHint = 44;
		okBtn.setLayoutData(gd_okBtn);
		okBtn.setText("OK");
		
		okBtn.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				if (takeBtn.getSelection())
				{
					SeatClassSelection window = new SeatClassSelection(0);
					window.open();
				}
				else if (viewBtn.getSelection())
				{
					SeatClassSelection window = new SeatClassSelection(1);
					window.open();
				}
			}
		});
	}

}