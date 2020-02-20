package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class Login {

	protected Shell shlLoginForm;
	private Text usernameTB;
	private Text passwordTB;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
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
		shlLoginForm.open();
		shlLoginForm.layout();
		while (!shlLoginForm.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLoginForm = new Shell();
		shlLoginForm.setSize(450, 300);
		shlLoginForm.setText("Login Form");
		shlLoginForm.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shlLoginForm, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.horizontalSpacing = 20;
		gl_composite.marginTop = 25;
		gl_composite.verticalSpacing = 15;
		gl_composite.marginLeft = 45;
		composite.setLayout(gl_composite);
		new Label(composite, SWT.NONE);
		
		Label loginFormLbl = new Label(composite, SWT.NONE);
		loginFormLbl.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		GridData gd_loginFormLbl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_loginFormLbl.horizontalIndent = 35;
		gd_loginFormLbl.widthHint = 129;
		loginFormLbl.setLayoutData(gd_loginFormLbl);
		loginFormLbl.setText("Login Form");
		
		Label usernameLbl = new Label(composite, SWT.NONE);
		GridData gd_usernameLbl = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_usernameLbl.verticalIndent = 15;
		usernameLbl.setLayoutData(gd_usernameLbl);
		usernameLbl.setText("Username");
		
		usernameTB = new Text(composite, SWT.BORDER);
		GridData gd_usernameTB = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_usernameTB.verticalIndent = 15;
		gd_usernameTB.widthHint = 224;
		usernameTB.setLayoutData(gd_usernameTB);
		
		Label passwordLbl = new Label(composite, SWT.NONE);
		passwordLbl.setText("Password");
		
		passwordTB = new Text(composite, SWT.BORDER);
		GridData gd_passwordTB = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_passwordTB.widthHint = 224;
		passwordTB.setLayoutData(gd_passwordTB);
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.marginTop = 5;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1);
		gd_composite_1.widthHint = 223;
		composite_1.setLayoutData(gd_composite_1);
		
		Button createAcctBtn = new Button(composite_1, SWT.NONE);
		GridData gd_createAcctBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_createAcctBtn.widthHint = 100;
		createAcctBtn.setLayoutData(gd_createAcctBtn);
		createAcctBtn.setText("Create Account");
		
		Button loginBtn = new Button(composite_1, SWT.NONE);
		GridData gd_loginBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_loginBtn.widthHint = 100;
		loginBtn.setLayoutData(gd_loginBtn);
		loginBtn.setText("Login");

	}

}
