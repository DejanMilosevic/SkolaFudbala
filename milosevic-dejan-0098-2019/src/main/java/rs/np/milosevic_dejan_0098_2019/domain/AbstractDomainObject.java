package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja apstraktnu domensku klasu koju nasledjuju sve domenske klase.
 * Sadrzi apstraktne metode koje svaka od domenskih klasa implementira.
 *
 * @author Dejan Milosevic 
 * @since 1.1.0
 */
public abstract class AbstractDomainObject {

	/**
	 * Vraca String koji sadrzi naziv tabele.
	 * 
	 * Naziv tabele se koristi prilikom poziva bilo koje od CRUD operacija nad
	 * tabelom u bazi podataka koja odgovara domenskoj klasi koja implementira
	 * metodu.
	 * 
	 * @return naziv tabele kao String
	 */
	public abstract String nazivTabele();

	/**
	 * Vraca String koji sadrzi alijas tabele.
	 * 
	 * Alijas se koristi prilikom poziva SELECT upita nad tabelom u bazi podataka
	 * koja odgovara domenskoj klasi koja implementira metodu.
	 * 
	 * @return alijas tabele kao String
	 */
	public abstract String alijas();

	/**
	 * Vraca String koji sadrzi JOIN klauzulu.
	 * 
	 * JOIN klauzulom se tabela koja odgovara domenskoj klasi koja implementira
	 * metodu povezuje sa jednom ili vise drugih tabela u bazi podataka preko
	 * primarnog ili spoljnog kljuca.
	 * 
	 * Moze da ima prazan String kao vrednost, u slucaju da se data tabela ne
	 * povezuje ni sa jednom drugom tabelom.
	 * 
	 * @return JOIN klauzula kao String
	 */
	public abstract String join();

	/**
	 * Vraca listu sa elementima apstraktne domenske klase.
	 * 
	 * U listu se ubacuju elementi tabele koja odgovara domenskoj klasi koja
	 * implementira metodu i koji su vraceni SELECT upitom u okviru ResultSet-a.
	 * 
	 * @param rs skup rezultata koji vraca SELECT upit
	 * 
	 * @return lista sa elementima apstraktne domenske klase
	 * 
	 * @throws SQLException ako je doslo do greske prilikom izvrsavanja SELECT upita
	 */
	public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;

	/**
	 * Vraca String sa imenima kolona za INSERT upit.
	 * 
	 * Koristi se prilikom ubacivanja novog reda u tabelu koja odgovara domenskoj
	 * klasi koja implementira metodu.
	 * 
	 * Moze da ima prazan String kao vrednost, u slucaju da se ne vrsi ubacivanje
	 * redova u datu tabelu.
	 * 
	 * @return imena kolona za INSERT upit kao STRING
	 */
	public abstract String koloneZaInsert();

	/**
	 * Vraca String koji sadrzi vrednost za primarni kljuc.
	 * 
	 * Primarni kljuc se odnosi na tabelu u bazi podataka koja odgovara domenskoj
	 * klasi koja implementira metodu.
	 * 
	 * Koristi se prilikom izvrsavanja UPDATE ili DELETE upita, tj. pri izmeni ili
	 * izbacivanju odredjenog reda iz tabele.
	 * 
	 * Moze da ima prazan String kao vrednost, u slucaju da se ne vrsi izmena niti
	 * izbacivanje redova date tabele.
	 * 
	 * @return vrednost za primarni kljuc kao String
	 */
	public abstract String vrednostZaPrimarniKljuc();

	/**
	 * Vraca String sa vrednostima kolona za INSERT upit.
	 * 
	 * Koristi se prilikom ubacivanja novog reda u tabelu koja odgovara domenskoj
	 * klasi koja implementira metodu.
	 * 
	 * Moze da ima prazan String kao vrednost, u slucaju da se ne vrsi ubacivanje
	 * redova u datu tabelu.
	 * 
	 * @return vrednosti kolona za INSERT upit kao STRING
	 */
	public abstract String vrednostiZaInsert();

	/**
	 * Vraca String sa vrednostima kolona za UPDATE upit.
	 * 
	 * Koristi se prilikom izmene postojeceg reda u tabelu koja odgovara domenskoj
	 * klasi koja implementira metodu.
	 * 
	 * Moze da ima prazan String kao vrednost, u slucaju da se ne vrsi izmena redova
	 * date tabele.
	 * 
	 * @return vrednosti kolona za UPDATE upit kao STRING
	 */
	public abstract String vrednostiZaUpdate();

	/**
	 * Vraca String sa WHERE klauzulom.
	 * 
	 * Koristi se pri pozivu SELECT upita, kojim se vracaju samo odredjeni redovi
	 * tabele u bazi podataka koja odgovara domenskoj klasi koja implementira
	 * metodu.
	 * 
	 * Moze da ima prazan String kao vrednost, u slucaju da ne sadrzi WHERE klauzulu
	 * u SELECT upitu.
	 * 
	 * @return WHERE klauzula kao String
	 */
	public abstract String uslov();

}
