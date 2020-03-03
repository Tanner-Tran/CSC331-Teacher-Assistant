package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;

import java.awt.Rectangle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import Controller.DBController;
import Model.Database;

public class Login 
{

	protected Shell shlLoginForm;
	private Text usernameTB;
	private Text passwordTB;

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

	protected void createContents() {
		shlLoginForm = new Shell();
		shlLoginForm.setSize(450, 300);
		shlLoginForm.setText("Login");
		shlLoginForm.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		org.eclipse.swt.graphics.Rectangle bds = shlLoginForm.getMonitor().getBounds();
		Point p = shlLoginForm.getSize();
		int nLeft = (bds.width - p.x) / 2;
		int nTop = (bds.height - p.y) / 2;
		shlLoginForm.setBounds(nLeft, nTop, p.x, p.y);
		
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
		
		passwordTB = new Text(composite, SWT.PASSWORD | SWT.BORDER);
		passwordTB.setEchoChar('•');
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
		
		// Button functions
		createAcctBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				CreateAccount crWindow = new CreateAccount();
				crWindow.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		loginBtn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent e)
			{
				if (DBController.validateLogin(usernameTB.getText(), passwordTB.getText()))
				{
					GUI.setCookie(usernameTB.getText());
					shlLoginForm.dispose();
					Menu menuWindow = new Menu();
					menuWindow.open();
				}
				else
				{
					MessageBox errorMsg = new MessageBox(shlLoginForm, SWT.ICON_ERROR);
					errorMsg.setText("Error");
					errorMsg.setMessage("Invalid credentials. Please try again.");
					errorMsg.open();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				// Required by interface; ignore
				
			}
		});
		
		// Login on enter
		passwordTB.addKeyListener(new KeyListener() 
		{
	        @Override
	        public void keyPressed(KeyEvent arg0) 
	        {
	            if (arg0.keyCode == SWT.CR) 
	            {
	            	if (DBController.validateLogin(usernameTB.getText(), passwordTB.getText()))
					{
	            		GUI.setCookie(usernameTB.getText());
	            		shlLoginForm.dispose();
						Menu menuWindow = new Menu();
						menuWindow.open();
					}
	            	else
					{
						MessageBox errorMsg = new MessageBox(shlLoginForm, SWT.ICON_ERROR);
						errorMsg.setText("Error");
						errorMsg.setMessage("Invalid credentials. Please try again.");
						errorMsg.open();
					}
	            }
	        }

			@Override
			public void keyReleased(KeyEvent e) 
			{
				// Required by interface; ignore		
			}
	    });
	}
} // Class end
