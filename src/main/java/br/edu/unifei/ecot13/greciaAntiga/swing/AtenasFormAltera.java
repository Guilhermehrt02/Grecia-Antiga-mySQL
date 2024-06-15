package br.edu.unifei.ecot13.greciaAntiga.swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.List;

public class AtenasFormAltera extends JFrame {

	private JPanel contentPane;

	private JTextField txtGovernante;
	private JTextField txtAteniense;
	private JTextField txtEducacao;
	private JTextField txtPeriodo;
	private EntityManagerFactory emf=
	Persistence.createEntityManagerFactory("guilherme");
	private EntityManager em = 
		emf.createEntityManager();
	private Atenas atenas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtenasFormAltera frame = new AtenasFormAltera();
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
	public AtenasFormAltera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPeriodo = new JLabel("Período:");
		lblPeriodo.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblPeriodo.setBounds(13, 111, 98, 16);
		contentPane.add(lblPeriodo);
		
		JLabel lblGovernante = new JLabel("Governante:");
		lblGovernante.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblGovernante.setBounds(13, 11, 91, 14);
		contentPane.add(lblGovernante);

		JLabel lblAteniense = new JLabel("Ateniense:");
		lblAteniense.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblAteniense.setBounds(13, 86, 86, 14);
		contentPane.add(lblAteniense);

		JLabel lblEducacao = new JLabel("Ênfase educação:");
		lblEducacao.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblEducacao.setBounds(13, 61, 128, 14);
		contentPane.add(lblEducacao);
		
		JLabel lblQtdVotos = new JLabel("Quantidade de votos:");
		lblQtdVotos.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblQtdVotos.setBounds(13, 36, 165, 14);
		contentPane.add(lblQtdVotos);
	
		txtPeriodo = new JTextField();
		txtPeriodo.setEnabled(false);
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(148, 108, 118, 20);
		contentPane.add(txtPeriodo);
		
		txtEducacao = new JTextField();
		txtEducacao.setEnabled(false);
		txtEducacao.setColumns(10);
		txtEducacao.setBounds(148, 57, 118, 20);
		contentPane.add(txtEducacao);
		
		txtGovernante = new JTextField();
		txtGovernante.setEnabled(true);
		txtGovernante.setColumns(10);
		txtGovernante.setBounds(148, 7, 118, 20);
		contentPane.add(txtGovernante);
		
		txtAteniense = new JTextField();
		txtAteniense.setEnabled(false);
		txtAteniense.setColumns(10);
		txtAteniense.setBounds(148, 82, 118, 20);
		contentPane.add(txtAteniense);
		
		JSpinner spnQtdVotos = new JSpinner();
		spnQtdVotos.setEnabled(false);
		spnQtdVotos.setBounds(200, 32, 66, 20);
		contentPane.add(spnQtdVotos);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.getTransaction().begin();
				atenas.setPeriodo(txtPeriodo.getText());
				txtPeriodo.setEnabled(false);
				
				atenas.setEnfaseEducacao(txtEducacao.getText());
				txtEducacao.setEnabled(false);
				
//				Ateniense a = new Ateniense();
//				a.setNome(txtAteniense.getText());
//				atenas.getAtenienses().add(a);
//				txtAteniense.setEnabled(false);
				
				String[] nomesSeparados = txtAteniense.getText().split(", ");
				
//				em.createQuery("DELETE FROM ATENIENSE A "
//			             + "WHERE A IN (SELECT AA.ateniense FROM AtenasAteniense AA "
//			             + "WHERE AA.atenienses.nome = A.nome "
//			             + "AND AA.atenas.governante = '"+atenas.getGovernante()+ "')")
//			    .executeUpdate();
/*
		        Ateniense[] atenienses = new Ateniense[nomesSeparados.length];
		        for (int i = 0; i < nomesSeparados.length; i++) {
		        	atenienses[i] = new Ateniense();
		            atenienses[i].setNome(nomesSeparados[i]);
		           // em.merge(atenienses[i]);
		        }
		        
		        List<Ateniense> ateniensesList = new ArrayList<>();
		        for (Ateniense ateniense : atenienses) {
		            ateniensesList.add(ateniense);
		        }
		        atenas.setAtenienses(ateniensesList);*/
		        txtAteniense.setEnabled(false);
		        
				atenas.setQtdVotos((Integer)spnQtdVotos.getValue());
				spnQtdVotos.setEnabled(false);
				
				atenas.setPeriodo(txtPeriodo.getText());
				txtPeriodo.setEnabled(false);
				
				btnAlterar.setEnabled(false);
				txtGovernante.setEnabled(true);
				JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				em.merge(atenas);
				em.getTransaction().commit();
				dispose();
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(113, 139, 79, 31);
		contentPane.add(btnAlterar);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setHorizontalAlignment(SwingConstants.LEADING);
        ImageIcon icon = new ImageIcon("C:\\Users\\ghori\\Downloads\\lupa.png");
		btnBuscar.setIcon(icon);
		int width = 20;  
        int height = 20; 
        Image scaledIcon = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        btnBuscar.setIcon(new ImageIcon(scaledIcon));
        
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atenas=em.find(Atenas.class, 
						txtGovernante.getText());
				if(atenas!=null) {
					txtGovernante.setEnabled(false);
					txtEducacao.setEnabled(true);
					txtEducacao.setText(atenas.getEnfaseEducacao());
					txtAteniense.setEnabled(true);
					
					StringBuilder concatenacao = new StringBuilder();
					for (Ateniense ateniense : atenas.getAtenienses()) {
					    String nome = ateniense.getNome(); 
					    concatenacao.append(nome).append(", ");
					}
					String resultado = concatenacao.toString();
					txtAteniense.setText(resultado);
					
					txtPeriodo.setText(atenas.getPeriodo());
					txtPeriodo.setEnabled(true);
					
					spnQtdVotos.setEnabled(true);
					spnQtdVotos.setValue(atenas.getQtdVotos());
					btnAlterar.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Atenas não existe");
				}
				
			}
		});
		btnBuscar.setBounds(273, 7, 37, 20);
		contentPane.add(btnBuscar);
	}

}
