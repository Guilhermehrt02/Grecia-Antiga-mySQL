package br.edu.unifei.ecot13.greciaAntiga.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.greciaAntiga.Atenas;
import br.edu.unifei.ecot13.greciaAntiga.Ateniense;

public class AtenasFormInserir extends JFrame {

	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("guilherme");
	private EntityManager em = emf.createEntityManager();
	private Atenas atenas;

	private JPanel contentPane;
	private JTextField txtGovernante;
	private JTextField txtAteniense;
	private JTextField txtEducacao;
	private JTextField txtPeriodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtenasFormInserir frame = new AtenasFormInserir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AtenasFormInserir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblPeriodo.setBounds(10, 118, 107, 15);
		contentPane.add(lblPeriodo);
		
		JLabel lblGovernante = new JLabel("Governante:");
		lblGovernante.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblGovernante.setBounds(10, 8, 91, 20);
		contentPane.add(lblGovernante);

		JLabel lblAteniense = new JLabel("Ateniense:");
		lblAteniense.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblAteniense.setBounds(10, 93, 91, 14);
		contentPane.add(lblAteniense);

		JLabel lblEducacao = new JLabel("Ênfase educação:");
		lblEducacao.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblEducacao.setBounds(10, 68, 128, 14);
		contentPane.add(lblEducacao);
		
		JLabel lblQtdVotos = new JLabel("Quantidade de votos:");
		lblQtdVotos.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblQtdVotos.setBounds(8, 39, 166, 14);
		contentPane.add(lblQtdVotos);
	
		txtPeriodo = new JTextField();
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(142, 114, 128, 20);
		contentPane.add(txtPeriodo);

		txtGovernante = new JTextField();
		txtGovernante.setColumns(10);
		txtGovernante.setBounds(142, 7, 128, 20);
		contentPane.add(txtGovernante);
		
		txtAteniense = new JTextField();
		txtAteniense.setColumns(10);
		txtAteniense.setBounds(142, 89, 128, 20);
		contentPane.add(txtAteniense);
	
		txtEducacao = new JTextField();
		txtEducacao.setColumns(10);
		txtEducacao.setBounds(142, 64, 128, 20);
		contentPane.add(txtEducacao);
		
		JSpinner spnQtdVotos = new JSpinner();
		spnQtdVotos.setBounds(197, 35, 73, 20);
		contentPane.add(spnQtdVotos);

		JButton btnInserir = new JButton("OK");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atenas=new Atenas();
				atenas.setGovernante(txtGovernante.getText());
				atenas.setEnfaseEducacao(txtEducacao.getText());
				atenas.setPeriodo(txtPeriodo.getText());
				
				
				String[] nomesSeparados = txtAteniense.getText().split(", ");

		        Ateniense[] atenienses = new Ateniense[nomesSeparados.length];
		        for (int i = 0; i < nomesSeparados.length; i++) {
		        	atenienses[i] = new Ateniense();
		            atenienses[i].setNome(nomesSeparados[i]);
		            em.persist(atenienses[i]);
		        }
		        
		        List<Ateniense> ateniensesList = new ArrayList<>();
		        for (Ateniense ateniense : atenienses) {
		            ateniensesList.add(ateniense);
		        }
		        atenas.setAtenienses(ateniensesList);
				
		        atenas.setQtdVotos((Integer)spnQtdVotos.getValue());
		        
		        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
		        em.getTransaction().begin();
				em.persist(atenas);
				em.getTransaction().commit();
				dispose();
			}
		});
		btnInserir.setBounds(101, 144, 73, 23);
		contentPane.add(btnInserir);
	}

}
