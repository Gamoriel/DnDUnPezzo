package org.prepuzy.businesslogic;

import java.util.ArrayList;
import java.util.List;

import org.prepuzy.dao.DaoFactory;
import org.prepuzy.dao.JPA.JpaDaoFactory;
import org.prepuzy.model.AbilitaFrutto;
import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Capitolo;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Equipaggiamento;
import org.prepuzy.model.Frutto;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Mappa;
import org.prepuzy.model.Nave;
import org.prepuzy.model.OggettiMercante;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Professione;
import org.prepuzy.model.Qualita;
import org.prepuzy.model.Razza;
import org.prepuzy.model.Resistenza;
import org.prepuzy.model.StatusAlterati;
import org.prepuzy.model.Tipo;
import org.prepuzy.model.Tipologia;
import org.prepuzy.model.Utente;

import jakarta.persistence.EntityManager;

public class BusinessLogic {
	private static final String DATABASE = "JPA";
	
	// SEZIONE CAPITOLO
	
	public static void inserisciCapitolo(Capitolo c) {
		DaoFactory.getInstance(DATABASE).getJpaDaoCapitolo().insert(c);
	}
	
	public static Capitolo cercaConId(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoCapitolo().selectById(id);
	}
	
	public static List<Capitolo> mostraCapitoli() {
		return DaoFactory.getInstance(DATABASE).getJpaDaoCapitolo().selectAll();
	}
	
	public static List<Capitolo> mostraCapitoliVisibilitaUtenteBase() {
		return DaoFactory.getInstance(DATABASE).getJpaDaoCapitolo().filtroSelectAll();
	}
	
	public static List<Capitolo> mostraCapitoliConMappe() {
		return DaoFactory.getInstance(DATABASE).getJpaDaoCapitolo().SelectAllWithMappe();
	}
	
	public static boolean cancellaCapitoloById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoCapitolo().delete(id);
	}
	
	public static void modificaCapitolo (Capitolo c) {
		DaoFactory.getInstance(DATABASE).getJpaDaoCapitolo().update(c);
	}
	
	public static void modificaCapitoloConMappa (Capitolo c, Mappa m) {
		DaoFactory.getInstance(DATABASE).getJpaDaoCapitolo().updateConMappa(c, m);
	}
	
	// SEZIONE CIURMA
	
	public static void inserisciCiurma(Ciurma c) {
		DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().insert(c);
	}
	
	public static List<Ciurma> listaCiurme(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().listaCiurme();
	}
	
	public static List<Ciurma> mostraCiurmaVisibilitaUtenteBase(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().filtroSelectAll();
	}
	
	public static Ciurma cercaCiurmaConId(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().selectById(id);
	}
	
	public static void rimuoviPersonaggioDaCiurma(long id, long id2) {
		DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().rimuovipersonaggioDaCiurma(id, id2);
	}
	
	public static void aggiungiPersonaggioACiurma(long id, long id2) {
		DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().aggiungiPersonaggioACiurma(id, id2);
	}
	
	public static void modificaCiurma (Ciurma c) {
		DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().update(c);
	}
	
	public static void eliminaCiurma(long id) {
		DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().delete(id);
	}
	
	public static List<Personaggio> membriCiurma(long id){
		return DaoFactory.getInstance(DATABASE).getJpaDaoCiurma().membriCiurma(id);
	}
	
	// SEZIONE EQUIPAGGIAMENTO
	
	public static void aggiungiEquipaggiamento(Equipaggiamento e) {
		DaoFactory.getInstance(DATABASE).getJpaDaoEquipaggiamento().insert(e);
	}
	
	public static void modificaEquipaggiamento(Equipaggiamento e) {
		DaoFactory.getInstance(DATABASE).getJpaDaoEquipaggiamento().update(e);
	}
	
	public static boolean eliminaEquipaggiamento(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoEquipaggiamento().delete(id);
	}
	
	public static Equipaggiamento equipByPersonaggioId(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoEquipaggiamento().equipByIdPersonaggio(id);
	}
	// SEZIONE FRUTTO
	
	public static void aggiungiFrutto(Frutto f) {
		DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().insert(f);
	}
	
	public static void aggiungiAbilitaFrutto(AbilitaFrutto a) {
		DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().insertAbilita(a);
	}
	
	public static void eliminaAbilitaFrutto(long id) {
		DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().deleteAbilita(id);
	}
	
	public static List<Frutto> listaFrutti(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().selectAll();
	}
	
	public static List<Frutto> mostraFruttiVisibilitaUtenteBase(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().filtroSelectAll();
	}
	
	public static Frutto trovaFruttoById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().selectById(id);
	}
	
	public static void modificaFrutto(Frutto f) {
		DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().update(f);
	}
	
	public static void eliminaFrutto(long id) {
		DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().delete(id);
	}
	
	public static AbilitaFrutto abilitaFruttoById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().abilitaById(id);
	}
	
	public static List<AbilitaFrutto> listaAbilitaFrutto(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().selectAllAblitaFrutto();
	}
	
	public static void modificaAbilitaFrutto(AbilitaFrutto a) {
		DaoFactory.getInstance(DATABASE).getJpaDaoFrutto().updateAbilita(a);
	}
	
	// SEZIONE INVENTARIO
	
	public static void aggiungiInventario(Inventario i) {
		DaoFactory.getInstance(DATABASE).getJpaDaoInventario().insert(i);
	}
	
	// SEZIONE MAPPA
	
	public static void aggiungiMappa(Mappa m) {
		DaoFactory.getInstance(DATABASE).getJpaDaoMappa().insert(m);
	}
	
	public static Mappa cercaMappaConId(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoMappa().selectById(id);
	}
	
	public static List<Mappa> listaMappe() {
		return DaoFactory.getInstance(DATABASE).getJpaDaoMappa().listaMappe();
	}
	
	public static List<Mappa> mostraMappeVisibilitaUtenteBase(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoMappa().filtroSelectAll();
	}
	
	public static void modificaMappa(Mappa m) {
		DaoFactory.getInstance(DATABASE).getJpaDaoMappa().update(m);
	}
	
	public static void eliminaMappa(long id) {
		DaoFactory.getInstance(DATABASE).getJpaDaoMappa().delete(id);
	}
	
	// SEZIONE NAVE
	
	public static void aggiungiNave(Nave n) {
		DaoFactory.getInstance(DATABASE).getJpaDaoNave().insert(n);
	}
	
	public static List<Nave> listaNavi(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoNave().selectAll();
	}
	
	public static List<Nave> mostraNaviVisibilitaUtenteBase(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoNave().filtroSceletAll();
	}
	
	public static Nave naveById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoNave().selectById(id);
	}
	
	public static void modificaNave(Nave n) {
		DaoFactory.getInstance(DATABASE).getJpaDaoNave().update(n);
	}
	
	public static boolean eliminaNave(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoNave().delete(id);
	}
	
	// SEZIONE OGGETTO
	
	public static void aggiungiOggetto(Oggetto o) {
		DaoFactory.getInstance(DATABASE).getJpaDaoOggetto().insert(o);
	}
	
	public static Oggetto oggettoById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoOggetto().selectById(id);
	}
	
	public static void aggiornaOggetto(Oggetto o) {
		DaoFactory.getInstance(DATABASE).getJpaDaoOggetto().update(o);
	}
	
	public static boolean deleteOggetto(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoOggetto().delete(id);
	}
	
	public static List<Oggetto> listaOggetti(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoOggetto().selectAll();
	}
	
	public static List<Oggetto> mostraOggettiVisibilitaUtenteBase(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoOggetto().filtroSelectAll();
	}
	
	// SEZIONE PERSONAGGIO
	
	public static void aggiungiPersonaggio(Personaggio p) {
		DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().insert(p);
	}
	
	public static List<Personaggio> listaPersonaggi(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().listaPersonaggi();
	}
	
	public static List<Personaggio> listaPersonaggiUtente(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().listaPersonaggiUtente();
	}
	
	public static List<Personaggio> mostraPersonaggiVisibilitaUtenteBase(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().filtroSelectAll();
	}
	
	public static Personaggio personaggioById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().selectById(id);
	}
	
	public static Personaggio personaggioConAllInfoById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().PersonaggioConTuttiElementi(id);
	}
	
	public static void modificaPersonaggio(Personaggio p) {
		DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().update(p);
	}
	
	public static boolean eliminaPersonaggio(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().delete(id);
	}
	
	public static List<Personaggio> listaMercanti(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().listaMercanti();
	}
	
	public static List<OggettiMercante> inventarioMercante(Personaggio p) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().inventarioMercante(p);
	}
	
	public static void aggiornaPrezzo(OggettiMercante om, long prezzo) {
		DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().aggiornaPrezzo(om, prezzo);
	}
	
	public static void aggiungiOggettoMercante(OggettiMercante o) {
		DaoFactory.getInstance(DATABASE).getJpaDaoPersonaggio().insertOggettoMercante(o);
	}
	
	// SEZIONE PROFESSIONE
	
	public static void aggiungiProfessione(Professione p) {
		DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().insert(p);
	}
	
	public static List<Professione> listaProfessioni(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().selectAll();
	}
	
	public static Professione professioneById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().selectbyId(id);
	}
	
	public static void modificaProfessione(Professione p) {
		DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().update(p);
	}
	
	public static boolean eliminaProfessione (long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().delete(id);
	}
	
	public static AbilitaProfessione abilitaProfessioneById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().abilitaById(id);
	}
	
	public static List<AbilitaProfessione> listaAbilitaProfessione(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().selectAllAblitaProfessione();
	}
	
	public static void aggiungiAbilitaProfessione(AbilitaProfessione a) {
		DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().insertAbilita(a);
	}
	
	public static void modificaAbilitaProfessione(AbilitaProfessione a) {
		DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().updateAbilita(a);
	}
	
	public static boolean eliminaAbilitaProfessione(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoProfessione().deleteAbilita(id);
	}
	// SEZIONE QUALITA
	
	public static void aggiungiQualita(Qualita q) {
		DaoFactory.getInstance(DATABASE).getJpaDaoQualita().insert(q);
	}
	
	public static List<Qualita> listaQualita(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoQualita().selectAll();
	}
	
	public static Qualita qualitaById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoQualita().selectById(id);
	}
	
	public static boolean eliminaQualita(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoQualita().delete(id);
	}
	
	// SEZIONE RAZZA
	
	public static void aggiungiRazza(Razza r) {
		DaoFactory.getInstance(DATABASE).getJpaDaoRazza().insert(r);
	}
	
	public static List<Razza> listaRazze(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoRazza().selectAll();
	}
	
	public static Razza razzaById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoRazza().selectById(id);
	}
	
	public static void modificaRazza(Razza r) {
		DaoFactory.getInstance(DATABASE).getJpaDaoRazza().update(r);
	}
	
	public static boolean eliminaRazza(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoRazza().delete(id);
	}
	// SEZIONE RESISTENZA
	
	public static void aggiungiResistenza(Resistenza r) {
		DaoFactory.getInstance(DATABASE).getJpaDaoResistenza().insert(r);
	}
	
	public static List<Resistenza> listaResistenze(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoResistenza().selectAll();
	}
	
	public static Resistenza resistenzaById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoResistenza().selectById(id);
	}
	
	public static void modificaResistenza(Resistenza r) {
		DaoFactory.getInstance(DATABASE).getJpaDaoResistenza().update(r);
	}
	
	public static boolean eliminaResistenza(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoResistenza().delete(id);
	}
	
	// SEZIONE STATUS ALTERATI
	
	public static void aggiungiStatusAlterati(StatusAlterati s) {
		DaoFactory.getInstance(DATABASE).getJpaDaoStatusAlterati().insert(s);
	}
	
	public static List<StatusAlterati> listaStatusAlterati(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoStatusAlterati().selectAll();
	}
	
	public static StatusAlterati statusById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoStatusAlterati().selectById(id);
	}
	
	public static void modificaStatus(StatusAlterati s) {
		DaoFactory.getInstance(DATABASE).getJpaDaoStatusAlterati().update(s);
	}
	
	public static boolean eliminaStatus(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoStatusAlterati().delete(id);
	}
	
	// SEZIONE TIPO
	
	public static void aggiungiTipo (Tipo t) {
		DaoFactory.getInstance(DATABASE).getJpaDaoTipo().insert(t);
	}
	
	public static List<Tipo> listaTipi(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoTipo().selectAll();
	}
	
	public static Tipo tipoById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoTipo().selectById(id);
	}
	
	public static boolean eliminaTipo(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoTipo().delete(id);
	}
	
	// SEZIONE TIPOLOGIA
	
	public static Tipologia trovaTopologiaById(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoTipologia().selectById(id);
	}
	
	public static void aggiungiTipologia(Tipologia t) {
		DaoFactory.getInstance(DATABASE).getJpaDaoTipologia().insert(t);
	}
	
	public static List<Tipologia> listTipologie(){
		return DaoFactory.getInstance(DATABASE).getJpaDaoTipologia().selectAll();
	}
	
	public static boolean eliminaTipologia(long id) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoTipologia().delete(id);
	}
	// SEZIONE UTENTE
	
	public static void registrazione(Utente u){
		DaoFactory.getInstance(DATABASE).getJpaDaoUtenti().insert(u);
	}
	
	public static Utente login(Utente u) {
		return DaoFactory.getInstance(DATABASE).getJpaDaoUtenti().selectByUsernamePassword(u);
	}
	
	public static List<Personaggio> personaggiUtente(long id){
		return DaoFactory.getInstance(DATABASE).getJpaDaoUtenti().personaggiUtente(id);
	}

	public static List<AbilitaFrutto> abilitaFruttoUtente(long id){
		return DaoFactory.getInstance(DATABASE).getJpaDaoUtenti().abilitaFruttoUtente(id);
	}
	
	public static List<AbilitaProfessione> abilitaProfessioneUtente(long id){
		return DaoFactory.getInstance(DATABASE).getJpaDaoUtenti().abilitaProfessioneUtente(id);
	}
	
	public static void modificaUtente(Utente u) {
		DaoFactory.getInstance(DATABASE).getJpaDaoUtenti().update(u);
	}
	
	
    public static <T> List<T> getEntitiesByIds(Class<T> clazz, String[] ids) {
        if (ids == null || ids.length == 0) {
            return new ArrayList<>(); 
        }

        EntityManager em = JpaDaoFactory.getEntityManager();
        try {
            List<T> entities = new ArrayList<>(); 
            for (String idStr : ids) {
                try {
                    long id = Long.parseLong(idStr);
                    T entity = em.find(clazz, id);
                    if (entity != null) {
                        entities.add(entity); 
                    }
                } catch (NumberFormatException e) {
                    System.err.println("ID non valido: " + idStr);
                }
            }
            return entities; 
        } finally {
            em.close();
        }
    }
}