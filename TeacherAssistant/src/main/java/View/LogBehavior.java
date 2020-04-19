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
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LogBehavior {

	protected Shell shlLogBehavior;
	private Text minorTextbox;
	private Text moderateTextbox;
	private Text majorTextbox;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LogBehavior window = new LogBehavior();
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
		shlLogBehavior.open();
		shlLogBehavior.layout();
		while (!shlLogBehavior.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogBehavior = new Shell();
		shlLogBehavior.setSize(299, 268);
		shlLogBehavior.setText("Log Behavior");
		FillLayout fl_shlLogBehavior = new FillLayout(SWT.HORIZONTAL);
		shlLogBehavior.setLayout(fl_shlLogBehavior);
		
		Composite composite = new Composite(shlLogBehavior, SWT.NONE);
		GridLayout gl_composite = new GridLayout(5, false);
		gl_composite.marginTop = 10;
		gl_composite.marginRight = 13;
		gl_composite.marginLeft = 10;
		gl_composite.verticalSpacing = 17;
		composite.setLayout(gl_composite);
		new Label(composite, SWT.NONE);
		
		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		GridData gd_lblNewLabel_4 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_4.widthHint = 77;
		lblNewLabel_4.setLayoutData(gd_lblNewLabel_4);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblNewLabel_4.setText("Infractions");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 41;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("Minor :");
		
		minorTextbox = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_minorTextbox = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_minorTextbox.widthHint = 15;
		minorTextbox.setLayoutData(gd_minorTextbox);
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		GridData gd_btnNewButton_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 15;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setText("-");
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setText("/");
		
		Button button = new Button(composite, SWT.NONE);
		GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button.widthHint = 15;
		button.setLayoutData(gd_button);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				minorTextbox.setText("1");
			}
		});
		button.setText("+");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		GridData gd_lblNewLabel_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_1.widthHint = 62;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		lblNewLabel_1.setText("Moderate :");
		
		moderateTextbox = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_moderateTextbox = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
		gd_moderateTextbox.widthHint = 15;
		moderateTextbox.setLayoutData(gd_moderateTextbox);
		
		Button button_1 = new Button(composite, SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_1.widthHint = 15;
		button_1.setLayoutData(gd_button_1);
		button_1.setText("-");
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("/");
		
		Button button_3 = new Button(composite, SWT.NONE);
		GridData gd_button_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_3.widthHint = 15;
		button_3.setLayoutData(gd_button_3);
		button_3.setText("+");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		GridData gd_lblNewLabel_2 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_2.widthHint = 46;
		lblNewLabel_2.setLayoutData(gd_lblNewLabel_2);
		lblNewLabel_2.setText("Major :");
		
		majorTextbox = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_majorTextbox = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
		gd_majorTextbox.widthHint = 15;
		majorTextbox.setLayoutData(gd_majorTextbox);
		
		Button button_2 = new Button(composite, SWT.NONE);
		GridData gd_button_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_2.widthHint = 15;
		button_2.setLayoutData(gd_button_2);
		button_2.setText("-");
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("/");
		
		Button button_4 = new Button(composite, SWT.NONE);
		GridData gd_button_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_4.widthHint = 15;
		button_4.setLayoutData(gd_button_4);
		button_4.setText("+");
		new Label(composite, SWT.NONE);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		GridData gd_btnNewButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 64;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("OK");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);


	}

}
