package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

public class CreateAccount {

	protected Shell shell;
	private Text firstNameTb;
	private Text lastNameTb;
	private Text usernameTb;
	private Text passwordTb;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CreateAccount window = new CreateAccount();
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
	protected void createContents() 
	{
		shell = new Shell();
		shell.setSize(464, 341);
		shell.setText("Create Account");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, true);
		gl_composite.verticalSpacing = 10;
		gl_composite.horizontalSpacing = 25;
		gl_composite.marginTop = 25;
		gl_composite.marginRight = 70;
		composite.setLayout(gl_composite);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label firstNameLbl = new Label(composite, SWT.NONE);
		firstNameLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		firstNameLbl.setText("First Name");
		
		firstNameTb = new Text(composite, SWT.BORDER);
		GridData gd_firstNameTb = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_firstNameTb.widthHint = 115;
		firstNameTb.setLayoutData(gd_firstNameTb);
		
		Label lastNameLbl = new Label(composite, SWT.NONE);
		lastNameLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lastNameLbl.setText("Last Name");
		
		lastNameTb = new Text(composite, SWT.BORDER);
		GridData gd_lastNameTb = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lastNameTb.widthHint = 115;
		lastNameTb.setLayoutData(gd_lastNameTb);
		
		Label usernameLbl = new Label(composite, SWT.NONE);
		usernameLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		usernameLbl.setText("Username");
		
		usernameTb = new Text(composite, SWT.BORDER);
		GridData gd_usernameTb = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_usernameTb.widthHint = 115;
		usernameTb.setLayoutData(gd_usernameTb);
		
		Label passwordLbl = new Label(composite, SWT.NONE);
		passwordLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		passwordLbl.setText("Password");
		
		passwordTb = new Text(composite, SWT.BORDER);
		GridData gd_passwordTb = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_passwordTb.widthHint = 115;
		passwordTb.setLayoutData(gd_passwordTb);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button createAccountBtn = new Button(composite, SWT.NONE);
		createAccountBtn.setText("Create Account");
		
		createAccountBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				shell.setVisible(false);
				MessageBox dialog = new MessageBox(shell, SWT.ICON_ERROR);
				dialog.setText("Test");
				dialog.setMessage("Test");
				dialog.open();			
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
	}

}
