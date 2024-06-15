package br.edu.unifei.ecot13.greciaAntiga;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppInsert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("guilherme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		HomemAdulto h = new HomemAdulto();
		h.setNome("Guilherme");
		h.setFilosofo(true);
		h.setIdade(21);
		em.persist(h);
		
		Eupatrida e = new Eupatrida();
		e.setNome("Pedro");
		e.setFilosofo(false);
		e.setPosse("Cavalo");
		em.persist(e);

		Atenas a1 = new Atenas();//Atenas durante as guerras médicas 
		a1.setEnfaseEducacao("Formacao fisica e intelectual");
		a1.setGovernante("Arconte");
		a1.setPeriodo("522-424 a.C.");
		em.persist(a1);
		a1.getAtenienses().add(h);
		a1.getAtenienses().add(e);
		em.merge(a1);  
        Ateniense a = new Ateniense();
		a.setNome("Joao");
		a.setFilosofo(true);
		em.persist(a);
        
        Atenas a2 = new Atenas();//Atenas durante a guerra do peloponeso
        a2.setEnfaseEducacao("Formacao fisica e intelectual");
        a2.setGovernante("Pericles");
        a2.setPeriodo("431–404 a.C.");
        em.persist(a2);
        a2.getAtenienses().add(a);
        em.merge(a2);
        
        Espartano e1 = new Espartano();
        e1.setNome("Fernando");
        e1.setRei("Leônidas I");
        em.persist(e1);
        
        Esparta ee = new Esparta();//Esparta durante a guerra do peloponeso
        ee.setEnfaseEducacao("militar");
        ee.setGovernante("Leonidas");
        ee.setPeriodo("431–404 a.C.");
        ee.setGuerrasVencidas(true);
        em.persist(ee);
        ee.getEspartanos().add(e1);
        em.merge(ee);
        
        LigaDelos ld = new LigaDelos();//Durante a guerra do peloponeso
        ld.setSedeDelos("AtenasPeloponeso");
        ld.setNovoTerritorio(false);
        em.persist(ld);
        
        Comunidade co1 = new Comunidade();
        co1.setEconomia("mercado maritmo");
        co1.setLocalizacao("Africa");
        co1.setPolis(a2);
        em.persist(co1);

        Comunidade co2 = new Comunidade();
        co2.setEconomia("agricultura");
        co2.setLocalizacao("Peloponeso");
        co2.setPolis(ee);
        em.persist(co2);
        
        LigaPeloponeso lp = new LigaPeloponeso();
        lp.setEsparta(ee);
        lp.setSedePeloponeso("Esparta");
        lp.setAliado("Corinto");
        em.persist(lp);
        
        Peloponeso p = new Peloponeso();
        p.setMotivo("Rivalidade e competicao");
        p.setVencedor("Liga do Peloponeso");
        p.setImpactoResultante("Hegemonia espartana");
        p.setDelos(ld);
        p.setPeloponeso(lp);
        em.persist(p);
        
        Espartano e2 = new Espartano();
        e2.setNome("Carlos");
        e2.setRei("Leônidas I");
        em.persist(e2);
   
        Esparta ed = new Esparta();//Esparta durante a guerra do peloponeso
        ed.setEnfaseEducacao("militar");
        ed.setGovernante("Leotiquidas");
        ed.setPeriodo("522-424 a.C.");
        ed.setGuerrasVencidas(true);
        em.persist(ed);
        ed.getEspartanos().add(e2);
        em.merge(ed);
        
        Persa persa = new Persa(); //Persa durante as guerras medicas
        persa.setGovernante("Dario");
        persa.setImperador(true);
        persa.setPeriodo("522-424 a.C.");
        em.persist(persa);
        
        LigaDelos d = new LigaDelos();//Durante as guerras medicas
        d.setEsparta(ed);
        d.setSedeDelos("AtenasMedicas");
        d.setNovoTerritorio(true);
        em.persist(d);
        
        Medicas m = new Medicas();
        m.setDelos(d);
        m.setPersas(persa);
        m.setMotivo("Resistencia grega a expansao persa");
        m.setVencedor("Liga de Delos");
        m.setImpactoResultante("Fortalecimento das cidades-estados");
        em.persist(m);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
		
	}

}
