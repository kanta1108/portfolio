package jp.co.example.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 書籍テーブルエンティティ</br>
 * 書籍テーブル用のエンティティ
 * 
 * @author k.s
 * @version 1.0 BMS2106001 初期構築
 * 
 */
@Entity
@Table(name ="bmsap010")
@Data
public class Book {
	
	/**
	 * 書籍ID(PK)
	 */
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 書籍名
	 */
	@Column(name ="title", length = 255, nullable = false)
	private String title;

}
