package actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entities.Categorie;
import dao.CategorieDAO;
import service.CategorieDAOImpl;

public class CategorieAction extends ActionSupport implements ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 1L;
	private ArrayList<Categorie> listCategories = new ArrayList<Categorie>();
	private ArrayList<String> listPseudos = new ArrayList<String>();
	CategorieDAO cs = new CategorieDAOImpl();
	private int idCategorie;

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public CategorieDAO getCs() {
		return cs;
	}

	public void setCs(CategorieDAO cs) {
		this.cs = cs;
	}

	private String pseudo;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	private String nomCategorie;
	private String description;

	private Categorie theCategorie;

	private File photo;

	private HttpServletRequest servletRequest;
	private Map<String, Object> maSession;

	public ArrayList<Categorie> getListCategories() {
		return listCategories;
	}

	public void setListCategories(ArrayList<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	public ArrayList<String> getListPseudos() {
		return listPseudos;
	}

	public void setListPseudos(ArrayList<String> listPseudos) {
		this.listPseudos = listPseudos;
	}

	public String getNom() {
		return nomCategorie;
	}

	public void setNom(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getTheCategorie() {
		return theCategorie;
	}

	public void setTheCategorie(Categorie theCategorie) {
		this.theCategorie = theCategorie;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String enregistrer() {

		Categorie Categorie = new Categorie();

		Categorie.setNomCategorie(nomCategorie);
		Categorie.setDescription(description);

		cs.addCategorie(Categorie);
		for (Categorie cat : cs.listCategories()) {
			listCategories.add(cat);
		}

		return "success";

	}

	public String modifier() {

		CategorieDAO cDao = new CategorieDAOImpl();
		Categorie cat = cDao.getCategorieById(20);
		cat.setDescription(description);
		cat.setNomCategorie(nomCategorie);
		cs.updateCategorie(cat);

		for (Categorie catt : cs.listCategories()) {
			listCategories.add(cat);
		}

		return "success";

	}

	public Map<String, Object> getMaSession() {
		return maSession;
	}

	public void setMaSession(Map<String, Object> maSession) {
		this.maSession = maSession;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public String lister() {
		CategorieDAO cs = new CategorieDAOImpl();
		listCategories = (ArrayList<Categorie>) cs.listCategories();
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	public String supprimer() {

		cs.removeCategorie(idCategorie);
		CategorieDAO cs = new CategorieDAOImpl();
		listCategories = (ArrayList<Categorie>) cs.listCategories();
		return "success";
	}

	public String listePseudosContact() {
		CategorieDAO cs = new CategorieDAOImpl();
		listPseudos = new ArrayList<String>(cs.listPseudos());
		return "success";
	}

	public String detailsContact() {
		CategorieDAO cs = new CategorieDAOImpl();

		if (getPseudo() != null && !getPseudo().equals("")) {
			listCategories = new ArrayList<>(cs.selectCatByKeyword(pseudo));
		}

		return "success";
	}

	public String saisir() {

		return "success";
	}

}
