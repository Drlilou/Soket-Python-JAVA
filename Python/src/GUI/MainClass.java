package GUI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainClass extends JFrame {
	private JTextField textField;

	public MainClass() {
		setResizable(false);
		// setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Text Classifcation");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Welcome", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("wissem");
		lblNewLabel.setBounds(148, 124, 46, 14);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Train", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("img/img1.PNG"));
		lblNewLabel_1.setBounds(24, 25, 511, 364);
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Loss", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(24, 25, 511, 364);
		;
		lblNewLabel_2.setIcon(new ImageIcon("img/Capture.PNG"));
		panel_2.add(lblNewLabel_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Test", null, panel_3, null);
		panel_3.setLayout(null);

		textField = new JTextField();
		textField.setBounds(75, 183, 387, 27);
		panel_3.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Classer Text");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField.getText();
				boolean r = Connect.main(s);
				if (!r)
					JOptionPane.showMessageDialog(null, "Negatif");
				else
					JOptionPane.showMessageDialog(null, "Possitif");
			}
		});
		btnNewButton.setBounds(215, 251, 122, 23);
		panel_3.add(btnNewButton);
		setBounds(10, 10, 700, 600);
	}

	public static void main(String[] args) {
		new MainClass().setVisible(true);

	}

}
