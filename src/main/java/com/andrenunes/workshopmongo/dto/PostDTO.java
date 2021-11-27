package com.andrenunes.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.andrenunes.workshopmongo.domain.User;

/**
 * DTO (Data Transfer Object): é um objeto que tem o papel de carregar dados das
 * entidades de forma simples, podendo inclusive "projetar" apenas alguns dados
 * da entidade original.
 * 
 * @author andre
 * Sem uso
 */

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Date date;
	private String title;
	private String body;
	private User author;

	public PostDTO() {
	}

	public PostDTO(String id, Date date, String title, String body, User author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
