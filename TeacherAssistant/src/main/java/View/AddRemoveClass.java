package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;

public class AddRemoveClass {
	private static Text classTitleTextbox;
	private static Text classCodeTextbox;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(471, 327);
		shell.setText("Add / Remove Class");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.BORDER);
		GridLayout gl_composite = new GridLayout(3, false);
		gl_composite.horizontalSpacing = 10;
		gl_composite.marginLeft = 25;
		gl_composite.marginRight = 30;
		gl_composite.marginTop = 25;
		gl_composite.verticalSpacing = 15;
		composite.setLayout(gl_composite);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button addRadioBtn = new Button(composite, SWT.RADIO);
		addRadioBtn.setSelection(true);
		addRadioBtn.setText("Add");
		new Label(composite, SWT.NONE);
		
		Button removeRadioBtn = new Button(composite, SWT.RADIO);
		removeRadioBtn.setText("Remove");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 54;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("Class Title");
		
		classTitleTextbox = new Text(composite, SWT.BORDER);
		GridData gd_classTitleTextbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_classTitleTextbox.widthHint = 105;
		classTitleTextbox.setLayoutData(gd_classTitleTextbox);
		
		Combo classDropdown = new Combo(composite, SWT.NONE);
		classDropdown.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		classDropdown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		classDropdown.setText("Select a class");
		classDropdown.add("Class 1");
		
		Label lblClassCode = new Label(composite, SWT.NONE);
		lblClassCode.setText("Class Code");
		
		classCodeTextbox = new Text(composite, SWT.BORDER);
		GridData gd_classCodeTextbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_classCodeTextbox.widthHint = 105;
		classCodeTextbox.setLayoutData(gd_classCodeTextbox);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button addClassButton = new Button(composite, SWT.NONE);
		GridData gd_addClassButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_addClassButton.verticalIndent = 15;
		addClassButton.setLayoutData(gd_addClassButton);
		addClassButton.setText("Add Class");
		
		Button removeClassBtn = new Button(composite, SWT.NONE);
		GridData gd_removeClassBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_removeClassBtn.verticalIndent = 15;
		removeClassBtn.setLayoutData(gd_removeClassBtn);
		removeClassBtn.setText("Remove Class");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			
			if(removeRadioBtn.getSelection()) {
				classDropdown.setEnabled(true);
				removeClassBtn.setEnabled(true);
				
				classTitleTextbox.setEnabled(false);
				classCodeTextbox.setEnabled(false);
				addClassButton.setEnabled(false);
			}
			
			if(addRadioBtn.getSelection()) {
				classTitleTextbox.setEnabled(true);
				classCodeTextbox.setEnabled(true);
				addClassButton.setEnabled(true);
				
				classDropdown.setEnabled(false);
				removeClassBtn.setEnabled(false);
			}
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
