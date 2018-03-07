package model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.*;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int age;

	private int bons;

	private String motdepasse;

	private String nom;

	private String prenom;

	public Client() {
	}

	public Client(String motdepasse, String nom, String prenom, int bons,int age) {
		this.age = age;
		this.bons = bons;
		this.motdepasse = motdepasse;
		this.nom = nom;
		this.prenom = prenom;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBons() {
		return this.bons;
	}

	public void setBons(int bons) {
		this.bons = bons;
	}

	public String getMotdepasse() {
		return this.motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = md5(motdepasse);
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String md5(String input) {
		MessageDigest md;
		StringBuffer sb = new StringBuffer();
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(input.getBytes("UTF-8"));
			for (int i = 0; i < bytes.length; i++) {
				byte b = bytes[i];
				String hex = Integer.toHexString((int) 0x00FF & b);
				if (hex.length() == 1) {
					sb.append("0");
				}
				sb.append(hex);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

}