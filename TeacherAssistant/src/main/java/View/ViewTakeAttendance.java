package View;

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

public class ViewTakeAttendance {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ViewTakeAttendance window = new ViewTakeAttendance();
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
		shell.setSize(258, 186);
		shell.setText("Attendance");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
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
		takeBtn.setText("Take Attendance");
		
		Button viewBtn = new Button(composite, SWT.RADIO);
		viewBtn.setText("View Attendance");
		new Label(composite, SWT.NONE);
		
		Button okBtn = new Button(composite, SWT.NONE);
		GridData gd_okBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_okBtn.widthHint = 44;
		okBtn.setLayoutData(gd_okBtn);
		okBtn.setText("OK");

	}

}