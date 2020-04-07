package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

public class ClassDateSelection {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ClassDateSelection window = new ClassDateSelection();
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
		shell.setSize(308, 224);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
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

	}
}
