package root;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public final class MainClass extends JFrame implements Runnable {

	// tmp
	JTextArea graphMatrix = new JTextArea("����� ����� ������� ���������");
	JTextArea text = new JTextArea("����� ����� ����");

	//�������
	JButton butNext = new JButton("�����");
	JMenuBar mBar = new JMenuBar();
	JMenuItem menuAdd = new JMenuItem("������ ����");
	JDesktopPane dialog = new JDesktopPane(); // ��������� ����

	// tmp2

	// ������ ����
	JPanel rightPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel matrixPanel = new JPanel();
	JPanel buttonPanel = new JPanel();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new MainClass());
	}

	public void run() {
		setTitle("Warshall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(mBar);
		mBar.add(menuAdd);

		setLayout(new GridLayout(1, 2, 1, 1));
		add(leftPanel, GridLayout.class);
		leftPanel.setLayout(new GridLayout(2, 1, 1, 1));

		// �������
		Graph graph = new Graph(10);
		JTable gMatrix = new JTable(graph.matrix,graph.arg1);
		JScrollPane gmScroll = new JScrollPane(gMatrix,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		leftPanel.add(matrixPanel, leftPanel);
		
		matrixPanel.setBorder(new TitledBorder("������� ���������"));
		//matrixPanel.setSize(new Dimension (500,300));
		gMatrix.setShowGrid(false);
		gMatrix.setEnabled(false);
		gMatrix.setVisible(true);
		gMatrix.setPreferredScrollableViewportSize(new Dimension(250, 100));
		
		matrixPanel.add(gmScroll);

		// ������
		leftPanel.add(buttonPanel, leftPanel);
		buttonPanel.add(butNext, buttonPanel);
		//buttonPanel.setMinimumSize(butNext.getMinimumSize());
		//butNext.setSize(getMinimumSize());
		//butNext.setVerticalAlignment(SwingConstants.CENTER);

		// ����
		add(rightPanel, GridLayout.class);
		rightPanel.add(text, rightPanel);
		rightPanel.setBorder(new TitledBorder("����"));
		//rightPanel.setSize(400, 400);

		// ���������� ������
		MainClass thisFrame = this;
		butNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(thisFrame, "�� ����� �� ������");
			}

		});

		// ���������� ����
		menuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// dialog.add(new GraphAdd("���� �����"));
			}
		});

		pack();
		setSize(600, 400);
		setVisible(true);
	}
}
